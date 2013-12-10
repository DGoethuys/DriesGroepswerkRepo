package controller;

import persistentie.PersistentieFacade;
import persistentie.PersistentieType;
import views.*;
import model.*;

public class MainController {

	private Quiz _quiz;
	private Vraag _vraag;
	private MainWindow mainWin;
	
	public static void main(String[] args) {
		PersistentieType type = new PersistentieType();
		PersistentieFacade persistentie = type.getPersistentie("Text");
		persistentie.laadData();
		System.out.println(persistentie.getOpdrachtCatalogus());
		System.out.println(persistentie.getQuizCatalogus());
		System.out.println(persistentie.getQuizOpdrachtCatalogus());
	}
	
	public MainController(MainWindow view,Quiz quiz,Vraag vraag)
	{
		this._quiz = quiz;
		this._vraag = vraag;
		this.mainWin = view;
	}

}// Einde class
