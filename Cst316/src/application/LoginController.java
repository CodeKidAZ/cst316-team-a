package application;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

public class LoginController extends AnchorPane{
	@FXML 
	private ResourceBundle resources;
	@FXML 
	private URL location;
	@FXML
	Button continueBtn;

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
				    LandingController ctr = (LandingController) application.replaceSceneContent("landing.fxml", LandingController.class);
				    ctr.setApp(application);
				} catch (Exception e) {
					throw new Error(e);
				}
			}
		});
	}


}
