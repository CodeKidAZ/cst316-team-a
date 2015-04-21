package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import cst316.Company;
import cst316.Employee;
import cst316.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class MarketingChoiceTutController extends AnchorPane {


    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextArea descriptionBox;
    @FXML
    private ComboBox<String> dropMenu;
    @FXML
    private ComboBox<String> dropMenu2;
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
	@FXML
	private ImageView questionMark;

    
    String output;
    String outputType = "Print Marketing";
    Main application;
    Player player;
    double mP = -1;
    double mProjected = -1;
    int i = 0;
    
	ArrayList<Company> playerCompanyList = new ArrayList<Company>();
    

    
    Image image1 = new Image(MarketingChoiceTutController.class.getClassLoader().getResourceAsStream("res/printM.gif"));
    Image image2 = new Image(MarketingChoiceTutController.class.getClassLoader().getResourceAsStream("res/couponM.jpg"));
    Image image3 = new Image(MarketingChoiceTutController.class.getClassLoader().getResourceAsStream("res/wackyM2.gif"));
    Image image4 = new Image(MarketingChoiceTutController.class.getClassLoader().getResourceAsStream("res/tvM.gif"));
    
    Image image5 = new Image(MarketingChoiceTutController.class.getClassLoader().getResourceAsStream("res/question.gif"));
	
    

    // Event Listener on ComboBox[#dropMenuPotential].onAction
    @FXML
    public void dropMenuFired(ActionEvent event) {
        //doneText.setText(null);
    	outputType = (String) dropMenu.getSelectionModel().getSelectedItem().toString();
        switch (outputType) {
            case "Print Marketing":
                marketingPicture.setImage(image1);
                descriptionBox.clear();
                descriptionBox.appendText("Cost: x \n");
                descriptionBox.appendText("Description: Moderately expensive and moderately reliable form of Marketing. + 25MP");
                break;
            case "Coupon Marketing":
                marketingPicture.setImage(image2);
                descriptionBox.clear();
                descriptionBox.appendText("Cost: x \n");
                descriptionBox.appendText("Description: A more expensive and more reliable form of Marketing +45MP");
                ;
                break;
            case "WWITM Marketing":
                marketingPicture.setImage(image3);
                descriptionBox.clear();
                descriptionBox.appendText("Cost: x \n");
                descriptionBox.appendText("Description: The Cheapest Marketing option, and the most unreliable. The 'Wacky Waving Inflatable Tube Man' is either hit or miss with the audience. -25MP");
                break;
            case "Television Marketing":
                marketingPicture.setImage(image4);
                descriptionBox.clear();
                descriptionBox.appendText("Cost: x \n");
                descriptionBox.appendText("Description: The Most Expensive Marketing option, and the most reliable form of marketing.+100 MP");
                break;
        }
    }
    
    // Event Listener on ComboBox[#dropMenuPotential].onAction
    @FXML
    public void dropMenu2Fired(ActionEvent event) {
    	
		  
	        assert playerCompanyList != null: "Companies are null!";
	        
	        output = (dropMenu2.getSelectionModel().getSelectedItem()).toString();
	     /*   for(int i = 0; i<companies.size(); i++) {
	        	if( !dropMenu2.getItems().contains(companies.get(i).getCompanyName()) ) {
	        		dropMenu2.getItems().add(companies.get(i).getCompanyName());
	        	}
	        }
		  */
		  
        output = (dropMenu2.getSelectionModel().getSelectedItem()).toString();
        Company targetComp = player.getCompany(output);



        switch (outputType) {
            case "Print Marketing":
                descriptionBox.clear();
                descriptionBox.appendText("Cost: x \n");
                mP = targetComp.getMarketPower();
                mProjected = mP + 25;
                descriptionBox.appendText("Current Market Power of " + targetComp.getName() + " is " +targetComp.getMarketPower() + ".");
                descriptionBox.appendText("\nIf Print Marketing Campaign is purchased the new Market Power value will be: " + mProjected);
                break;
            case "Coupon Marketing":
                descriptionBox.clear();
                descriptionBox.appendText("Cost: x \n");
                 mP = targetComp.getMarketPower();
                 mProjected = mP + 45;
                descriptionBox.appendText("Current Market Power of " + targetComp.getName() + " is " +targetComp.getMarketPower() + ".");
                descriptionBox.appendText("\nIf Coupon Marketing Campaign is purchased the new Market Power value will be: " + mProjected);
                break;
            case "WWITM Marketing":
            	 descriptionBox.clear();
                 descriptionBox.appendText("Cost: x \n");
                  mP = targetComp.getMarketPower();
                  mProjected = mP - 25;
                 descriptionBox.appendText("Current Market Power of " + targetComp.getName() + " is " +targetComp.getMarketPower() + ".");
                 descriptionBox.appendText("\nIf WWITM Marketing Campaign is purchased the new Market Power value will be: " + mProjected);
                 break;
            case "Television Marketing":
            	 descriptionBox.clear();
                 descriptionBox.appendText("Cost: x \n");
                  mP = targetComp.getMarketPower();
                  mProjected = mP + 100;
                 descriptionBox.appendText("Current Market Power of " + targetComp.getName() + " is " +targetComp.getMarketPower() + ".");
                 descriptionBox.appendText("\nIf Television Marketing Campaign is purchased the new Market Power value will be: " + mProjected);
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
	
	// Event Listener on ImageView[#questionMark].onMouseEntered
	@FXML
	public void questionEntered(MouseEvent event) throws Exception {
		i = 0;
		i++;
		//System.out.println(i);
		if (i >= 1){
			MarketingChoiceTutController ctr = (MarketingChoiceTutController) application.replaceSceneContent("MarketingChoice.fxml", MarketingChoiceTutController.class);
			ctr.setApp(application);
		}
	}
	
	//@Override
	public void setApp(Main app) {
		application = app;
		questionMark.setImage(image5);
		this.player = application.getPlayer();
		dropMenu.getItems().setAll("Print Marketing",
								   "Coupon Marketing",
								   "WWITM Marketing",
							 	   "Television Marketing");
		
        marketingPicture.setImage(image1);
        descriptionBox.clear();
        descriptionBox.appendText("Cost: x \n");
        descriptionBox.appendText("Description: Moderately expensive and moderately reliable form of Marketing. + 25MP");

		playerCompanyList = player.getCompanyList();
		
		  ArrayList<String> companiesName = null;
		  
	        assert playerCompanyList != null: "Companies are null!";
	        for(int i = 0; i<playerCompanyList.size(); i++) {
	        	if( !dropMenu2.getItems().contains(playerCompanyList.get(i).getCompanyName()) ) {
	        		dropMenu2.getItems().add(playerCompanyList.get(i).getCompanyName());
	        	}
	        }
		
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	@FXML
	public void purchaseButtonFired(ActionEvent event) {
		  ArrayList<Company> companies = player.getCompanyList();
	        assert companies != null: "Companies are null!";
        Company targetComp = player.getCompany(output);

		if(outputType.equals("Print Marketing")) {
			System.out.println("PRINT MARKETING PURCHASED." + targetComp.getMarketPower());
	        targetComp.setMarketPower(mProjected);
			System.out.println("PRINT MARKETING PURCHASED." + targetComp.getMarketPower());
		}
		else if(outputType.equals("Coupon Marketing")) {
			System.out.println("COUPON MARKETING PURCHASED." + targetComp.getMarketPower());
	        targetComp.setMarketPower(mProjected);
			System.out.println("COUPON MARKETING PURCHASED." + targetComp.getMarketPower());
		}
		else if(outputType.equals("WWITM Marketing")) {
			System.out.println("WACKY WAVING INFLATABLE TUBE MAN MARKETING PURCHASED." + targetComp.getMarketPower());
	        targetComp.setMarketPower(mProjected);
			System.out.println("WACKY WAVING INFLATABLE TUBE MAN MARKETING PURCHASED." + targetComp.getMarketPower());
		}
		else if (outputType.equals("Television Marketing")){ 
			System.out.println("TELEVISION MARKETING PURCHASED." + targetComp.getMarketPower());
	        targetComp.setMarketPower(mProjected);
			System.out.println("TELEVISION MARKETING PURCHASED." + targetComp.getMarketPower());
		}
		else{
			System.out.println("ERROR: CAMPAIGN AND/OR COMPANY NOT SELECTED.");
		}
		
		}
	}
