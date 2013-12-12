package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import persistentie.PersistentieFacade;
import persistentie.PersistentieType;
import views.Menu;
import views.MainWindow;

public class OpstartController {
	MainWindow mainwindow;
	
	public static void main(String[] args) {
		try{
			OpstartController opstart = new OpstartController();
			PersistentieType type = new PersistentieType();
			PersistentieFacade persistentie = type.getPersistentie(opstart.getPersistentieFromInit());
			persistentie.laadData();
			System.out.println(persistentie.getOpdrachtCatalogus());
			System.out.println(persistentie.getQuizCatalogus());
			System.out.println(persistentie.getQuizOpdrachtCatalogus());
			opstart.opstartMenu();
			opstart.mainwindow.vulListToevoegen(persistentie.getOpdrachtCatalogus().getListOpdrachten());

			//opstart.mainwindow.frame.setVisible(true);
			
			
		}
		catch(Exception ex){
			System.out.println("Error: " + ex.getMessage());
		}

	}// Einde main
	
	public void opstartMenu(){
		
		Menu menu = new Menu ("Beheren van opdrachten (leraar)", "Beheren van quizzen/testen (leraar)" , "Deelnemen aan quiz (leerling)",
					"Overzicht scores (leraar)"," Quiz rapport (deelnemer quiz)" ," Quiz lijsten"," Instellingen van de quiz applicatie");
		
		if (menu.getMenuKeuze() == 2){
			
			mainwindow = new MainWindow();
			mainwindow.startUpMainWindow();
			}
		
	}
	
			
			/*EventQueue.invokeLater(new Runnable() {
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
	} */

	
	public String getPersistentieFromInit()throws NullPointerException{
		String persistentie = null;
		try{
			persistentie = this.leesVanInit("Persistentie");
			if(persistentie == null){
				throw new NullPointerException("Geen persistentie gevonden in init bestand");
			}
		}
		catch(Exception ex){
			System.out.println("Property niet gevonden");
		}
		return persistentie;
	}
	
	private String leesVanInit(String p){
		String property = null;
		File file = new File("bestanden/init.txt");
		try{
			Scanner scanner = new Scanner(file);
			while (scanner.hasNext() && !scanner.hasNext("END")){
				String lijn = scanner.nextLine();
				String [] velden = lijn.split(">");
				if(velden[0].contains(p)){
					property = velden[1];
					}
				}
			if (scanner!=null){
				scanner.close();
				}
			}
		catch(FileNotFoundException ex){
			System.out.println("init bestand niet gevonden");
			}
		catch(Exception ex){
			System.out.println("Error: " + ex.getMessage());
			}
		return property;
	}// Einde method
}// Einde class
