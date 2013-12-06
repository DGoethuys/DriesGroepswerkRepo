package persistentie;

import model.OpdrachtCatalogus;
import model.QuizCatalogus;
import model.QuizOpdrachtCatalogus;

//Hier in worden de namen van de methods gedeclareerd die we zullen gebruiken voor data te laden
//en op te slaan in zowel de database als de textbestanden
//Catalogussen staan hier in zodat deze in allebij de persistenties kunnen gebruikt worden zonder
//ze appart te declareren en initialiseren

public interface PersistentieFacade {
	OpdrachtCatalogus oc = new OpdrachtCatalogus();
	QuizCatalogus qc = new QuizCatalogus();
	QuizOpdrachtCatalogus qoc = new QuizOpdrachtCatalogus();
	
	public void laadData();
	public void bewaarData();
	
}