package controller;

import java.awt.EventQueue;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Opdracht;
import persistentie.PersistentieFacade;
import views.Menu;
import views.MainWindow;

public class OpstartController {
	
	public PersistentieFacade getPersistentie(){
		PersistentieFacade persistentie = PersistentieFacade.getPersistentie();
		return persistentie;
	}
	
	public void opstartMenu(){
		
		Menu menu = new Menu ("Beheren van opdrachten (leraar)", "Beheren van quizzen/testen (leraar)" , "Deelnemen aan quiz (leerling)",
					"Overzicht scores (leraar)"," Quiz rapport (deelnemer quiz)" ," Quiz lijsten"," Instellingen van de quiz applicatie");
		
		if (menu.getMenuKeuze() == 2){
			startUpMainWindow();
			}
		
	}
	
	
	public void startUpMainWindow(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
}// Einde class
