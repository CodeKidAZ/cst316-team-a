package application;

import java.nio.file.Paths;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class VideoController extends AnchorPane{
	@FXML
	MediaView vid;
	@FXML
	Button skipBtn;
	
	private String name;
	private Main app;
	private MediaPlayer player;
	private CreatePlayerController ctr;
	
	public void setApp(VideoApplication app){
		Media media = new Media(Paths.get("src/res/intro.mp4").toUri().toString());
		player = new MediaPlayer(media);
		vid.setMediaPlayer(player);
		player.play();
	}
	public void setApp(Main app, String name){
		Media media = new Media(Paths.get("src/res/intro.mp4").toUri().toString());
		player = new MediaPlayer(media);
		vid.setMediaPlayer(player);
		player.play();
		player.setOnEndOfMedia(new EndOfMedia());
		this.name = name;
		this.app = app;
	}
	
	
	@FXML
	void initialize(){

	}
	
	public void onSkipClicked(){
		
		player.stop();
		try {
			ctr = (CreatePlayerController) app.replaceSceneContent("CreatePlayer.fxml", CreatePlayerController.class);
			ctr.setApp(app);
			ctr.setPlayerName(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	class EndOfMedia implements Runnable{
		@Override
		public void run() {
			try {
				ctr = (CreatePlayerController) app.replaceSceneContent("CreatePlayer.fxml", CreatePlayerController.class);
				ctr.setApp(app);
				ctr.setPlayerName(name);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
