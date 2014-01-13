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
		//Map TreeMap = new TreeMap();
		SortedMap<Integer,Integer> naammap = 
                new TreeMap<Integer,Integer>();

		SortedMap<Integer,List<String>> cijfermap = 
                new TreeMap<Integer,List<String>>();
		
	//Method
		public QuizCollection(){
			//static functie van PersistentieFacade gebruiken om persistentie object te verkrijgen
			p = PersistentieFacade.getPersistentie();
			//TreeMap = new TreeMap<String, Integer>();
			//SortedMap<Integer,List<String>> cijfermap = 
                    new TreeMap<Integer,List<String>>();
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
			Set<Integer> categorieSet = cijfermap.keySet();
			//iterator van deze set
			Iterator<Integer> i = categorieSet.iterator();
			//itereren door deze set en de Key en Value pinten in console
			while(i.hasNext()){
			Integer categorie = i.next();
			System.out.println(categorie + "\t" + cijfermap.get(categorie));}
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
			if(!naammap.containsKey(quiz)){
				naammap.put(quiz, 1);
			}else{
				int n = naammap.get(quiz);
				n++;
				naammap.put(quiz, n);
			} //Einde if...else
				quiz++;
			}// Einde while
		}

// Einde class
