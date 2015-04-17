package test;

import java.io.File;
import java.util.ArrayList;

import org.json.JSONObject;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cst316.Investment;
import cst316.Player;

public class PlayerTest {
	Player player;
	
    @Before
    public void setUp() {
    	ArrayList<String> assets = new ArrayList<String>( );
    	assets.add("Test1");
    	assets.add("Test2");
    	player = new Player(100, 50.5, "dan", assets);
    }
	@Test
	public void testAssets() {
		assertEquals(player.getAssets().size(),2);
		player.addAsset("Test3");
		assertEquals(player.getAssets().size(),3);
		assertEquals(player.getAssets().get(2),"Test3");
		ArrayList<String> assets2 = new ArrayList<String>();
		player.setAssets(assets2);
		assertEquals(assets2, player.getAssets());
	}
	@Test
	public void testSaveLoad() {
		assertTrue(player.saveFile());
		assertTrue(player.readFile("dan"));
		(new File("dan.json")).delete();
	}
	@Test
	public void testDuplicateAssets() {
		Player player1 = new Player();
		Player player2 = new Player();
		assertEquals(player1.getAssets().size(), 0);
		assertEquals(player2.getAssets().size(), 0);
		player1.addAsset("Test Asset");
		assertEquals(player1.getAssets().size(), 1);
		assertEquals(player2.getAssets().size(), 0);
	}
	@Test
	public void testGetInvestments() {
		Player investing = new Player();
		assertEquals(investing.getInvestments().size(), 0);
		investing = new Player(15, 15.0, "Mick", new ArrayList<String>());
		assertEquals(investing.getInvestments().size(), 0);
	}
	@Test
	public void testAddInvestment() {
		Player investing = new Player();
		investing.addInvestment(new Investment("Name", 10.0, true));
		assertEquals(investing.getInvestments().size(), 1);
	}
	@Test
	public void testJSONInvestments() {
		Player investing = new Player(100, 50.5, "dan", new ArrayList<String>());
		assertEquals(investing.getInvestments().size(), 0);
		investing.addInvestment(new Investment("Name", 10.0, true));
		assertEquals(investing.getInvestments().size(), 1);
		assertTrue(investing.saveFile());
		assertEquals(investing.getInvestments().size(), 1);
		investing.addInvestment(new Investment("Name2", 10.0, true));
		assertEquals(investing.getInvestments().size(), 2);
		assertTrue(investing.readFile("dan"));
		assertEquals(investing.getInvestments().size(), 1);
		(new File("dan.json")).delete();
	}
	@Test
	public void testNonExistentFile() {
		Player tester = new Player();
		assertFalse(tester.readFile("ThisFileHadBetterNotExistOrThisTestWillFail"));
	}
	@Test
	public void testInvalidFile() {
		Player tester = new Player(0, 0.0, "/dev/null", new ArrayList<String>());
		assertFalse(tester.saveFile());
	}
	@Test
	public void testConstructJSONObject() throws Exception {
		Player tester = new Player(new JSONObject("{\"Money\":100,\"Points\":0,\"Investments\":[],\"Buildings\":[],\"Assets\":[],"
				+ "\"Companies\":[{\"companyName\":\"test\",\"employees\":-7,\"products\":[{\"TotalMarginalCost\":0,\"TotalFixedCost\":7,"
				+ "\"Name\":\"Vehical\"}]}],\"Employees\":0,\"Product\":{\"TotalMarginalCost\":0,\"TotalFixedCost\":0"
				+ ",\"Name\":\"House Wares\"},\"Name\":\"testMe\"}"));
		assertEquals(tester.getMoney(), 100, .5);
		assertEquals(tester.getName(), "testMe");
		assertEquals(tester.getPoints(), 0);
		assertEquals(tester.getAssets().size(), 0);
		assertEquals(tester.getInvestments().size(), 0);
		assertEquals(tester.getBuildings().size(), 0);
		assertEquals(tester.getCompanyList().size(), 1);
	}
	@Test
	public void testPerformInvestment() {
		Player tester = new Player();
		tester.takeInvestment("Test investment", 10.5, true);
		assertEquals(tester.getMoney(), -10.5, .5);
		assertEquals(tester.getInvestments().size(), 1);
		assertEquals(tester.getInvestments().get(0), new Investment("Test investment", 10.5, true));
		tester.cashInvestment(tester.getInvestments().get(0));
		assertTrue(tester.getMoney() == -10.5);
	}
}
