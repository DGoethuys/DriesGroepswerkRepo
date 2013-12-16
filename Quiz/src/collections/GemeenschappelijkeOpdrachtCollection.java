//Oefening 6b

package collections;

import java.util.HashSet;

import model.Quiz;
import model.QuizOpdracht;
import controller.OpstartController;
import persistentie.PersistentieFacade;
import views.IO;


public class GemeenschappelijkeOpdrachtCollection {
	
	//PersistentieFacade object later gevuld door method getPersistentie uit OpstartController
	private PersistentieFacade p;
	
	private HashSet<String> hsOpdrachten;
	private HashSet<String> hsQuizzenMetOpdrachten;
	private String quizNaam;
	
	public GemeenschappelijkeOpdrachtCollection(String qN){
		//Opject van opstart controller die persistentie gekozen in init bestand zal terug geven
		OpstartController o = new OpstartController();
		p = o.getPersistentie();
		//quiz naam bepalen
		this.setQuizNaam(qN);
		//lijst van opdrachten voor huidige gekozen quiz in HashSet steken
		this.lijstOpdrachtenVullen();
		//lijst om te tonen met alle gemeenschappelijke quizzen en hun opdrachten
		this.lijstQuizzenMetOpdrachtenVullen();
		//lijst tonen
		this.toonLijst();
	}
	
	//quizNaam aanpassen
	private void setQuizNaam(String qN){
		this.quizNaam = qN;
	}
	
	public String getQuizNaam(){
		return this.quizNaam;
	}
	
	private void lijstOpdrachtenVullen(){
		hsOpdrachten = new HashSet<String>();
		for(QuizOpdracht qo : p.getQuizOpdrachtCatalogus()){
			if(qo.getQuiz().getNaam().contains(quizNaam)){
				hsOpdrachten.add(qo.getOpdracht().getVraag().toString());
			}
		}
	}
	
	private void lijstQuizzenMetOpdrachtenVullen(){
		hsQuizzenMetOpdrachten = new HashSet<String>();
		for(Quiz q : p.getQuizCatalogus()){
			if(!q.getNaam().contains(this.getQuizNaam())){
				String str = q.getNaam();
				boolean toevoegen = false;
				for(QuizOpdracht qo : p.getQuizOpdrachtCatalogus()){
					if(qo.getQuiz().getNaam().contains(q.getNaam())){
						String opdracht = qo.getOpdracht().getVraag().toString();
						if(hsOpdrachten.contains(opdracht)){
							str += "\n\t" + qo.getOpdracht().getVraag();
							toevoegen = true;
						}
					}
				}
				if(toevoegen){
					hsQuizzenMetOpdrachten.add(str);
				}
			}
		}
	}
	
	public void toonLijst(){
		System.out.println("\nGeselecteerde quiz: " + this.getQuizNaam() + "\nQuizen met gemeenschappelijke opdrachten:");
		for(String str : hsQuizzenMetOpdrachten){
			System.out.println(str);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Beschikbare quizzen: ");
		for(Quiz q : new OpstartController().getPersistentie().getQuizCatalogus()){
			System.out.println(q.getNaam());
		}
		boolean opnieuw = false;
		do{
			//aanmaken van object
			GemeenschappelijkeOpdrachtCollection goc = new GemeenschappelijkeOpdrachtCollection(IO.leesString("Geef een quiz op: "));
			if(IO.leesChar("Opnieuw? (J/N)") == 'J'){
				opnieuw = true;
			}
		}while(opnieuw);
	}// Einde main
}// Einde class