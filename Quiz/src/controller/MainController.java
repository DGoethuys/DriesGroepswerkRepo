package controller;

import persistentie.PersistentieFacade;
import persistentie.PersistentieType;

public class MainController {

	
	public static void main(String[] args) {
		try{
			OpstartController opstart = new OpstartController();
			PersistentieType type = new PersistentieType();
			PersistentieFacade persistentie = type.getPersistentie(opstart.getPersistentieFromInit());
			persistentie.laadData();
			System.out.println(persistentie.getOpdrachtCatalogus());
			System.out.println(persistentie.getQuizCatalogus());
			System.out.println(persistentie.getQuizOpdrachtCatalogus());
		}
		catch(Exception ex){
			System.out.println("Error: " + ex.getMessage());
		}

	}// Einde main
}// Einde class
