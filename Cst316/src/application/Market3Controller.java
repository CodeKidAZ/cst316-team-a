package application;

import java.net.URL;
import java.util.ResourceBundle;

import cst316.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class Market3Controller extends AnchorPane {


    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextArea descriptionBox;
    @FXML
    private ComboBox<String> dropMenu;
    @FXML
    private Button returnButton;
    @FXML
    private ImageView marketingPicture;
    @FXML
    private Button purchaseButton;
    @FXML
    private Button chartButton;
    @FXML
    private Button test1Button;
    @FXML
    private Text doneText;
    String output;
    Main application;
    Player player;

    
    Image image1 = new Image(Market3Controller.class.getClassLoader().getResourceAsStream("res/printM.gif"));
    Image image2 = new Image(Market3Controller.class.getClassLoader().getResourceAsStream("res/couponM.jpg"));
    Image image3 = new Image(Market3Controller.class.getClassLoader().getResourceAsStream("res/wackyM2.gif"));
    Image image4 = new Image(Market3Controller.class.getClassLoader().getResourceAsStream("res/tvM.gif"));
	
    

    // Event Listener on ComboBox[#dropMenuPotential].onAction
    @FXML
    public void dropMenuFired(ActionEvent event) {
        //doneText.setText(null);
        output = (String) dropMenu.getSelectionModel().getSelectedItem().toString();
        switch (output) {
            case "Print Marketing":
                marketingPicture.setImage(image1);
                descriptionBox.clear();
                descriptionBox.appendText("Cost: x \n");
                descriptionBox.appendText("Description: Moderately expensive and moderately reliable form of Marketing.");
                break;
            case "Coupon Marketing":
                marketingPicture.setImage(image2);
                descriptionBox.clear();
                descriptionBox.appendText("Cost: x \n");
                descriptionBox.appendText("Description: A more expensive and more reliable form of Marketing ");
                ;
                break;
            case "WWITM Marketing":
                marketingPicture.setImage(image3);
                descriptionBox.clear();
                descriptionBox.appendText("Cost: x \n");
                descriptionBox.appendText("Description: The Cheapest Marketing option, and the most unreliable. The 'Wacky Waving Inflatable Tube Man' is either hit or miss with the audience.");
                break;
            case "Television Marketing":
                marketingPicture.setImage(image4);
                descriptionBox.clear();
                descriptionBox.appendText("Cost: x \n");
                descriptionBox.appendText("Description: The Most Expensive Marketing option, and the most reliable form of marketing.");
                break;
        }
    }

    // Event Listener on ComboBox[#dropMenu].onContextMenuRequested

    @FXML
    public void changeMenu(ContextMenuEvent event) {
    }

    ;
	// Event Listener on Button[#returnButton].onAction
	@FXML
	public void returnButtonFired(ActionEvent event) throws Exception {
		LandingController ctr = (LandingController) application.replaceSceneContent("Landing.fxml", LandingController.class);
		ctr.setApp(application);
	}
	
	@FXML
	public void chartButtonFired(ActionEvent event) throws Exception {
		MarketingStatisticsController ctr = (MarketingStatisticsController) application.replaceSceneContent("MarketingStatistics.fxml", MarketingStatisticsController.class);
		ctr.setApp(application);
	}
	
	@FXML
	public void test1ButtonFired(ActionEvent event) throws Exception {
		PieChartFromArrayController ctr = (PieChartFromArrayController) application.replaceSceneContent("PieChartFromArray.fxml", PieChartFromArrayController.class);
		ctr.setApp(application);
	}
	
	//@Override
	public void setApp(Main app) {
		application = app;
		dropMenu.getItems().setAll("Print Marketing",
								   "Coupon Marketing",
								   "WWITM Marketing",
							 	   "Television Marketing");
		this.player = application.getPlayer();
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	@FXML
	public void purchaseButtonFired(ActionEvent event) {
		if(output == "Print Marketing") {
			System.out.println("PRINT MARKETING PURCHASED.");
		}
		else if(output == "Coupon Marketing") {
			System.out.println("COUPON MARKETING PURCHASED.");
		}
		else if(output == "WWITM Marketing") {
			System.out.println("WACKY WAVING INFLATABLE TUBE MAN MARKETING PURCHASED.");
		}
		else{ 
			System.out.println("TELEVISION MARKETING PURCHASED.");
		}
		
		}
	}
