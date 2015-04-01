package application;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import service.TimedEventService;
import cst316.Player;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

public class LoginController extends AnchorPane{
	@FXML
	Button continueBtn;
	@FXML
	ComboBox<String> playerNameText;

	private Main application;
	InputStream in;
	Image invIn;
	Image invOut;
                Main a;
        
    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private Group theBox;

	public void setApp(Main app){
		application = app;
               
	}
	
	@FXML
	void continueBtnClicked() throws Exception {
		Player player = new Player();
		String playerName = playerNameText.getValue().toString();
		boolean exists = player.readFile(playerName);
		TimedEventService.createNewInstance(application);
		if (exists) {
			LandingController ctr = (LandingController) application.replaceSceneContent("Landing.fxml", LandingController.class);
			ctr.setApp(application);
			application.setPlayer(player);
		} else {
			VideoController ctr = (VideoController) application.replaceSceneContent("Video.fxml", VideoController.class);
			ctr.setApp(application, playerName);
		}
	}

	@FXML
	void initialize(){
		playerNameText.getItems().addAll(Player.getAvailablePlayers());
                 theBox.setLayoutX(500);
                 theBox.setLayoutY(500);
	}


}
