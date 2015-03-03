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
	
	public void setApp(VideoApplication app){
		Media media = new Media(Paths.get("src/res/intro.mp4").toUri().toString());
		MediaPlayer player = new MediaPlayer(media);
		vid.setMediaPlayer(player);
		player.play();
	}
	
	
	@FXML
	void initialize(){

	}
	
	public void onSkipClick(){
		// TODO: skip animation into next scene
	}

}
