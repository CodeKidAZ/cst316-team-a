package application;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import cst316.Player;

/**
 * This class is meant to allow the user to buy a new product for their company
 * Implementation is not yet here since it depends on having a company.class
 * that does not yet exist. Essentially this is a UI shell.
 * 
 * @author daniel
 */

public class ProductManagementController extends AnchorPane  {
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
	@FXML
	private ImageView returnButton;
	@FXML
	private ImageView purchaseButton;
	@FXML
	private TextArea descriptionField;
	@FXML
	private ComboBox<String> comboBox;
	@FXML 
	private TextArea activeProduct;

	Image retIn;
	Image retOut;
	Image purIn;
	Image purOut;

	private Player player;
	private Main application;
	InputStream in;	
	String output;
	
	public void setApp(Main app){
		application = app;
		in = this.getClass().getClassLoader().getResourceAsStream("res/return.png");
		retOut = new Image(in);
		in = this.getClass().getClassLoader().getResourceAsStream("res/return_highlight.png");
		retIn = new Image(in);
		in = this.getClass().getClassLoader().getResourceAsStream("res/purchase.png");
		purOut = new Image(in);
		in = this.getClass().getClassLoader().getResourceAsStream("res/purchase_highlight.png");
		purIn = new Image(in);
		comboBox.getItems().setAll("Cellphone Product",
				"Houseware Product",
				"Movie Development",
				"Vehical Product",
				"Software Application");
		this.player = application.getPlayer();
	}	
	

	@FXML
	public void returnMouseClicked(MouseEvent event) throws Exception {
		HRController ctr = (HRController) application.replaceSceneContent("HR.fxml", HRController.class);
		ctr.setApp(application);
	}

	@FXML
	public void returnMouseEntered(MouseEvent event) {
		if (returnButton != null) {
			returnButton.setImage(retIn);
		}
	}

	@FXML
	public void returnMouseExited(MouseEvent event) {
		if (returnButton != null) {
			returnButton.setImage(retOut);
		}
	}

	@FXML
	public void purchaseMouseClicked(MouseEvent event) {
		// TODO Make the player's company gain this as their new product
	}

	@FXML
	public void purchaseMouseEntered(MouseEvent event) {
		if (purchaseButton != null) {
			purchaseButton.setImage(purIn);
		}
	}

	@FXML
	public void purchaseMouseExited(MouseEvent event) {
		if (purchaseButton != null) {
			purchaseButton.setImage(purOut);
		}
	}
	
	@FXML
	public void comboBoxMouseClicked(ActionEvent event) { 
		output = (String) comboBox.getSelectionModel().getSelectedItem().toString();
		switch(output) {
		case "Cellphone Product": 
			descriptionField.clear();
			descriptionField.appendText("Cost: 5 Employees \n");
			descriptionField.appendText("Production Time: 10 days \n");
			descriptionField.appendText("Potential Profit: 1000$ \n");
			descriptionField.appendText("Risk: 80% chance for success \n");
			descriptionField.appendText("Description: Cell phones are huge in the market right now, try to cash in on this new technology. \n");
			break;
		case "Houseware Product": 
			descriptionField.clear();
			descriptionField.appendText("Cost: 4 Employees \n");
			descriptionField.appendText("Production Time: 7 days \n");
			descriptionField.appendText("Potential Profit: 700$ \n");
			descriptionField.appendText("Risk: 90% chance for success \n");
			descriptionField.appendText("Description: Everyone needs house wares. Not a big reward investment, but also not a big risk. Safe product. \n");
			break;
		case "Movie Development": 
			descriptionField.clear();
			descriptionField.appendText("Cost: 10 Employees \n");
			descriptionField.appendText("Production Time: 20 days \n");
			descriptionField.appendText("Potential Profit: 3000$ \n");
			descriptionField.appendText("Risk: 50% chance for success \n");
			descriptionField.appendText("Description: Everyone loves movies, but not everyne loves ALL movies. This is a high risk high reward investment. \n");
			break;
		case "Vehical Product": 
			descriptionField.clear();
			descriptionField.appendText("Cost: 8 Employees \n");
			descriptionField.appendText("Production Time: 25 days \n");
			descriptionField.appendText("Potential Profit: 2000$ \n");
			descriptionField.appendText("Risk: 70% chance for success \n");
			descriptionField.appendText("Description: Cars are a stable product to invest in since everyone needs them, however you still have to put effort into making them worth buying. Mid range investment risk. \n");
			break;
		case "Software Application": 
			descriptionField.clear();
			descriptionField.appendText("Cost: 4 Employees \n"); 
			descriptionField.appendText("Production Time: 15 days \n");
			descriptionField.appendText("Potential Profit: 1500$ \n");
			descriptionField.appendText("Risk: 75% chance for success \n");
			descriptionField.appendText("Description: Software teams are small in your business so applications dont require many employees. Decent chance for success and good net profit. \n");
			break;
		}
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
}
