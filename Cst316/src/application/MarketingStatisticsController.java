package application;

import java.util.ArrayList;

import cst316.Company;
import cst316.MarketCompany;
import cst316.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.chart.PieChart;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class MarketingStatisticsController extends AnchorPane {
	@FXML
	private ImageView marketStatsPicture;
	@FXML
	private ComboBox<String> dropMenu;
	@FXML
	private Button returnButton;
	@FXML
	private PieChart piechart;
	
	//git test
	//Declaring local variables to be used in the Marketing Statistics Display
	String output;
	Main application;
	Player player;
	
	ObservableList<PieChart.Data> pieChartData =
            FXCollections.observableArrayList();
	
	
	ArrayList<Company> companyListPhone = new ArrayList<Company>();
	ArrayList<Company> companyListGames = new ArrayList<Company>();
	ArrayList<Company> companyListCandy = new ArrayList<Company>();
	ArrayList<Company> companyListPillow = new ArrayList<Company>();
	

	
    /*Image image1 = new Image(MarketingStatisticsController.class.getClassLoader().getResourceAsStream("res/phoneApp.gif"));
    Image image2 = new Image(MarketingStatisticsController.class.getClassLoader().getResourceAsStream("res/cGames.gif"));
    Image image3 = new Image(MarketingStatisticsController.class.getClassLoader().getResourceAsStream("res/candy.gif"));
    Image image4 = new Image(MarketingStatisticsController.class.getClassLoader().getResourceAsStream("res/animePillow.gif"));
    */
	
	/*Image image1 = new Image("file:/../res/phoneApp.gif");
	Image image2 = new Image("file:/../res/cGames.jpg");
	Image image3 = new Image("file:/../res/candy.gif");
	Image image4 = new Image("file:/../res/animePillow.gif");
	*/
	
    Image image1 = new Image(MarketingStatisticsController.class.getClassLoader().getResourceAsStream("res/phoneApp.gif"));
    Image image2 = new Image(MarketingStatisticsController.class.getClassLoader().getResourceAsStream("res/cGames.gif"));
    Image image3 = new Image(MarketingStatisticsController.class.getClassLoader().getResourceAsStream("res/candy.gif"));
    Image image4 = new Image(MarketingStatisticsController.class.getClassLoader().getResourceAsStream("res/animePillow.gif"));
	
    
	static Company phone1 = new Company("Calculator Inc.", 15.5);
	static Company phone2 = new Company("FaceBiik", 15.5);
	static Company phone3 = new Company("Selfie Taker 5000", 15.5);
	static Company phone4 = new Company("SnapChoot", 15.5);
	static Company phone5 = new Company("Mail-Order Bride Finder Inc.", 15.5);
	static Company phone6 = new Company("MagentaBerry", 15.5);
	
	static Company game1 = new Company("MikkelSoft", 207);
	static Company game2 = new Company("Boggle", 25);
	static Company game3 = new Company("Pear", 5.5);
	static Company game4 = new Company("Riot Games", 12.5);
	static Company game5 = new Company("Thanks Obama Inc.", 30);
	
	static Company candy1 = new Company("Hersheys", 999);
	static Company candy2 = new Company("Jaw Breakers", 11);
	static Company candy3 = new Company("Wonka Inc.", 511);
	static Company candy4 = new Company("Lollipops", 95);
	static Company candy5 = new Company("JellyBeans", 215);
	static Company candy6 = new Company("Mars Bars", 356);




	// Event Listener on ComboBox[#dropMenu].onAction
	@FXML
	public void dropMenuFired(ActionEvent event) {
		output = (String) dropMenu.getSelectionModel().getSelectedItem().toString();
		switch(output) {
			case "Phone App Market Report": 
				//If the 'Phone App Market Report' choice is selected from the dropDown menu, then draw this pieChart of sample data
				//The area for each slice is determined by the integer parameter divided by the total
				//EG. 'Calculator' occupies 77/2436 = 0.03 = 3% of the total pie circle
				pieChartData.clear();
				
				for (int z = 0; z < companyListPhone.size(); z ++){
					pieChartData.add(new PieChart.Data((companyListPhone.get(z)).getName(), (companyListPhone.get(z)).getMarketPower()));
				}
				 piechart.setTitle("Phone App Company Market Report (Equal Market Example)");
			        piechart.setData(pieChartData);
			        marketStatsPicture.setImage(image1);
				break;
			case "Computer Gaming Market Report":
				pieChartData.clear();
				
				for (int z = 0; z < companyListGames.size(); z ++){
					pieChartData.add(new PieChart.Data((companyListGames.get(z)).getName(), (companyListGames.get(z)).getMarketPower()));
				}
			        piechart.setTitle("Computer Gaming Market Report (Dominant Market Example)");
			        piechart.setData(pieChartData);				
			        marketStatsPicture.setImage(image2);
				break;
			case "Candy Market Report": 
				pieChartData.clear();
				
				for (int z = 0; z < companyListCandy.size(); z ++){
					pieChartData.add(new PieChart.Data((companyListCandy.get(z)).getName(), (companyListCandy.get(z)).getMarketPower()));
				}
			        piechart.setTitle("Candy Market Report (Plurality Market Example)");
			        piechart.setData(pieChartData);
			        marketStatsPicture.setImage(image3);
			break;
			case "Anime Pillow Market Report": 
				pieChartData.clear();
				
				for (int z = 0; z < companyListCandy.size(); z ++){
					pieChartData.add(new PieChart.Data((companyListCandy.get(z)).getName(), (companyListCandy.get(z)).getMarketPower()));
				}
			        piechart.setTitle("Candy Market Report");
			        piechart.setData(pieChartData);
			        piechart.setTitle("Anime Pillow Market Report");
			        piechart.setData(pieChartData);
			        marketStatsPicture.setImage(image4);
		}
	}
	
	/*@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		dropMenu.getItems().setAll("Phone App Market Report",
				"Computer Gaming Market Report",
				"Candy Market Report",
				"Anime Pillow Market Report");
		
	}*/
	
	
	//@Override
		public void setApp(Main app) {
			application = app;
			dropMenu.getItems().setAll(
					"Phone App Market Report",
					"Computer Gaming Market Report",
					"Candy Market Report"
					//"Anime Pillow Market Report"
					);
			this.player = application.getPlayer();
			
			companyListPhone.add(phone1);
			companyListPhone.add(phone2);
			companyListPhone.add(phone3);
			companyListPhone.add(phone4);
			companyListPhone.add(phone5);
			companyListPhone.add(phone6);
			
			companyListGames.add(game1);
			companyListGames.add(game2);
			companyListGames.add(game3);
			companyListGames.add(game4);
			companyListGames.add(game5);
			
			companyListCandy.add(candy1);
			companyListCandy.add(candy2);
			companyListCandy.add(candy3);
			companyListCandy.add(candy4);
			companyListCandy.add(candy5);
			companyListCandy.add(candy6);

		}
		
		public void setPlayer(Player player) {
			this.player = player;
		}
	
	// Event Listener on Button[#returnButton].onAction
	@FXML
	public void returnButtonFired(ActionEvent event) throws Exception {
		Market3Controller ctr = (Market3Controller) application.replaceSceneContent("MarketingChoice.fxml", Market3Controller.class);
		ctr.setApp(application);
	}
}
