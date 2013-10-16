package model;

import java.util.ArrayList;

public class OpdrachtCatalogus {
	
	/*
	 * TO DO:
	 * Testklasses schrijven
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
	
	public void veranderAantalPogingen( int opdracht, int aantalPogingen ){
		opdrachten.get(opdracht).setAantalPogingen(aantalPogingen);
	}
	
	public void veranderMaxAntwoordTijd( int opdracht, int maxAntwoordTijd ){
		opdrachten.get(opdracht).setMaxAntwoordTijd(maxAntwoordTijd);
	}
	
	@Override
	public String toString() {
		return "OpdrachtCatalogus [opdrachten=" + opdrachten + "]";
	}
}
