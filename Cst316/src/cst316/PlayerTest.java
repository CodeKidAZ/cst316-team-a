package cst316;

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
    	player = new Player(100,100, 50.5, "dan", assets);
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
		
		ArrayList<String> addMe = new ArrayList<String>();
		addMe.add("added");
		player.addAssets(addMe);
		assertEquals(player.getAssets().get(0),"added");
		assertTrue(player.printAssets());
		
		assertTrue(player.removeAsset("added"));
		
	}
	@Test
	public void testSaveLoad() {
		assertTrue(player.saveFile());
		assertTrue(player.readFile("dan"));
	}
}
