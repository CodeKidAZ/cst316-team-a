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

/**
 * FXML Controller class
 *
 * @author Sumit
 */
public class Corp3of5Controller implements Initializable 
{
    MainA a;
    @FXML
    private Button nextButton3;
    @FXML
    private Button backButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
     public void setMainA(MainA a)
    {
        this.a = a;
        
    }

    @FXML
    private void open4of5(ActionEvent event) {
        a.openCorpProcess4of5();
    }

    @FXML
    private void backButton(ActionEvent event) {
        a.openCorpProcess2of5();
    }
}
