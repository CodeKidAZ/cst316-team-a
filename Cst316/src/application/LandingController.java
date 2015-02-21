package application;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class LandingController extends AnchorPane{
	@FXML 
	private ResourceBundle resources;
	@FXML 
	private URL location;
	@FXML
	ImageView invBtn;

	//private Main application;
	InputStream in;
	Image invIn;
	Image invOut;

	public void setApp(Main app){
		//application = app;
		in = this.getClass().getClassLoader().getResourceAsStream("res/inv_txt_hover.png");
		invIn = new Image(in);
		in = this.getClass().getClassLoader().getResourceAsStream("res/inv_txt_up.png");
		invOut = new Image(in);
	}

	@FXML
	void initialize(){

	}

	public void onInvMouseEntered(){
		if(invBtn != null)
		invBtn.setImage(invIn);

	}

	public void onInvMouseExit(){
		if(invBtn != null)
		invBtn.setImage(invOut);


	}


}
