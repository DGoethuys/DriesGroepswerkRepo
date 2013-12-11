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

public class QuizCatalogus implements Iterable<Quiz> {
	
	/* Aanpassingen: method voor quiz te zoeken op naam, method voor quizzen te lezen van bestand
	 * 
	 * TO DO:
	 * Testklasses schrijven
	 * Method voor wijzigen van Quiz objecten
	 */
	
	//Lijst waar Quiz objecten in gaan komen
	private ArrayList<Quiz> quizzen = new ArrayList<Quiz>();
	
	//method voor toe te voegen
	public void addQuiz( Quiz quiz ){
		quizzen.add(quiz);
	}

	//method voor deleten
	public void deleteQuiz( Opdracht opdracht ){
		quizzen.remove(opdracht);
	}
	
	//method om de lengte van de lijst te verkrijgen
	public int getLength(){
		return quizzen.size();
	}
	
	//method om met int een object op te halen (beginnend van 0)
	public Quiz getQuiz( int quiz ){
		return quizzen.get(quiz);
	}
	
	public void leesQuizzenVanDataBase(){
		String DB_URL = "jdbc:mysql://localhost/quizdb";
		try{
				Connection con  = DriverManager.getConnection(DB_URL, "root","root");
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from quizdb.quiz");
				while (res.next()){
					System.out.println(res.getString(2));
					  String naam = res.getString(1);
					  String leerjaren = res.getString(2);
					  String onderwerp = res.getString(3);
					  
					  Quiz q = new Quiz(naam, leerjaren, onderwerp);		
					  quizzen.add(q);
				}			 
			}
		catch(SQLException ex){System.out.println("SQL exception: "+ex.getMessage());}
	}
	
	public void leesQuizzenVanTekstBestand(){
		  File file = new File("bestanden/quizzen.txt");
		  Scanner scanner = null;
		  try{
			scanner = new Scanner(file);
			while (scanner.hasNext() && !scanner.hasNext("END")){
		      String lijn = scanner.nextLine();
			  String [] velden = lijn.split(",");
			  String naam = velden[0];
			  String leerjaren = velden[1];
			  String onderwerp = velden[2];
			  
			  Quiz q = new Quiz(naam, leerjaren, onderwerp);		
			  quizzen.add(q);

			}
		  }
		  catch(FileNotFoundException ex){
		    System.out.println("bestand met quizzen niet gevonden");
		  }
		  catch(ArrayIndexOutOfBoundsException ex){
			  System.out.println("Je bent buiten de grenzen van je array zaken aan het proberen op te halen");
		  }
		  catch(Exception ex){
		    System.out.println("Error message lees quiz van tekstbestand: " + ex.getMessage());
		  }
		  finally{
			  if (scanner!=null){
				  scanner.close();
				  }
		  }
		}
	
	public void schrijfQuizOpdrachtenNaarTekstBestand(){
		File file = new File("bestanden/quizzen.txt");
		try{
			PrintWriter writer = new PrintWriter(file);
			for (int i = 0 ; i <quizzen.size() ; i++){
				Quiz q = quizzen.get(i);
				String lijn = q.getNaam().toString() + "," + q.getleerjaren().toString() + "," + q.getOnderwerp().toString();
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
	
	public Quiz getQuizBijNaam( String naam ){
		Quiz q = null;
		for (int i = 0; i < quizzen.size(); i++ ){
			if (getQuiz(i).getNaam().contentEquals(naam)){
				q = getQuiz(i);
			}
		}
		if(q == null){
			throw new NullPointerException("Quiz met naam: " + naam + " niet gevonden");
		}
		return q;
	}
	
	@Override
	public String toString() {
		return "QuizCatalogus [quizzen=" + quizzen + "]";
	}
	
	@Override
	public Iterator<Quiz> iterator() {
		Iterator<Quiz> iterator = quizzen.iterator();
		return iterator;
	}
	
}// Einde class