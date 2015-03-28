package application;

import cst316.Investment;
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
	@FXML
	private Button cancelBtn;

	private Main app;
	private Scene prevScene;
	private Wait wait;
	private Player player;
	private boolean good;
	private String name;

	public void setApp(Main app, Scene scene, Wait wait, boolean good, String name){
		this.app = app;
		this.prevScene = scene;
		this.wait = wait;
		player = app.getPlayer();
		moneyLbl.setText(Double.toString(player.getMoney()));
		this.name = name;
		this.good = good;
	}

	// Event Listener on TextField[#investInput].onKeyUp
	@FXML
	public void investOnkey(KeyEvent event) {
		try{
			Thread.sleep(50); // split second to catch up
			double input = Double.parseDouble(investInput.getText());
			if(player.getMoney()-input < 0){
				moneyLbl.setText("Not enough money!");
			}else{
				moneyLbl.setText(Double.toString((player.getMoney()-input)));
			}
		}catch(Exception e){
			moneyLbl.setText(Double.toString(player.getMoney()));
		}
	}
	// Event Listener on Button[#offerBtn].onMouseClicked
	@FXML
	public void onOfferClicked(MouseEvent event) {
		try{
			double input = Double.parseDouble(investInput.getText());
			Investment inv;
			switch(wait){
			case NONE:{
				inv = new Investment(name, input*4,good);
				player.addInvestment(inv);
				break;
			}
			case SHORT:{
				inv = new Investment(name, input*2,good);
				player.addInvestment(inv);
				break;
			}
			case LONG:{
				inv = new Investment(name, input,good);
				player.addInvestment(inv);
				break;
			}
			case LONGER:{
				inv = new Investment(name, input*.75,good);
				player.addInvestment(inv);
				break;
			}
			}
			app.getStage().setScene(prevScene);
		}catch(Exception e){}
	}
	
	// Event Listener on Button[#offerBtn].onMouseClicked
	@FXML
	public void onCancelClicked(MouseEvent event) {
		app.getStage().setScene(prevScene);
	}
		
}
