package test;


import static org.junit.Assert.*;

import java.io.InputStream;
import java.lang.reflect.Field;

import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import org.junit.Before;
import org.junit.Test;

import cst316.Player;
import application.Main;
import application.LandingController;

public class LandingTest extends Main {
    LandingController ctrl;
    ImageView invBtn;
    ImageView mngBtn;
    ImageView rndBtn;
    ImageView markBtn;
    ImageView statBtn;

	@Before
	public void setUp() throws Exception {
		setPlayer(new Player());
        ctrl = new LandingController();
        ctrl.setApp(this);
        Class<LandingController> landingController = LandingController.class;
        Field field;
        invBtn = new ImageView();
        field = landingController.getDeclaredField("invBtn");
        field.setAccessible(true);
        field.set(ctrl, invBtn);
        mngBtn = new ImageView();
        field = landingController.getDeclaredField("mngBtn");
        field.setAccessible(true);
        field.set(ctrl, mngBtn);
        rndBtn = new ImageView();
        field = landingController.getDeclaredField("rndBtn");
        field.setAccessible(true);
        field.set(ctrl, rndBtn);
        markBtn = new ImageView();
        field = landingController.getDeclaredField("markBtn");
        field.setAccessible(true);
        field.set(ctrl, markBtn);
        statBtn = new ImageView();
        field = landingController.getDeclaredField("statBtn");
        field.setAccessible(true);
        field.set(ctrl, statBtn);
    }

	@Test
	public void testStatMouseInOut() {
		ctrl.onStatMouseExit();
		Image defaultBg = statBtn.getImage();
		ctrl.onStatMouseEntered();
		assertTrue(!defaultBg.equals(statBtn.getImage()));
		ctrl.onStatMouseExit();
		assertTrue(defaultBg.equals(statBtn.getImage()));
	}

	@Test
	public void testInvMouseInOut() {
		ctrl.onInvMouseExit();
		Image defaultBg = invBtn.getImage();
		ctrl.onInvMouseEntered();
		assertTrue(!defaultBg.equals(invBtn.getImage()));
		ctrl.onInvMouseExit();
		assertTrue(defaultBg.equals(invBtn.getImage()));
	}

	@Test
	public void testRndMouseInOut() {
		ctrl.onRndMouseExit();
		Image defaultBg = rndBtn.getImage();
		ctrl.onRndMouseEntered();
		assertTrue(!defaultBg.equals(rndBtn.getImage()));
		ctrl.onRndMouseExit();
		assertTrue(defaultBg.equals(rndBtn.getImage()));
	}

	@Test
	public void testMarkMouseInOut() {
		ctrl.onMarkMouseExit();
		Image defaultBg = markBtn.getImage();
		ctrl.onMarkMouseEntered();
		assertTrue(!defaultBg.equals(markBtn.getImage()));
		ctrl.onMarkMouseExit();
		assertTrue(defaultBg.equals(markBtn.getImage()));
	}

	@Test
	public void testMngMouseInOut() {
		ctrl.onMngMouseExit();
		Image defaultBg = mngBtn.getImage();
		ctrl.onMngMouseEntered();
		assertTrue(!defaultBg.equals(mngBtn.getImage()));
		ctrl.onMngMouseExit();
		assertTrue(defaultBg.equals(mngBtn.getImage()));
	}
	
	// A lot of this was taken from the Oracle JFX samples, changes will be made
	public Node replaceSceneContent(String fxml, Class<? extends AnchorPane> cls) throws Exception {
        return null;
	}

}
