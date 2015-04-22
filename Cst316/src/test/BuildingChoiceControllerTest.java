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
import application.PlayerStatusController;
import application.ResearchDevelopController;

public class BuildingChoiceControllerTest extends Main {
    BuildingChoiceController ctrl;
    
    TextArea descriptionBox;
    ComboBox<String> dropMenu;
    Button returnButton;
    ImageView buildingPicture;
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
		
        ctrl = new BuildingChoiceController();
        
        Class<BuildingChoiceController> buildingChoiceController = BuildingChoiceController.class;
        Field field;
        
        descriptionBox = new TextArea();
        field = buildingChoiceController.getDeclaredField("descriptionBox");
        field.setAccessible(true);
        field.set(ctrl, descriptionBox);
        dropMenu = new ComboBox<String>();
        field = buildingChoiceController.getDeclaredField("dropMenu");
        field.setAccessible(true);
        field.set(ctrl, dropMenu);
        returnButton = new Button();
        field = buildingChoiceController.getDeclaredField("returnButton");
        field.setAccessible(true);
        field.set(ctrl, returnButton);
        buildingPicture = new ImageView();
        field = buildingChoiceController.getDeclaredField("buildingPicture");
        field.setAccessible(true);
        field.set(ctrl, buildingPicture);
        purchaseButton = new Button();
        field = buildingChoiceController.getDeclaredField("purchaseButton");
        field.setAccessible(true);
        field.set(ctrl, purchaseButton);
        doneText = new Text();
        field = buildingChoiceController.getDeclaredField("doneText");
        field.setAccessible(true);
        field.set(ctrl, doneText);
        
        ctrl.setApp(this);
    }

	@Test
	public void testSetApp() throws Exception {
		assertTrue(dropMenu.getItems().size() == Building.getAllBuildingNames().length);
	}

	@Test
	public void testSetBuilding() throws Exception {
		Building b = new Building("Basic Building");
		ctrl.setBuilding(b);
		assertTrue(buildingPicture.getImage() != null);
		assertEquals("Cost: 10.0\nDescription: The basic building for entrepreneurs\n", descriptionBox.getText());
		assertEquals("Basic Building", dropMenu.getSelectionModel().getSelectedItem());
		assertEquals(b, ctrl.getBuilding());
	}
	
	@Test
	public void testDropMenuFired() throws Exception {
		dropMenu.getSelectionModel().select("Factory");
		ctrl.dropMenuFired(null);
		assertEquals("Factory", ctrl.getBuilding().getName());
		assertTrue(buildingPicture.getImage() != null);
		assertEquals("Cost: 10.0\nDescription: A small scale factory for mass production\n", descriptionBox.getText());
		assertEquals("Factory", dropMenu.getSelectionModel().getSelectedItem());
	}
	
	@Test
	public void testPurchaseButtonFiredFail() throws Exception {
		getPlayer().setMoney(5.0);
		ctrl.setBuilding(new Building("Basic Building"));
		ctrl.purchaseButtonFired(null);
		assertEquals(getPlayer().getMoney(), 5.0, 0.1);
	}

	@Test
	public void testPurchaseButtonFiredPass() throws Exception {
		getPlayer().setMoney(15.0);
		ctrl.setBuilding(new Building("Basic Building"));
		ctrl.purchaseButtonFired(null);
		assertEquals(getPlayer().getMoney(), 5.0, 0.1);
	}
	
	@Test
	public void testReturnButtonFired() throws Exception {
		BooleanClosure bool = new BooleanClosure();
		currentTesting = new LandingController() {
			public void setApp(Main application) {
				bool.flag = true;
				assertTrue(application.equals(BuildingChoiceControllerTest.this));
			}
		};
		ctrl.returnButtonFired(null);
		assertTrue(bool.flag);
	}
	
	public Node replaceSceneContent(String fxml, Class<? extends AnchorPane> cls) throws Exception {
        return currentTesting;
	}
}
