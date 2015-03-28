package application;
//
import cst316.Employee;
import cst316.Player;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

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
    @FXML
    private Button workersListButt;
    @FXML
    private Button incorporateButton;
    @FXML
    private Button createCompanyButton;
    @FXML
    private TableView<Employee> CompanyTableView;
    @FXML
    private TableColumn<Employee, String> companyNameColumn;
    @FXML
    private TableColumn<Employee, Number> employeesColumn;

    private Main application;
    private Player player;
    public static ObservableList<Employee> CompanyList = FXCollections.observableArrayList(); // to store list of companies
   
    
    @FXML
    private void onBack() throws Exception {
        System.out.println("YOU CLICKED BACK");
        LandingController ctr = (LandingController) application.replaceSceneContent("Landing.fxml", LandingController.class);
        ctr.setApp(application);
       
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
    }
    //____________________________________________________OPEN WORKERS LIST SCREEN
    @FXML
    private void openWorkersList(ActionEvent event) throws Exception {
         WorkersListController ctr = (WorkersListController) application.replaceSceneContent("WorkersList.fxml", WorkersListController.class);
        ctr.setApp(application);
        ctr.setPlayer(player);
        
    }
  //____________________________________________________OPEN CORP SCREEN
    @FXML
    private void openCorpScreen(ActionEvent event) throws Exception{
        CorpController ctr = (CorpController) application.replaceSceneContent("Corp.fxml", CorpController.class);
        ctr.setApp(application);
        ctr.setPlayer(player);
    }
  //____________________________________________________CREATE COMPANY
    @FXML
    private void createCompany(ActionEvent event) {
    	TextInputDialog dialog = new TextInputDialog();
    	dialog.setTitle("HUMAN RESOURCE");
    	dialog.setHeaderText("Create a Company");
    	dialog.setContentText("Please enter new company name:");
    
    	Optional<String> result = dialog.showAndWait();
    	result.ifPresent(name -> System.out.println("Your name: " + name));
           System.out.println("Company Name is " + result.get());
           Employee a = new Employee(result.get()+".Corp",0);
           CompanyList.add(a);
           CompanyTableView.setItems(CompanyList); 
       
        //wageColumn.setCellValueFactory(cellData -> cellData.getValue().getWageProperty()); 
    }

    public void setApp(Main app) {
        this.application = app;
        this.player = application.getPlayer();
        companyNameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());    // -> is lambda expression
        CompanyTableView.setItems(CompanyList); 
        hireButton.setShape(new Circle(80));
        hireButton.setMinSize(80, 80);
       hireButton.setMaxSize(80, 80);
       
       fireButton.setShape(new Circle(80));
       fireButton.setMinSize(80, 80);
       fireButton.setMaxSize(80, 80);
      
      workersListButt.setShape(new Circle(80));
      workersListButt.setMinSize(80, 80);
      workersListButt.setMaxSize(80, 80);
     
     createCompanyButton.setShape(new Circle(80));
     createCompanyButton.setMinSize(80, 80);
     createCompanyButton.setMaxSize(80, 80);
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    
}
