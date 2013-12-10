package utils;

import java.util.GregorianCalendar;
import java.util.Date;

public class Gregoriaans implements Comparable<Datum> {
	
	GregorianCalendar gregorianCalendar=new GregorianCalendar();
	
	public void Datum(){
		//Constructor zonder parameters (object datum gelijk aan de systeemdatum)
		gregorianCalendar.getTime();
	}
	
	//Terug opnieuw bekijken.
	
	public void Datum(Date d){
		gregorianCalendar.setTime(d);
	}
	
	
	public void Datum( int dag, int maand, int jaar){
		gregorianCalendar.set(jaar, maand, dag);
		
		
		//Een constructor met parameters dag, maand en jaar ( 3 gehele getallen).
	}
	
	public void Datum ( String datum ){
		String[] p = datum.split("/", 3);
		gregorianCalendar.set(Integer.parseInt(p[0]), Integer.parseInt(p[1]), Integer.parseInt(p[2]));
		//Een constructor met een String als parameter. In deze String zit de datum in DDMMJJJJ formaat maar tussen de dag, maand en jaar staat een scheidingsteken (Vb 12/05/2009)
	}
	
	/*Set methoden, nog niet zeker of we deze allemaal public zouden laten of alleen de setDatum public of setDatum weg doen en ze in de constructor steken
	Set methoden:
	boolean setDatum (int dag, int maand, int jaar): een methode om een Datumobject een geldige waarde te geven (indien ongeldige dag of maand Exception werpen). Je kan ook private setters maken voor dag, maand en jaar die dan worden aangeroepen door de constructor.
	*/
	
	//public void setDag( int dag ){
	//	this.dag = dag;
	//}
	//
	//public void setMaand( int maand ){
	//	this.maand = maand;
	//}
	
	//public void setJaar( int jaar ){
	//	this.jaar = jaar;
	//}
	
	//public void setDatum( int dag, int maand, int jaar ){
	//	this.gregorianCalendar.
	//	this.setDag(dag);
	//	this.setMaand(maand);
	//	this.setJaar(jaar);
	//}

	public String getDatumInAmerikaansFormaat(){
		//getDatumInAmerikaansFormaat: geeft een datum in Amerikaans formaat terug (vb 2009/2/4)
		return "something";
	}
	
	public String getDatumInEuropeesFormaat(){
		//getDatumInEuropeesFormaat : geeft een datum in Europees formaat terug   (vb 4/2/2009)
		return "something";
	}
	
	@Override
	public String toString() {
		//toString  : geeft datum object terug als volgt: 4 februari 2009
		return "something";
	}
	
	boolean kleinerDan (Datum d){
		//boolean kleinerDan (Datum d) : bepaalt of een datum d kleiner is dan huidig datumobject
		return true;
	}
	int verschilInJaren (Datum d){
		//int verschilInJaren (Datum d) : bepaalt het verschil in volledige jaren tussen datum d en huidig datumobject  (vb 01032007 en 03012009 -> 1 jaar)
		return 0;
	}
	int verschilInMaanden (Datum d){
		//int verschilInMaanden (Datum d) : bepaalt het verschil in volledige maanden tussen datum d en huidig datumobject (vb 01032007 en 03012009 -> 22 maanden)
		return 0;
	}
	int verschilInDagen (Datum d){
		//int verschilInDagen (Datum d) : bepaalt het verschil in dagen tussen datum d en huidig datumobject 
		return 0;
	}
	void veranderHuidigeDatum (int aantalDagen){
		//void veranderDatum (int aantalDagen): verhoogt of verlaagt de datum met een aantal dagen
	}
	Datum veranderNieuweDatum (int aantalDagen){
		//Datum veranderDatum(int aantalDagen): geeft een nieuw Datum object terug dat gelijk is aan het originele datum object verhoogt of verlaagt met een aantal dagen.
		Datum datum = new Datum();
		return datum;
	}
	
	//Andere instantiemethoden:equals methode en compareTo methode

	
	@Override
	public int hashCode() {
		return gregorianCalendar.hashCode();	
	}

	@Override
	public boolean equals(Object obj) {
		return gregorianCalendar.equals(obj);
	}

	@Override
	public int compareTo(Datum o) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}// Einde class

