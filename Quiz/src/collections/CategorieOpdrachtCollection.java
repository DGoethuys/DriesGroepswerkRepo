

//Oefening 6a
package collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import persistentie.PersistentieFacade;
import controller.OpstartController;

public class CategorieOpdrachtCollection {
	
	//PersistentieFacade object later gevuld door method getPersistentie uit OpstartController
	PersistentieFacade p;
	
	//Hashmap waar alles in word bijgehouden om daarna in te itereren
	HashMap<String, Integer> hm;
	
	public CategorieOpdrachtCollection(){
		//Opject van opstart controller die persistentie gekozen in init bestand zal terug geven
		OpstartController o = new OpstartController();
		p = o.getPersistentie();
		hm = new HashMap<String, Integer>();
	}
	
	public static void main(String[] args) {
		
		//aanmaken van object
		CategorieOpdrachtCollection coc = new CategorieOpdrachtCollection();
		//vullen van lijst met method vulLijst
		coc.vullijst();
		//tonen van lijst met method toonLijst
		coc.toonLijst();
	}// Einde main

	public void toonLijst(){
		//Set met alle Key waarden (categorie)
		Set<String> categorieSet = hm.keySet();
		//iterator van deze set
		Iterator<String> i = categorieSet.iterator();
		//itereren door deze set en de Key en Value pinten in console
		while(i.hasNext()){
		String categorie = i.next();
		System.out.println(categorie + "\t" + hm.get(categorie));
		}// Einde while
	}
	
	public void vullijst(){
		//int initialiseren om te incrementeren bij iteratie
		int opdracht = 0;
		//lengte van lijst met opdrachten in variabele length steken
		int length = p.getOpdrachtCatalogus().getLength();
		//HashMap vullen met key categorie en value als 1 (elke keer geincrementeerd als categorie
		//opnieuw voorkomt
		while(opdracht < length){
			String categorie = p.getOpdrachtCatalogus().getOpdracht(opdracht).getCategorie().toString();
			if(!hm.containsKey(categorie)){
				hm.put(categorie, 1);
			}else{
				int n = hm.get(categorie);
				n++;
				hm.put(categorie, n);
			} //Einde if...else
			opdracht++;
		}// Einde while
	}
	
}// Einde class
