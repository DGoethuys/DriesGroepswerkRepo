package model;

import java.util.ArrayList;

public class Meerkeuze extends Opdracht implements Valideerbaar{

	private static final long serialVersionUID = 1L;
	private ArrayList<String> keuzes = new ArrayList<String>();
	
	
	public Meerkeuze(String vraag, String juisteAntwoord, ArrayList<String> keuzes) {
		super( vraag, juisteAntwoord);
		this.keuzes = keuzes;
	}
	
	
	public Meerkeuze(String vraag, String juisteAntwoord, ArrayList<String> keuzes, int aantalPogingen, int maxAntwoordTijd){
		super( vraag, juisteAntwoord, aantalPogingen, maxAntwoordTijd);
		this.keuzes = keuzes;
	}
	
	public void setKeuzes(ArrayList<String> keuzes ){
		this.keuzes = keuzes;
	}
	
	public ArrayList<String> getKeuzes(){
		return this.keuzes;
	}
	
	@Override
	public String toString() {
		return "Opdracht - vraag: " + this.vraag + ", juiste antwoord: "
				+ this.juisteAntwoord + ", aantal pogingen: " + this.aantalPogingen
				+ ", maximale antwoord tijd: " + this.maxAntwoordTijd + ", Keuzes: " + this.keuzes;
	}
	
	public boolean isValid(){
		return true;
	}


	@Override
	public boolean isValid(String antwoord) {
		return this.isJuisteAntwoord(antwoord);
	}


	@Override
	public String getValideerTekst() {
		return "Je hebt de juiste keuze gekozen voor de vraag: \"" + this.vraag + "\"";
	}

}
