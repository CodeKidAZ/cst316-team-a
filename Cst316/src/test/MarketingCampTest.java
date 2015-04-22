/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cst316.MarketCompany;
import cst316.MarketingCamp;

/**
 * @author Wesley Local
 *
 */
public class MarketingCampTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testName() {
		MarketingCamp emptyConstructor1 = new MarketingCamp(); 
		MarketingCamp mcSample1 = new MarketingCamp("test1", 2.0, true, 200.0); 
		MarketingCamp mcSample2 = new MarketingCamp("test2", 175.0, true, 400.0); 
		MarketingCamp mcSample3 = new MarketingCamp("test3", -25.5, false, -200.0); 
		MarketingCamp mcSample4 = new MarketingCamp("test4", 175.0, false, 400.0); 
		
		assertEquals("test1", ((mcSample1).getName()));
		assertEquals("test2", ((mcSample2).getName()));
		assertEquals("test3", ((mcSample3).getName()));
		assertEquals("test4", ((mcSample4).getName()));
		
	}
	
	@Test
	public void testReturnPower() {
		MarketingCamp mcSample1 = new MarketingCamp("test1", 4.0, true, 500.0); 
		MarketingCamp mcSample2 = new MarketingCamp("test2", 255.0, true, 600.0); 
		MarketingCamp mcSample3 = new MarketingCamp("test3", -75.5, false, -133.0); 
		MarketingCamp mcSample4 = new MarketingCamp("test4", 111.11, false, 41234.1234); 
		
		assertEquals(0.0, ((mcSample1).calculateReturnPower()), .32);
		assertEquals(0.0, ((mcSample2).calculateReturnPower()), .32);;
		assertEquals(0.0, ((mcSample3).calculateReturnPower()), .61);
		assertEquals(0.0, ((mcSample4).calculateReturnPower()), .61);
		
		mcSample1.setGood(false);
		mcSample2.setGood(false);
		
		mcSample3.setGood(true);
		mcSample3.setGood(true);
		
		assertEquals(0.0, ((mcSample1).calculateReturnPower()), .61);
		assertEquals(0.0, ((mcSample2).calculateReturnPower()), .61);;
		assertEquals(0.0, ((mcSample3).calculateReturnPower()), .32);
		assertEquals(0.0, ((mcSample4).calculateReturnPower()), .32);
		
	}

}
