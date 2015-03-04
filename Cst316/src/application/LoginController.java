package application;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import cst316.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
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
	ToggleGroup playerToggleGroup;

	private Main application;
	InputStream in;
	Image invIn;
	Image invOut;

	public void setApp(Main app){
		application = app;
	}

	@FXML
	void initialize(){
        continueBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					Player player = new Player();
					RadioButton toggle = (RadioButton) playerToggleGroup.getSelectedToggle();
					boolean exists = player.readFile(toggle.getText());
					if (exists) {
						LandingController ctr = (LandingController) application.replaceSceneContent("Landing.fxml", LandingController.class);
						ctr.setApp(application);
						ctr.setPlayer(player);
					} else {
						VideoController ctr = (VideoController) application.replaceSceneContent("video.fxml", VideoController.class);
						ctr.setApp(application, toggle.getText());
					}
				} catch (Exception e) {
					throw new Error(e);
				}
			}
		});
	}


}
