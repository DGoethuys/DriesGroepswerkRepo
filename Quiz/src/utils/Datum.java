package utils;

import java.util.Date;

public class Datum implements Comparable<Datum> {
	
	//DONE
	
	private int dag;
	private int maand;
	private int jaar;
	
	//Enum voor het opvragen van de namen van de dagen met een nummer
	private enum Maand {
		januari(1),
		februari(2),
		maart(3),
		april(4),
		mei(5),
		juni(6),
		juli(7),
		augustus(8),
		september(9),
		oktober(10),
		november(11),
		december(12);
		
		int maandNummer = 0;
		
		Maand(int maandNummer){
			this.maandNummer = maandNummer;
		}
		
		//method voor het verkrijgen van de maand met een nummer als parameter
		public static Maand perNummer(int maandNummer){
			for (Maand m : Maand.values()){
				if (m.maandNummer == maandNummer){
					return m;
				}
			}
			return null;
		}
	}
	
	//Constructor zonder parameters (object datum gelijk aan de systeemdatum)
	//Dit werkt ookal is er deprecation alleen kwam de dag er 1 teveel, de maand er 1 te weinig uit en tellen de jaartallen pas na 1900
	@SuppressWarnings("deprecation")
	public Datum()throws IllegalArgumentException{
		Date date = new Date();
		this.setDatum(date.getDay() -1, date.getMonth() + 1, date.getYear() + 1900);
	}
	
	//Een constructor met een datum object als parameter
	public Datum( Datum d)throws IllegalArgumentException{
		this.setDatum(d.dag, d.maand, d.jaar);
	}

	//Een constructor met parameters dag, maand en jaar ( 3 gehele getallen)
	public Datum( int dag, int maand, int jaar)throws IllegalArgumentException{
		this.setDatum(dag, maand, jaar);
	}

	//Een constructor met een String als parameter. In deze String zit de datum in DDMMJJJJ formaat maar tussen de dag, maand en jaar staat een scheidingsteken (Vb 12/05/2009)
	//Hier zou ik nog veranderingen willen voor duidelijkere code
	public Datum ( String datum )throws IllegalArgumentException{
		String[] p = datum.split("/", 3);
		if(  p.length == 3 && this.isInt(p[0]) && this.isInt(p[1]) && this.isInt(p[2]) ){
			if(p[1].length() != 2 ){
				throw new IllegalArgumentException("Error: De maand moet met 2 getallen ingevoerd worden! (bijvoorbeeld: \"O8\")");
			}else{
				if(p[2].length() != 4 ){
					throw new IllegalArgumentException("Error: Het jaartal moet met 4 getallen ingevoerd worden! (bijvoorbeeld: \"0564\")");
				}else{
				this.setDatum(Integer.parseInt(p[0]), Integer.parseInt(p[1]), Integer.parseInt(p[2]));
				}
			}
		}else{
			throw new IllegalArgumentException("Error: Gelieve 3 getallen in te geven gescheiden door een \"\\\"!");
		}
	}
	
	//bepalen of input getallen zijn
	private boolean isInt(String string){
		try{
		@SuppressWarnings("unused")
		int i = Integer.parseInt(string);
		}
		catch(NumberFormatException e){
			return false;
		}
		return true;
		
	}
	
	//Set methoden, ik heb de setDag, setMaand en setJaar private gemaakt, exceptions worden getest in setDatum
	//Set methoden: boolean setDatum (int dag, int maand, int jaar): een methode om een Datumobject een geldige 
	//waarde te geven (indien ongeldige dag of maand Exception werpen). Je kan ook private setters maken 
	//voor dag, maand en jaar die dan worden aangeroepen door de constructor.
	public void setDatum( int dag, int maand, int jaar ) throws IllegalArgumentException{
		if ( this.isEenendertigMaad(maand) && dag > 31){
			throw new IllegalArgumentException("Error: Maand met 31 dagen!");
		}
		if ( this.isDertigMaand(maand) && dag > 30){
			throw new IllegalArgumentException("Error: Maand met 30 dagen!");
		}
		if(maand == 2 && dag > 28 && jaar % 4 != 0){
			throw new IllegalArgumentException("Error: Februari kan niet meer dan 28 dagen tellen!");
		}
		if(maand == 2 && dag > 29 && jaar % 4 == 0){
			throw new IllegalArgumentException("Error: Februari kan niet meer dan 29 dagen tellen! (schrikkeljaar)");
		}
		if(maand > 12){
			throw new IllegalArgumentException("Error: Een jaar kan niet meer dan 12 maanden tellen!");
		}
		if(dag <= 0 || maand <= 0 || jaar <= 0){
			throw new IllegalArgumentException("Error: Gelieve voor de dag, maand en jaar een geldige waarde in te voeren groter dan 0!");
		}
		this.setDag(dag);
		this.setMaand(maand);
		this.setJaar(jaar);
	}
	
	private void setDag(int dag) throws IllegalArgumentException 
	{
        if(dag >= 1 && dag <= 31)
            this.dag = dag;
        else throw new IllegalArgumentException("Dag moet tussen 1 & 31 liggen");     
	}
	
	private void setMaand(int maand) throws IllegalArgumentException 
	{
		if(maand >= 1 && maand <= 12)
			this.maand = maand;
		else throw new IllegalArgumentException("Maand moet tussen 1 en 12 liggen!");
	}
	
	private void setJaar(int jaar) throws IllegalArgumentException
	{
		if(jaar < 0){
			this.jaar = jaar;
		}
		else throw new IllegalArgumentException("Maand moet tussen 1 en 12 liggen.")
	}
	
	//getters
	public int getDag(){
		return this.dag;
	}
	
	public int getMaand(){
		return this.maand;
	}
	
	public int getJaar(){
		return this.jaar;
	}
	
	//bepaalt of een datum d kleiner is dan huidig datumobject
	public boolean kleinerDan (Datum d){
		if(this.jaar < d.jaar){
			return true;
		}else if(this.jaar == d.jaar && this.maand < d.maand){
			return true;
		}else if(this.jaar == d.jaar && this.maand == d.maand && this.dag < d.dag){
			return true;
		}else{
			return false;
		}
	}
	
	//bepaalt het verschil in volledige jaren tussen datum d en huidig datumobject  (vb 01032007 en 03012009 -> 1 jaar)
	public int verschilInJaren (Datum d){
		int verschil = Math.abs(this.jaar - d.jaar);
		if(this.jaar > d.jaar){
			if(this.maand > d.maand)
				return verschil++;
			if(this.maand == d.maand && this.dag > d.dag)
				return verschil++;
		}
		if(d.jaar > this.jaar){
			if(d.maand > this.maand)
				return verschil++;
			if(d.maand == this.maand && d.dag > this.dag)
				return verschil++;
		}
		return verschil;
	}
	
	//bepaalt het verschil in volledige maanden tussen datum d en huidig datumobject (vb 01032007 en 03012009 -> 22 maanden)
	//dit houd geen rekening met de dagen
	public int verschilInMaanden (Datum d){
		int verschil = Math.abs(this.maand - d.maand);
		if(this.jaar != d.jaar)
			verschil += (Math.abs(this.jaar - d.jaar))*12;
		if(d.jaar > this.jaar && d.maand > this.maand && d.dag > this.dag)
				return verschil++;
		if(this.jaar > d.jaar && this.maand > d.maand && this.dag > d.dag)
				return verschil++;
		return verschil;
	}

	//bepaalt het verschil in dagen tussen datum d en huidig datumobject 
	public int verschilInDagen (Datum d){
		int verschil = 0;
		verschil += Math.abs(this.jarenInDagen(this.jaar) - this.jarenInDagen(d.jaar));
		verschil += Math.abs(this.maandenInDagen(this.maand, this.jaar) - this.maandenInDagen(d.maand, d.jaar));
		verschil += Math.abs(this.dag - d.dag);
		return verschil;
	}
	
	//Berekend hoeveel dagen een jaartal bevat
	private int jarenInDagen(int jaren){
		int totDagen = 0;
		int j = jaren;
		while( j != 0){
			if( j % 4 != 0 ){
				totDagen += 365;
			}
			if( j % 4 == 0 ){
				totDagen += 366;
			}
			j--;
		}
		return totDagen;
	}
	
	//Berekend hoeveel dagen in de maanden van een jaar zitten
	private int maandenInDagen(int maanden, int jaar){
		int totDagen = 0;
		int m = maanden;
		while( m != 0 ){
			if ( this.isEenendertigMaad(m) ){
				totDagen += 31;
			}
			if ( this.isDertigMaand(m) ){
				totDagen += 30;
			}
			if( m == 2 && this.isSchrikkelJaar(jaar) ){
				totDagen += 28;
			}
			if( m == 2 && this.isSchrikkelJaar(jaar) ){
				totDagen += 29;
			}
			m--;
		}
		return totDagen;
	}
	
	//method voor datum om te zetten naar dagen
	private int datumInDagen(){
		return this.dag + maandenInDagen(this.maand, this.jaar) + jarenInDagen(this.jaar);
	}

	//void veranderDatum (int aantalDagen): verhoogt of verlaagt de datum met een aantal dagen
	//DEES KAN BETER
	void veranderHuidigeDatum (int aantalDagen){
		int a = aantalDagen;
		while(a != 0){
			//test of de dag die toegevoegd word nog in het bereik zit van de maand
			//(zo nee, maand word toegevoegd en dag op 1 gezet. als maand over 12 gaat gebeurd hetzelfde voor maand en jaar)
			//getest als de maand eenendertig dagen heeft
			if ( this.isEenendertigMaad(this.maand) && this.dag == 31 ){
				this.setDag(1);
				if(this.maand == 12){
					this.setMaand(1);
					this.jaar++;
				}else{
					this.maand++;
				}
			}else
			//als de maand dertig dagen heeft
			if( this.isDertigMaand(this.maand) && this.dag == 30 ){
				this.setDag(1);
				if(this.maand == 12){
					this.setMaand(1);
					this.jaar++;
				}else{
					this.maand++;
				}
			}else
			//als de maand fabruari is en niet in een schrikkeljaar
			if(this.maand == 2 && this.dag == 28 && !this.isSchrikkelJaar(this.jaar)){
				this.setDag(1);
				this.maand++;
			}else
			//en als de maand februari is en wel in een schrikkeljaar
			if(this.maand == 2 && this.dag == 29 && this.isSchrikkelJaar(this.jaar)){
				this.setDag(1);
				this.maand++;
			}else
			//anders word gewoon een dag toegevoegd en geen maand
			{
				this.dag++;
			}
			a--;
		}
	}
	
	//geeft een nieuw Datum object terug dat gelijk is aan het originele datum object verhoogt of verlaagt met een aantal dagen.
	Datum veranderNieuweDatum (int aantalDagen){
		Datum datum = new Datum(this);
		datum.veranderHuidigeDatum(aantalDagen);
		return datum;
	}
	
	//method om te bepalen of een maand 30 dagen bevat
	private boolean isDertigMaand(int maand){
		if( maand == 4 || maand == 6|| maand == 9 || maand == 11 ){
			return true;
		}else{
			return false;
		}
	}
	
	//method om te bepalen of een maand 31 dagen bevat
	private boolean isEenendertigMaad(int maand){
		if ( maand == 1 || maand == 3 || maand == 5 || maand == 7 || maand == 8 || maand == 10 || maand == 12 ){
			return true;
		}else{
			return false;
		}
	}
	
	//method om te bepalen of we in een schrikkeljaar zitten
	private boolean isSchrikkelJaar(int jaar){
		if ( jaar % 4 == 0 || jaar % 400 == 0 ){
			return true;
		}
		return false;
	}
	
	//getDatumInAmerikaansFormaat: geeft een datum in Amerikaans formaat terug (vb 2009/2/4)
	public String getDatumInAmerikaansFormaat(){
		return this.jaar + "/" + this.maand + "/" + this.dag;
	}

	//getDatumInEuropeesFormaat : geeft een datum in Europees formaat terug   (vb 4/2/2009)
	public String getDatumInEuropeesFormaat(){
		return this.dag + "/" + this.maand + "/" + this.jaar;
	}
	
	//toString  : geeft datum object terug als volgt: 4 februari 2009
	@Override
	public String toString() {
		return dag + " " + Maand.perNummer(maand) + " " + jaar;
	}
	

	//hashCode... ik denk nie da dees nodig is of aangepast moet worden
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dag;
		result = prime * result + jaar;
		result = prime * result + maand;
		return result;
	}

	
	//equals methode
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Datum other = (Datum) obj;
		if (this.dag != other.getDag())
			return false;
		if (this.maand != other.getMaand())
			return false;
		if (this.jaar != other.getJaar())
			return false;
		return true;
	}
	
	//compareTo methode die de datums vergelijkt met aantal dagen
	@Override
	public int compareTo(Datum datum) {
		return this.datumInDagen() - datum.datumInDagen();
	}
	
	/*Main voor het testen van de nest*/
	public static void main(String[] args) {

		Datum systeemDatum = null;
		Datum datumString = null;
		try{
			systeemDatum = new Datum();
			datumString = new Datum("11/08/1990");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		System.out.printf("%s%n", systeemDatum);
		System.out.printf( "Datum: %s%nDatum Amerikaanse format: %s%nnDatum Europese format: %s", datumString, datumString.getDatumInAmerikaansFormaat(), datumString.getDatumInEuropeesFormaat());
		
		/*
		Datum datumInt = null;
		Datum datumDatum = null;
		Datum datumString = null;
		try{
			  datumInt = new Datum(11, 8, 1990);
			  datumDatum = new Datum(datumInt);
			  datumString = new Datum("11/08/1990");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}

		  System.out.println(datumString);
		  System.out.println(datumString.getDatumInAmerikaansFormaat() + " - " + datumInt.getDatumInEuropeesFormaat());
		  System.out.println(datumInt);
		  System.out.println(datumDatum);
		  System.out.println(datumString);
		  
		  if(datumInt.kleinerDan(datumString)){
			  System.out.println("Jeppers");
		  }else{
			  System.out.println("Nope");
		  }
		  
		  System.out.println(datumInt.verschilInJaren(datumString));
		  System.out.println(datumInt.verschilInMaanden(datumString));
		  System.out.println(datumInt.verschilInDagen(datumString));
		  */
	}
	

}
