package service;

import java.util.ArrayList;

import cst316.Investment;
import cst316.Player;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import application.Main;

public class InvestmentService extends Service<Void> implements EventHandler<WorkerStateEvent>{
	private Main app;

	private InvestmentService(Main app){
		this.app = app;
		this.setOnSucceeded(this);
		this.start();
	}
	
	// This posts to the UI thread whatever should be seen by the user when timers expire
	@Override
    public void handle(WorkerStateEvent t) {
		if(app!=null){
			Player player = app.getPlayer();

			try {
				ArrayList<Investment> inv = player.getInvestments();
				for(int x = 0; x< inv.size(); x++){
					inv.get(x).calculateROI();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			new InvestmentService(app);
		}
    }

	public static void createNewInstance(Main app){
		new InvestmentService(app);
	}
	
	// This occurs off of the main UI thread and is where any timing should take place
	@Override
    protected Task<Void> createTask() {
		return new Task<Void>(){
			@Override
			protected Void call() throws Exception {
				int minute = 60000;
				Thread.sleep(minute);
				return null;
			}
		};
	}

}
