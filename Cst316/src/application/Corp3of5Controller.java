
package application;

import cst316.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class Corp3of5Controller extends AnchorPane {

     private Main application;
     private Player player;
 //=======================USER DEFINED VARIABLES ABOVE =========+++==========
    
    
    @FXML
    private Button nextButton3;
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
    private void open4of5(ActionEvent event) throws Exception {
       Corp4of5Controller ctr = (Corp4of5Controller) application.replaceSceneContent("Corp4of5.fxml", Corp4of5Controller.class);
        ctr.setApp(application);
        ctr.setPlayer(player);
    }

    @FXML
    private void backButton(ActionEvent event) throws Exception {
        Corp2of5Controller ctr = (Corp2of5Controller) application.replaceSceneContent("Corp2of5.fxml", Corp2of5Controller.class);
        ctr.setApp(application);
        ctr.setPlayer(player);
    }
}
