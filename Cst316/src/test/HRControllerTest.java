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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
import cst316.Company;
import cst316.Player;
import application.BuildingChoiceController;
import application.CorpController;
import application.FireController;
import application.HRController;
import application.InvestmentController;
import application.Main;
import application.LandingController;
import application.Market3Controller;
import application.PlayerStatusController;
import application.ResearchDevelopController;
import application.WorkersListController;

public class HRControllerTest extends Main {
	HRController ctrl;
	
	TableView<Company> companyTableView;
	TableColumn<Company, String> companyNameColumn;
	ImageView fireImage;
	ImageView hireImage1;
	ImageView createCompanyImage;
	ComboBox<String> companyComboBox;
	Label totalLabel;
	
    Node currentTesting;
    
    class BooleanClosure {
    	public boolean flag = false;
    };

	@Before
	public void setUp() throws Exception {
		
		new JFXPanel(); // boot up JavaFX Toolkit
		
		setPlayer(new Player());
		
        ctrl = new HRController();
        
        Class<HRController> hrController = HRController.class;
        Field field;
        
        companyTableView = new TableView<Company>();
        field = hrController.getDeclaredField("companyTableView");
        field.setAccessible(true);
        field.set(ctrl, companyTableView);
        companyNameColumn = new TableColumn<Company, String>();
        field = hrController.getDeclaredField("companyNameColumn");
        field.setAccessible(true);
        field.set(ctrl, companyNameColumn);
        fireImage = new ImageView();
        field = hrController.getDeclaredField("fireImage");
        field.setAccessible(true);
        field.set(ctrl, fireImage);
        hireImage1 = new ImageView();
        field = hrController.getDeclaredField("hireImage1");
        field.setAccessible(true);
        field.set(ctrl, hireImage1);
        createCompanyImage = new ImageView();
        field = hrController.getDeclaredField("createCompanyImage");
        field.setAccessible(true);
        field.set(ctrl, createCompanyImage);
        companyComboBox = new ComboBox<String>();
        field = hrController.getDeclaredField("companyComboBox");
        field.setAccessible(true);
        field.set(ctrl, companyComboBox);
        totalLabel = new Label();
        field = hrController.getDeclaredField("totalLabel");
        field.setAccessible(true);
        field.set(ctrl, totalLabel);
        
        ctrl.setApp(this);
    }

	@Test
	public void testSetApp() throws Exception {
		assertTrue(null != companyNameColumn.getCellValueFactory());
		assertTrue(null != fireImage.getImage());
		assertTrue(null != hireImage1.getImage());
		assertTrue(null != createCompanyImage.getImage());
		assertEquals(HRController.comboList, companyTableView.getItems());
		assertEquals(HRController.comboList, companyComboBox.getItems());
	}
	
	@Test
	public void testOpenFire() throws Exception {
		BooleanClosure bool = new BooleanClosure();
		currentTesting = new FireController() {
			public void setApp(Main application) {
				bool.flag = true;
				assertTrue(application.equals(HRControllerTest.this));
			}
		};
		ctrl.openFire(null);
		assertTrue(bool.flag);
	}

	@Test
	public void testOpenWorkersList() throws Exception {
		BooleanClosure bool = new BooleanClosure();
		currentTesting = new WorkersListController() {
			public void setApp(Main application) {
				bool.flag = true;
				assertTrue(application.equals(HRControllerTest.this));
			}
		};
		ctrl.openWorkersList(null);
		assertTrue(bool.flag);
	}

	@Test
	public void testOpenCorpScreen() throws Exception {
		BooleanClosure bool = new BooleanClosure();
		currentTesting = new CorpController() {
			public void setApp(Main application) {
				bool.flag = true;
				assertTrue(application.equals(HRControllerTest.this));
			}
		};
		ctrl.openCorpScreen(null);
		assertTrue(bool.flag);
	}
	
	public Node replaceSceneContent(String fxml, Class<? extends AnchorPane> cls) throws Exception {
        return currentTesting;
	}
}
