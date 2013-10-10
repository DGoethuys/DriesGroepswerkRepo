package model;

import java.util.ArrayList;

public class Opdracht {

	private String vraag;
	private String juisteAntwoord;
	private int aantalPogingen;
	private ArrayList<String> hints;
	private int maxAntwoordTijd;
	
	//constructor die alleen vraag en antwoord nodig heeft en default waarde aan aantalPogingen en maxAntwoordTijd geeft
	public Opdracht ( String vraag, String juisteAntwoord){
		this( vraag, juisteAntwoord, 3, 5);
	}
	
	//constructor voor alle parameters behalve de hints
	public Opdracht( String vraag, String juisteAntwoord, int aantalPogingen, int maxAntwoordTijd ){
		this.setVraag(vraag);
		this.setJuisteAntwoord(juisteAntwoord);
		this.setAantalPogingen(aantalPogingen);
		this.setMaxAntwoordTijd(maxAntwoordTijd);
	}
	
	//3 constructoren voor hints mee te geven, van 1 tot 3
	public Opdracht( String vraag, String juisteAntwoord, int aantalPogingen,int maxAntwoordTijd , String hint1 ){
		this.setVraag(vraag);
		this.setJuisteAntwoord(juisteAntwoord);
		this.setAantalPogingen(aantalPogingen);
		this.setMaxAntwoordTijd(maxAntwoordTijd);
		this.addHint(hint1);
	}

	public Opdracht( String vraag, String juisteAntwoord, int aantalPogingen,int maxAntwoordTijd , String hint1 , String hint2 ){
		this.setVraag(vraag);
		this.setJuisteAntwoord(juisteAntwoord);
		this.setAantalPogingen(aantalPogingen);
		this.setMaxAntwoordTijd(maxAntwoordTijd);
		this.addHint(hint1);
		this.addHint(hint2);
	}
	
	public Opdracht( String vraag, String juisteAntwoord, int aantalPogingen,int maxAntwoordTijd , String hint1, String hint2, String hint3 ){
		this.setVraag(vraag);
		this.setJuisteAntwoord(juisteAntwoord);
		this.setAantalPogingen(aantalPogingen);
		this.setMaxAntwoordTijd(maxAntwoordTijd);
		this.addHint(hint1);
		this.addHint(hint2);
		this.addHint(hint3);
	}
	
	//getters
	public String getVraag(){
		return this.vraag;
	}
	
	public String getJuisteAntwoord(){
		return this.juisteAntwoord;
	}
	
	public int getAantalPogingen(){
		return this.aantalPogingen;
	}
	
	public int getMaxAntwoordTijd(){
		return this.maxAntwoordTijd;
	}
	
	//setters
	public void setVraag( String vraag ){
		this.vraag = vraag;
	}
	
	public void setJuisteAntwoord( String juisteAntwoord ){
		this.juisteAntwoord = juisteAntwoord;
	}
	
	public void setAantalPogingen( int aantalPogingen ){
		this.aantalPogingen = aantalPogingen;
	}
	
	public void setMaxAntwoordTijd( int maxAntwoordTijd ){
		this.maxAntwoordTijd = maxAntwoordTijd;
	}
	
	//methods voor het toevoegen of verwijderen van hints
	public void addHint( String hint ){
		this.hints.add(hint);
	}
	
	public void removeHint( int hint ){
		this.hints.remove(hint);
	}
	
	public void removeLastHint(){
		this.removeHint(this.numberOfHints());
	}
	
	public int numberOfHints(){
		int numberOfHints = this.hints.size();
		return numberOfHints;
	}
	
	public String getHint( int hint ){
		return this.hints.get(hint);
	}
	
	public String getLastHint(){
		int numberOfHints = this.numberOfHints();
		return this.hints.get(numberOfHints);
	}
	
	public ArrayList<String> getAllHints(){
		return hints;
	}
	
	//method om te bepalen of juiste antwoord is gegeven
	public boolean isJuisteAntwoord( String antwoord ){
		if( antwoord == this.juisteAntwoord ){
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "Opdracht - vraag: " + vraag + ", juiste antwoord: "
				+ juisteAntwoord + ", aantal pogingen: " + aantalPogingen
				+ ", maximale antwoord tijd: " + maxAntwoordTijd + ", hints: " + this.numberOfHints();
	}
	
	
	public static void main(String[] args) {
		


	}

}
