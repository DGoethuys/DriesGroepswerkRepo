package testing;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

import model.Meerkeuze;

public class MeerkeuzeTest {
	public ArrayList<String> keuze;
	private Meerkeuze meerkeuze;
	
	
	
	@Before
	public void setUp(){
		 meerkeuze = new Meerkeuze();
		 
		final ArrayList<String> keuze = new ArrayList<String>();
			keuze.add("Parijs");
			keuze.add("Londen");
			keuze.add("Brussel");
	}
	
	@Test
	public void Test_SetMeerkeuze_GeldigeParameters_Aanvaard() {
	    meerkeuze.setKeuze(keuze);
		
		assertEquals(this.keuze, meerkeuze.getKeuze());
		
	}

}