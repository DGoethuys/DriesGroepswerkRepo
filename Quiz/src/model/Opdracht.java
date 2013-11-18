package model;

import java.io.Serializable;
import java.util.ArrayList;


public abstract class Opdracht implements Comparable<Quiz>, Cloneable, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * TO DO:
	 * Exceptions toevoegen
	 * compareTo()
	 * clone()
	 * Serializable?
	 */
	
	protected String vraag;
	protected String juisteAntwoord;
	protected int aantalPogingen;
	protected int maxAntwoordTijd;
	protected ArrayList<QuizOpdracht> quizOpdrachten = new ArrayList<QuizOpdracht>();
	
	//constructor die alleen vraag en antwoord nodig heeft en default waarde aan aantalPogingen en maxAntwoordTijd geeft
	public Opdracht(String vraag, String juisteAntwoord){
		this(vraag, juisteAntwoord, 3, 5);
	}
	
	//constructor voor alle parameters behalve de hints
	public Opdracht(String vraag, String juisteAntwoord, int aantalPogingen, int maxAntwoordTijd){
		this.setVraag(vraag);
		this.setJuisteAntwoord(juisteAntwoord);
		this.setAantalPogingen(aantalPogingen);
		this.setMaxAntwoordTijd(maxAntwoordTijd);	
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
	public void setVraag(String vraag)throws NullPointerException{
		if(this.vraag != null)
			this.vraag = vraag;
		else throw new NullPointerException("Vraag moet ingevuld zijn!");
	}
	
	public void setJuisteAntwoord(String juisteAntwoord) throws NullPointerException{
		if(this.juisteAntwoord != null)
			this.juisteAntwoord = juisteAntwoord;
		else throw new NullPointerException("Het juiste antwoord moet ingevuld zijn!");
	}
	
	public void setAantalPogingen(int aantalPogingen) throws NullPointerException{
		if(this.aantalPogingen != 0)
			this.aantalPogingen = aantalPogingen;
		else throw new NullPointerException("Er moet minstens 1 poging worden gegevens");
	}
	
	public void setMaxAntwoordTijd(int maxAntwoordTijd) throws NullPointerException{
		if(this.maxAntwoordTijd < 1)
			this.maxAntwoordTijd = maxAntwoordTijd;
		else throw new NullPointerException("Er moet een redelijke antwoordtijd worden opgegeven!");
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
	public int compareTo(Quiz o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	

}
