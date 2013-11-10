package model;

import java.util.ArrayList;

public class Meerkeuze extends Opdracht implements Valideerbaar{

	
	private ArrayList<String> Keuze = new ArrayList<String>();
	private String keuze;
	
	
	//public Meerkeuze() {
	// for (String s : Keuze)
	//	{
	//	    keuze += s + "\n";
	//	}
			
		// TODO Auto-generated constructor stub
	//}
	
	
	public Meerkeuze(String vraag, String juisteAntwoord, int aantalPogingen, int maxAntwoordTijd, ArrayList<String> Keuze){
		super( vraag, juisteAntwoord, aantalPogingen, maxAntwoordTijd);
		this.Keuze = Keuze;
	}
	
	public void setKeuze(ArrayList<String> Keuze ){
		this.Keuze = Keuze;
	}
	
	public ArrayList<String> getKeuze(){
		return this.Keuze;
	}
	
	@Override
	public String toString() {
		return "Opdracht - vraag: " + this.vraag + ", juiste antwoord: "
				+ this.juisteAntwoord + ", aantal pogingen: " + this.aantalPogingen
				+ ", maximale antwoord tijd: " + this.maxAntwoordTijd + ", Keuzes: " + this.keuze;
	}
	
	public boolean isValid(){
		return true;
	}


	@Override
	public boolean isValid(String antwoord) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public String getValideerTekst() {
		// TODO Auto-generated method stub
		return null;
	}

}
