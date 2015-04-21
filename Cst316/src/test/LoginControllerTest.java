package test;


import static org.junit.Assert.*;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Group;
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
import application.LoginController;
import application.Main;
import application.LandingController;
import application.Market3Controller;
import application.MarketingStatisticsController;
import application.PieChartFromArrayController;
import application.PlayerStatusController;
import application.ResearchDevelopController;
import application.VideoController;

public class LoginControllerTest extends Main {
    LoginController ctrl;
    
    ComboBox<String> playerNameText;
    Button continueBtn;
    Group theBox;
    
    Node currentTesting;
    
    class BooleanClosure {
    	public boolean flag = false;
    };

	@Before
	public void setUp() throws Exception {
		
		new JFXPanel(); // boot up JavaFX Toolkit
		
		setPlayer(new Player());
		
        ctrl = new LoginController();
        
        Class<LoginController> loginController = LoginController.class;
        Field field;
        
        playerNameText = new ComboBox<String>();
        field = loginController.getDeclaredField("playerNameText");
        field.setAccessible(true);
        field.set(ctrl, playerNameText);
        continueBtn = new Button();
        field = loginController.getDeclaredField("continueBtn");
        field.setAccessible(true);
        field.set(ctrl, continueBtn);
        theBox = new Group();
        field = loginController.getDeclaredField("theBox");
        field.setAccessible(true);
        field.set(ctrl, theBox);
        
        ctrl.setApp(this);
        Method mtd = loginController.getDeclaredMethod("initialize");
        mtd.setAccessible(true);
        mtd.invoke(ctrl);
    }
	
	@Test
	public void testExistingPlayer() throws Exception {
		Player plr = new Player();
		plr.setName("Existing Player");
		plr.saveFile();
		playerNameText.getSelectionModel().select("Existing Player");
		
		BooleanClosure bool = new BooleanClosure();
		currentTesting = new LandingController() {
			public void setApp(Main application) {
				bool.flag = true;
				assertTrue(application.equals(LoginControllerTest.this));
			}
		};
		ctrl.continueBtnClicked();
		assertTrue(bool.flag);
	}
	
	@Test
	public void testNewPlayer() throws Exception {
		playerNameText.getSelectionModel().select("Definitely A Non-Existing Player");
		
		BooleanClosure bool = new BooleanClosure();
		currentTesting = new VideoController() {
			public void setApp(Main application, String playerName) {
				bool.flag = true;
				assertTrue(application.equals(LoginControllerTest.this));
				assertEquals("Definitely A Non-Existing Player", playerName);
			}
		};
		ctrl.continueBtnClicked();
		assertTrue(bool.flag);
	}
	
	public Node replaceSceneContent(String fxml, Class<? extends AnchorPane> cls) throws Exception {
        return currentTesting;
	}
}
