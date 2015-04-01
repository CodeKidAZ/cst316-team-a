package application;

import java.util.Random;

import cst316.Player;
import cst316.SurpriseEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.input.MouseEvent;

public class SurpriseEventController extends AnchorPane{
	@FXML
	private AnchorPane AnchorPane;
	@FXML
	private TextArea textBox;
	@FXML
	private Button acceptButton;
	
	private Main app;
	private Scene prevScene;
	private Player player;
	private SurpriseEvent event;

	// Event Listener on Button[#acceptButton].onMouseClicked
	@FXML
	public void acceptButtonFired(MouseEvent event) {
		// apply changes from random even here
		app.getStage().setScene(prevScene);
	}
	
	public void setApp(Main app, Scene prevScene) {
		this.app = app;
		this.player = app.getPlayer();
		this.prevScene = prevScene;
		int whichEvent = genRandNum(5, 1);
		int multiplier = genRandNum(3, 1);
		event = new SurpriseEvent();
		event.createEvent(whichEvent, multiplier);
		textBox.appendText(event.getEventTxt());
	}
	
	/**
	 * Basic random number generator in a range
	 * @param max
	 * @param min
	 * @return
	 */
	public int genRandNum(int max, int min) {
		Random rand = new Random();
		return rand.nextInt((max - min) + 1) + min;
	}
}
