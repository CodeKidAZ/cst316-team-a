package application;

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
	



	// Event Listener on ComboBox[#dropMenu].onAction
	@FXML
	public void dropMenuFired(ActionEvent event) {
		output = (String) dropMenu.getSelectionModel().getSelectedItem().toString();
		switch(output) {
			case "Phone App Market Report": 
				//If the 'Phone App Market Report' choice is selected from the dropDown menu, then draw this pieChart of sample data
				//The area for each slice is determined by the integer parameter divided by the total
				//EG. 'Calculator' occupies 77/2436 = 0.03 = 3% of the total pie circle
				ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
					new PieChart.Data("Calculator", 77),
					new PieChart.Data("Calculator II the Sequel", 211),
					new PieChart.Data("Selfie Taker 5000", 911),
					new PieChart.Data("SnapChoot", 555),
					new PieChart.Data("Mail-Order Bride Finder", 215),
					new PieChart.Data("Fantasy Football Tracker", 356),
					new PieChart.Data("FaceBiik", 111));
			        piechart.setTitle("Phone App Market Report");
			        piechart.setData(pieChartData);
			        marketStatsPicture.setImage(image1);
				break;
			case "Computer Gaming Market Report":
				  ObservableList<PieChart.Data> pieChartData2 =
	                FXCollections.observableArrayList(
            		new PieChart.Data("MikkelSoft", 17),
                    new PieChart.Data("Boggle", 25),
                    new PieChart.Data("Pear", 5.5),
                    new PieChart.Data("Riot Games", 12.5),
                    new PieChart.Data("Thanks Obama Inc.", 30),
                    new PieChart.Data("All Other Companies", 10));
			        piechart.setTitle("Computer Gaming Market Report");
			        piechart.setData(pieChartData2);				
			        marketStatsPicture.setImage(image2);
				break;
			case "Candy Market Report": 
				ObservableList<PieChart.Data> pieChartData3 =
                FXCollections.observableArrayList(
                    new PieChart.Data("Hersheys", 999),
                    new PieChart.Data("Jaw Breakers", 11),
                    new PieChart.Data("Wonka Inc.", 511),
                    new PieChart.Data("Lollipops", 95),
                    new PieChart.Data("JellyBeans", 215),
                    new PieChart.Data("Mars Bars", 356));
			        piechart.setTitle("Candy Market Report");
			        piechart.setData(pieChartData3);
			        marketStatsPicture.setImage(image3);
			break;
			case "Anime Pillow Market Report": 
				ObservableList<PieChart.Data> pieChartData4 =
                FXCollections.observableArrayList(
                    new PieChart.Data("Kirishima", 90),
                    new PieChart.Data("Sakura Haruno", 211),
                    new PieChart.Data("Hatsune Miku", 335),
                    new PieChart.Data("Wesley-Chan", 115),
                    new PieChart.Data("Midori", 256));
			        piechart.setTitle("Anime Pillow Market Report");
			        piechart.setData(pieChartData4);
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
					"Candy Market Report",
					"Anime Pillow Market Report"
					);
			this.player = application.getPlayer();
		}
		
		public void setPlayer(Player player) {
			this.player = player;
		}
	
	// Event Listener on Button[#returnButton].onAction
	@FXML
	public void returnButtonFired(ActionEvent event) throws Exception {
		LandingController ctr = (LandingController) application.replaceSceneContent("Landing.fxml", LandingController.class);
		ctr.setApp(application);
	}
}
