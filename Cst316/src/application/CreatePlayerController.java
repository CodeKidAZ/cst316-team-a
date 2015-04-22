package application;

import java.io.InputStream;
import java.util.ArrayList;

import service.InvestmentService;
import service.TimedEventService;
import cst316.Company;
import cst316.Player;
import cst316.Product;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

public class CreatePlayerController extends AnchorPane {

    @FXML
    Button continueBtn;
    @FXML
    ComboBox<String> productCombo;

    private String playerName;

    private Main application;
    InputStream in;
    Image invIn;
    Image invOut;
    @FXML
    private AnchorPane AnchorPane;

    private Player player;
    private String compName;
    
    public void setApp(Main app) {
        application = app;
        String[] allProductNames = Product.getAllProductNames();
        ObservableList<String> items = productCombo.getItems();
        for (String name : allProductNames) {
            items.add(name);
        }
        productCombo.setItems(items);
        player = application.getPlayer();
    }
    
    public void setCompanyName(String compName){
    	this.compName = compName;
    }

    /*void initialize() {
        continueBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    String productName = productCombo.getValue().toString();
                    Product product = new Product(productName, 0.0, 0.0);
                    Player player = new Player(0, 100.0, playerName, new ArrayList<String>());
                    application.setPlayer(player);
                    player.setProduct(product);
                    player.saveFile();
                    BuildingChoiceController ctr = (BuildingChoiceController) application.replaceSceneContent("BuildingChoice.fxml", BuildingChoiceController.class);
                    ctr.setApp(application);
                } catch (Exception e) {
                    throw new Error(e);
                }
            }
        });
    }*/

    @FXML
    private void handle(ActionEvent event) {
        try {
            String productName = productCombo.getValue().toString();
            Product product = new Product(productName, 0.0, 0.0);
            Company comp = player.getCompany(compName);
            comp.addProducts(product);
            player.saveFile();
            BuildingChoiceController ctr = (BuildingChoiceController) application.replaceSceneContent("BuildingChoice.fxml", BuildingChoiceController.class);
            ctr.setApp(application);
            TimedEventService.createNewInstance(application);
    		InvestmentService.createNewInstance(application);
        } catch (Exception e) {
            throw new Error(e);
        }
    }

}
