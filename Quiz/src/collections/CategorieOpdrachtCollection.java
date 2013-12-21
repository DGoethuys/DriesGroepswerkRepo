//Oefening 6a
package collections;

import java.util.HashMap;
import java.util.Iterator;

import model.Opdracht;
import persistentie.PersistentieFacade;

public class CategorieOpdrachtCollection {
	
	//PersistentieFacade object later gevuld door method getPersistentie uit OpstartController
	PersistentieFacade p = PersistentieFacade.getPersistentie();
	
	//Hashmap waar alles in word bijgehouden om daarna in te itereren
	HashMap<String, Integer> hm;
	
	public CategorieOpdrachtCollection(){
		//Opject van opstart controller die persistentie gekozen in init bestand zal terug geven
		hm = new HashMap<String, Integer>();
	}//Einde constructor
	
	public void vullijst(){
		//HashMap vullen met key categorie en value als 1 (elke keer geincrementeerd als categorie
		//opnieuw voorkomt
		for(Iterator<Opdracht> i = p.getOpdrachtCatalogus().iterator(); i.hasNext();){
			String categorie = i.next().getCategorie().toString();
			if(!hm.containsKey(categorie)){
				hm.put(categorie, 1);
			}else{
				int n = hm.get(categorie);
				n++;
				hm.put(categorie, n);
			} //Einde if...else
		}// Einde for
	}//Einde method
	
	public void toonLijst(){
		//itereren door deze set en de Key en Value pinten in console
		for(Iterator<String> i = hm.keySet().iterator();i.hasNext();){
		String categorie = i.next();
		System.out.println(categorie + "\t" + hm.get(categorie));
		}// Einde for
	}//Einde method
	
	public static void main(String[] args) {
		//aanmaken van object
		CategorieOpdrachtCollection coc = new CategorieOpdrachtCollection();
		//vullen van lijst met method vulLijst
		coc.vullijst();
		//tonen van lijst met method toonLijst
		coc.toonLijst();
	}// Einde main

	
}// Einde class
