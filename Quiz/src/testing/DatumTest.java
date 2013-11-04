package testing;

import static org.junit.Assert.*;
import utils.Datum;

import org.junit.Before;
import org.junit.Test;

public class DatumTest {
	private Datum datum; 
	
	@Before
	public void setUp(){
		 datum = new Datum();
	}

	@Test
	public void Test_SetDatum_GeldigeParameters_Aanvaard() {
		datum.setDatum(02, 10, 2013);
		
		assertEquals("02/10/2013", datum.getDatumInEuropeesFormaat());
		
	}
	//@Test
	//public void Test_SetDag_GeldigeDagen_Aanvaard() {	
	//}
	//@Test
	//public void Test_SetMaand_GeldigeMaanden_Aanvaard() {
	//	fail("Not yet implemented");
	//}
	//@Test
	//ublic void Test_SetJaar_GeldigeJaren_Aanvaard() {
	//	fail("Not yet implemented");
	//}
	//@Test
	//public void Test_SetDatum_Exception_OngeldigeParameters() {
	//	fail("Not yet implemented");
	//}
	//@Test
	//public void Test_SetDag_Exception_OngeldigAantalDagen() {
	//	fail("Not yet implemented");
	//}
	//@Test
	//public void Test_SetMaand_Exception_OngeldigAantalMaanden() {
	//	fail("Not yet implemented");
	//}
	//@Test
	//public void Test_SetJaar_Exception_OngeldigJaar() {
	//	fail("Not yet implemented");
	//}
	

}
