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
	
	String output;
	Main application;
	Player player;
	
	ObservableList<PieChart.Data> pieChartData =
            FXCollections.observableArrayList();
	
	
	ArrayList<Company> companyListPhone = new ArrayList<Company>();
	ArrayList<Company> companyListGames = new ArrayList<Company>();
	ArrayList<Company> companyListCandy = new ArrayList<Company>();
	ArrayList<Company> companyListPillow = new ArrayList<Company>();
	
	  ArrayList<String> companiesName = new ArrayList<String>();
	
	//Source: http://giphy.com/gifs/chucknorris-thumbs-e5asd17fasfZk
    Image goodImg = new Image(MarketingStatisticsController.class.getClassLoader().getResourceAsStream("res/goodNews.gif"));
    
    //Source: http://giphy.com/gifs/reaction-ok-D7Qzw12q9s8Tu
    Image okayImg = new Image(MarketingStatisticsController.class.getClassLoader().getResourceAsStream("res/okay.gif"));
    
    //Source: http://giphy.com/gifs/bad-news-lIk6BF7Vj9XcA
    Image badImg = new Image(MarketingStatisticsController.class.getClassLoader().getResourceAsStream("res/badNews.gif"));

	
    


	ArrayList<Company> playerCompanyList = new ArrayList<Company>();
	ArrayList<Company> playerCompanyList2 = new ArrayList<Company>();



	// Event Listener on ComboBox[#dropMenu].onAction
	@FXML
	public void dropMenuFired(ActionEvent event) {
		output = (String) dropMenu.getSelectionModel().getSelectedItem().toString();
		double power = 0;
		pieChartData.clear();
		
		 Company otherComp = new Company("default Name", -1.0);
		if (companiesName.contains(output)){
			System.out.println("companiesName list does contain the selected value");
			for (int z = 0; z < companiesName.size(); z ++){
				if (output.equals(companiesName.get(z))){
					power = ((playerCompanyList.get(z)).getMarketPower());
					
					pieChartData.add(new PieChart.Data((playerCompanyList.get(z)).getName(), power));

					otherComp.setName("All Other Companies");
	        		otherComp.setMarketPower((100-(playerCompanyList.get(z).getMarketPower())));
					pieChartData.add(new PieChart.Data((otherComp.getName()), (otherComp.getMarketPower())));
				}
				
			}
			 piechart.setTitle("Current Market Power Report");
		        piechart.setData(pieChartData);
		        
		        if (power > 55){
			        marketStatsPicture.setImage(goodImg);
		        }
		        if (power < 55 && power > 40){
			        marketStatsPicture.setImage(okayImg);
		        }
		        if (power < 40){
			        marketStatsPicture.setImage(badImg);
		        }
		        	

		}
		else {
			System.out.println("Error Selected item is not in the list of company names: ");
			for (int z = 0; z < companiesName.size(); z ++){
				System.out.println(companiesName.get(z));
			}
		}
		
		/*
		switch(output) {
			case "Phone App Market Report": 
				//If the 'Phone App Market Report' choice is selected from the dropDown menu, then draw this pieChart of sample data
				//The area for each slice is determined by the integer parameter divided by the total
				//EG. 'Calculator' occupies 77/2436 = 0.03 = 3% of the total pie circle
				pieChartData.clear();
				
				for (int z = 0; z < playerCompanyList.size(); z ++){
					pieChartData.add(new PieChart.Data((playerCompanyList.get(z)).getName(), (playerCompanyList.get(z)).getMarketPower()));
				}
				 piechart.setTitle("Phone App Company Market Report (Equal Market Example)");
			        piechart.setData(pieChartData);
			        marketStatsPicture.setImage(image1);
				break;
			case "Computer Gaming Market Report":
				pieChartData.clear();
				
				for (int z = 0; z < playerCompanyList.size(); z ++){
					pieChartData.add(new PieChart.Data((playerCompanyList.get(z)).getName(), (playerCompanyList.get(z)).getMarketPower()));
				}
			        piechart.setTitle("Computer Gaming Market Report (Dominant Market Example)");
			        piechart.setData(pieChartData);				
			        marketStatsPicture.setImage(image2);
				break;
			case "Candy Market Report": 
				pieChartData.clear();
				
				for (int z = 0; z < playerCompanyList.size(); z ++){
					pieChartData.add(new PieChart.Data((playerCompanyList.get(z)).getName(), (playerCompanyList.get(z)).getMarketPower()));
				}
			        piechart.setTitle("Candy Market Report (Plurality Market Example)");
			        piechart.setData(pieChartData);
			        marketStatsPicture.setImage(image3);
			break;
			case "Anime Pillow Market Report": 
				pieChartData.clear();
				
				for (int z = 0; z < playerCompanyList.size(); z ++){
					pieChartData.add(new PieChart.Data((playerCompanyList.get(z)).getName(), (playerCompanyList.get(z)).getMarketPower()));
				}
			        piechart.setTitle("Candy Market Report");
			        piechart.setData(pieChartData);
			        piechart.setTitle("Anime Pillow Market Report");
			        piechart.setData(pieChartData);
			        marketStatsPicture.setImage(image4);
		}
		*/
	}
	
	
	//@Override
		public void setApp(Main app) {
			application = app;
			dropMenu.getItems().setAll(
					//"Anime Pillow Market Report"
					);
			this.player = application.getPlayer();
			

			playerCompanyList = player.getCompanyList();
			

			  
		        assert playerCompanyList != null: "Companies are null!";
		        for(int i = 0; i<playerCompanyList.size(); i++) {
		        	if( !dropMenu.getItems().contains(playerCompanyList.get(i).getCompanyName()) ) {
		        		dropMenu.getItems().add(playerCompanyList.get(i).getCompanyName());
						System.out.println(playerCompanyList.get(i).getCompanyName());
		        		companiesName.add((String)(playerCompanyList.get(i).getCompanyName()));
		        		
		        	}
		        }
		        
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
