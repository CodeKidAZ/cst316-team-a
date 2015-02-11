package cst316;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public final class LoginApplication extends Application {

	/**
	 * @param primaryStage
	 */
	public void start(final Stage primaryStage) {
		
		// The Next button
		Button btn = new Button();
		btn.setText("Continue");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				CreateProfileApplication app = new CreateProfileApplication();
				app.start(primaryStage);
			}
		});
		
		// The character selection form
		RadioButton c1 = new RadioButton("Character #1");
		RadioButton c2 = new RadioButton("Character #2");
		RadioButton c3 = new RadioButton("Character #3");
		RadioButton c4 = new RadioButton("Character #4");
		ToggleGroup ct = new ToggleGroup();
		c1.setToggleGroup(ct);
		c2.setToggleGroup(ct);
		c3.setToggleGroup(ct);
		c4.setToggleGroup(ct);
		
		// The layout
		GridPane root = new GridPane();
		root.setAlignment(Pos.CENTER);
		root.setHgap(10);
		root.setVgap(10);
		root.add(c1, 0, 0);
		root.add(c2, 0, 1);
		root.add(c3, 0, 2);
		root.add(c4, 0, 3);
		root.add(btn, 0, 4);
		
		// Finally put it on the screen
		Scene scene = new Scene(root, 300, 250);
		primaryStage.setTitle("Choose a character");
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
