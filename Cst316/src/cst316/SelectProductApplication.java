package cst316;

//hi this is wesley test
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public final class SelectProductApplication extends Application {

	/**
	 * @param primaryStage
	 */
	public void start(Stage primaryStage) {
		
		// The selection box
		ComboBox<String> box = new ComboBox<String>();
		box.getItems().addAll("Food", "Clothing", "Bread", "Eggs", "Milk", "Squick");
		
		// The Next button
		Button btn = new Button();
		btn.setText("Next");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Clicked Next");
			}
		});
		
		// The layout
		GridPane root = new GridPane();
		root.setAlignment(Pos.CENTER);
		root.setHgap(10);
		root.setVgap(10);
		root.add(box, 0, 0);
		root.add(btn, 0, 1);
		
		// Finally put it on the screen
		Scene scene = new Scene(root, 300, 250);
		primaryStage.setTitle("Select a product");
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
