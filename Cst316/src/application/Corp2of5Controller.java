package application;

import cst316.Player;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class Corp2of5Controller extends AnchorPane {
    private Main application;
    private Player player;
    
//=======================USER DEFINED VARIABLES ABOVE =========+++==========
   
    @FXML
    private Button nextButton2;
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
    private void open3of5(ActionEvent event) throws Exception {
      Corp3of5Controller ctr = (Corp3of5Controller) application.replaceSceneContent("Corp3of5.fxml", Corp3of5Controller.class);
        ctr.setApp(application);
        ctr.setPlayer(player);
    }
    
    @FXML
    private void backButton(ActionEvent event) throws Exception {
       CorpController ctr = (CorpController) application.replaceSceneContent("Corp.fxml", CorpController.class);
        ctr.setApp(application);
        ctr.setPlayer(player);
    }
}
