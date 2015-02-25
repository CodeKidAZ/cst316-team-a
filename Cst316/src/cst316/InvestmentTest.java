package cst316;

import static org.junit.Assert.*;
import org.json.JSONObject;

import org.junit.Test;

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

}
