//Jan past Exceptions aan + de bijhorende testen
package model;

import java.io.Serializable;
import java.util.ArrayList;


public abstract class Opdracht implements Comparable<Opdracht>, Cloneable, Serializable {
	
	private static final long serialVersionUID = 1L;
	/*
	 * TO DO:
	 * Exceptions toevoegen
	 * compareTo()
	 * clone()
	 * Serializable?
	 */
	
	protected String categorie;
	protected String vraag;
	protected String juisteAntwoord;
	protected int aantalPogingen;
	protected int maxAntwoordTijd;
	protected String type;


	protected ArrayList<QuizOpdracht> quizOpdrachten = new ArrayList<QuizOpdracht>();
	
	//constructor die alleen vraag en antwoord nodig heeft en default waarde aan aantalPogingen en maxAntwoordTijd geeft
	public Opdracht(String categorie, String vraag, String juisteAntwoord){
		this(categorie, vraag, juisteAntwoord, 3, 5);
	}
	
	//constructor voor alle parameters behalve de hints
	public Opdracht(String categorie, String vraag, String juisteAntwoord, int aantalPogingen, int maxAntwoordTijd){
		this.setCategorie(categorie);
		this.setVraag(vraag);
		this.setJuisteAntwoord(juisteAntwoord);
		this.setAantalPogingen(aantalPogingen);
		this.setMaxAntwoordTijd(maxAntwoordTijd);
	}
	
	//getters
	public String getCategorie(){
		return this.categorie;
	}
	
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
	
	public String getType() {
		return type;
	}
	
	//setters
	public void setType(String type)throws NullPointerException{
		if(type == null)
			throw new NullPointerException("Kies een Type!");
		else this.type = type;
	} 
	
	public void setCategorie(String categorie)throws NullPointerException{
		if(categorie == null)
			throw new NullPointerException("Categorie moet ingevuld zijn!");
		else this.categorie = categorie;
	}
	
	
	public void setVraag(String vraag)throws NullPointerException{
		if(vraag == null)
			throw new NullPointerException("Vraag moet ingevuld zijn!");
		else this.vraag = vraag;
	}
	
	public void setJuisteAntwoord(String juisteAntwoord) throws NullPointerException{
		if(juisteAntwoord == null)
			throw new NullPointerException("Het juiste antwoord moet ingevuld zijn!");
		else this.juisteAntwoord = juisteAntwoord;
	}
	
	public void setAantalPogingen(int aantalPogingen) throws NullPointerException{
		if(aantalPogingen == 0)
			throw new NullPointerException("Er moet minstens 1 poging worden gegevens");
		else this.aantalPogingen = aantalPogingen;
	}
	
	public void setMaxAntwoordTijd(int maxAntwoordTijd) throws NullPointerException{
		if(maxAntwoordTijd > 1)
			this.maxAntwoordTijd = maxAntwoordTijd;
		else throw new NullPointerException("Er moet een redelijke antwoordtijd worden opgegeven!");
	}
	
	//method om te bepalen of juiste antwoord is gegeven
	public boolean isJuisteAntwoord( String antwoord ){
		if(antwoord == this.juisteAntwoord){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public int compareTo(Opdracht o) {
		return this.vraag.toString().compareTo(o.vraag.toString());
	}
	
	protected String uitleg(){
		return null;
	}
	
	public static void main(String[] args) {
		Opdracht o1 = new Vraag("Aardrijkskunde", "Wat is de hoofdstad van Belgi�?", "Brussel");
		Opdracht o2 = new Vraag("Aardrijkskunde", "Wat is de hoofdstad van Itali�?", "Brussel");
		System.out.print(o1.compareTo(o2));
	}
}// Einde class
