package application;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.TextArea;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import cst316.Player;

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


	private Player player;
	private Main application;
	InputStream in;
	
	public void setApp(Main app){
		application = app;
		this.player = application.getPlayer();
	}	
	public void setPlayer(Player player) {
		this.player = player;
	}
	public void onReturnMouseClick(MouseEvent event) {

	}
	public void onReturnMouseEnter(MouseEvent event) {

	}
	public void onReturnMouseExit(MouseEvent event) {

	}
}
