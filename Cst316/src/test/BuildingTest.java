package test;

import static org.junit.Assert.*;

import org.json.JSONObject;
import org.junit.Test;

import cst316.Building;

public class BuildingTest {

	@Test
	public void testStringConstruct() throws Exception {
		Building uut = new Building("Corporate HQ");
		assertEquals(uut.getName(), "Corporate HQ");
		assertEquals(uut.getTotalCost(), 10.0, .5);
		assertEquals(uut.getImage(), "res/building_4.png");
		assertEquals(uut.getDescription(), "The best building in the game yields massive production");
	}

	@Test
	public void testJSONConstruct() throws Exception {
		Building uut = new Building(new JSONObject("{\"Name\": \"Corporate HQ\"}"));
		assertEquals(uut.getName(), "Corporate HQ");
		assertEquals(uut.getTotalCost(), 10.0, .5);
		assertEquals(uut.getImage(), "res/building_4.png");
		assertEquals(uut.getDescription(), "The best building in the game yields massive production");
	}
	
	@Test
	public void testToJSONString() throws Exception {
		JSONObject jsonObject = new JSONObject("{\"Name\": \"Corporate HQ\"}");
		Building uut = new Building(jsonObject);
		assertEquals(uut.toJSONString(), jsonObject.toString());
	}
	
	@Test
	public void testGetAllBuildingNames() throws Exception {
		String[] names = Building.getAllBuildingNames();
		for (String name : names) {
			Building uut = new Building(name);
			assertEquals(uut.getName(), name);
		}
	}
}
