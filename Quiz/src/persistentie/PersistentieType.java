package persistentie;

public class PersistentieType {
	private PersistentieFacade persistentie;

	// Geeft een persistentie voor een type terug
  	public PersistentieFacade getPersistentie(String persistentieType) {
  	  	if (persistentieType.equals("Text")){
  	  		persistentie = new TextPersistentie();
  	  	}
		else if(persistentieType.equals("Database")){
			persistentie = new DataBasePersistentie();
		}
	return persistentie;
  	}// Einde method
  	
	/* Main method die toont hoe deze class werkt
	public static void main(String[] args) {
  	PersistentieType type = new PersistentieType();

	PersistentieFacade persistentie = type.getPersistentie("Text");
	System.out.println("Persistentie: " + persistentie.getPersistentie());
	}// Einde main
	*/
}// Einde class
