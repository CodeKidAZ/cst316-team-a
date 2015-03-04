package application;
//
import cst316.Player;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Sumit
 */
public class HRController extends AnchorPane {
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Label hrTitleLabel;
    @FXML
    private Button hireButton;
    @FXML
    private Button fireButton;

    private Main application;
    private Player player;
    
    @FXML
    private void onBack() throws Exception {
        System.out.println("YOU CLICKED BACK");
        LandingController ctr = (LandingController) application.replaceSceneContent("Landing.fxml", LandingController.class);
        ctr.setApp(application);
        ctr.setPlayer(player);
    }
    @FXML
    private void openHire(ActionEvent event) throws Exception {
        System.out.println("YOU CLICKED HIRE");
        HireController ctr = (HireController) application.replaceSceneContent("Hire.fxml", HireController.class);
        ctr.setApp(application);
        ctr.setPlayer(player);
    }

    @FXML
    private void openFire(ActionEvent event) throws Exception {
        System.out.println("YOU CLICKED FIRE");
        FireController ctr = (FireController) application.replaceSceneContent("Fire.fxml", FireController.class);
        ctr.setApp(application);
        ctr.setPlayer(player);
    }

    public void setApp(Main app) {
        this.application = app;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    
}
