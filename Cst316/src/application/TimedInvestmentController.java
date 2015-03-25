package application;

import cst316.Player;
import application.TimedEventController.Wait;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.KeyEvent;

public class TimedInvestmentController extends AnchorPane{
	@FXML
	private AnchorPane AnchorPane;
	@FXML
	private Label moneyLbl;
	@FXML
	private TextField investInput;
	@FXML
	private Button offerBtn;

	private Main app;
	private Scene prevScene;
	private Wait wait;
	private Player player;
	
	public void setApp(Main app, Scene scene, Wait wait){
		this.app = app;
		this.prevScene = scene;
		this.wait = wait;
		player = app.getPlayer();
	}
	
	// Event Listener on TextField[#investInput].onKeyTyped
	@FXML
	public void investOnkey(KeyEvent event) {
		
	}
	// Event Listener on Button[#offerBtn].onMouseClicked
	@FXML
	public void onOfferClicked(MouseEvent event) {
		app.getStage().setScene(prevScene);
	}
}
