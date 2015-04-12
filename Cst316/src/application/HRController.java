package application;
//


import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import cst316.Company;
import cst316.Employee;
import cst316.Player;

/**
 * FXML Controller class
 *
 * @author Sumit
 */
public class HRController extends AnchorPane {

    @FXML
    private Label hrTitleLabel;

    @FXML
    private Button workersListButt;
    @FXML
    private Button incorporateButton;

    @FXML
    private TableView<Employee> companyTableView;
    @FXML
    private TableColumn<Employee, String> companyNameColumn;

    @FXML
    private ImageView fireImage;
    @FXML
    private ImageView hireImage1;
    @FXML
    private ImageView createCompanyImage;
    @FXML
    private Button productButton;

    private Main application;
    private Player player;
    public static ObservableList<Employee> CompanyList = FXCollections.observableArrayList(); // to store list of companies
    public static ObservableList<String> comboList = FXCollections.observableArrayList();

    @FXML
    private TableColumn<?, ?> employeesColumn1;
    @FXML
    private TableColumn<?, ?> employeesColumn11;
    @FXML
    private Button deleteCompanyButt;
    @FXML
    private ComboBox<String> companyComboBox;

    @FXML
    private void productMouseClicked(MouseEvent event) throws Exception {
        ProductManagementController ctr = (ProductManagementController) application.replaceSceneContent("ProductManagement.fxml", ProductManagementController.class);
        ctr.setApp(application);
    }

    //____________________________________________________BACK BUTTON
    @FXML
    private void onBack() throws Exception {
        System.out.println("YOU CLICKED BACK");
        LandingController ctr = (LandingController) application.replaceSceneContent("Landing.fxml", LandingController.class);
        ctr.setApp(application);

    }

    //_________________________________________________________HIRE

    @FXML
    private void openHire(MouseEvent event) throws Exception {
        System.out.println("YOU CLICKED HIRE");
        HireController ctr = (HireController) application.replaceSceneContent("Hire.fxml", HireController.class);
        ctr.setApp(application);
        ctr.setPlayer(player);
    }

    @FXML
    private void hireMouseExit(MouseEvent event) {
        hireImage1.setScaleX(1);
        hireImage1.setScaleY(1);
    }

    @FXML
    private void hireMouseEnter(MouseEvent event) {
        hireImage1.setScaleX(1.2);
        hireImage1.setScaleY(1.2);
    }

    //____________________________________________________FIRE
    @FXML
    private void fireMouseExit(MouseEvent event) {
        fireImage.setScaleX(1);
        fireImage.setScaleY(1);

    }

    @FXML
    private void fireMouseEnter(MouseEvent event) {
        fireImage.setScaleX(1.2);
        fireImage.setScaleY(1.2);

    }

    @FXML
    private void openFire(MouseEvent event) throws Exception {
        System.out.println("YOU CLICKED FIRE");
        FireController ctr = (FireController) application.replaceSceneContent("Fire.fxml", FireController.class);
        ctr.setApp(application);
        //ctr.setPlayer(player);

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
    private void openCorpScreen(ActionEvent event) {//throws Exception{
        try {
            CorpController ctr = (CorpController) application.replaceSceneContent("Corp.fxml", CorpController.class);
            ctr.setApp(application);
            ctr.setPlayer(player);
        } catch (Exception e) {
            System.out.println("exection");
        }
    }

    //____________________________________________________CREATE COMPANY

    @FXML
    private void createCompanyMouseExit(MouseEvent event) {
        createCompanyImage.setScaleX(1);
        createCompanyImage.setScaleY(1);
    }

    @FXML
    private void createCompanyMouseEnter(MouseEvent event) {
        createCompanyImage.setScaleX(1.2);
        createCompanyImage.setScaleY(1.2);
    }

    @FXML
    private void createCompany(MouseEvent event) {
        try {
            DialogueController ctr = (DialogueController) application.replaceSceneContent("Dialogue.fxml", null);
            ctr.setApp(application);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void setApp(Main app) {
        this.application = app;
        companyNameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());    // -> is lambda expression
        companyTableView.setItems(CompanyList);
        companyComboBox.setItems(comboList);
        Image fire = new Image(this.getClass().getClassLoader().getResourceAsStream("res/deleteEmployee.png"));
        fireImage.setImage(fire);
        Image hire = new Image(this.getClass().getClassLoader().getResourceAsStream("res/hireEmployee.png"));
        hireImage1.setImage(hire);
        Image company = new Image(this.getClass().getClassLoader().getResourceAsStream("res/createCompany.png"));
        createCompanyImage.setImage(company);
        this.player = application.getPlayer();
        
        ArrayList<Company> companies = player.getCompanyList();
        for(int i = 0; i<companies.size(); i++) {
        	CompanyList.add(new Employee(companies.get(i).getCompanyName(),0));
        	comboList.add(companies.get(i).getCompanyName());
        }
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @FXML
    private void deleteCompany(ActionEvent event) {
    }

}
