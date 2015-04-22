package application;

import java.util.ArrayList;

import cst316.Company;
import cst316.Player;
import cst316.Product;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class FirstCompanyController extends AnchorPane {
	@FXML
	private TextField compInput;
	
	private Main application;
	private String playerName;

	public void setApp(Main app) {
        application = app;
        
    }
	
	public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
	
	// Event Listener on Button.onMouseClicked
	@FXML
	public void doneClicked(MouseEvent event) {
		Player player = new Player(0, 100.0, playerName, new ArrayList<String>());
		player.addCompanies(new Company(compInput.getText()));
        application.setPlayer(player);
        CreatePlayerController ctr;
		try {
			ctr = (CreatePlayerController) application.replaceSceneContent("CreatePlayer.fxml", null);
			ctr.setApp(application);
			ctr.setCompanyName(compInput.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
