
package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import cst316.Building;
import cst316.Company;
import cst316.Employee;
import cst316.MCamp;
import cst316.MarketCompany;
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

/**
 * @author Wesley Local
 *
 */
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
    private ComboBox<String> dropMenu2;
    @FXML
    private Button returnButton;
    @FXML
    private ImageView marketingPicture;
    @FXML
    private ImageView marketLogo;
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

    
    String output = "default";
    String outputType = "Print Marketing";
    Main application;
    Player player;
    double mP = -1;
    double mProjected = -1;
    int i = 1;
    
    double mPTemp;
    double MProjTemp;
    private MCamp mCTemp;
    
	private double power;
	private boolean isGood = false;
    
    
	ArrayList<Company> playerCompanyList = new ArrayList<Company>();
	
	Company targetComp = new Company("default");
    

	//Source: http://giphy.com/gifs/printer-e5aasdfsaf18
    Image image1 = new Image(Market3Controller.class.getClassLoader().getResourceAsStream("res/Print Marketing.gif"));
	//Source: http://giphy.com/gifs/coupouner-asdxcvxcv11
    Image image2 = new Image(Market3Controller.class.getClassLoader().getResourceAsStream("res/couponM.jpg"));
	//Source: http://giphy.com/gifs/wackycosplay-fghjgfj13
    Image image3 = new Image(Market3Controller.class.getClassLoader().getResourceAsStream("res/wackyM2.gif"));
	//Source: http://giphy.com/gifs/television-yuituryfgj55
    Image image4 = new Image(Market3Controller.class.getClassLoader().getResourceAsStream("res/tvM.gif"));
    
	//Source: http://giphy.com/gifs/mickey-45646asdfdas
    Image image5 = new Image(Market3Controller.class.getClassLoader().getResourceAsStream("res/question.gif"));
    
	//Source: http://giphy.com/gifs/money-234225qwer
    Image image6 = new Image(Market3Controller.class.getClassLoader().getResourceAsStream("res/cGames.gif"));
    
	private static Random random = new Random();
	
    
	public void setMCamp(MCamp mc) {
		this.outputType = mc.getName();
		this.mCTemp = mc;
		dropMenu.getSelectionModel().select(mc.getName());
		Image image = new Image(getClass().getClassLoader().getResourceAsStream(mc.getImage()));
		marketingPicture.setImage(image);
		descriptionBox.clear();
		descriptionBox.appendText("Cost: " + mc.getTotalCost() + "\n");
		descriptionBox.appendText("Description: " + mc.getDescription() + "\n");
	}
	
	
    // Event Listener on ComboBox[#dropMenuPotential].onAction
    /**
     * @param event
     */
    @FXML
    public void dropMenuFired(ActionEvent event) {
		String name = (String) dropMenu.getSelectionModel().getSelectedItem().toString();
		setMCamp(new MCamp(name));
        }
    
    // Event Listener on ComboBox[#dropMenuPotential].onAction
    /**
     * @param event
     */
    @FXML
    public void dropMenu2Fired(ActionEvent event) {
    	
		  
        assert playerCompanyList != null: "Companies are null!";
        
        output = (dropMenu2.getSelectionModel().getSelectedItem()).toString();
		System.out.println(output);
	  
        
		assert player.getCompany(output) != null: "Target output company is null!";
		
		targetComp = player.getCompany(output);
		System.out.println("tempComps name " + targetComp.getName());
		System.out.println(targetComp.getMarketPower());




        switch (outputType) {
            case "Print Marketing":
                descriptionBox.clear();
                descriptionBox.appendText("Cost: 100 \n");
                mPTemp = targetComp.getMarketPower();
                MProjTemp = mPTemp + calcPrintPower();
                descriptionBox.appendText("Current Market Power of " + targetComp.getName() + " is " +targetComp.getMarketPower() + ".");
                descriptionBox.appendText("\nIf Print Marketing Campaign is purchased the new Market Power value will be an estimated: " + MProjTemp);
                break;
            case "Coupon Marketing":
                descriptionBox.clear();
                descriptionBox.appendText("Cost: 200 \n");
                mPTemp = targetComp.getMarketPower();
                MProjTemp = mPTemp + calcCouponPower();
                descriptionBox.appendText("Current Market Power of " + targetComp.getName() + " is " +targetComp.getMarketPower() + ".");
                descriptionBox.appendText("\nIf Coupon Marketing Campaign is purchased the new Market Power value will be an estimated: " + MProjTemp);
                break;
            case "WWITM Marketing":
            	 descriptionBox.clear();
                 descriptionBox.appendText("Cost: 50 \n");
                 mPTemp = targetComp.getMarketPower();
                 MProjTemp = mPTemp + calcWackyPower();
                 descriptionBox.appendText("Current Market Power of " + targetComp.getName() + " is " +targetComp.getMarketPower() + ".");
                 descriptionBox.appendText("\nIf WWITM Marketing Campaign is purchased the new Market Power value will be an estimated: " + MProjTemp);
                 break;
            case "Television Marketing":
            	 descriptionBox.clear();
                 descriptionBox.appendText("Cost: 275 \n");
                 mPTemp = targetComp.getMarketPower();
                 MProjTemp = mPTemp + calcTVPower();
                 descriptionBox.appendText("Current Market Power of " + targetComp.getName() + " is " +targetComp.getMarketPower() + ".");
                 descriptionBox.appendText("\nIf Television Marketing Campaign is purchased the new Market Power value will be an estimated: " + MProjTemp);
                 break;
        }
    }

    // Event Listener on ComboBox[#dropMenu].onContextMenuRequested

    /**
     * @param event
     */
    @FXML
    public void changeMenu(ContextMenuEvent event) {
    }

    ;
	// Event Listener on Button[#returnButton].onAction
	/**
	 * @param event
	 * @throws Exception
	 */

	public void returnButtonFired(ActionEvent event) throws Exception {
		LandingController ctr = (LandingController) application.replaceSceneContent("Landing.fxml", LandingController.class);
		ctr.setApp(application);
	}
	
	/**
	 * @param event
	 * @throws Exception
	 */
	@FXML
	public void chartButtonFired(ActionEvent event) throws Exception {
		MarketingStatisticsController ctr = (MarketingStatisticsController) application.replaceSceneContent("MarketingStatistics.fxml", MarketingStatisticsController.class);
		ctr.setApp(application);
	}
	
	/**
	 * @param event
	 * @throws Exception
	 */
	@FXML
	public void test1ButtonFired(ActionEvent event) throws Exception {
		PieChartFromArrayController ctr = (PieChartFromArrayController) application.replaceSceneContent("PieChartFromArray.fxml", PieChartFromArrayController.class);
		ctr.setApp(application);
	}
	
	// Event Listener on ImageView[#questionMark].onMouseEntered
	/**
	 * @param event
	 * @throws Exception
	 */
	@FXML
	public void questionEntered(MouseEvent event) throws Exception {
		i++;
		//System.out.println(i);
		if (i% 2 == 0){
			MarketingChoiceTutController ctr = (MarketingChoiceTutController) application.replaceSceneContent("MarketingChoiceTut.fxml", MarketingChoiceTutController.class);
			ctr.setApp(application);
		}

	}
	
    /**
     * @return a random double value between 5 and 15.
     */
    public double calcPrintPower() {
			power = (Math.abs((random.nextGaussian() * 10)) + 5);
		return power;
	}
    
    /**
     * @return  a random double value between 15 and 20.
     */
    public double calcCouponPower() {
		power = (Math.abs((random.nextGaussian() * 5)) + 15);
		return power;
	}
    
    
    /**
     * @return  a random double value between -10 and 40.
     */
    public double calcWackyPower() {
		power = (((random.nextDouble() * 50)) - 10);
		return power;
	}
    
    /**
     * @return  a random double value between 33 and 35.
     */
    public double calcTVPower() {
    	power = (Math.abs((random.nextGaussian() * 2)) + 33);
		return power;
	}
	
	//@Override
	/**
	 * @param app
	 */
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
        descriptionBox.appendText("Cost: 100 \n");
        descriptionBox.appendText("Description: Moderately expensive and moderately reliable form of Marketing. +5MP to +15");

		playerCompanyList = player.getCompanyList();
		ArrayList<String> companiesName = new ArrayList<String>();
		
		String temp = "hello";
  
		assert playerCompanyList != null: "Companies are null!";
		for(int i = 0; i<playerCompanyList.size(); i++) {
			if( !dropMenu2.getItems().contains(playerCompanyList.get(i).getCompanyName()) ) {
				dropMenu2.getItems().add(playerCompanyList.get(i).getCompanyName());

				temp = (playerCompanyList.get(i).getCompanyName());
				}
			}

		}
		
	/**
	 * @param player
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	/**
	 * @param event
	 */
	@FXML
	public void purchaseButtonFired(ActionEvent event) {
		ArrayList<Company> companies = player.getCompanyList();
        assert companies != null: "Companies are null!";
        Company targetComp = player.getCompany(output);
        double cost = 0;

		if(outputType.equals("Print Marketing")) {
			cost = 100;
			if (player.getMoney() >= cost) {
				System.out.println("PRINT MARKETING PURCHASED." + targetComp.getMarketPower());
				mP = targetComp.getMarketPower();
				mProjected = mP + calcPrintPower();
		        targetComp.setMarketPower(mProjected);
				System.out.println("PRINT MARKETING PURCHASED." + targetComp.getMarketPower());
		        descriptionBox.clear();
	            descriptionBox.appendText("\nNEW MARKET POWER IS: " + mProjected);
				marketingPicture.setImage(image6);
	            player.setMoney(player.getMoney() - cost);
			}
			else{
				descriptionBox.clear();
	            descriptionBox.appendText("Not enough money to pay for selected Campaign.");
			}
		}
		else if(outputType.equals("Coupon Marketing")) {
			cost = 200;
			if (player.getMoney() >= cost) {
				System.out.println("COUPON MARKETING PURCHASED." + targetComp.getMarketPower());
	            mP = targetComp.getMarketPower();
	            mProjected = mP + calcCouponPower();
		        targetComp.setMarketPower(mProjected);
				System.out.println("COUPON MARKETING PURCHASED." + targetComp.getMarketPower());
		        descriptionBox.clear();
	            descriptionBox.appendText("\nNEW MARKET POWER IS: " + mProjected);
				marketingPicture.setImage(image6);
	            player.setMoney(player.getMoney() - cost);
			}
			else{
				descriptionBox.clear();
	            descriptionBox.appendText("Not enough money to pay for selected Campaign.");
			}
		}
		else if(outputType.equals("WWITM Marketing")) {
			cost = 50;
			if (player.getMoney() >= cost) {
				System.out.println("WACKY WAVING INFLATABLE TUBE MAN MARKETING PURCHASED." + targetComp.getMarketPower());
	            mP = targetComp.getMarketPower();
	            mProjected = mP + calcWackyPower();
		        targetComp.setMarketPower(mProjected);
				System.out.println("WACKY WAVING INFLATABLE TUBE MAN MARKETING PURCHASED." + targetComp.getMarketPower());
		        descriptionBox.clear();
	            descriptionBox.appendText("\nNEW MARKET POWER IS: " + mProjected);
				marketingPicture.setImage(image6);
	            player.setMoney(player.getMoney() - cost);
			}
			else{
				descriptionBox.clear();
	            descriptionBox.appendText("Not enough money to pay for selected Campaign.");
			}

		}
		else if (outputType.equals("Television Marketing")){
			cost = 50;
			if (player.getMoney() >= cost) {
				System.out.println("TELEVISION MARKETING PURCHASED." + targetComp.getMarketPower());
	            mP = targetComp.getMarketPower();
	            mProjected = mP + calcWackyPower();
		        targetComp.setMarketPower(mProjected);
				System.out.println("TELEVISION MARKETING PURCHASED." + targetComp.getMarketPower());
		        descriptionBox.clear();
	            descriptionBox.appendText("\nNEW MARKET POWER IS: " + mProjected);
				marketingPicture.setImage(image6);
	            player.setMoney(player.getMoney() - cost);
			}
			else{
				descriptionBox.clear();
	            descriptionBox.appendText("Not enough money to pay for selected Campaign.");
			}

		}
		else{
			System.out.println("ERROR: CAMPAIGN AND/OR COMPANY NOT SELECTED.");
		}
		
	}
}

