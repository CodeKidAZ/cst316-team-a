package test;

import static org.junit.Assert.*;

import java.io.InputStream;

import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import cst316.Investment;
import cst316.Management;
import cst316.Player;
import application.InvestmentController;
import application.LoginController;
import application.Main;

public class ChartTest extends Main{
	private Stage stage;
	private Scene scene;
	private final double MINIMUM_WINDOW_WIDTH = 1280;
	private final double MINIMUM_WINDOW_HEIGHT = 720;
	private Player player;
	private Investment inv;
	private InvestmentController ctr;

	@Before
	public void setUp(){
		player = new Player();
		inv = new Investment("Google", 100, true);
		player.addInvestment(inv);
		launch("");
	}
	@Override
	public void start(Stage primaryStage) {
		try {
			// This will need to be redone, really badly!
			Management management = new Management();
			management.getClass();
			BorderPane root = new BorderPane();
			stage = primaryStage;
			scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setMinWidth(MINIMUM_WINDOW_WIDTH);
			stage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
			stage.setScene(scene);
			stage.show();

			ctr = (InvestmentController) replaceSceneContent("Investment.fxml", null);

			ctr.setApp(this);
			ctr.setPlayer(player);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public Node replaceSceneContent(String fxml, Class<? extends AnchorPane> cls) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		if (cls == null) {
			System.out.println("controlller was set by FXML");
		} else {
			loader.setController(cls.getConstructor().newInstance()); //set controller manually
		}
		InputStream in = Main.class.getResourceAsStream(fxml);
		loader.setBuilderFactory(new JavaFXBuilderFactory());
		loader.setLocation(Main.class.getResource(fxml));
		AnchorPane page;
		try {
			page = (AnchorPane) loader.load(in);
		} finally {
			in.close();
		}

		// Store the stage width and height in case the user has resized the window
		double stageWidth = stage.getWidth();
		if (!Double.isNaN(stageWidth)) {
			stageWidth -= (stage.getWidth() - stage.getScene().getWidth());
		}

		double stageHeight = stage.getHeight();
		if (!Double.isNaN(stageHeight)) {
			stageHeight -= (stage.getHeight() - stage.getScene().getHeight());
		}

		Scene scene = new Scene(page);
		if (!Double.isNaN(stageWidth)) {
			page.setPrefWidth(stageWidth);
		}
		if (!Double.isNaN(stageHeight)) {
			page.setPrefHeight(stageHeight);
		}

		stage.setScene(scene);
		stage.sizeToScene();
		return (Node) loader.getController();
	}
	@Ignore @Test
	public void testInvestment() {

		for(int x = 0; x < 15; x++){
			inv.calculateROI();
		}
	}

}
