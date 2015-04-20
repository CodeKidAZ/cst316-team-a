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

import cst316.PrintMarketing;

/**
 * @author Wesley Local
 *
 */
public class PrintMarketingTest {
	
	PrintMarketing print1;
	PrintMarketing print2;
	PrintMarketing print3;

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
		print1 = new PrintMarketing(30, 1, 500, "Posters for ASU PAB", true);
		print2 = new PrintMarketing(30, -1, 500, "Posters for ASU PAB", true);
		print3 = new PrintMarketing(30, 0, 500, "Posters for ASU PAB", true);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testStartCampaign() {
		print1 = new PrintMarketing(30, 1, 500, "Posters for ASU PAB", true);
		assertTrue((print1.startCampaign() <= 100) && (print1.startCampaign() >= -100));
		print1.setRisk(5);
		assertTrue((print1.startCampaign() <= 500) && (print1.startCampaign() >= -500));
		print2 = new PrintMarketing(30, -1, 500, "Posters for ASU PAB", true);
		assertTrue((print2.startCampaign() <= 100) && (print2.startCampaign() >= -100));
		print2.setRisk(5);
		assertTrue((print2.startCampaign() <= 500) && (print2.startCampaign() >= -500));
		print3 = new PrintMarketing(30, 0, 500, "Posters for ASU PAB", true);
		assertTrue((print3.startCampaign() == 0));
		print2.setRisk(5);
		assertTrue((print3.startCampaign() == 0));
	}
	
	@Test
	public void testCancelCampaign() {
		assertTrue((print1.cancelCampaign() < 100) && (print1.cancelCampaign() > 0));
		assertTrue((print2.cancelCampaign() < 100) && (print2.cancelCampaign() > 0));
		assertTrue((print3.cancelCampaign() < 100) && (print3.cancelCampaign() > 0));
	}

}
