package test;


import static org.junit.Assert.*;

import java.io.InputStream;
import java.lang.reflect.Field;

import javafx.embed.swing.JFXPanel;
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
import application.BuildingChoiceController;
import application.HRController;
import application.InvestmentController;
import application.Main;
import application.LandingController;
import application.Market3Controller;
import application.MarketingStatisticsController;
import application.PieChartFromArrayController;
import application.PlayerStatusController;
import application.ResearchDevelopController;

public class Market3ControllerTest extends Main {
    Market3Controller ctrl;
    
    TextArea descriptionBox;
    ComboBox<String> dropMenu;
    Button returnButton;
    ImageView marketingPicture;
    ImageView questionMark;
    Button purchaseButton;
    Text doneText;
    
    Node currentTesting;
    
    class BooleanClosure {
    	public boolean flag = false;
    };

	@Before
	public void setUp() throws Exception {
		
		new JFXPanel(); // boot up JavaFX Toolkit
		
		setPlayer(new Player());
		
        ctrl = new Market3Controller();
        
        Class<Market3Controller> market3Controller = Market3Controller.class;
        Field field;
        
        descriptionBox = new TextArea();
        field = market3Controller.getDeclaredField("descriptionBox");
        field.setAccessible(true);
        field.set(ctrl, descriptionBox);
        dropMenu = new ComboBox<String>();
        field = market3Controller.getDeclaredField("dropMenu");
        field.setAccessible(true);
        field.set(ctrl, dropMenu);
        returnButton = new Button();
        field = market3Controller.getDeclaredField("returnButton");
        field.setAccessible(true);
        field.set(ctrl, returnButton);
        questionMark = new ImageView();
        field = market3Controller.getDeclaredField("questionMark");
        field.setAccessible(true);
        field.set(ctrl, questionMark);
        marketingPicture = new ImageView();
        field = market3Controller.getDeclaredField("marketingPicture");
        field.setAccessible(true);
        field.set(ctrl, marketingPicture);
        purchaseButton = new Button();
        field = market3Controller.getDeclaredField("purchaseButton");
        field.setAccessible(true);
        field.set(ctrl, purchaseButton);
        doneText = new Text();
        field = market3Controller.getDeclaredField("doneText");
        field.setAccessible(true);
        field.set(ctrl, doneText);
        
        ctrl.setApp(this);
    }

	@Test
	public void testSetApp() throws Exception {
		assertTrue(dropMenu.getItems().size() == 4);
	}
	
	@Test
	public void testDropMenuFired() throws Exception {
		dropMenu.getSelectionModel().select("Print Marketing");
		ctrl.dropMenuFired(null);
		assertEquals("Print Marketing", dropMenu.getSelectionModel().getSelectedItem());
		assertTrue(marketingPicture.getImage() != null);
		assertEquals("Cost: 100.0\nDescription: HEEELLLOOModerately expensive and moderately reliable form of Marketing. +5MP to +15\n", descriptionBox.getText());
	}
	
	@Test
	public void testPurchaseButtonFiredFail() throws Exception {
		dropMenu.getSelectionModel().select("Print Marketing");
		ctrl.dropMenuFired(null);
		ctrl.purchaseButtonFired(null);
		// XXX
	}

	@Test
	public void testPurchaseButtonFiredPass() throws Exception {
		dropMenu.getSelectionModel().select("Print Marketing");
		ctrl.dropMenuFired(null);
		ctrl.purchaseButtonFired(null);
		// XXX
	}
	
	@Test
	public void testReturnButtonFired() throws Exception {
		BooleanClosure bool = new BooleanClosure();
		currentTesting = new LandingController() {
			public void setApp(Main application) {
				bool.flag = true;
				assertTrue(application.equals(Market3ControllerTest.this));
			}
		};
		ctrl.returnButtonFired(null);
		assertTrue(bool.flag);
	}

	@Test
	public void testChartButtonFired() throws Exception {
		BooleanClosure bool = new BooleanClosure();
		currentTesting = new MarketingStatisticsController() {
			public void setApp(Main application) {
				bool.flag = true;
				assertTrue(application.equals(Market3ControllerTest.this));
			}
		};
		ctrl.chartButtonFired(null);
		assertTrue(bool.flag);
	}
	
	@Test
	public void testTest1ButtonFired() throws Exception {
		BooleanClosure bool = new BooleanClosure();
		currentTesting = new PieChartFromArrayController() {
			public void setApp(Main application) {
				bool.flag = true;
				assertTrue(application.equals(Market3ControllerTest.this));
			}
		};
		ctrl.test1ButtonFired(null);
		assertTrue(bool.flag);
	}
	
	public Node replaceSceneContent(String fxml, Class<? extends AnchorPane> cls) throws Exception {
        return currentTesting;
	}
}
