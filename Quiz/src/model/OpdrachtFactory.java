package model;

import java.util.ArrayList;

public class OpdrachtFactory {

	public Opdracht getOpdracht(String type, String categorie, String vraag, String juisteAntwoord, ArrayList<String> keuzes){
		Opdracht o = null;
		switch(type){
		case "Vraag":
			o = new Vraag(categorie, vraag, juisteAntwoord);
			break;
			case "Meerkeuze":
				o = new Meerkeuze(categorie, vraag, juisteAntwoord, keuzes);
				break;
				case "Opsomming":
					o = new Opsomming(categorie, vraag, juisteAntwoord);
					break;
		  }
		return o;
	}
}
