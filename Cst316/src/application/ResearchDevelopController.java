package application;

import java.net.URL;
import java.util.ResourceBundle;

import cst316.Player;
import cst316.ResearchAndDevelopment;
import cst316.ResearchDevelObject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class ResearchDevelopController extends AnchorPane {
	@FXML 
	private ResourceBundle resources;
	@FXML 
	private URL location;
	@FXML
	private ImageView returnButton;
	@FXML
	private TextArea descriptionBox;
	@FXML
	private ComboBox<String> researchChoiceBox;
	@FXML
	private ImageView pictureBox;
	@FXML
	private ComboBox<String> devChoiceBox;
	@FXML
	private ImageView purchaseButton;
	
	ResearchAndDevelopment rD = new ResearchAndDevelopment();
	ResearchDevelObject current = new ResearchDevelObject();
	String outputDev;
	String outputResearch;
	Player player;
	Main application;
	
	// Event Listener on ImageView[#returnButton].onMouseClicked
	@FXML
	public void returnMouseFired(MouseEvent event) throws Exception {
		LandingController ctr = (LandingController) application.replaceSceneContent("Landing.fxml", LandingController.class);
		ctr.setApp(application);
		ctr.setPlayer(player);
	}
	// Event Listener on ImageView[#returnButton].onMouseEntered
	@FXML
	public void returnMouseEnter(MouseEvent event) {
		Image image = new Image(this.getClass().getClassLoader().getResourceAsStream("res/return_highlight.png"));
		returnButton.setImage(image);
	}
	// Event Listener on ImageView[#returnButton].onMouseExited
	@FXML
	public void returnMouseExit(MouseEvent event) {
		Image image = new Image(this.getClass().getClassLoader().getResourceAsStream("res/return.png"));
		returnButton.setImage(image);
	}
	// Event Listener on ComboBox[#researchChoiceBox].onAction
	@FXML
	public void researchChoiceButtonFired(ActionEvent event) {
		Image image = new Image(this.getClass().getClassLoader().getResourceAsStream("res/research_logo.png"));
		pictureBox.setImage(image);
		outputResearch = (String) researchChoiceBox.getSelectionModel().getSelectedItem().toString();
		switch(outputResearch) {
		case "Research new materials": 
			descriptionBox.clear();
			descriptionBox.appendText("Cost: 5 Employees \n");
			descriptionBox.appendText("Description: Researches new materials for "
					+ "your products so that they are more "
					+ "reliable an aesthetically appealing");
			current = rD.getResDevObjsElement("materials");
			break;
		case "Research new media trends": 
			descriptionBox.clear();
			descriptionBox.appendText("Cost: 10 Employees \n");
			descriptionBox.appendText("Description: Researches what is currently "
					+ "trending and in style so that your products a"
					+ "ren't seen as 'old fashioned' or unappealing especially "
					+ "to the younger demographics");
			current = rD.getResDevObjsElement("mediaTrends");
			break;
		case "Research new technology": 
			descriptionBox.clear();
			descriptionBox.appendText("Cost: 15 Employees \n");
			descriptionBox.appendText("Description: Researches newer and faster "
					+ "technologies for your products so that it is overall more "
					+ "effective and responsive to the end users.");
			current = rD.getResDevObjsElement("technology");
			break;
		case "Research new strategies": 
			descriptionBox.clear();
			descriptionBox.appendText("Cost: 20 Employees \n");
			descriptionBox.appendText("Description: Researches new strategies for "
					+ "the employees so that they can work in a more efficient manner "
					+ "and achieve more with less time.");
			current = rD.getResDevObjsElement("strategies");
			break;
		}
	}
	// Event Listener on ComboBox[#devChoiceBox].onAction
	@FXML
	public void devChoiceButtonFired(ActionEvent event) {
		Image image = new Image(this.getClass().getClassLoader().getResourceAsStream("res/development_logo.png"));
		pictureBox.setImage(image);
		outputDev = (String) devChoiceBox.getSelectionModel().getSelectedItem().toString();
		switch(outputDev) {
		case "Develop a commercial":
			descriptionBox.clear();
			descriptionBox.appendText("Cost: 25 Employees \n");
			descriptionBox.appendText("Description: Develops a commercial that "
					+ "advertises your product and allows for more people to be aware of it.");
			current = rD.getResDevObjsElement("commercial");
		break;
		case "Develop a science lab":
			descriptionBox.clear();
			descriptionBox.appendText("Cost: 30 Employees \n");
			descriptionBox.appendText("Description: Develop a science lab that "
					+ "increases the quality of all research that the company has invested in.");
			current = rD.getResDevObjsElement("scienceLab");
		break;
		}
	}
	// Event Listener on ImageView[#purchaseButton].onMouseClicked
	@FXML
	public void purchaseButtonFired(MouseEvent event) {
		//Check to see if player has enough employees for the 'purchase'
		//If they do, add to their assets and increase their point value associated with asset
		if(current != null) {
			if(rD.getPlayer().getEmployees() >= current.getCost()) {
				rD.getPlayer().addAsset(current.getName());
				rD.getPlayer().addPoints(current.getPointWorth());
				rD.getPlayer().addEmployees(-(current.getCost())); //Subtract employee # by cost
			}
		}
	}
	// Event Listener on ImageView[#purchaseButton].onMouseEntered
	@FXML
	public void purchaseEnter(MouseEvent event) {
		Image image = new Image(this.getClass().getClassLoader().getResourceAsStream("res/purchase_highlight.png"));
		purchaseButton.setImage(image);
	}
	// Event Listener on ImageView[#purchaseButton].onMouseExited
	@FXML
	public void purchaseExit(MouseEvent event) {
		Image image = new Image(this.getClass().getClassLoader().getResourceAsStream("res/purchase.png"));
		purchaseButton.setImage(image);
	}
	
	public void setApp(Main app) {
		application = app;
		researchChoiceBox.getItems().setAll("Research new materials",
											"Research new media trends",
											"Research new technology",
											"Research new strategies");
		devChoiceBox.getItems().setAll("Develop a commercial",
									   "Develop a science lab");
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
}
