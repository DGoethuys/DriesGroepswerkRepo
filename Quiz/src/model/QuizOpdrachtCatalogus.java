	package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class QuizOpdrachtCatalogus {
	
	private ArrayList<QuizOpdracht> quizOpdrachten = new ArrayList<QuizOpdracht>();
	
	public void leesQuizOpdrachtenVanTekstBestand(){
		  File file = new File("bestanden/quizOpdrachten.txt");
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

	
	public static void main(String[] args){
		
		
		OpdrachtCatalogus oc = new OpdrachtCatalogus();
		oc.leesOpdrachtenVanTekstBestand();
		QuizCatalogus qc = new QuizCatalogus();
		qc.leesQuizzenVanTekstBestand();
		QuizOpdrachtCatalogus qoc = new QuizOpdrachtCatalogus();
		qoc.leesQuizOpdrachtenVanTekstBestand();
		
		System.out.println(oc.toString() + "\n");
		System.out.println(qc.toString() + "\n");
		System.out.println(qoc.toString() + "\n");
		
	}
}
