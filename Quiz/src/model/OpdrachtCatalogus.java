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

public class OpdrachtCatalogus implements Iterable<Opdracht> {
	
	/* Aanpassingen: method voor opdracht te zoeken op vraag, method voor opdrachten te lezen van bestand
	 * 
	 * 
	 * TO DO:
	 * Testklasses schrijven
	 * logica voor verschillende soorten vragen (Polymorphisme toepassen)
	 * bij gebruik van onderliggende klassen casten naar subclasses 
	 * cast: Subclass referenceOfSubClass = (SubClass)referenceOfGeneralClass;
	 * (instanceof of .getClass().getName() gebruiken om te testen)
	 */
	
	//Lijst waar Opdracht objecten in gaan komen
	private ArrayList<Opdracht> opdrachten = new ArrayList<Opdracht>();
	
	//method voor toe te voegen
	public void addOpdracht( Opdracht opdracht ){
		opdrachten.add(opdracht);
	}

	//method voor deleten
	public void deleteOpdracht( Opdracht opdracht ){
		opdrachten.remove(opdracht);
	}
	
	//method om de lengte van de lijst te verkrijgen
	public int getLength(){
		return opdrachten.size();
	}
	
	//method om met int een object op te halen (beginnend van 0)
	public Opdracht getOpdracht( int opdracht ){
		return opdrachten.get(opdracht);
	}
	
	public void verwisselOpdracht( int opdracht, Opdracht nieuweOpdracht ){
		opdrachten.remove(opdracht);
		opdrachten.add(opdracht, nieuweOpdracht);
	}
	
	//method voor alle variabelen voor Opdracht te veranderen (deze zijn tot nu toe alleen voor de abstracte klasse)
	public void veranderOpdracht( int opdracht, String vraag, String juisteAntwoord, int aantalPogingen, int maxAntwoordTijd ){
		opdrachten.get(opdracht).setVraag(vraag);
		opdrachten.get(opdracht).setJuisteAntwoord(juisteAntwoord);
		opdrachten.get(opdracht).setAantalPogingen(aantalPogingen);
		opdrachten.get(opdracht).setMaxAntwoordTijd(maxAntwoordTijd);
	}

	//methods voor aanpassen van variabelen in Opdracht
	public void veranderVraag( int opdracht, String vraag ){
		opdrachten.get(opdracht).setVraag(vraag);
	}
	
	public void veranderJuisteAntwoord( int opdracht, String juisteAntwoord ){
		opdrachten.get(opdracht).setJuisteAntwoord(juisteAntwoord);
	}
	
	public void veranderAantalPogingen(int opdracht, int aantalPogingen){
		opdrachten.get(opdracht).setAantalPogingen(aantalPogingen);
	}
	
	public void veranderMaxAntwoordTijd( int opdracht, int maxAntwoordTijd ){
		opdrachten.get(opdracht).setMaxAntwoordTijd(maxAntwoordTijd);
	}
	
	public void leesOpdrachtenVanDataBase(){
		String DB_URL = "jdbc:mysql://localhost/quizdb";
		try{
				Connection con  = DriverManager.getConnection(DB_URL, "root","root");
				Statement st = con.createStatement();
				ResultSet res = st.executeQuery("select * from quizdb.quiz");
				while (res.next()){
					System.out.println(res.getString(2));
					  String categorie = res.getString(1);
					  String vraag = res.getString(2);
					  String juisteAntwoord = res.getString(3);
					  String type = res.getString(4);
					  String keuzesString = res.getString(5);
					  String [] veldenKeuzesString = keuzesString.split(",");
					  ArrayList<String> keuzes = new ArrayList<String>();
					  int n= 0;
					  while(veldenKeuzesString.length > n){
						  keuzes.add(veldenKeuzesString[n]);
						  n++;
					  }
					  OpdrachtFactory factory = new OpdrachtFactory();
					  opdrachten.add(factory.getOpdracht(type, categorie, vraag, juisteAntwoord, keuzes));
				}
			}
		catch(SQLException ex){System.out.println("SQL exception: "+ex.getMessage());}
	}
	
	public void leesOpdrachtenVanTekstBestand(){
		  File file = new File("bestanden/opdrachten.txt");
		  Scanner scanner = null ;
		  try{
			scanner = new Scanner(file);
			while (scanner.hasNext() && !scanner.hasNext("END")){
		      String lijn = scanner.nextLine();
			  String [] velden = lijn.split(",");
			  String categorie = velden[0];
			  String vraag = velden[1];
			  String juisteAntwoord = velden[2];
			  String type = velden[3];
				  ArrayList<String> keuzes = new ArrayList<String>();
				  int n= 4;
				  while(velden.length > n){
					  keuzes.add(velden[n]);
					  n++;
				  }
				  OpdrachtFactory factory = new OpdrachtFactory();
				  opdrachten.add(factory.getOpdracht(type, categorie, vraag, juisteAntwoord, keuzes));
			}
		  }
		  catch(FileNotFoundException ex){
		    System.out.println("bestand met opdrachten niet gevonden");
		  }
		  catch(Exception ex){
		    System.out.println("Error message lees opdracht van tekstbestand: " + ex.getMessage());
		  }
		  finally{
			  if (scanner!=null){
				  scanner.close();
				  }
		  }
	}
	
	public void schrijfOpdrachtenNaarTekstBestand(){
		File file = new File("bestanden/opdrachten.txt");
		try{
			PrintWriter writer = new PrintWriter(file);
			for (int i = 0 ; i <opdrachten.size() ; i++){
				Opdracht o = opdrachten.get(i);
				String lijn = null;
				if(o.type == "Meerkeuze"){
					lijn = o.getVraag() + "," + o.getJuisteAntwoord().toString() + "," + o.getType() + ",";
					Meerkeuze m = (Meerkeuze)o;
					int n = m.getKeuzes().size();
					while(n != 0){
						int keuze = n - 1;
						lijn += m.getKeuzes().get(keuze) + ",";
						n--;
					}
				}else{
					lijn = o.getVraag() + "," + o.getJuisteAntwoord().toString() + "," + o.getType();
				}
				writer.println(lijn);
			}
			writer.println("END");
			if (writer != null)
				writer.close();
			}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	public Opdracht getOpdrachtBijVraag( String vraag ){
		Opdracht o = null;
		try{
			for(Opdracht opdracht : opdrachten){
				if(opdracht.getVraag().contains(vraag)){
					o = opdracht;
				}
			}
			if(o == null){
				throw new Exception("Opdracht met opgegeven naam werd niet gevonden");
			}
		}
		catch(Exception ex){
			System.out.println("Error: " + ex.getMessage());
		}
		return o;
		/*
		Opdracht o = null;

		for (int i = 0; i < opdrachten.size(); i++ ){
			if (getOpdracht(i).getVraag().contentEquals(vraag)){
				o = getOpdracht(i);
			}
		}
		if(o == null){
			throw new NullPointerException("Opdracht met vraag: " + vraag + " niet gevonden");
		}
		return o;
		*/
	}
	
	@Override
	public String toString() {
		return "OpdrachtCatalogus [opdrachten=" + opdrachten + "]";
	}

	@Override
	public Iterator<Opdracht> iterator() {
		Iterator<Opdracht> iterator = opdrachten.iterator();
		return iterator;
	}
	
	public ArrayList<Opdracht> getListOpdrachten(){
		return this.opdrachten;
	}
/*
	public static void main(String[] args) {
		OpdrachtCatalogus x = new OpdrachtCatalogus();
		x.leesOpdrachtenVanTekstBestand();
		Opdracht o = x.getOpdrachtBijVraag("Wat is de hoofdstad van Duitsland?");
		System.out.println(o);
	}
*/
}// Einde class