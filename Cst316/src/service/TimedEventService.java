package service;

import java.util.Random;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import application.Main;
import application.TimedEventController;

public class TimedEventService extends Service<Void> implements EventHandler<WorkerStateEvent>{
	private Main app;
	private boolean a;
	
	private TimedEventService(Main app){
		this.app = app;
		this.setOnSucceeded(this);
		this.start();
	}
	
	// This posts to the UI thread whatever should be seen by the user when timers expire
	@Override
    public void handle(WorkerStateEvent t) {
		if(app!=null){
			Stage stage = app.getStage();
			Scene scene = stage.getScene(); // This is a copy of what the user was doing before

			try {
				TimedEventController ctr = 
						(TimedEventController)app.replaceSceneContent("TimedEvent.fxml", 
								TimedEventController.class);
				ctr.setApp(app, scene);
			} catch (Exception e) {
				e.printStackTrace();
			}
			new TimedEventService(app);
		}
    }

	public static void createNewInstance(Main app){
		new TimedEventService(app);
	}
	
	// This occurs off of the main UI thread and is where any timing should take place
	@Override
    protected Task<Void> createTask() {
		return new Task<Void>(){

			@Override
			protected Void call() throws Exception {
				int minute = 60000;
				Random rand = new Random();
				int time = rand.nextInt(7*minute)+3*minute;
				//System.out.println(time/minute + "minutes");
				Thread.sleep(time);
				return null;
			}
		
		};
	}

}
