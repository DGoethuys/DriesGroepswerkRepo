package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Quiz implements Comparable<Quiz>, Cloneable, Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private String naam;
	private String onderwerp;
	private String leerjaren;
	private boolean test = false;
	protected ArrayList<QuizOpdracht> quizOpdrachten = new ArrayList<QuizOpdracht>();
	
	// constructor
	public Quiz( String naam, String leerjaren, String onderwerp){
		this.setNaam(naam);
		this.setLeerjaren(leerjaren);
		this.setOnderwerp(onderwerp);
	}
	
	//getters
	public String getNaam(){
		return this.naam;
	}
	
	public String getOnderwerp(){
		return this.onderwerp;
	}
	
	public String getleerjaren(){
		return this.leerjaren;	
	}
	
	//setters
	public void setNaam( String naam ){
		this.naam = naam;
	}
	
	public void setOnderwerp(String onderwerp){
		this.onderwerp = onderwerp;
	}
	public void setLeerjaren(String leerjaren){
		this.leerjaren = leerjaren;
	}
		

	
	public void setTest( int i){
		if(i == 1){
			test = true;
		}else if(i == 0){
			test = false;
		}
	}
	
	public boolean isTest(){
		return this.test;
	}
	public boolean isUniekeDeelname(){
		return this.test;
		
	}
	
	@Override
	public String toString() {
		return "Naam: " + this.naam + ", Onderwerp: "
				+ this.onderwerp + ", Voor Leerjaar: " + this.leerjaren;
	}

	@Override
	public int compareTo(Quiz o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Quiz clone=(Quiz)super.clone();
		return clone;
	}
}// Einde class
