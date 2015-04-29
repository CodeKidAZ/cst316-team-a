package application;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import cst316.Player;
import cst316.Investment;

public class PlayerStatusController extends AnchorPane {
	@FXML 
	private ResourceBundle resources;
	@FXML 
	private URL location;
	@FXML
	private AnchorPane anchorPane;
	@FXML
	private TextArea pointsText;
	@FXML
	private TextArea employeesText;
	@FXML
	private TextArea moneyText;
	@FXML
	private TextArea assetsText;
	@FXML
	private TextArea investmentsText;
	@FXML
	private TextArea productText;
	@FXML
	private ImageView returnBtn;
	
	Image retIn;
	Image retOut;

	private Player player;
	private Main application;
	InputStream in;
	
	public void setApp(Main app){
		application = app;
		in = this.getClass().getClassLoader().getResourceAsStream("res/return_highlight.png");
		retIn = new Image(in);
		in = this.getClass().getClassLoader().getResourceAsStream("res/return.png");
		retOut = new Image(in);
		this.player = application.getPlayer();
		if (player != null) {
			pointsText.appendText(player.getPoints()+"");
			employeesText.appendText(player.getEmployees()+"");
			moneyText.appendText(player.getMoney()+"");
			ArrayList<String> assets = player.getAssets();
			for (int i = 0; i < assets.size(); i++){
				assetsText.appendText(assets.get(i)+", ");
			}
			ArrayList<Investment> investment = player.getInvestments();
			for (int i = 0; i < investment.size(); i++) {
				investmentsText.appendText(investment.get(i).getName()+", ");
			}
		}
	}	
	public void onReturnMouseClick(MouseEvent event) throws Exception {
		LandingController ctr = (LandingController) application.replaceSceneContent("Landing.fxml", LandingController.class);
		ctr.setApp(application);
		//ctr.setPlayer(player);
	}
	public void onReturnMouseEnter(MouseEvent event) {
		if (returnBtn != null) {
			returnBtn.setImage(retIn);
		}
	}
	public void onReturnMouseExit(MouseEvent event) {
		if (returnBtn != null) {
			returnBtn.setImage(retOut);
		}
	}
}
