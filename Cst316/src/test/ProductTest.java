package test;

import static org.junit.Assert.*;

import org.json.JSONObject;
import org.junit.Test;

import cst316.Product;

public class ProductTest {

	@Test
	public void testBasicConstructor() throws Exception {
        Product product = new Product("Electronics", 5.5, 0.5);
        assertEquals(product.getName(), "Electronics");
        assertEquals(product.getTotalFixedCost(), 5.5, 0.01);
        assertEquals(product.getTotalMarginalCost(), 0.5, 0.01);
        assertEquals(product.getMarginalToFixed(), 0.1, 0.01);
	}
	
	@Test
	public void testJSONConstructor() throws Exception {
		Product product = new Product(new JSONObject("{"
				+ "\"Name\": \"Food\","
				+ "\"TotalFixedCost\": 7.5,"
				+ "\"TotalMarginalCost\": 5.5,"
				+ "}"));
        assertEquals(product.getName(), "Food");
        assertEquals(product.getTotalFixedCost(), 7.5, 0.01);
        assertEquals(product.getTotalMarginalCost(), 5.5, 0.01);
        assertEquals(product.getMarginalToFixed(), 1.5, 0.01);
	}
	
	@Test
	public void testToJSONString() throws Exception {
        Product product = new Product("Electronics", 5.5, 0.5);
        JSONObject json = new JSONObject();
        json.put("Name", "Electronics");
        json.put("TotalFixedCost", 5.5);
        json.put("TotalMarginalCost", 0.5);
        assertEquals(product.toJSONString(), json.toString());
	}

    @Test
    public void testTotalAverageCost() throws Exception {
        Product product = new Product("Electronics", 5.5, 0.5);
        assertEquals(product.getTotalAverageCost(1), 6.0, 0.01);
        assertEquals(product.getTotalAverageCost(2), 3.25, 0.01);
    }

    @Test
    public void testSetters() throws Exception {
        Product product = new Product("Electronics", 5.5, 0.5);
        product.setTotalMarginalCost(1.0);
        product.setTotalFixedCost(2.0);
        assertEquals(product.getTotalMarginalCost(), 1.0, 0.01);
        assertEquals(product.getTotalFixedCost(), 2.0, 0.01);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testZeroTotalAverageCost() throws Exception {
        Product product = new Product("Electronics", 5.5, 0.5);
        product.getTotalAverageCost(0);
    }
}
