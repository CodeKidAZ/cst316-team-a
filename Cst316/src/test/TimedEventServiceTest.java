package test;
	
import java.io.InputStream;

import application.LandingController;
import application.Main;
import service.TimedEventService;
import cst316.Management;
import cst316.Player;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TimedEventServiceTest extends Main {
	
	private Stage stage;
	private final double MINIMUM_WINDOW_WIDTH = 1280;
    private final double MINIMUM_WINDOW_HEIGHT = 720;
    private Player player;

    @Before
    public void setUp(){
    	
    }
    @Ignore @Test
	public void testPageChange() {
    	try{
    		launch("");
    	}catch(Exception e){
    		e.printStackTrace();
    	}
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			// This will need to be redone, really badly!
			Management management = new Management();
			BorderPane root = new BorderPane();
			stage = primaryStage;
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setMinWidth(MINIMUM_WINDOW_WIDTH);
            stage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
			stage.setScene(scene);
			stage.show();
			TimedEventService.createNewInstance(this);
			LandingController ctr = (LandingController) replaceSceneContent("Landing.fxml", LandingController.class);
			ctr.setApp(this);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Stage getStage(){
		return stage;
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
