package testing;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import utils.Datum;
import model.Opdracht;

public class OpdrachtTest {
	
	private Opdracht opdracht;
	
	//@Before
	//public void setUp(){
	//	 opdracht = new Opdracht();
	//}
	
	@Test
	public void Test_SetVraag_GeldigeParameters_Aanvaard() {
	    opdracht = new opdracht();
	    opdacht.setVraag("Wat is je naam?");	
		
		assertEquals("Wat is je naam?", opdracht.getVraag());
		
	}
	
	public void Test_SetJuisteAntwoord_GeldigeParameters_Aanvaard() {
	    opdracht = new opdracht();
	    opdacht.setJuisteAntwoord("Jan");	
		
		assertEquals("Jan", opdracht.getJuisteAntwoord());
		
	}
	
	public void Test_setAantalPogingen_GeldigeParameters_Aanvaard() {
	    opdracht = new opdracht();
	    opdacht.setAantalPogingen(3);	
		
		assertEquals(3, opdracht.getAantalPogingen());
		
	}
	
	public void Test_setMaxAntwoordTijd_GeldigeParameters_Aanvaard() {
	    opdracht = new opdracht();
	    opdacht.setMaxAntwoordTijd(10);	
		
		assertEquals(10, opdracht.getMaxAntwoordTijd());
		
	}
	
	public void Test_addHint_GeldigeParameters_Aanvaard() {
	    opdracht = new opdracht();
	    opdacht.addHint("Haepers");	
		
		assertEquals("Haepers", opdracht.getHint(1));
		
	}
	

}
