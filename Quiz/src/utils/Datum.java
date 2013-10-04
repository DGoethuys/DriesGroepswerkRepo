package utils;

import java.util.Date;
//import java.util.Calendar;

public class Datum implements Comparable<Datum> {
	
	private int dag;
	private int maand;
	private int jaar;
	
	//Main voor het testen van de nest
	public static void main(String[] args) {
		  Datum datum = new Datum();
		  Datum datumMetInts = new Datum(11, 8, 1990);
		  Datum datumMetDatum = new Datum(datumMetInts);
		  Datum datumString = new Datum("7/11/1990");
		  System.out.println(datum);
		  System.out.println(datum.getDatumInAmerikaansFormaat() + " - " + datum.getDatumInEuropeesFormaat());
		  System.out.println(datumMetInts);
		  System.out.println(datumMetDatum);
		  System.out.println(datumString);
		  
		  if(datumMetInts.kleinerDan(datum)){
			  System.out.println("Jeppers");
		  }else{
			  System.out.println("Nope");
		  }
	}
	
	public Datum(){
		//Ik weet nie wa ik hier ga moete doen, dit is duidelijk not the way to go... maja xD het werkt
		Date date = new Date();
		this.setDatum(date.getDay() -1, date.getMonth() + 1, date.getYear() + 1900);
		//Constructor zonder parameters (object datum gelijk aan de systeemdatum)
	}
	
	public Datum( Datum d){
		this.setDatum(d.dag, d.maand, d.jaar);
		//Een constructor met een datum object als parameter ; 
	}
	
	public Datum( int dag, int maand, int jaar){
		this.setDatum(dag, maand, jaar);
		//Een constructor met parameters dag, maand en jaar ( 3 gehele getallen).
	}
	
	public Datum ( String datum ){
		String[] p = datum.split("/", 3);
		this.setDatum(Integer.parseInt(p[0]), Integer.parseInt(p[1]), Integer.parseInt(p[2]));
		//Een constructor met een String als parameter. In deze String zit de datum in DDMMJJJJ formaat maar tussen de dag, maand en jaar staat een scheidingsteken (Vb 12/05/2009)
	}
	
	/*Set methoden, nog niet zeker of we deze allemaal public zouden laten of alleen de setDatum public of setDatum weg doen en ze in de constructor steken
	Set methoden:
	boolean setDatum (int dag, int maand, int jaar): een methode om een Datumobject een geldige waarde te geven (indien ongeldige dag of maand Exception werpen). Je kan ook private setters maken voor dag, maand en jaar die dan worden aangeroepen door de constructor.
	*/
	
	public void setDag( int dag ){
		this.dag = dag;
	}
	
	public void setMaand( int maand ){
		this.maand = maand;
	}
	
	public void setJaar( int jaar ){
		this.jaar = jaar;
	}
	
	public void setDatum( int dag, int maand, int jaar ){
		this.setDag(dag);
		this.setMaand(maand);
		this.setJaar(jaar);
	}

	public String getDatumInAmerikaansFormaat(){
		//getDatumInAmerikaansFormaat: geeft een datum in Amerikaans formaat terug (vb 2009/2/4)
		return this.jaar + "/" + this.maand + "/" + this.dag;
	}
	
	public String getDatumInEuropeesFormaat(){
		//getDatumInEuropeesFormaat : geeft een datum in Europees formaat terug   (vb 4/2/2009)
		return this.dag + "/" + this.maand + "/" + this.jaar;
	}
	
	@Override
	public String toString() {
		//toString  : geeft datum object terug als volgt: 4 februari 2009
		return "dag: " + dag + " maand: " + maand + " jaar: " + jaar;
	}
	
	boolean kleinerDan (Datum d){
		if(this.jaar < d.jaar){
			return true;
		}else if(this.jaar == d.jaar && this.maand < d.maand){
			return true;
		}else if(this.jaar == d.jaar && this.maand == d.maand && this.dag < d.dag){
			return true;
		}else{
			return false;
		}
		//boolean kleinerDan (Datum d) : bepaalt of een datum d kleiner is dan huidig datumobject
	}
	int verschilInJaren (Datum d){
		int verschil = this.jaar - d.jaar;
		return verschil;
		//int verschilInJaren (Datum d) : bepaalt het verschil in volledige jaren tussen datum d en huidig datumobject  (vb 01032007 en 03012009 -> 1 jaar)
	}
	int verschilInMaanden (Datum d){
		//DEES MOET IK NOG
		int verschil = 0;
		return verschil;
		//int verschilInMaanden (Datum d) : bepaalt het verschil in volledige maanden tussen datum d en huidig datumobject (vb 01032007 en 03012009 -> 22 maanden)
	}
	int verschilInDagen (Datum d){
		//DEES MOET IK NOG
		int verschil = 0;
		return verschil;
		//int verschilInDagen (Datum d) : bepaalt het verschil in dagen tussen datum d en huidig datumobject 
	}
	void veranderHuidigeDatum (int aantalDagen){
		//DEES MOET IK NOG
		//void veranderDatum (int aantalDagen): verhoogt of verlaagt de datum met een aantal dagen
	}
	Datum veranderNieuweDatum (int aantalDagen){
		//DEES MOET IK NOG
		//Datum veranderDatum(int aantalDagen): geeft een nieuw Datum object terug dat gelijk is aan het originele datum object verhoogt of verlaagt met een aantal dagen.
		Datum datum = new Datum();
		return datum;
	}

	//Hier weet ik nog de klote wa ik moet doen...
	//Andere instantiemethoden:equals methode en compareTo methode

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dag;
		result = prime * result + jaar;
		result = prime * result + maand;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Datum other = (Datum) obj;
		if (dag != other.dag)
			return false;
		if (jaar != other.jaar)
			return false;
		if (maand != other.maand)
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Datum o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
