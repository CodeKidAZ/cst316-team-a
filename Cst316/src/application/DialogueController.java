/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import cst316.Employee;
import cst316.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Sumit
 */
public class DialogueController extends AnchorPane{

    private Main application;
    private Player player;
   
    private ImageView darkBackground;
    @FXML
    private TextField nameField;
    @FXML
    private Button okButton;
    @FXML
    private Button cancelButton;
    @FXML
    private ImageView companyImage;
    
    public void setApp(Main app) {
         this.application = app;
         Image company = new Image(this.getClass().getClassLoader().getResourceAsStream("res/createCompany.png"));
         companyImage.setImage(company);
         
    }
    public void setPlayer(Player player) {
        this.player = player;
    }

    @FXML
    private void okMethod(ActionEvent event) throws Exception{
        Employee a = new Employee(nameField.getText(),0);
        HRController.CompanyList.add(a);
        HRController.comboList.add(nameField.getText());
        HRController ctr = (HRController) application.replaceSceneContent("HR.fxml", null);
              ctr.setApp(application);
    }
    @FXML
    private void cancelMethod(ActionEvent event) throws Exception{
         HRController ctr = (HRController) application.replaceSceneContent("HR.fxml", null);
              ctr.setApp(application);
    }
    public String getName()
    {
        return nameField.getText();
    }    
}
