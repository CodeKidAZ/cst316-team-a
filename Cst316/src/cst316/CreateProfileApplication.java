package cst316;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public final class CreateProfileApplication extends Application {

	/**
	 * @param primaryStage
	 */
	public void start(Stage primaryStage) {
		
		// The Next button
		Button btn = new Button();
		btn.setText("Continue");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Clicked Next");
			}
		});
		
		// The character selection form
		TextField name = new TextField();
		TextField location = new TextField();
		Text nameLabel = new Text("Name");
		Text locationLabel = new Text("Location");
		
		// The layout
		GridPane root = new GridPane();
		root.setAlignment(Pos.CENTER);
		root.setHgap(10);
		root.setVgap(10);
		root.add(nameLabel, 0, 0);
		root.add(name, 1, 0);
		root.add(locationLabel, 0, 2);
		root.add(location, 1, 2);
		root.add(btn, 0, 3);
		
		// Finally put it on the screen
		Scene scene = new Scene(root, 300, 250);
		primaryStage.setTitle("Build a profile");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

}
