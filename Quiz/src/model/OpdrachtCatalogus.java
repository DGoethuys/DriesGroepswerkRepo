package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class OpdrachtCatalogus {
	
	/* Aanpassingen: method voor opdracht te zoeken op vraag, method voor opdrachten te lezen van bestand
	 * 
	 * 
	 * TO DO:
	 * Testklasses schrijven
	 * logica voor verschillende soorten vragen (Polymorphisme toepassen)
	 * bij gebruik van onderliggende klassen casten naar subclasses 
	 * cast: Subclass referenceOfSubClass = (SubClass)referenceOfGeneralClass;
	 * (instanceof of .getClass().getName() gebruiken om te testen)
	 * Methods voor wegschrijven in file
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
	
	public void leesOpdrachtenVanTekstBestand(){
		  File file = new File("bestanden/opdrachten.txt");
		  try{
			Scanner scanner = new Scanner(file);
			while (scanner.hasNext()){
		      String lijn = scanner.nextLine();
			  String [] velden = lijn.split(",");
			  String vraag = velden[0];
			  String juisteAntwoord = velden[1];
			  String type = velden[2];
			  int n = 3;
			  ArrayList<String> keuzes = new ArrayList<String>();
			  while (scanner.hasNext()){
				  keuzes.add(velden[n]);
			  }
			  switch(type){
			  case "Vraag":
				  Opdracht v = new Vraag(vraag, juisteAntwoord);		
				  opdrachten.add(v);
				  break;
			  case "Meerkeuze":
				  Opdracht m = new Meerkeuze(vraag, juisteAntwoord, keuzes);		
				  opdrachten.add(m);
				  break;
			  case "Opsomming":
				  Opdracht o = new Opsomming(vraag, juisteAntwoord);		
				  opdrachten.add(o);
				  break;
			  }

			}
			if (scanner!=null){
			  scanner.close();
			}
		  }
		  catch(FileNotFoundException ex){
		    System.out.println("bestand met opdrachten niet gevonden");
		  }
		  catch(Exception ex){
		    System.out.println(ex.getMessage());
		  }
		}
	
	public Opdracht getOpdrachtBijVraag( String vraag ){
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
	}
	
	@Override
	public String toString() {
		return "OpdrachtCatalogus [opdrachten=" + opdrachten + "]";
	}
}