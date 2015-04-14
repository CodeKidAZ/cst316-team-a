package application;


import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;

import org.json.JSONArray;

import cst316.Investment;
import cst316.Player;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class InvestmentController extends AnchorPane {

	@FXML
	Button continueBtn;
	@FXML
	Button sellBtn;
	@FXML
	ComboBox<String> companyCombo;
	@FXML
	TextField amountText;
	@FXML
	LineChart<Number, Number> chart;
	@FXML
	Label noDataLbl;
	@FXML
	Group sellGrp;
	@FXML
	Label valueLbl;
	@FXML
	Label valueMsg;
	@FXML
	Label moneyLbl;
	
	private Player player;
	private boolean sellToggle = true;
	private NumberFormat numForm;

	private Main application;
	@FXML
	private AnchorPane AnchorPane;
	@FXML
	private Button cancelBtn;
	@FXML
	private ImageView companyImage;
	

	public void setApp(Main app) {
		numForm = new DecimalFormat("#0.00");
		application = app;

		String[] allCompanyNames = Investment.getAllCompanyNames();
		ObservableList<String> items = companyCombo.getItems();
		for (String name : allCompanyNames) {
			items.add(name);
		}
		companyCombo.setItems(items);
		this.player = application.getPlayer();
		moneyLbl.setText("Player money: $" + numForm.format(player.getMoney()));

	}
	public void setPlayer(Player player) {
		this.player = player;
	}

	@FXML
	public void onContinueClick() throws Exception {
		String companyName = companyCombo.getValue().toString();
		try{
			double amount = Double.parseDouble(amountText.getText());
			if(player.investmentExists(companyName)){
				Investment inv = player.getInvestment(companyName);
				inv.addAmount(amount);
			}else{
				Random random = new Random();
				Investment investment = new Investment(companyName, amount, random.nextBoolean());
				player.addInvestment(investment);
			}
			player.setMoney(player.getMoney() - amount);
			moneyLbl.setText("Player money: $" + numForm.format(player.getMoney()));
			LandingController ctr = (LandingController) application.replaceSceneContent("Landing.fxml", LandingController.class);
			ctr.setApp(application);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@FXML
	public void onCancelClick() throws Exception {
		valueMsg.setText("Current value:");
		LandingController ctr = (LandingController) application.replaceSceneContent("Landing.fxml", LandingController.class);
		ctr.setApp(application);
	}
	@FXML
	public void onSellClicked(){
		String name = companyCombo.getSelectionModel().getSelectedItem().toString();
		Investment inv = player.getInvestment(name);
		if(sellToggle){
			sellBtn.setText("Confirm");
			valueMsg.setText("Are you sure? Sales fee:");
			valueLbl.setText("$" + numForm.format(inv.getFee()));
			sellToggle = false;
		}else{
			sellBtn.setText("Sell");
			player.setMoney(player.getMoney() + inv.getAmount() - inv.getFee());
			player.removeInvestment(inv);
			moneyLbl.setText("Player money: $" + numForm.format(player.getMoney()));
			sellToggle = true;
		}
	}

	@FXML
	private void companyDropDown(ActionEvent event) {
		sellToggle = true;
		String name = companyCombo.getSelectionModel().getSelectedItem().toString();
		if(player.investmentExists(name)){
			valueMsg.setText("Current value:");
			sellGrp.setOpacity(1);
			sellBtn.setOpacity(1);
			sellBtn.setText("Sell");
			Investment inv = player.getInvestment(name);
			valueLbl.setText("$" + numForm.format(inv.getAmount()));
			generateChart(name);
			System.out.println(inv.isGood());
		}else{
			sellGrp.setOpacity(0);
			sellBtn.setOpacity(0);
			chart.setOpacity(0);
			noDataLbl.setOpacity(1);
		}
		companyImage.setImage(Investment.getImage(name));
	}

	public void generateChart(String name){
		ArrayList<Investment> inv = player.getInvestments();
		Investment i = null;
		for(int x = 0; x < inv.size(); x++){
			if(inv.get(x).getName().equals(name)){
				i = inv.get(x);
				break;
			}
		}
		if(i != null){
			JSONArray gains = i.getGains();
			if(gains.length() >=1){
				chart.getData().clear();
				final NumberAxis xAxis = new NumberAxis();
				final NumberAxis yAxis = new NumberAxis();
				xAxis.setLabel("Months");

				XYChart.Series series = new Series();
				series.setName(name);
				//populating the series with data
				JSONArray monthly;
				for(int x = 0; x < gains.length(); x++){
					monthly = gains.getJSONArray(x);
					series.getData().add(new XYChart.Data(Integer.toString(monthly.getInt(0)), monthly.getDouble(1)));
				}
				chart.getData().add(series);
				chart.setOpacity(1);
				noDataLbl.setOpacity(0);
			}else{
				chart.setOpacity(0);
				noDataLbl.setOpacity(1);
			}
		}else{
			chart.setOpacity(0);
			noDataLbl.setOpacity(1);
		}
	}

}
