package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuizOpdracht {
	
	/*Aanpassingen: Setters en getters toegevoegd, method om een bestand in te lezen, constructor die met behulp
	 * van catalogussen quizzen en opdrachten zoekt bij naam en vraag
	 * 
	 * TO-DO:
	 * 
	 *	Nog vrij onduidelijk wat hier moet gebeuren, ik ben nu aant werken naar 3 bestanden:
	 * een met quizzen, een met opdrachten en een met quizopdrachten
	 * Weet totaal niet of dit de juiste manier is en ben aant denken ook een QuizOpdrachtcatalogus te maken
	 * want het is onlogisch om dit hier in te dumpen, maar dit word momenteel wel gedaan xD
	 */
	
	private ArrayList<QuizOpdracht> quizOpdrachten = new ArrayList<QuizOpdracht>();
	private Quiz quiz;
	private Opdracht opdracht;
	private int maxScore;
	
	QuizOpdracht(Quiz quiz, Opdracht opdracht, int maxScore){
		this.setQuiz(quiz);
		this.setOpdracht(opdracht);
		this.setMaxScore(maxScore);
	}
	
	QuizOpdracht(String naam, String vraag, int maxScore){
		QuizCatalogus qc = new QuizCatalogus();
		qc.leesQuizzenVanTekstBestand();
		Quiz quiz = qc.getQuizBijNaam(naam);
		
		OpdrachtCatalogus oc = new OpdrachtCatalogus();
		oc.leesOpdrachtenVanTekstBestand();
		Opdracht opdracht = oc.getOpdrachtBijVraag(vraag);
		
		this.setQuiz(quiz);
		this.setOpdracht(opdracht);
		this.setMaxScore(maxScore);
	}
	
	public void leesQuizOpdrachtenVanTekstBestand(){
		  File file = new File("bestanden\\quizOpdrachten.txt");
		  try{
			Scanner scanner = new Scanner(file);
			while (scanner.hasNext()){
		      String lijn = scanner.nextLine();
			  String [] velden = lijn.split(",");
			  String naam = velden[0];
			  String vraag = velden[1];
			  int maxScore= Integer.parseInt(velden[2]);
			  
			  QuizOpdracht qo = new QuizOpdracht(naam, vraag, maxScore);		
			  quizOpdrachten.add(qo);

			}
			if (scanner!=null){
			  scanner.close();
			}
		  }
		  catch(FileNotFoundException ex){
		    System.out.println("bestand met quizOpdrachten niet gevonden");
		  }
		  catch(Exception ex){
		    System.out.println(ex.getMessage());
		  }
		}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public Opdracht getOpdracht() {
		return opdracht;
	}

	public void setOpdracht(Opdracht opdracht) {
		this.opdracht = opdracht;
	}

	public int getMaxScore() {
		return maxScore;
	}

	public void setMaxScore(int maxScore) {
		this.maxScore = maxScore;
	}

}