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
import cst316.Company;
import cst316.Player;
import cst316.Product;

/**
 * This class is meant to allow the user to buy a new product for their company
 * and see what products are with which existing companies.
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
	private ImageView successImage;
	@FXML
	private TextArea descriptionField;
	@FXML
	private ComboBox<String> comboBox;
	@FXML
	private ComboBox<String> cComboBox;
	@FXML 
	private TextArea activeProduct;

	Image retIn;
	Image retOut;
	Image purIn;
	Image purOut;
	
	private String cComboBoxOutput, comboBoxOutput;
	private Company selectedCompany;
	private Product selectedProduct;
	private Player player;
	private Main application;
	private InputStream in;	
	
	/**
	 * Sets up images and selection options for the menus
	 * @param app
	 */
	public void setApp(Main app){
		application = app;
		this.player = application.getPlayer();
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
		for(int i = 0; i<player.getCompanyList().size(); i++) {
			cComboBox.getItems().add(player.getCompanyList().get(i).getCompanyName());
		}
	}	
	

	@FXML
	public void returnMouseClicked(MouseEvent event) throws Exception {
		HRController ctr = (HRController) application.replaceSceneContent("HR.fxml", null);
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
	/**
	 * Add the product to your company
	 * Subtract employees from your company and then save progress
	 * and update the stat box.
	 * @param event
	 */
	@FXML
	public void purchaseMouseClicked(MouseEvent event) {
		selectedCompany.addProducts(selectedProduct);
		selectedCompany.addEmployees(-selectedProduct.getTotalFixedCost());
		player.saveFile();
		setupProductStats( );
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
	
	/**
	 * Populates the description box based on what was clicked last.
	 * @param event
	 */
	@FXML
	public void comboBoxMouseClicked(ActionEvent event) { 
		comboBoxOutput = (String) comboBox.getSelectionModel().getSelectedItem().toString();
		switch(comboBoxOutput) {
		case "Cellphone Product": 
			selectedProduct = new Product("Cell Phone",5);
			descriptionField.clear();
			descriptionField.appendText("Cost: 5 Employees \n");
			descriptionField.appendText("Potential Profit: 1000$ \n");
			descriptionField.appendText("Risk: 80% chance for success \n");
			descriptionField.appendText("Description: Cell phones are huge in the market right now, try to cash in on this new technology. \n");
			break;
		case "Houseware Product": 
			selectedProduct = new Product("House Wares",4);
			descriptionField.clear();
			descriptionField.appendText("Cost: 4 Employees \n");
			descriptionField.appendText("Potential Profit: 700$ \n");
			descriptionField.appendText("Risk: 90% chance for success \n");
			descriptionField.appendText("Description: Everyone needs house wares. Not a big reward investment, but also not a big risk. Safe product. \n");
			break;
		case "Movie Development": 
			selectedProduct = new Product("Movies",10);
			descriptionField.clear();
			descriptionField.appendText("Cost: 10 Employees \n");
			descriptionField.appendText("Potential Profit: 3000$ \n");
			descriptionField.appendText("Risk: 50% chance for success \n");
			descriptionField.appendText("Description: Everyone loves movies, but not everyne loves ALL movies. This is a high risk high reward investment. \n");
			break;
		case "Vehical Product": 
			selectedProduct = new Product("Vehical",7);
			descriptionField.clear();
			descriptionField.appendText("Cost: 7 Employees \n");
			descriptionField.appendText("Potential Profit: 2000$ \n");
			descriptionField.appendText("Risk: 70% chance for success \n");
			descriptionField.appendText("Description: Cars are a stable product to invest in since everyone needs them, however you still have to put effort into making them worth buying. Mid range investment risk. \n");
			break;
		case "Software Application": 
			selectedProduct = new Product("Software",4);
			descriptionField.clear();
			descriptionField.appendText("Cost: 4 Employees \n"); 
			descriptionField.appendText("Potential Profit: 1500$ \n");
			descriptionField.appendText("Risk: 70% chance for success \n");
			descriptionField.appendText("Description: Software teams are small in your business so applications dont require many employees. Decent chance for success and good net profit. \n");
			break;
		}
	}
	
	/**
	 * Handles the Company combo box clicks
	 * @param event
	 */
	@FXML
	public void cComboBoxMouseClicked(ActionEvent event) {
		cComboBoxOutput = (String) cComboBox.getSelectionModel().getSelectedItem().toString();
		selectedCompany = player.getCompany(cComboBoxOutput);
		setupProductStats( );
	}
	
	/**
	 * Updates the product stats based on what the company the player
	 * has currently selected.
	 */
	public void setupProductStats( ) {
		activeProduct.clear();
		activeProduct.appendText("Company: " + selectedCompany.getCompanyName()+"\n");
		if(selectedCompany.getProducts() != null) {
			for(int i = 0; i<selectedCompany.getProducts().size(); i++) {
				activeProduct.appendText(selectedCompany.getProducts().get(i).getName()+"\n");
			}
		}
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
}
