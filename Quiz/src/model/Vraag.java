package model;

import java.util.ArrayList;

public class Vraag extends Opdracht {

	private ArrayList<String> hints = new ArrayList<String>();
	
	public Vraag (){
		
	}
	
	//constructor die alleen vraag en antwoord nodig heeft en default waarde aan aantalPogingen en maxAntwoordTijd geeft
	public Vraag ( String vraag, String juisteAntwoord){
		super( vraag, juisteAntwoord);
	}
	
	//constructor voor alle parameters behalve de hints
	public Vraag( String vraag, String juisteAntwoord, int aantalPogingen, int maxAntwoordTijd ){
		super( vraag, juisteAntwoord, aantalPogingen, maxAntwoordTijd);
	}
	
	//3 constructoren voor hints mee te geven, van 1 tot 3
	public Vraag( String vraag, String juisteAntwoord, int aantalPogingen,int maxAntwoordTijd , String hint1 ){
		super(vraag, juisteAntwoord, aantalPogingen, maxAntwoordTijd);
		this.addHint(hint1);
	}

	public Vraag( String vraag, String juisteAntwoord, int aantalPogingen,int maxAntwoordTijd , String hint1 , String hint2 ){
		super(vraag, juisteAntwoord, aantalPogingen, maxAntwoordTijd);
		this.addHint(hint1);
		this.addHint(hint2);
	}
	
	public Vraag( String vraag, String juisteAntwoord, int aantalPogingen,int maxAntwoordTijd , String hint1, String hint2, String hint3 ){
		super(vraag, juisteAntwoord, aantalPogingen, maxAntwoordTijd);
		this.addHint(hint1);
		this.addHint(hint2);
		this.addHint(hint3);
	}
	
	//methods voor het toevoegen of verwijderen van hints
	public void addHint( String hint ){
		this.hints.add(hint);
	}
	
	public void removeHint( int hint ){
		this.hints.remove(hint);
	}
	
	public void removeLastHint(){
		this.removeHint(this.numberOfHints() - 1);
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
		return this.hints.get(numberOfHints - 1);
	}
	
	public String getFirstHint(){
		return this.hints.get(0);
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
		return "Opdracht - vraag: " + this.vraag + ", juiste antwoord: "
				+ this.juisteAntwoord + ", aantal pogingen: " + this.aantalPogingen
				+ ", maximale antwoord tijd: " + this.maxAntwoordTijd + ", hints: " + this.numberOfHints();
	}
	
	
	public static void main(String[] args) {
		Vraag opdracht1 = new Vraag( "Wat is de vorm van de maan?", "rond", 5, 10);
		opdracht1.addHint("Bal");
		opdracht1.addHint("Hoepel");
		System.out.println(opdracht1.toString());
		System.out.println("Hint1 : " + opdracht1.getHint(0));
		System.out.println("Hint2: " + opdracht1.getHint(1));
		System.out.println("Eerste hint: " + opdracht1.getFirstHint());
		System.out.println("Laatste hint: " + opdracht1.getLastHint());
		System.out.println("Alle hints :" +opdracht1.getAllHints());
		opdracht1.setAantalPogingen(4);
		System.out.println(opdracht1.toString());


	}

}
