package application;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import service.TimedEventService;
import cst316.Player;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class LandingController extends AnchorPane {
	@FXML 
	private ResourceBundle resources;
	@FXML 
	private URL location;
	@FXML
	ImageView invBtn;
	@FXML
	ImageView mngBtn;
	@FXML
	ImageView rndBtn;
	@FXML
	ImageView markBtn;

	private Main application;
	Player player;
	InputStream in;
	Image invIn;
	Image invOut;
	Image rndIn;
	Image rndOut;
	Image markIn;
	Image markOut;
	Image mngIn;
	Image mngOut;

	public void setApp(Main app) {
		application = app;
		in = this.getClass().getClassLoader().getResourceAsStream("res/inv_txt_hover.png");
		invIn = new Image(in);
		in = this.getClass().getClassLoader().getResourceAsStream("res/inv_txt_up.png");
		invOut = new Image(in);
		in = this.getClass().getClassLoader().getResourceAsStream("res/rnd_txt_hover.png");
		rndIn = new Image(in);
		in = this.getClass().getClassLoader().getResourceAsStream("res/rnd_txt_up.png");
		rndOut = new Image(in);
		in = this.getClass().getClassLoader().getResourceAsStream("res/mark_txt_hover.png");
		markIn = new Image(in);
		in = this.getClass().getClassLoader().getResourceAsStream("res/mark_txt_up.png");
		markOut = new Image(in);
		in = this.getClass().getClassLoader().getResourceAsStream("res/man_txt_hover.png");
		mngIn = new Image(in);
		in = this.getClass().getClassLoader().getResourceAsStream("res/man_txt_up.png");
		mngOut = new Image(in);
		this.player = application.getPlayer();
		TimedEventService.createNewInstance(app);
	}

	@FXML
	void initialize(){
	}

	public void onInvMouseEntered(){
		if (invBtn != null) {
			invBtn.setImage(invIn);
		}
	}

	public void onInvMouseExit(){
		if (invBtn != null) {
			invBtn.setImage(invOut);
		}
	}
	
	public void onRndMouseEntered(){
		if (rndBtn != null) {
			rndBtn.setImage(rndIn);
		}
	}

	public void onRndMouseExit(){
		if (rndBtn != null) {
			rndBtn.setImage(rndOut);
		}
	}
	
	public void onMarkMouseEntered(){
		if (markBtn != null) {
			markBtn.setImage(markIn);
		}
	}

	public void onMarkMouseExit(){
		if (markBtn != null) {
			markBtn.setImage(markOut);
		}
	}
	
	public void onMngMouseEntered(){
		if (mngBtn != null) {
			mngBtn.setImage(mngIn);
		}
	}

	public void onMngMouseExit(){
		if (mngBtn != null) {
			mngBtn.setImage(mngOut);
		}
	}
	
	public void onMarketingClick() throws Exception {
		Market3Controller ctr = (Market3Controller) application.replaceSceneContent("MarketingChoice.fxml", Market3Controller.class);
		ctr.setApp(application);
		ctr.setPlayer(player);
	}
	public void onRNDClick() throws Exception {
		ResearchDevelopController ctr = (ResearchDevelopController) application.replaceSceneContent("ResearchDevelop.fxml", ResearchDevelopController.class);
		ctr.setApp(application);
	}
	public void onManagementClick() throws Exception {
		HRController ctr = (HRController) application.replaceSceneContent("HR.fxml", HRController.class);
		ctr.setApp(application);
		ctr.setPlayer(player);
	}
	public void onInvestmentsClick() throws Exception {
		InvestmentController ctr = (InvestmentController) application.replaceSceneContent("Investment.fxml", InvestmentController.class);
		ctr.setApp(application);
		ctr.setPlayer(player);
	}


}
