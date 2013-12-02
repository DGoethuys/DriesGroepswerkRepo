package testing;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

import model.Meerkeuze;

public class MeerkeuzeTest {
	public ArrayList<String> keuze;
	private Meerkeuze meerkeuze;
	public boolean Valide = true;
	
	
	
	@Before
	public void setUp(){
		 meerkeuze = new Meerkeuze(null, null, keuze, 0, 0);
		 
		final ArrayList<String> keuze = new ArrayList<String>();
			keuze.add("Parijs");
			keuze.add("Londen");
			keuze.add("Brussel");
	}
	
	@Test
	public void Test_SetMeerkeuze_GeldigeParameters_Aanvaard() {
	    meerkeuze.setKeuzes(keuze);
		
		assertEquals(this.keuze, meerkeuze.getKeuzes());
	}
	
	@Test
	public void Test_SetIsValid_GeldigeParameters_Aanvaard(){
		meerkeuze.isValid();
		
		assertEquals(this.Valide, meerkeuze.isValid());
	}

}