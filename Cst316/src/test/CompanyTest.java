package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.json.JSONObject;
import org.junit.Test;

import cst316.Company;
import cst316.Product;
import cst316.ResearchDevelObject;

public class CompanyTest {

	Company a = new Company("Intel");
	private ArrayList<Product> myProducts;
	
	@Test
	public void testCompany() {
	
	}

	@Test
	public void testSetCompanyName() {
		a.setCompanyName("Samsung");
		assertEquals(a.getCompanyName(),"Samsung");
	}

	@Test
	public void testGetProducts() throws Exception {
		
	}

	@Test
	public void testGetCompanyName() {
		assertEquals(a.getCompanyName(),"Intel");
	}
	
	@Test
	public void testAddProducts() throws Exception {
		//Product b= new Product("Electronics", 80.0, 5.00);
	
		a.addProducts(new Product("Electronics", 5.5, 0.5));
		//System.out.println(a.getProducts());
	}
	@Test
	public void testGetRandD() {
		fail("Not yet implemented");
	}

	@Test
	public void testMyEmployees() {
		fail("Not yet implemented");
	}

	

	@Test
	public void testAddRandD() {
		ResearchDevelObject r = new ResearchDevelObject();
		a.addRandD(r);
	}

	@Test
	public void testAddEmployees() {
		fail("Not yet implemented");
	}

}
