package persistentie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import model.OpdrachtCatalogus;
import model.QuizCatalogus;
import model.QuizOpdrachtCatalogus;

//Singleton class die een object aanmaakt waar alle catalogussen in zitten

public abstract class PersistentieFacade {
	
	//static instance of PersistentieFacade
	private static PersistentieFacade persistentie;
	
	protected OpdrachtCatalogus oc = new OpdrachtCatalogus();
	protected QuizCatalogus qc = new QuizCatalogus();
	protected QuizOpdrachtCatalogus qoc = new QuizOpdrachtCatalogus();
	
	//private constructor
	protected PersistentieFacade(){
		laadData();
	}
	
	//Abstract method om data te lezen
	protected abstract void laadData();
	//Abstract method om data weg te schrijven
	public abstract void bewaarData();
	
	public abstract String getPersistentieType();
	
	public OpdrachtCatalogus getOpdrachtCatalogus(){
		return oc;
	}
	
	public QuizCatalogus getQuizCatalogus(){
		return qc;
	}
	
	public QuizOpdrachtCatalogus getQuizOpdrachtCatalogus(){
		return qoc;
	}
	
	// Geeft een persistentie voor een type terug
  	public static PersistentieFacade getPersistentie() {
  		String persistentieType = setPersistentieFromInit();
  		if(persistentie == null){
  	  	  	if (persistentieType.equals("Text")){
  	  	  		persistentie = new TextPersistentie();
  	  	  	}
  			else if(persistentieType.equals("Database")){
  				persistentie = new DataBasePersistentie();
  			}
  		}
  		return persistentie;
  	}// Einde method
  	
  	//Gebruikt de method leesVanInit om een String met het type van persistentie terug te geven
  	private static String setPersistentieFromInit()throws NullPointerException{
		String persistentieType = null;
		try{
			persistentieType = leesVanInit("Persistentie");
			if(persistentieType == null){
				throw new NullPointerException("Geen persistentie gevonden in init bestand");
			}
		}
		catch(Exception ex){
			System.out.println("Property niet gevonden");
		}
		return persistentieType;
	}// Einde method
	
  	//Leest uit het init bestand welk type persistenitie gebruikt moet worden
	private static String leesVanInit(String p){
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
