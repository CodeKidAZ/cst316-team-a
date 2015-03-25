
package cst316;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class SurpriseEventController implements Initializable {
	SurpriseEvent event = new SurpriseEvent();
	@FXML
	private TextArea textBox;
	@FXML
	private Button acceptButton;
	// Event Listener on Button[#acceptButton].onAction
	@FXML
	public void acceptButtonFired(ActionEvent event) {
		Platform.exit();
	}
	public SurpriseEventController() { }
	/**
	 * Calling class should use this constructor
	 * Allows the player class to feel the changes of the event using pointers.
	 * @param event
	 */
	public SurpriseEventController(SurpriseEvent event) {
		this.event = event;
	}
	/**
	 * Performs the event and displays it which event occurred in the UI
	 */
	@Override
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		int whichEvent = genRandNum(5, 1);
		int multiplier = genRandNum(3, 1);
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
