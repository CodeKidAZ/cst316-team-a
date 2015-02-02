package cst316;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public final class LoginApplication extends Application {

	/**
	 * @param primaryStage
	 */
	public void start(Stage primaryStage) {
		
		// The Next button
		Button btn = new Button();
		btn.setText("Next");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Clicked Next");
			}
		});
		
		// The amount entering field
		TextField user = new TextField();
		TextField pass = new PasswordField();

		
		// The Labels
		Text userLabel = new Text();
		userLabel.setText("Username");
		Text passLabel = new Text();
		passLabel.setText("Password");
		
		// The layout
		GridPane root = new GridPane();
		root.setAlignment(Pos.CENTER);
		root.setHgap(10);
		root.setVgap(10);
		root.add(userLabel, 0, 0);
		root.add(user, 1, 0);
		root.add(passLabel, 0, 1);
		root.add(pass, 1, 1);
		root.add(btn, 0, 2);
		
		// Finally put it on the screen
		Scene scene = new Scene(root, 300, 250);
		primaryStage.setTitle("Log in");
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
