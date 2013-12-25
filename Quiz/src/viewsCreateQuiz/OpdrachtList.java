package viewsCreateQuiz;

import java.util.ArrayList;

import model.Opdracht;

public class OpdrachtList{
	
	private ArrayList<Opdracht> opdrachtenLijst;
	
	public OpdrachtList(){
		opdrachtenLijst = new ArrayList<Opdracht>();
	}
	
	public void addOpdracht(Opdracht o){
		opdrachtenLijst.add(o);
	}
	
	public void removeOpdracht(Opdracht o){
		opdrachtenLijst.remove(o);
	}
	
	public int getLength(){
		return opdrachtenLijst.size();
	}
	
	public Opdracht getOpdracht(int opdracht){
		return opdrachtenLijst.get(opdracht);
	}
	
	public String getField(int opdracht, int field){
		switch(field){
		case 0:
			return opdrachtenLijst.get(opdracht).getVraag().toString();
		case 1:
			return opdrachtenLijst.get(opdracht).getCategorie().toString();
		default:
			return null;
		}
	}

	public boolean contains(Opdracht o) {
		return opdrachtenLijst.contains(o);
	}

}
