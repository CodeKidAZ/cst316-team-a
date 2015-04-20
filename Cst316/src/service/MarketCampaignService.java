package service;

import java.util.Random;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import application.Main;
import application.SurpriseEventController;
import application.TimedEventController;

public class MarketCampaignService extends Service<Void> implements EventHandler<WorkerStateEvent>{
	private Main app;
	
	private MarketCampaignService(Main app){
		this.app = app;
		this.setOnSucceeded(this);
		this.start();
	}
	
	// This posts to the UI thread whatever should be seen by the user when timers expire
	@Override
    public void handle(WorkerStateEvent t) {
		/*if(app!=null){
			Stage stage = app.getStage();
			Scene scene = stage.getScene(); // This is a copy of what the user was doing before

			try {
				// TODO : investment vs. Surprise event
				if(Math.random()>=.5){
				TimedEventController ctr = 
						(TimedEventController)app.replaceSceneContent("TimedEvent.fxml", 
								TimedEventController.class);
				ctr.setApp(app, scene);
				}else{
					SurpriseEventController ctr = 
						(SurpriseEventController)app.replaceSceneContent("SurpriseEvent.fxml", 
									SurpriseEventController.class);
					ctr.setApp(app, scene);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			new MarketCampaignService(app);
			
		}*/
		
    }

	public static void createNewInstance(Main app){
		new MarketCampaignService(app);
	}
	
	// This occurs off of the main UI thread and is where any timing should take place
	@Override
    protected Task<Void> createTask() {
		return new Task<Void>(){

			@Override
			protected Void call() throws Exception {
				int minute = 60000;
				int time = 5*minute;
				//System.out.println(time/minute + "minutes");
				Thread.sleep(time);
				return null;
			}
		
		};
	}

}
