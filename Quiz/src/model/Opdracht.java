package model;


public abstract class Opdracht {

	protected String vraag;
	protected String juisteAntwoord;
	protected int aantalPogingen;
	protected int maxAntwoordTijd;
	
	public Opdracht (){
		
	}
	
	//constructor die alleen vraag en antwoord nodig heeft en default waarde aan aantalPogingen en maxAntwoordTijd geeft
	public Opdracht ( String vraag, String juisteAntwoord){
		this( vraag, juisteAntwoord, 3, 5);
	}
	
	//constructor voor alle parameters behalve de hints
	public Opdracht( String vraag, String juisteAntwoord, int aantalPogingen, int maxAntwoordTijd ){
		this.setVraag(vraag);
		this.setJuisteAntwoord(juisteAntwoord);
		this.setAantalPogingen(aantalPogingen);
		this.setMaxAntwoordTijd(maxAntwoordTijd);
	}
	
	//getters
	public String getVraag(){
		return this.vraag;
	}
	
	public String getJuisteAntwoord(){
		return this.juisteAntwoord;
	}
	
	public int getAantalPogingen(){
		return this.aantalPogingen;
	}
	
	public int getMaxAntwoordTijd(){
		return this.maxAntwoordTijd;
	}
	
	//setters
	public void setVraag( String vraag ){
		this.vraag = vraag;
	}
	
	public void setJuisteAntwoord( String juisteAntwoord ){
		this.juisteAntwoord = juisteAntwoord;
	}
	
	public void setAantalPogingen( int aantalPogingen ){
		this.aantalPogingen = aantalPogingen;
	}
	
	public void setMaxAntwoordTijd( int maxAntwoordTijd ){
		this.maxAntwoordTijd = maxAntwoordTijd;
	}
	
	//method om te bepalen of juiste antwoord is gegeven
	public boolean isJuisteAntwoord( String antwoord ){
		if( antwoord == this.juisteAntwoord ){
			return true;
		}else{
			return false;
		}
	}

}
