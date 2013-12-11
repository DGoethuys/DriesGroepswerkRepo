	package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class QuizOpdrachtCatalogus implements Iterable<QuizOpdracht> {
	
	private ArrayList<QuizOpdracht> quizOpdrachten = new ArrayList<QuizOpdracht>();
	
	public QuizOpdracht getQuizOpdracht( int qO ){
		QuizOpdracht quizOpdracht = quizOpdrachten.get(qO);
		return quizOpdracht;
	}
	
	public void leesQuizOpdrachtenVanDataBase(){
		String DB_URL = "jdbc:mysql://localhost/quizdb";
		try{
				Connection con  = DriverManager.getConnection(DB_URL, "root","root");
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from quizdb.QuizOpdracht");
				while (res.next()){
					System.out.println(res.getString(2));
					  String naam = res.getString(1);;
					  String vraag = res.getString(2);
					  int maxScore= res.getInt(3);
					  
					  QuizOpdracht qo = new QuizOpdracht(naam, vraag, maxScore);
					  quizOpdrachten.add(qo);
				}			 
			}
		catch(SQLException ex){System.out.println("SQL exception: "+ex.getMessage());}
	}
	
	public void schrijfQuizOpdrachtenNaarDataBase(){
		
	}
	
	//method om QuizOpdrachten uit tekst bestand in te lezen en ze op te slaan als objecten in een ArrayList
	public void leesQuizOpdrachtenVanTekstBestand(){
		  File file = new File("bestanden/quizOpdrachten.txt");
		  Scanner scanner = null;
		  try{
			scanner = new Scanner(file);
			while (scanner.hasNext() && !scanner.hasNext("END")){
		      String lijn = scanner.nextLine();
			  String [] velden = lijn.split(",");
			  String naam = velden[0];
			  String vraag = velden[1];
			  int maxScore= Integer.parseInt(velden[2]);
			  
			  QuizOpdracht qo = new QuizOpdracht(naam, vraag, maxScore);
			  quizOpdrachten.add(qo);

			}
		  }
		  catch(FileNotFoundException ex){
		    System.out.println("bestand met quizOpdrachten niet gevonden");
		  }
		  catch(Exception ex){
		    System.out.println("Error message lees quizOpdracht van tekstbestand: " + ex.getMessage());
		  }
		  finally{
			  if (scanner!=null){
				  scanner.close();
				  }
		  }
		}

	//method om ArrayList van objecten af te gaan en deze om te zetten naar strings om ze weg te schrijven
	//in een tekst bestand
	public void schrijfQuizOpdrachtenNaarTekstBestand(){
		File file = new File("bestanden/quizOpdrachten.txt");
		try{
			PrintWriter writer = new PrintWriter(file);
			for (int i = 0 ; i <quizOpdrachten.size() ; i++){
				QuizOpdracht qo = quizOpdrachten.get(i);
				String lijn = qo.getQuiz().getNaam().toString() + "," + qo.getOpdracht().getVraag().toString() + "," + qo.getMaxScore();
				writer.println(lijn);
			}
			writer.println("END");
			if (writer !=null)
				writer.close();
			}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	/*
	public static void main(String[] args){
		OpdrachtCatalogus oc = new OpdrachtCatalogus();
		oc.leesOpdrachtenVanTekstBestand();
		QuizCatalogus qc = new QuizCatalogus();
		qc.leesQuizzenVanTekstBestand();
		QuizOpdrachtCatalogus qoc = new QuizOpdrachtCatalogus();
		qoc.leesQuizOpdrachtenVanTekstBestand();

		QuizOpdracht qo = qoc.quizOpdrachten.get(1);
		if(qoc.quizOpdrachten.contains(qo)){
			qoc.quizOpdrachten.remove(qo);
		}else{
			System.out.println("niet in lijst biatch");
		}
		
		//qoc.quizOpdrachten.add(qo);
		qoc.schrijfQuizOpdrachtenNaarBestand();
		oc.schrijfOpdrachtenNaarBestand();
		qc.schrijfQuizOpdrachtenNaarBestand();
		

		OpdrachtCatalogus oc = new OpdrachtCatalogus();
		oc.leesOpdrachtenVanTekstBestand();
		QuizCatalogus qc = new QuizCatalogus();
		qc.leesQuizzenVanTekstBestand();
		QuizOpdrachtCatalogus qoc = new QuizOpdrachtCatalogus();
		qoc.leesQuizOpdrachtenVanTekstBestand();
		
		System.out.println(oc.toString() + "\n");
		System.out.println(qc.toString() + "\n");
		System.out.println(qoc.toString() + "\n");
		
	}*/
	
	@Override
	public String toString() {
		return "OpdrachtCatalogus [QuizOpdrachten=" + quizOpdrachten + "]";
	}
	
	@Override
	public Iterator<QuizOpdracht> iterator() {
		Iterator<QuizOpdracht> iterator = quizOpdrachten.iterator();
		return iterator;
	}
	
	
}// Einde class
