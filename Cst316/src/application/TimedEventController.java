package application;

import java.util.Random;

import cst316.Investment;
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
/**
 * TimedEvent FXML Controller class
 *
 * @author Derek Hamel
 */
public class TimedEventController extends AnchorPane implements EventHandler<WorkerStateEvent>{
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
	private boolean good;
	private String name;
	Task<Void> timer;
	public enum Wait{
		NULL,NONE,SHORT,LONG,LONGER
	};


	public void setApp(Main app, Scene scene){
		// Always 15 seconds
		this.timeMax = 15000;
		
		if(app == null){
			System.out.println("app null");
		}
		if(app.getStage() == null){
			System.out.println("stage null");
		}
		
		String[] rnd = Investment.getTimedInvestment();
		name = rnd[0];
		good = rnd[1].equals("0");
		hintOne.setText(rnd[2]);
		hintTwo.setText(rnd[3]);
		hintThree.setText(rnd[4]);
		hintFour.setText(rnd[5]);
		timeLabel.setText(timeMax/1000 + " Seconds");
		wait = Wait.NONE;
		this.app = app;
		this.prevScene = scene;
		try{
			timer = new Task<Void>(){
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
			timer.cancel();
			ctr = (TimedInvestmentController) app.replaceSceneContent("TimedInvestment.fxml", TimedInvestmentController.class);
			ctr.setApp(app, prevScene, wait, good, name);
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
			ignoreClicked(null);
		}

	}
}
