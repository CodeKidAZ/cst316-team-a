package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import service.InvestmentService;
import application.Main;
import cst316.Investment;
import cst316.Player;

public class InvestmentServiceTest extends Main{
	Player player;
	@Before
    public void setUp() {
        setPlayer(new Player());
        player = getPlayer();
        Investment inv = new Investment("inv", 100, true);
        player.addInvestment(inv);
        try{
    		launch("");
    	}catch(Exception e){
    		e.printStackTrace();
    	}
        InvestmentService.createNewInstance(this);
    }
	
	@Ignore @Test
	public void test() {
		try {
			Thread.sleep(61000);
			player.getInvestments().get(0).calculateROI();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		assertTrue(player.getInvestments().get(0).getAmount() != 100);
	}



}
