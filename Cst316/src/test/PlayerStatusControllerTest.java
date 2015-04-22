package test;


import static org.junit.Assert.*;

import java.io.InputStream;
import java.lang.reflect.Field;

import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import org.junit.Before;
import org.junit.Test;

import test.LandingControllerTest.BooleanClosure;
import cst316.Building;
import cst316.Player;
import cst316.Product;
import application.BuildingChoiceController;
import application.HRController;
import application.InvestmentController;
import application.Main;
import application.LandingController;
import application.Market3Controller;
import application.PlayerStatusController;
import application.ResearchDevelopController;

public class PlayerStatusControllerTest extends Main {
    PlayerStatusController ctrl;
    
	private TextArea pointsText;
	private TextArea employeesText;
	private TextArea moneyText;
	private TextArea assetsText;
	private TextArea investmentsText;
	private TextArea productText;
	private ImageView returnBtn;
    
    Node currentTesting;
    
    class BooleanClosure {
    	public boolean flag = false;
    };

	@Before
	public void setUp() throws Exception {
		
		new JFXPanel(); // boot up JavaFX Toolkit
		
		setPlayer(new Player());
		
        ctrl = new PlayerStatusController();
        
        Class<PlayerStatusController> playerStatusController = PlayerStatusController.class;
        Field field;
        
        pointsText = new TextArea();
        field = playerStatusController.getDeclaredField("pointsText");
        field.setAccessible(true);
        field.set(ctrl, pointsText);
        employeesText = new TextArea();
        field = playerStatusController.getDeclaredField("employeesText");
        field.setAccessible(true);
        field.set(ctrl, employeesText);
        moneyText = new TextArea();
        field = playerStatusController.getDeclaredField("moneyText");
        field.setAccessible(true);
        field.set(ctrl, moneyText);
        assetsText = new TextArea();
        field = playerStatusController.getDeclaredField("assetsText");
        field.setAccessible(true);
        field.set(ctrl, assetsText);
        investmentsText = new TextArea();
        field = playerStatusController.getDeclaredField("investmentsText");
        field.setAccessible(true);
        field.set(ctrl, investmentsText);
        productText = new TextArea();
        field = playerStatusController.getDeclaredField("productText");
        field.setAccessible(true);
        field.set(ctrl, productText);
        returnBtn = new ImageView();
        field = playerStatusController.getDeclaredField("returnBtn");
        field.setAccessible(true);
        field.set(ctrl, returnBtn);
        
		Player player = new Player();
		player.setPoints(5);
		player.setEmployees(5);
		player.setMoney(5.1);
		player.addAsset("Test Asset");
		Product product = new Product("Software", 0.5);
		player.setProduct(product);
		setPlayer(player);
        
        ctrl.setApp(this);
    }

	@Test
	public void testSetApp() throws Exception {
		assertEquals("5", pointsText.getText());
		assertEquals("5", employeesText.getText());
		assertEquals("5.1", moneyText.getText());
		assertEquals("Test Asset, ", assetsText.getText());
		assertEquals("", investmentsText.getText());
		assertEquals("Software", productText.getText());
	}
	
	public Node replaceSceneContent(String fxml, Class<? extends AnchorPane> cls) throws Exception {
        return currentTesting;
	}
}
