package application;

import java.net.URL;
import java.util.ResourceBundle;

import cst316.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.chart.PieChart;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;

public class MarketingStatisticsController implements Initializable {
	@FXML
	private ImageView marketStatsPicture;
	@FXML
	private ComboBox<String> dropMenu;
	@FXML
	private Button returnButton;
	@FXML
	private PieChart piechart;
	
	//Declaring local variables to be used in the Marketing Statistics Display
	String output;
	Main application;
	Player player;


	// Event Listener on ComboBox[#dropMenu].onAction
	@FXML
	public void dropMenuFired(ActionEvent event) {
		output = (String) dropMenu.getSelectionModel().getSelectedItem().toString();
		switch(output) {
			case "Phone App Market Report": 
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
	        piechart.setData(pieChartData2);				; 
				break;
			case "Candy Market Report": 
				ObservableList<PieChart.Data> pieChartData3 =
                FXCollections.observableArrayList(
                    new PieChart.Data("Hersheys", 999),
                    new PieChart.Data("Jaw Breakers", 11),
                    new PieChart.Data("Wonka Inc.", 511),
                    new PieChart.Data("Lollipops", 95),
                    new PieChart.Data("JellyBeans", 215),
                    new PieChart.Data("Cadbury Eggs", 356));
	        piechart.setTitle("Candy Market Report");
	        piechart.setData(pieChartData3);
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
			break;
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		dropMenu.getItems().setAll("Phone App Market Report",
				"Computer Gaming Market Report",
				"Candy Market Report",
				"Anime Pillow Market Report");
		
	}
	// Event Listener on Button[#returnButton].onAction
	@FXML
	public void returnButtonFired(ActionEvent event) throws Exception {
		LandingController ctr = (LandingController) application.replaceSceneContent("Landing.fxml", LandingController.class);
		ctr.setApp(application);
	}
}
