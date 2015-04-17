/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import cst316.Company;
import cst316.Employee;
import cst316.Player;

/**
 *
 * @author Sumit
 */
public class DialogueController extends AnchorPane{

    private Main application;
    private Player player;
   
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
         this.player = application.getPlayer();
         
    }
    public void setPlayer(Player player) {
        this.player = player;
    }

    @FXML
    private void okMethod(ActionEvent event) throws Exception{
    	String name = nameField.getText();
        Employee employee = new Employee(name,0);
        HRController.CompanyList.add(employee);
        HRController.comboList.add(name);
        
        Company company = new Company(name);
        player.addCompanies(company);
        player.saveFile();
        
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
