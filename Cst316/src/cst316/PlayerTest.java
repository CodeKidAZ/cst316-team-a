package cst316;

import java.io.File;
import java.util.ArrayList;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

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
		assertEquals(player.getAssets().size(),2,0);
		player.addAsset("Test3");
		assertEquals(player.getAssets().size(),3,0);
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
		investing.printInvestments();
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
}
