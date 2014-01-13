package controller;

import java.awt.EventQueue;

import persistentie.PersistentieFacade;
import views.Menu;
import viewsCreateQuiz.CreateQuizView;

public class OpstartController {
	/*
	public PersistentieFacade getPersistentie(){
		PersistentieFacade persistentie = PersistentieFacade.getPersistentie();
		return persistentie;
	}
	*/
	public void opstartMenu(){
		
		Menu menu = new Menu ("Beheren van opdrachten (leraar)", "Beheren van quizzen/testen (leraar)" , "Deelnemen aan quiz (leerling)",
					"Overzicht scores (leraar)", "Quiz rapport (deelnemer quiz)", "Quiz lijsten", "Instellingen van de quiz applicatie");
		
		switch (menu.getMenuKeuze()){
		case 1:
			System.out.println("Beheren van opdrachten (leraar)");
			break;
		case 2:
			startUpCreateQuizView();
			break;
		case 3:
			System.out.println("Deelnemen aan quiz (leerling)");
			break;
		case 4:
			System.out.println("Overzicht scores (leraar)");
			break;
		case 5:
			System.out.println(" Quiz rapport (deelnemer quiz)");
			break;
		case 6:
			System.out.println("Quiz lijsten");
			break;
		case 7:
			System.out.println("Instellingen van de quiz applicatie");
			break;
		default:
			break;
			}
		
	}
	
	
	public void startUpCreateQuizView(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateQuizView window = new CreateQuizView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
}// Einde class
