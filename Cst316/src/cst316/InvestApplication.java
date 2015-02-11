package cst316;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


//Eclipse Git push test1
public final class InvestApplication extends Application {

	/**
	 * @param primaryStage
	 */
	public void start(Stage primaryStage) {
		
		// The selection box
		ComboBox<String> box = new ComboBox<String>();
		box.getItems().addAll("SOIL", "GOGL", "RDHT", "MSFT");
		
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
		TextField txt = new TextField();
		
		// The Labels
		Text boxLabel = new Text();
		boxLabel.setText("Company");
		Text txtLabel = new Text();
		txtLabel.setText("Amount");
		
		// The layout
		GridPane root = new GridPane();
		root.setAlignment(Pos.CENTER);
		root.setHgap(10);
		root.setVgap(10);
		root.add(boxLabel, 0, 0);
		root.add(box, 1, 0);
		root.add(txtLabel, 0, 1);
		root.add(txt, 1, 1);
		root.add(btn, 0, 2);
		
		// Finally put it on the screen
		Scene scene = new Scene(root, 300, 250);
		primaryStage.setTitle("Invest in a company");
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
