package viewsCreateQuiz;

public class TableObject {
	
	private String vraag;
	private String categorie;
	private int maxScore;
	
	public TableObject(String vraag, String categorie){
		this.setVraag(vraag);
		this.setCategorie(categorie);
	}
	
	public Object get(int o){
		Object object = null;
		switch(o){
		case 0:
			object = this.getVraag();
			break;
		case 1:
			object = this.getCategorie();
			break;
		case 2:
			object = this.getMaxScore();
			break;
		}
		return object;
	}
	
	public String getVraag() {
		return vraag;
	}
	public void setVraag(String vraag) {
		this.vraag = vraag;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public int getMaxScore() {
		return maxScore;
	}
	public void setMaxScore(int maxScore) {
		this.maxScore = maxScore;
	}

}
