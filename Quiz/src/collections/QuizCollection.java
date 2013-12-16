// Jan
package collections;

import model.*;
import Enums.*;

import java.lang.reflect.Array;
import java.util.*;

import persistentie.PersistentieFacade;
import controller.OpstartController;

import javax.swing.JList;




public class QuizCollection {
	
	//PersistentieFacade object later gevuld door method getPersistentie uit OpstartController
		PersistentieFacade p;
		
	//TreeMap
		Map TreeMap = new TreeMap();
	
		
	//Method
		public QuizCollection(){
			//Opject van opstart controller die persistentie gekozen in init bestand zal terug geven
			OpstartController o = new OpstartController();
			p = o.getPersistentie();
			TreeMap = new TreeMap<String, Integer>();
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
			Set<String> categorieSet = TreeMap.keySet();
			//iterator van deze set
			Iterator<String> i = categorieSet.iterator();
			//itereren door deze set en de Key en Value pinten in console
			while(i.hasNext()){
			String categorie = i.next();
			System.out.println(categorie + "\t" + TreeMap.get(categorie));
			}// Einde while
			
		
		public void vullijst(){
			//int initialiseren om te incrementeren bij iteratie
			int quiz = 0;
			//lengte van lijst met Quiz in variabele length steken
			int length = p.getQuizCatalogus().getLength();
			//TreeMap vullen
			while( quiz < length){
				String opdracht = p.getQuizOpdrachtCatalogus().getQuizOpdracht(quiz).toString();
				}
			if(!TreeMap.containsKey(quiz)){
				TreeMap.put(quiz, 1);
			}else{
				int n = TreeMap.get(quiz);
				n++;
				TreeMap.put(quiz, n);
			} //Einde if...else
				quiz++;
			}// Einde while
		}

// Einde class
