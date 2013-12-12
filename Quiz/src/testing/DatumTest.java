package testing;

import static org.junit.Assert.*;
import utils.Datum;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class DatumTest {
	private Datum datum; 
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@Before
	public void setUp() throws Exception {
		 datum = new Datum(2,10,2013);
	}

	@Test
	public void Test_SetDatum_GeldigeParameters_Aanvaard() {
		datum.setDatum(2,10,2013);
		
		assertEquals(2, datum.getDag());
		assertEquals(10, datum.getMaand());
		assertEquals(2013, datum.getJaar());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void Test_SetDatum_ExceptionMaandGroterDan12_Exception(){
		datum.setDatum(01, 13, 2012);
		
	}
	
	@Test
	public void Test_SetDatum_ExceptionDagGroterDan31_Exception(){
		expectedEx.expect(IllegalArgumentException.class);
	    expectedEx.expectMessage("Error: Maand met 31 dagen!");
		datum.setDatum(32, 12, 2012);
		
	}
	
	@Test
	public void Test_SetDatum_ExceptionJaarIsNul_Exception(){
		expectedEx.expect(IllegalArgumentException.class);
	    expectedEx.expectMessage("Error: Gelieve voor de dag, maand en jaar een geldige waarde in te voeren groter dan 0!");
		datum.setDatum(1, 12, 0);
		
	}
	
	@Test
	public void Test_SetDatum_ExceptionFebruariMeerDan27Dagen_Exception(){
		expectedEx.expect(IllegalArgumentException.class);
	    expectedEx.expectMessage("Error: Februari kan niet meer dan 28 dagen tellen!");
		datum.setDatum(29, 2, 2010);
		
	}

}// Einde class
