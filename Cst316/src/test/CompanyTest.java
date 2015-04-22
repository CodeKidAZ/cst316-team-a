package test;

import static org.junit.Assert.*;

import org.json.JSONObject;
import org.junit.Test;

import cst316.Company;
import cst316.Product;
import cst316.ResearchDevelObject;

public class CompanyTest {

	Company c = new Company("PQR.Corp");
	double totalEmp = 25;
	@Test
	public void testCompanyString() {
		Company  a = new Company("ABC.Corp");
	}

	@Test
	public void testCompanyJSONObject() throws Exception {
		JSONObject js = new JSONObject();
		js.put("companyName", "NuclearBombs");
		js.put("employees", "1");
		
		Product a = new Product("Drones", 55);
		Product b = new Product("Fighter", 505);
		c.addProducts(a);
		c.addProducts(b);
		
		Company z = new Company(js);
	}

	@Test
	public void testToJSONString() {
		//fail("Not yet implemented");
	}

	@Test
	public void testSetname() {
		Company b = new Company("XYZ.Corp");
		b.setName("PQR.Corp");
		assertEquals(b.getCompanyName(), "PQR.Corp");
	}

	@Test
	public void testGetCompanyName() {
		
		assertEquals(c.getCompanyName(), "PQR.Corp");
	}

	@Test
	public void testGetProducts() {
		Product a = new Product("Drones", 55);
		c.addProducts(a);
		assertEquals(c.getProducts().get(0).getName(), a.getName());
	}

	@Test
	public void testGetRandD() {
		assertEquals(0, c.getRandD().size());
	}

	@Test
	public void testAddProducts() {
		Product a = new Product("Drones", 55);
		c.addProducts(a);
		assertEquals(c.getProducts().get(0).getName(), a.getName());
	}

	@Test
	public void testAddRandD() {
		ResearchDevelObject r = new ResearchDevelObject(22, 100, "DroneResearch");
		// c.addRandD(r);
	}

	@Test
	public void testGetEmployees() {
		assertEquals(c.getEmployees(), 0,0);
	}

	@Test
	public void testSetEmployees() {
		c.setEmployees(30);
		assertEquals(c.getEmployees(), 30,0);
	}

	@Test
	public void testAddEmployees() {
		c.addEmployees(totalEmp);
		assertEquals(c.getEmployees(), 25,0);
	}
	
	@Test
	public void testToJson() {
		String test = c.toJSONString();
		assert(test.equals("{\"Name\":\"ABC.Corp\"}"));
	}
	
	@Test
	public void testFetchProductString() {
		Product test = new Product("aProduct", 505);
		c.addProducts(test);
		String name = c.fetchProductString(0);
		assert(name.equals("aProduct"));
		assertNull(c.fetchProductString(1000));
	}

}
