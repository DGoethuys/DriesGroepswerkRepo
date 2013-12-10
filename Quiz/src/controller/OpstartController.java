package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class OpstartController {
	
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
