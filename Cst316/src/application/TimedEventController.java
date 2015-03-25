package application;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class TimedEventController extends AnchorPane implements EventHandler<WorkerStateEvent>{
	@FXML
	private AnchorPane AnchorPane;
	@FXML
	private ProgressBar timeProgress;
	@FXML
	private Label timeLabel;
	@FXML
	private Label hintOne;
	@FXML
	private Label hintTwo;
	@FXML
	private Label hintThree;
	@FXML
	private Label hintFour;
	@FXML
	private Button invBtn;
	@FXML
	private Button ignBtn;

	private Main app;
	private int timeMax;
	private Wait wait;
	private Scene prevScene;
	public enum Wait{
		NULL,NONE,SHORT,LONG,LONGER
	};


	public void setApp(Main app, Scene scene){
		// SET TIMER HERE
		this.timeMax = 15000;

		wait = Wait.NONE;
		timeLabel.setText(timeMax/1000 + " Seconds");
		this.app = app;
		this.prevScene = scene;
		try{
			Task<Void> timer = new Task<Void>(){
				@Override
				protected Void call() throws Exception {
					long start = System.currentTimeMillis();
					while(System.currentTimeMillis() - start < timeMax){
						updateProgress(timeMax - (System.currentTimeMillis()-start),timeMax);
					}
					return null;
				}

			};
			timer.setOnSucceeded(this);
			timer.progressProperty().addListener((obs, oldProgress, newProgress) -> 
		    	updateTime(newProgress.doubleValue()));
			new Thread(timer).start();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@FXML
	void initialize(){

	}

	// Event Listener on Button[#invBtn].onMouseClicked
	@FXML
	public void investClicked(MouseEvent event) {
		TimedInvestmentController ctr;
		try {
			ctr = (TimedInvestmentController) app.replaceSceneContent("TimedInvestment.fxml", TimedInvestmentController.class);
			ctr.setApp(app, prevScene, wait);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// Event Listener on Button[#ignBtn].onMouseClicked
	@FXML
	public void ignoreClicked(MouseEvent event) {
		wait = Wait.NULL;
		app.getStage().setScene(prevScene);
	}

	public void updateTime(double diff){
		if(diff > .75){
			wait = Wait.NONE;
		}else if(diff > .5){
			wait = Wait.SHORT;
			hintTwo.setOpacity(1);
		}else if(diff > .25){
			wait = Wait.LONG;
			hintThree.setOpacity(1);
		}else if(diff > 0){
			wait = Wait.LONGER;
			hintFour.setOpacity(1);
		}else{
			ignoreClicked(null);
		}
		timeLabel.setText((int)(timeMax/1000*diff) + " Seconds");
		timeProgress.setProgress(diff);
	}


	@Override
	public void handle(WorkerStateEvent event) {
		if(event.getEventType() == WorkerStateEvent.WORKER_STATE_SUCCEEDED){
			updateTime(0);
		}

	}
}
