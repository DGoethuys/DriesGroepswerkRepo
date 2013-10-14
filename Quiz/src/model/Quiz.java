package model;

import java.util.ArrayList;

public class Quiz {
	
	
	private String onderwerp;
	private String leerjaren;
	private ArrayList<String> quiz = new ArrayList<String>();
	private boolean test = false;
	
	// constructor
	public Quiz( String leerjaren, String onderwerp){
		this.setLeerjaren(leerjaren);
		this.setOnderwerp(onderwerp);
	}
	
	//getters	
	public String getOnderwerp(){
		return this.onderwerp;
	}
	
	public String getleerjaren(){
		return this.leerjaren;	
	}
	
	//setters
	
	public void setOnderwerp(String onderwerp){
		this.onderwerp = onderwerp;
	}
	public void setLeerjaren(String leerjaren){
		this.leerjaren = leerjaren;
	}
		
	// toevoegen en verwijderen van quiz
	public void addQuiz( String quiz ){
		this.quiz.add(quiz);
	}

	public void removeQuiz( String Quiz ){
		this.quiz.remove(quiz);
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
		return test;
		
	}
	
	@Override
	public String toString() {
		return "Quiz: " + this.quiz + ", Onderwerp: "
				+ this.onderwerp + ", Voor Leerjaar: " + this.leerjaren;
	}

	public static void main(String[] args) {
		
	}
}

