package model;


public class QuizOpdracht {
	
	/*Aanpassingen: Setters en getters toegevoegd, method om een bestand in te lezen, constructor die met behulp
	 * van catalogussen quizzen en opdrachten zoekt bij naam en vraag
	 * 
	 * TO-DO:
	 * 
	 *	Nog vrij onduidelijk wat hier moet gebeuren, ik ben nu aant werken naar 3 bestanden:
	 * een met quizzen, een met opdrachten en een met quizopdrachten
	 * Weet totaal niet of dit de juiste manier is en ben aant denken ook een QuizOpdrachtcatalogus te maken
	 * want het is onlogisch om dit hier in te dumpen, maar dit word momenteel wel gedaan xD
	 */
	
	private Quiz quiz;
	private Opdracht opdracht;
	private int maxScore;
	
	QuizOpdracht(Quiz quiz, Opdracht opdracht, int maxScore){
		this.setQuiz(quiz);
		this.setOpdracht(opdracht);
		this.setMaxScore(maxScore);
	}
	
 	QuizOpdracht(String naam, String vraag, int maxScore){
	QuizCatalogus qc = new QuizCatalogus();
	qc.leesQuizzenVanTekstBestand();
	Quiz quiz = qc.getQuizBijNaam(naam);
	
	OpdrachtCatalogus oc = new OpdrachtCatalogus();
	oc.leesOpdrachtenVanTekstBestand();
	Opdracht opdracht = oc.getOpdrachtBijVraag(vraag);
	
	this.setQuiz(quiz);
	this.setOpdracht(opdracht);
	this.setMaxScore(maxScore);
 	}
	
	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public Opdracht getOpdracht() {
		return opdracht;
	}

	public void setOpdracht(Opdracht opdracht) {
		this.opdracht = opdracht;
	}

	public int getMaxScore() {
		return maxScore;
	}

	public void setMaxScore(int maxScore) {
		this.maxScore = maxScore;
	}

}