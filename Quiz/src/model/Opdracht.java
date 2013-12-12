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
		this(categorie, vraag, juisteAntwoord, 3, 5, "Meerkeuze");
	}
	
	//constructor voor alle parameters behalve de hints
	public Opdracht(String categorie, String vraag, String juisteAntwoord, int aantalPogingen, int maxAntwoordTijd, String type){
		this.setCategorie(categorie);
		this.setVraag(vraag);
		this.setJuisteAntwoord(juisteAntwoord);
		this.setAantalPogingen(aantalPogingen);
		this.setMaxAntwoordTijd(maxAntwoordTijd);
		this.setType(type);
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
		if(type != null)
			this.type = type;
		else throw new NullPointerException("Kies een Type!");
	} 
	
	public void setCategorie(String categorie)throws NullPointerException{
		if(categorie != null)
			this.categorie = categorie;
		else throw new NullPointerException("Categorie moet ingevuld zijn!");
	}
	
	
	public void setVraag(String vraag)throws NullPointerException{
		if(vraag != null)
			this.vraag = vraag;
		else throw new NullPointerException("Vraag moet ingevuld zijn!");
	}
	
	public void setJuisteAntwoord(String juisteAntwoord) throws NullPointerException{
		if(juisteAntwoord != null)
			this.juisteAntwoord = juisteAntwoord;
		else throw new NullPointerException("Het juiste antwoord moet ingevuld zijn!");
	}
	
	public void setAantalPogingen(int aantalPogingen) throws NullPointerException{
		if(aantalPogingen != 0)
			this.aantalPogingen = aantalPogingen;
		else throw new NullPointerException("Er moet minstens 1 poging worden gegevens");
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		 Opdracht clone=(Opdracht)super.clone();
		 return clone;
	}
	
	protected String uitleg(){
		return null;
	}
}// Einde class
