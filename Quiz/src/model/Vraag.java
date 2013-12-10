package model;

import java.util.ArrayList;

public class Vraag extends Opdracht implements Valideerbaar {
	
	/*TO-DO:
	 * Exceptions voor hint methods en isJusiteAntwoord()
	 */

	private static final long serialVersionUID = 1L;

	private ArrayList<String> hints = new ArrayList<String>();

	//constructor die alleen vraag en antwoord nodig heeft en default waarde aan aantalPogingen en maxAntwoordTijd geeft
	public Vraag (String categorie, String vraag, String juisteAntwoord){
		super(categorie, vraag, juisteAntwoord);
		super.type = "Vraag";
	}
	
	//constructor voor alle parameters behalve de hints
	public Vraag(String categorie, String vraag, String juisteAntwoord, int aantalPogingen, int maxAntwoordTijd ){
		super(categorie, vraag, juisteAntwoord, aantalPogingen, maxAntwoordTijd);
		super.type = "Vraag";
	}
	
	//constructor voor hints mee te geven
	public Vraag(String categorie, String vraag, String juisteAntwoord, int aantalPogingen,int maxAntwoordTijd , String ... hints ){
		super(categorie, vraag, juisteAntwoord, aantalPogingen, maxAntwoordTijd);
		int n = 0;
		while(hints.length < 0){
			this.addHint(hints[n]);
			n++;
		}
		super.type = "Vraag";
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
	
	public ArrayList<String> getHints(){
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
		return "Opdracht(Vraag) vraag: " + this.vraag + ", juiste antwoord: "
				+ this.juisteAntwoord + ", aantal pogingen: " + this.aantalPogingen
				+ ", maximale antwoord tijd: " + this.maxAntwoordTijd + ", hints: " + this.numberOfHints();
	}
	
	
	public static void main(String[] args) {
		Vraag opdracht1 = new Vraag("Vormen", "Wat is de vorm van de maan?", "rond", 5, 10);
		opdracht1.addHint("Bal");
		opdracht1.addHint("Hoepel");
		System.out.println(opdracht1.toString());
		System.out.println("Hint1 : " + opdracht1.getHint(0));
		System.out.println("Hint2: " + opdracht1.getHint(1));
		opdracht1.setAantalPogingen(4);
		System.out.println(opdracht1.toString());
	}

	@Override
	public boolean isValid(String antwoord) {
		return this.isJuisteAntwoord(antwoord);
	}

	@Override
	public String getValideerTekst() {
		return "Je antwoord voor vraag: \"" + this.vraag + "\" was juist.";
	}
}// Einde class