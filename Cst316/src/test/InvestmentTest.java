package test;

import static org.junit.Assert.*;

import org.json.JSONObject;
import org.junit.Test;

import cst316.Investment;

public class InvestmentTest {

	@Test
	public void testBasicConstructor() {
		Investment investment = new Investment("R2D2", 66.6, true);
		assertEquals(investment.getAmount(), 66.6, 0.5);
		assertEquals(investment.getName(), "R2D2");
		assertEquals(investment.isGood(), true);
	}
	
	@Test
	public void testJSONConstructor() {
		Investment investment = new Investment(new JSONObject("{"
				+ "\"Name\": \"R2D2\","
				+ "\"Amount\": 66.6,"
				+ "\"IsGood\": true"
				+ "}"));
		assertEquals(investment.getAmount(), 66.6, 0.5);
		assertEquals(investment.getName(), "R2D2");
		assertEquals(investment.isGood(), true);
	}
	
	@Test
	public void testCalculateGoodROI() {
		Investment investment1 = new Investment("GoodTest", 100.0, true);
		int threshold = 0;
		for (int i = 0; i != 1000; ++i) {
			double roi = investment1.calculateROI();
			if (roi > 0) {
				threshold += 1;
			}
		}
		assertTrue(threshold > 500);
	}
	
	@Test
	public void testCalculateBadROI() {
		Investment investment1 = new Investment("BadTest", 100.0, false);
		int threshold = 0;
		for (int i = 0; i != 1000; ++i) {
			double roi = investment1.calculateROI();
			if (roi < 0) {
				threshold += 1;
			}
		}
		assertTrue(threshold > 500);
	}
	
	@Test
	public void testToString() {
		Investment investment1 = new Investment("BadTest", 100.0, false);
		assertEquals(investment1.toString(), "BadTest: 100.0");
		Investment investment2 = new Investment("GoodTest", 25.5, false);
		assertEquals(investment2.toString(), "GoodTest: 25.5");
	}
	
	@Test
	public void testToJSONString() {
		Investment investment1 = new Investment("BadTest", 100.0, false);
		Investment investment1b = new Investment(new JSONObject(investment1.toJSONString()));
		assertEquals(investment1, investment1b);
		Investment investment2 = new Investment("GoodTest", 50.0, false);
		Investment investment2b = new Investment(new JSONObject(investment2.toJSONString()));
		assertEquals(investment2, investment2b);
	}
	
	@Test
	public void testEquals() {
		String s = "la la la";
		Investment investment1 = new Investment("XTest", 100.0, false);
		assertTrue(!investment1.equals(s));
		Investment investment2 = new Investment("XTest", 50.0, false);
		assertTrue(!investment2.equals(investment1));
		Investment investment3 = new Investment("XTest", 100.0, true);
		assertTrue(!investment3.equals(investment1));
		Investment investment4 = new Investment("YTest", 100.0, false);
		assertTrue(!investment4.equals(investment1));
		Investment investment5 = new Investment("XTest", 100.0, false);
		assertTrue(investment5.equals(investment1));
	}

}
