package model;

import java.util.ArrayList;

public class QuizCatalogus {
	
	/*
	 * TO DO:
	 * Testklasses schrijven
	 * Method voor wijzigen van Quiz objecten
	 */
	
	//Lijst waar Quiz objecten in gaan komen
	private ArrayList<Quiz> quizzen = new ArrayList<Quiz>();
	
	//method voor toe te voegen
	public void addQuiz( Quiz quiz ){
		quizzen.add(quiz);
	}

	//method voor deleten
	public void deleteQuiz( Opdracht opdracht ){
		quizzen.remove(opdracht);
	}
	
	//method om de lengte van de lijst te verkrijgen
	public int getLength(){
		return quizzen.size();
	}
	
	//method om met int een object op te halen (beginnend van 0)
	public Quiz getQuiz( int quiz ){
		return quizzen.get(quiz);
	}

	@Override
	public String toString() {
		return "QuizCatalogus [quizzen=" + quizzen + "]";
	}
	
}
