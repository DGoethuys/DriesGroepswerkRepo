package persistentie;

//deze klasse roept simpelweg de alle methods op die data halen uit textbestanden en wegschrijven naar
public class TextPersistentie extends PersistentieFacade {
	
	@Override
	public void laadData() {
		qc.leesQuizzenVanTekstBestand();
		oc.leesOpdrachtenVanTekstBestand();
		qoc.leesQuizOpdrachtenVanTekstBestand();
	}

	@Override
	public void bewaarData() {
		qoc.schrijfQuizOpdrachtenNaarBestand();
		oc.schrijfOpdrachtenNaarBestand();
		qc.schrijfQuizOpdrachtenNaarBestand();
	}

	@Override
	public String getPersistentie() {
		return "Text";
	}

}// Einde class
