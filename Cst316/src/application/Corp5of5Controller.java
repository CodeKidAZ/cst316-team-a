/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import application.Main;

import cst316.Player;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Sumit
 */
public class Corp5of5Controller extends AnchorPane {

    private Main application;
    private Player player;
    
    //=========================USER DEFINED VARIABLES ABOVE========================================
    @FXML
    private Button doneButton;
    @FXML
    private Button backButton;
    
//____________________________________________________SET METHODS
    public void setApp(Main app) {
        this.application = app;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    
    @FXML
    private void doneButton(ActionEvent event) throws Exception {
        HRController ctr = (HRController) application.replaceSceneContent("HR.fxml", null);
        ctr.setApp(application);
        ctr.setPlayer(player);
    }

    @FXML
    private void backButton(ActionEvent event) throws Exception {
         Corp4of5Controller ctr = (Corp4of5Controller) application.replaceSceneContent("Corp4of5.fxml", Corp4of5Controller.class);
        ctr.setApp(application);
        ctr.setPlayer(player);
    }
}
