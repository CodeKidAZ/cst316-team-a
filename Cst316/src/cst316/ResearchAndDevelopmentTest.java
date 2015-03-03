package cst316;

import static org.junit.Assert.*;

import org.junit.Test;

public class ResearchAndDevelopmentTest {
	ResearchAndDevelopment rD = new ResearchAndDevelopment();
	ResearchDevelObject obj = new ResearchDevelObject();
	
	@Test
	public void testResearchDev() {
		rD.generateResDevObjs();
		assertEquals(rD.getResDevObjsElement("materials").getName(),"materials");
		assertNull(rD.getResDevObjsElement("test"));
		
		Player p = new Player();
		ResearchAndDevelopment rD2 = new ResearchAndDevelopment(p);
		
		assertEquals(obj.getCost(),0);
		assertEquals(obj.getPointWorth(),0);
		
		assertEquals(rD2.getPlayer(), p);
	}

}
