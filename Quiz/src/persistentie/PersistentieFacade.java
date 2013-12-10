package persistentie;

import model.OpdrachtCatalogus;
import model.QuizCatalogus;
import model.QuizOpdrachtCatalogus;

//Hier in worden de namen van de methods gedeclareerd die we zullen gebruiken voor data te laden
//en op te slaan in zowel de database als de textbestanden
//Catalogussen staan hier in zodat deze in allebij de persistenties kunnen gebruikt worden zonder
//ze appart te declareren en initialiseren

public abstract class PersistentieFacade {
	protected OpdrachtCatalogus oc = new OpdrachtCatalogus();
	protected QuizCatalogus qc = new QuizCatalogus();
	protected QuizOpdrachtCatalogus qoc = new QuizOpdrachtCatalogus();
	
	public abstract void laadData();
	public abstract void bewaarData();
	public abstract String getPersistentieType();
	
	public OpdrachtCatalogus getOpdrachtCatalogus(){
		return oc;
	}
	
	public QuizCatalogus getQuizCatalogus(){
		return qc;
	}
	
	public QuizOpdrachtCatalogus getQuizOpdrachtCatalogus(){
		return qoc;
	}
	
}// Einde class
