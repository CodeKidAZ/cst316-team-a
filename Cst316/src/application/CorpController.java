/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CorpProcess;

import application.MainA;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Sumit
 */
public class CorpController implements Initializable {
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField locationTextField;
    @FXML
    private Button nextButton1;
    private MainA a;
    @FXML
    private Button backButton;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void open2of5(ActionEvent event) 
    {
         a.openCorpProcess2of5();
        
    }
    
     public void setMainA(MainA a)
    {
        this.a = a;
    }

    @FXML
    private void backButton(ActionEvent event) {
        //NEEDS TO BE IMPLEMENTED BASED ON GAME
    }
    
}
