/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.util.Random;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import application.MarketCompany;

/**
 * @author Wesley Local
 *
 */
public class MarketShareMeasureTest {
	

	//private ArrayList<MarketCompany> companyList;
	Random rNG = new Random();

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
	public void test() {
		
		ArrayList<MarketCompany> companyList = new ArrayList<MarketCompany>();
		
		double i = rNG.nextInt(255);
		double a = rNG.nextInt(255);
		double b = rNG.nextInt(255);
		double c = rNG.nextInt(255);
		
		double total = i+a+b+c;
		
		MarketCompany mcSample1 = new MarketCompany("Microsoft", i);
		MarketCompany mcSample2 = new MarketCompany("Google", a);
		MarketCompany mcSample3 = new MarketCompany("IBM", b);
		MarketCompany mcSample4 = new MarketCompany("Sony", c);
		companyList.add(mcSample1);
		companyList.add(mcSample2);
		companyList.add(mcSample3);
		companyList.add(mcSample4);
		
		/*System.out.println((companyList.get(0)).getName()); 
		System.out.println((companyList.get(1)).getName());
		System.out.println((companyList.get(2)).getName());
		System.out.println((companyList.get(3)).getName());
		*/
		assertEquals("Microsoft", ((companyList.get(0)).getName()));
		assertEquals("Google", ((companyList.get(1)).getName()));
		assertEquals("IBM", ((companyList.get(2)).getName()));
		assertEquals("Sony", ((companyList.get(3)).getName()));

	}

}
