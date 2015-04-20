package application;
//

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

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
import cst316.Management;
import cst316.Player;

/**
 * FXML Controller class
 *
 * @author Sumit
 */
public class HRController extends AnchorPane {

    private Main application;
    private Player player;
    public static ObservableList<Company> CompanyList = FXCollections.observableArrayList(); // to store list of companies
    public static ObservableList<String> comboList = FXCollections.observableArrayList();
    public static TreeMap<String, Company> tree1 = new TreeMap<String, Company>();
    ArrayList<Company> companies;

    @FXML
    private Label hrTitleLabel;

    @FXML
    private Button workersListButt;
    @FXML
    private Button incorporateButton;

    @FXML
    private TableView<Company> companyTableView;
    @FXML
    private TableColumn<Company, String> companyNameColumn;

    @FXML
    private ImageView fireImage;
    @FXML
    private ImageView hireImage1;
    @FXML
    private ImageView createCompanyImage;
    @FXML
    private Button productButton;
    @FXML
    private TableColumn<?, ?> employeesColumn1;
    @FXML
    private TableColumn<?, ?> employeesColumn11;
    @FXML
    private Button deleteCompanyButt;
    @FXML
    private ComboBox<String> companyComboBox;
    @FXML
    private Label totalLabel;
    @FXML
    private TableColumn<Company, Number> employeesColumn;

    @FXML
    private void productMouseClicked(MouseEvent event) throws Exception {
        ProductManagementController ctr = (ProductManagementController) application.replaceSceneContent("ProductManagement.fxml", ProductManagementController.class);
        ctr.setApp(application);
    }
    public void setApp(Main app) {
        this.application = app;
        companyNameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());    // -> is lambda expression
        //employeesColumn.setCellValueFactory(cellData ->cellData.getValue().getTotalEmployeesProperty());
        Image fire = new Image(this.getClass().getClassLoader().getResourceAsStream("res/deleteEmployee.png"));
        fireImage.setImage(fire);
        Image hire = new Image(this.getClass().getClassLoader().getResourceAsStream("res/hireEmployee.png"));
        hireImage1.setImage(hire);
        Image company = new Image(this.getClass().getClassLoader().getResourceAsStream("res/createCompany.png"));
        createCompanyImage.setImage(company);
        this.player = application.getPlayer();

        if (comboList.size() == 0) {
            companies = player.getCompanyList();
            for (int i = 0; i < companies.size(); i++) {
                tree1.put(companies.get(i).getCompanyName(), (new Company(companies.get(i).getCompanyName())));
                System.out.println(tree1.keySet());
                System.out.println(companies.get(i).getCompanyName());

                comboList.add(companies.get(i).getCompanyName());
                CompanyList.add(new Company(companies.get(i).getCompanyName()));

            }
        
        } else {
            System.out.println("dont load player company data again");
        }

        int a = comboList.size();
        totalLabel.setText(Integer.toString(a));
        companyComboBox.setItems(comboList);
        companyTableView.setItems(CompanyList);
        companies = player.getCompanyList();
        System.out.println("com size is "+companies.size());

    }

    //____________________________________________________BACK BUTTON
    @FXML
    private void onBack() throws Exception {
        System.out.println("YOU CLICKED BACK");
        
        player.saveFile();
        LandingController ctr = (LandingController) application.replaceSceneContent("Landing.fxml", LandingController.class);
        ctr.setApp(application);

    }

	//_________________________________________________________HIRE
    @FXML
    private void openHire(MouseEvent event) throws Exception {
        System.out.println("YOU CLICKED HIRE");

        String a = companyComboBox.getValue(); //get selected company name
        for (int i = 0; i < companies.size(); i++) { //get selected company object from arraylist and pass it to HireController
            if (companies.get(i).getCompanyName() == a) {
                System.out.println("  ");
                System.out.println("Company current is " + companies.get(i).getCompanyName());
                System.out.println("  ");
                HireController ctr = (HireController) application.replaceSceneContent("Hire.fxml", null);
                ctr.setCompany(companies.get(i));
                ctr.setApp(application);
                ctr.setPlayer(player);

            } else {

            }
        }

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
        String a = companyComboBox.getValue(); //get selected company name
        
        for (int i = 0; i < companies.size(); i++) 
        { //get selected company object from arraylist and pass it to HireController
            if (companies.get(i).getCompanyName() == a) 
            {
                System.out.println("  ");
                System.out.println("Company current is " + companies.get(i).getCompanyName());
                System.out.println("  ");
                 FireController ctr = (FireController) application.replaceSceneContent("Fire.fxml", null);
                ctr.setCompany(companies.get(i));
                
                ctr.setApp(application);
                ctr.setPlayer(player);
            } 
            else 
            {

            }
        }

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

    

    public void setPlayer(Player player) {
        this.player = player;
    }

    @FXML
    private void deleteCompany(ActionEvent event) {
    }

    @FXML
    private void currentCompany(ActionEvent event) {
        System.out.println("YOU SELECTED " + companyComboBox.getSelectionModel().getSelectedItem());
    }
}
