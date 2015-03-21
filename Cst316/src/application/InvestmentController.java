package application;

import java.io.InputStream;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import cst316.Investment;
import cst316.Player;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

public class InvestmentController extends AnchorPane{
	@FXML 
	private ResourceBundle resources;
	@FXML 
	private URL location;
	@FXML
	Button continueBtn;
	@FXML
	ComboBox<String> companyCombo;
	@FXML
	TextField amountText;
	
	private Player player;

	private Main application;
	InputStream in;
	Image invIn;
	Image invOut;

	public void setApp(Main app){
		application = app;
		String[] allCompanyNames = Investment.getAllCompanyNames();
		ObservableList<String> items = companyCombo.getItems();
		for (String name : allCompanyNames) {
			items.add(name);
		}
		companyCombo.setItems(items);
		this.player = application.getPlayer();
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public void onContinueClick() throws Exception {
		String companyName = companyCombo.getValue().toString();
		double amount = Double.parseDouble(amountText.getText());
		Random random = new Random();
		Investment investment = new Investment(companyName, amount, random.nextBoolean());
		LandingController ctr = (LandingController) application.replaceSceneContent("Landing.fxml", LandingController.class);
		player.addInvestment(investment);
		ctr.setApp(application);	
	}
	
	public void onCancelClick() throws Exception {
		LandingController ctr = (LandingController) application.replaceSceneContent("Landing.fxml", LandingController.class);
		ctr.setApp(application);	
	}

}
