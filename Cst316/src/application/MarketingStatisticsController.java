package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;


public class MarketingStatisticsController extends AnchorPane  {
	@FXML
	private PieChart PHart;

 
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                new PieChart.Data("MikkelSoft", 17),
                new PieChart.Data("Boggle", 25),
                new PieChart.Data("Pear", 5.5),
                new PieChart.Data("Riot Games", 12.5),
                new PieChart.Data("Thanks Obama Inc.", 30),
                new PieChart.Data("All Other Companies", 10)
        );
        PHart.setData(pieChartData);
        PHart.setTitle("Approximated Control of the Mobile App Market");
        PHart.setStartAngle(180);
        
        PHart.setLabelLineLength(12);
        PHart.setLegendSide(Side.LEFT);

    }
 
