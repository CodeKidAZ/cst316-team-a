package controllers;
import application.MainA;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

public class FireController implements Initializable 
{
    private MainA a;

    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
    }    
    public void setMainA(MainA a)
    {
        this.a = a;
    }
    
}
