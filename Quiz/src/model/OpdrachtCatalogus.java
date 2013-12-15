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
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Klasse die een catalogus bijhoud van Opdrachten
 * 
 * @author Dries Goethuys
 *
 */
public class OpdrachtCatalogus implements Iterable<Opdracht> {
		
	/**
	 * Lijst waar Opdracht objecten in gaan komen
	 */
	private HashSet<Opdracht> opdrachten = new HashSet<Opdracht>();
	
	/**
	 * method voor toe te voegen
	 * @param opdracht
	 */
	public void addOpdracht( Opdracht opdracht ){
		opdrachten.add(opdracht);
	}

	/**
	 * method voor deleten
	 * @param opdracht
	 */
	public void deleteOpdracht( Opdracht opdracht ){
		opdrachten.remove(opdracht);
	}
	
	/**
	 * method om de lengte van de lijst te verkrijgen
	 */
	public int getLength(){
		return opdrachten.size();
	}
	
	/**
	 * method om met int een object op te halen (beginnend van 0)
	 * @param opdracht
	 * @return Opdracht
	 */
	public Opdracht getOpdracht( int opdracht ){
        ArrayList<Opdracht> oArrayList = new ArrayList<Opdracht>();
    	for(Opdracht o : opdrachten){
    		oArrayList.add(o);
    	}
		return oArrayList.get(opdracht);
	}
	
	/**
	 * method voor alle variabelen voor Opdracht te veranderen (deze zijn tot nu toe alleen voor de abstracte klasse)
	 * @param opdracht
	 * @param vraag
	 * @param juisteAntwoord
	 * @param aantalPogingen
	 * @param maxAntwoordTijd
	 */
	public void veranderOpdracht( int opdracht, String vraag, String juisteAntwoord, int aantalPogingen, int maxAntwoordTijd ){
		getOpdracht(opdracht).setVraag(vraag);
		getOpdracht(opdracht).setJuisteAntwoord(juisteAntwoord);
		getOpdracht(opdracht).setAantalPogingen(aantalPogingen);
		getOpdracht(opdracht).setMaxAntwoordTijd(maxAntwoordTijd);
	}

	/**
	 * methods voor aanpassen van vraag in Opdracht
	 * @param opdracht
	 * @param vraag
	 */
	public void veranderVraag( int opdracht, String vraag ){
		getOpdracht(opdracht).setVraag(vraag);
	}
	
	public void veranderJuisteAntwoord( int opdracht, String juisteAntwoord ){
		getOpdracht(opdracht).setJuisteAntwoord(juisteAntwoord);
	}
	
	public void veranderAantalPogingen(int opdracht, int aantalPogingen){
		getOpdracht(opdracht).setAantalPogingen(aantalPogingen);
	}
	
	public void veranderMaxAntwoordTijd( int opdracht, int maxAntwoordTijd ){
		getOpdracht(opdracht).setMaxAntwoordTijd(maxAntwoordTijd);
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
	/**
	 * Method om data weg te schrijven naar tekstbestanden
	 */
	public void schrijfOpdrachtenNaarTekstBestand(){
		File file = new File("bestanden/opdrachten.txt");
		try{
			PrintWriter writer = new PrintWriter(file);
			for (int i = 0 ; i <opdrachten.size() ; i++){
				Opdracht o = getOpdracht(i);
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
	
	public HashSet<Opdracht> getListOpdrachten(){
		return this.opdrachten;
	}
}// Einde class