package test;

import static org.junit.Assert.*;

import java.io.InputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import org.junit.Before;
import org.junit.Test;

import application.Main;
import application.VideoController;

public class VideoControllerTest extends Main{
	private VideoController ctr;
	private Stage stage;

	@Before
	public void setUp() {
		
	}

	@Test
	public void testLoadScene() {
		try {
			launch("");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			stage = primaryStage;
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setMinWidth(1280);
            stage.setMinHeight(720);
			primaryStage.setScene(scene);
			primaryStage.show();
			ctr = (VideoController) replaceSceneContent("Video.fxml", VideoController.class);
			ctr.setApp(this, "player 4");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// A lot of this was taken from the Oracle JFX samples, changes will be made
		public Node replaceSceneContent(String fxml, Class<? extends AnchorPane> cls) throws Exception {
	        FXMLLoader loader = new FXMLLoader();
	        loader.setController(cls.getConstructor().newInstance());
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

}
