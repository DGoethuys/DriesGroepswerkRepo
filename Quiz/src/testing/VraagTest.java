package testing;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.Vraag;

public class VraagTest {
	
	private Vraag vraag;
	
	@Before
	public void setUp(){
		 vraag = new Vraag("Wetenschappen", "Wat is je naam", "Jan");
	}
	
	@Test
	public void Test_SetVraag_GeldigeParameters_Aanvaard() {
	    vraag.setVraag("Wat is je naam?");	
		
		assertEquals("Wat is je naam?", vraag.getVraag());
		
	}
	
	@Test
	public void Test_SetJuisteAntwoord_GeldigeParameters_Aanvaard() {
		vraag.setJuisteAntwoord("Jan");	
		
		assertEquals("Jan", vraag.getJuisteAntwoord());
		
	}
	
	@Test
	public void Test_setAantalPogingen_GeldigeParameters_Aanvaard() {
		vraag.setAantalPogingen(3);	
		
		assertEquals(3, vraag.getAantalPogingen());
		
	}
	
	@Test
	public void Test_setMaxAntwoordTijd_GeldigeParameters_Aanvaard() {
		vraag.setMaxAntwoordTijd(10);	
		
		assertEquals(10, vraag.getMaxAntwoordTijd());
		
	}
	
	@Test
	public void Test_addHint_GeldigeParameters_Aanvaard() {
		vraag.addHint("Haepers");	
		
		assertEquals("Haepers", vraag.getHint(0));
		
	}
	

}// Einde class
