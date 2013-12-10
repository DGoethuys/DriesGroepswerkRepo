package testing;

import static org.junit.Assert.*;
import utils.Datum;

import org.junit.Before;
import org.junit.Test;

public class DatumTest {
	private Datum datum; 
	
	@Before
	public void setUp() {//throws Exception {
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
	
	@Test(expected = IllegalArgumentException.class)
	public void Test_SetDatum_ExceptionDagGroterDan31_Exception(){
		datum.setDatum(32, 12, 2012);
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void Test_SetDatum_ExceptionJaarIsNul_Exception(){
		datum.setDatum(1, 12, 0);
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void Test_SetDatum_ExceptionFebruariMeerDan27Dagen_Exception(){
		datum.setDatum(29, 2, 2010);
		
	}

}// Einde class
