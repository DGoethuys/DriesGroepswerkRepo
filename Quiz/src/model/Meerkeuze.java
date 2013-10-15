package model;

import java.util.ArrayList;

public class Meerkeuze extends Opdracht{

	private String vraag;
	private String juisteAntwoord;
	private int aantalPogingen;
	private ArrayList<String> Keuze = new ArrayList<String>();
	private int maxAntwoordTijd;
	private String keuze;
	
	
	public Meerkeuze() {
	 for (String s : Keuze)
		{
		    keuze += s + "\n";
		}
			
		// TODO Auto-generated constructor stub
	}
	
	
	public Meerkeuze(String vraag, String juisteAntwoord, int aantalPogingen, int maxAntwoordTijd, ArrayList<String> Keuze){
		this.setVraag(vraag);
		this.setJuisteAntwoord(juisteAntwoord);
		this.setAantalPogingen(aantalPogingen);
		this.setMaxAntwoordTijd(maxAntwoordTijd);
		this.setKeuze(Keuze);
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

}
