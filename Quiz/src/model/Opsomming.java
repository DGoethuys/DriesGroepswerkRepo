package model;

public class Opsomming extends Opdracht implements Valideerbaar {
	

	public Opsomming ( String vraag, String juisteAntwoord){
		super( vraag, juisteAntwoord);
	}
	public Opsomming( String vraag, String juisteAntwoord, int aantalPogingen, int maxAntwoordTijd ){
		super( vraag, juisteAntwoord, aantalPogingen, maxAntwoordTijd);
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
		return "Opdracht - opsomming( zorg ervoor dat elk woord gescheiden moet zijn met een ';' ): " + this.vraag + "aantal pogingen: " + this.aantalPogingen
				+ ", maximale antwoord tijd: " + this.maxAntwoordTijd;
	}
	
	@Override
	public boolean isValid(String antwoord) {
		return true;
	}
	
	public static void main(String[] args) {
		Opsomming opsomming1 = new Opsomming("Zet in juiste volgorde: dinsdag, donderdag, woensdag, maandag ", "maandag, dinsdag, woensdag, donderdag",5,10);
		System.out.println(opsomming1.toString());
		

	}

	
	

	
	

}
