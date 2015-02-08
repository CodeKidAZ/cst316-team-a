package controllers;
//
import application.MainA;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Sumit
 */
public class HRController implements Initializable 
{
    @FXML
    private Label hrTitleLabel;
    @FXML
    private Button hireButton;
    @FXML
    private Button fireButton;
    private MainA a;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
    }    

    @FXML
    private void openHire(ActionEvent event) 
    {
        System.out.println("YOU CLICKED HIRE");
        a.openHireScreen();
    }

    @FXML
    private void openFire(ActionEvent event) 
    {
        System.out.println("YOU CLICKED FIRE");
        a.openFireScreen();
    }
    public void setMainA(MainA a)
    {
        this.a = a;
    }
    
}
