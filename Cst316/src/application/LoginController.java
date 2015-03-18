package application;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import cst316.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

public class LoginController extends AnchorPane{
	@FXML 
	private ResourceBundle resources;
	@FXML 
	private URL location;
	@FXML
	Button continueBtn;
	@FXML
	TextField playerNameText;

	private Main application;
	InputStream in;
	Image invIn;
	Image invOut;

	public void setApp(Main app){
		application = app;
	}
	
	@FXML
	void continueBtnClicked() throws Exception {
		Player player = new Player();
		String playerName = playerNameText.getText();
		boolean exists = player.readFile(playerName);
		if (exists) {
			LandingController ctr = (LandingController) application.replaceSceneContent("Landing.fxml", LandingController.class);
			ctr.setApp(application);
			ctr.setPlayer(player);
		} else {
			VideoController ctr = (VideoController) application.replaceSceneContent("Video.fxml", VideoController.class);
			ctr.setApp(application, playerName);
		}
	}

	@FXML
	void initialize(){
		// This function intentionally left blank
	}


}
