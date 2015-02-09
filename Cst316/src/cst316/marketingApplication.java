/**
 * 
 */
package cst316;

/**
 * @author Wesley Local
 *
 */

import java.util.ArrayList;
import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


//Eclipse Git push test1
public final class marketingApplication extends Application {

	/**
	 * @param primaryStage
	 */
	public void start(Stage primaryStage) {
		
		
		HBox hBox1 = addHBox();
		
		// The marketing type selection box
		ComboBox<String> box = new ComboBox<String>();
		box.getItems().addAll("Vouchers for free product", "Vouchers for 50% discount", "Print Advertising Campaign", "Television Advertising Campaign");
		
		// The marketing duration selection box
		ComboBox<String> box2 = new ComboBox<String>();
		box2.getItems().addAll("2 Weeks", "4 Weeks", "3 Months", "1 Year");
		
		// The Start Marketing button
		Button btn = new Button();
		btn.setText("Start Marketing Campaign");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Marketing Campaign Confirmed");
			}
		});
		
		// The Labels
		Text boxLabel = new Text();
		boxLabel.setText("Marketing Type");
		boxLabel.setStyle("-fx-background-color: #FF9933;");
		Text box2Label = new Text();
		box2Label.setText("Length of Time");
		box2Label.setStyle("-fx-background-color: #FF9933;");
		
		// The layout
		GridPane root = new GridPane();
		root.setAlignment(Pos.TOP_CENTER);
		root.setHgap(10);
		root.setVgap(10);
		root.add(hBox1, 0, 0);
		root.add(boxLabel, 0, 1);
		root.add(box, 1, 1);
		root.add(box2Label, 0, 2);
		root.add(box2, 1, 2);
		root.add(btn, 0, 3);
		
		// Put on Screen
		Scene scene = new Scene(root, 800, 235);
		scene.getStylesheets().add("http://www.public.asu.edu/~wcoomber/MarketingStyles.css");
		primaryStage.setTitle("Marketing");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	//This function creates an orange HBox that contains a VBox and communicates to the 
	//User the status of current marketing campaigns
	public HBox addHBox() {
	    HBox hbox = new HBox();
	    hbox.setPadding(new Insets(15, 12, 15, 12));
	    hbox.setSpacing(10);
	    hbox.setStyle("-fx-background-color: #FF9933;");

		Text currentLabel = new Text();
		currentLabel.setText("Marketing Campaigns in operation:");
	    
		VBox vBox1 = addVBox();
	    hbox.getChildren().addAll(currentLabel,vBox1);

	    return hbox;
	}
	
	//This function creates a VBox to list out all currently running marketing campaigns
	//I am still working on getting it to properly space and margin a list of strings.
	public VBox addVBox() {
	    VBox vbox1 = new VBox();
	    vbox1.setPadding(new Insets(15, 12, 15, 12));
	    vbox1.setSpacing(10);
	    vbox1.setStyle("-fx-background-color: #FF9933;");
	    	    
	    Text curMarketing = new Text("50% Discount Voucher for 2 Weeks");
	    curMarketing.setFont(Font.font ("Arial", 12));
	    curMarketing.setFill(Color.BLUE);
	    
	    Text cur2Marketing = new Text("Television Advertising for 3 Months");
	    cur2Marketing.setFont(Font.font ("Arial", 12));
	    cur2Marketing.setFill(Color.DARKSLATEBLUE);
	    
	    /* WiP stuff (displaying an Array of Strings of the names of current Marketing Campaigns
	    	    ArrayList<String> list = new ArrayList<String>();
	    list.add("50% Discount Voucher for 2 Weeks");
	    list.add("50% Discount Voucher for 4 Weeks");
	    
	    String[] listArr = new String[list.size()];
	    listArr = list.toArray(listArr);
	    
		for (int i=0; i<1; i++) {
			vbox1.setMargin(curMarketing, new Insets(0, 0, 0, 8));
			vbox1.getChildren().add(curMarketing);
			
	    }
    
    	    */
	    
	VBox.setMargin(curMarketing, new Insets(0, 0, 0, 8));
	vbox1.getChildren().add(curMarketing);
	
	VBox.setMargin(cur2Marketing, new Insets(0, 0, 0, 8));
	vbox1.getChildren().add(cur2Marketing);

	    return vbox1;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);

	}

}

