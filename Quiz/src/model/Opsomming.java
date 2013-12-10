package model;

public class Opsomming extends Opdracht implements Valideerbaar {
	
	private static final long serialVersionUID = 1L;
	
	public Opsomming (String categorie, String vraag, String juisteAntwoord){
		super(categorie, vraag, juisteAntwoord);
		super.type = "Opsomming";
	}
	public Opsomming(String categorie, String vraag, String juisteAntwoord, int aantalPogingen, int maxAntwoordTijd ){
		super(categorie, vraag, juisteAntwoord, aantalPogingen, maxAntwoordTijd);
		super.type = "Opsomming";
	}
	
	//method om te bepalen of juiste antwoord is gegeven
	public boolean isJuisteVolgorde( String antwoord ){
		if( antwoord == this.juisteAntwoord){
			return true;
		}else{
			return false;
		}
	}	
	@Override
	public String toString() {
		return "Opdracht(Opsomming) vraag: " + this.vraag + "aantal pogingen: " + this.aantalPogingen
				+ ", maximale antwoord tijd: " + this.maxAntwoordTijd;
	}
	
	@Override
	public String uitleg(){
		return "Zet de opsomming uit de opgave in de juiste volgorde, zorg ervoor dat elk woord/cijfer gescheiden is met een ';'";
	}
	
	@Override
	public boolean isValid(String antwoord) {
		return this.isJuisteVolgorde(antwoord);
	}
	
	@Override
	public String getValideerTekst() {
		return "Je hebt de vraag: \"" + this.vraag + "\" in de juiste volgorde gezet.";
	}
	
	public static void main(String[] args) {
		Opsomming opsomming1 = new Opsomming("Dagen kennis", "Zet in juiste volgorde: dinsdag, donderdag, woensdag, maandag ", "maandag, dinsdag, woensdag, donderdag",5,10);
		System.out.println(opsomming1.toString());
	}
}// Einde class
