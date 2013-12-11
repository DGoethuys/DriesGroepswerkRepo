package persistentie;

public class DataBasePersistentie extends PersistentieFacade {

	@Override
	public void laadData() {
		qc.leesQuizzenVanDataBase();
		oc.leesOpdrachtenVanDataBase();
		qoc.leesQuizOpdrachtenVanDataBase();
	}

	@Override
	public void bewaarData() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getPersistentieType() {
		return "Database";
	}

}// Einde class
