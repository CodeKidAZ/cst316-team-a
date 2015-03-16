package service;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import application.InvestmentController;
import application.LandingController;
import application.Main;

public class TimedEventService extends Service<Void> implements EventHandler<WorkerStateEvent>{
	private Main app;
	private boolean a;
	
	private TimedEventService(Main app, boolean a){
		this.app = app;
		this.a = a;
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
				if(a){
					System.out.println("changing");
					app.replaceSceneContent("Investment.fxml", InvestmentController.class);
					new TimedEventService(app, false);
				}else{
					System.out.println("changing back");
					app.replaceSceneContent("Landing.fxml", LandingController.class);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    }

	public static void createNewInstance(Main app, boolean a){
		new TimedEventService(app, a);
	}
	
	// This occurs off of the main UI thread and is where any timing should take place
	@Override
    protected Task<Void> createTask() {
		return new Task<Void>(){

			@Override
			protected Void call() throws Exception {
				Thread.sleep(2000);
				
				return null;
			}
		
		};
	}

}
