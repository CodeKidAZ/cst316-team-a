package cst316;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class marketingApplication extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("MarketingChoiceFXML.fxml"));
		Scene scene = new Scene(root);
		
		stage.setScene(scene);;
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
