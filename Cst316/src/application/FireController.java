package application;

import cst316.Company;
import cst316.Employee;
import cst316.Management;
import cst316.Player;
import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeMap;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class FireController extends AnchorPane {

    private Main application;
    private Player player;
    private ObservableList<Employee> tableData = FXCollections.observableArrayList();
    Company myCompany;

    @FXML
    private TableView<Employee> fireTable;
    @FXML
    private Button backButton;
    @FXML
    private Button fireButton;
    @FXML
    private Label hireTitleLabel;
    @FXML
    private Label totalHiredLabel;
    @FXML
    private TableColumn<Employee, String> nameColumn;
    @FXML
    private TableColumn<Employee, Number> wageColumn;
    @FXML
    private Label currentCompanyLabel;

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setApp(Main app) {
        this.application = app;
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
        wageColumn.setCellValueFactory(cellData -> cellData.getValue().getWageProperty());
        Set<String> setNames = myCompany.getHiredTree().keySet();  //get keys from Employee Tree Map
        for (String key : setNames) {
            String name = myCompany.hiredTree.get(key).getName();
            int wage = myCompany.hiredTree.get(key).getWage();
             Employee node = new Employee(name, wage);
            tableData.add(node);
        }
        System.out.println("out");
        fireTable.setItems(tableData);
        totalHiredLabel.setText("Total Hired : " + myCompany.getHiredTree().size());
        
    }
    @FXML
    private void backMethod(ActionEvent event) throws Exception {
        System.out.println("YOU CLICKED BACK");
        HRController ctr = (HRController) application.replaceSceneContent("HR.fxml", null);
        ctr.setApp(application);
        ctr.setPlayer(player);
    }

    @FXML
    private void fireMethod(ActionEvent event) {
        int selectedIndex = fireTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {

            Employee a = new Employee(fireTable.getSelectionModel().getSelectedItem().getName(), fireTable.getSelectionModel().getSelectedItem().getWage());
            myCompany.employmentTree.put(a.getName(), a);                                            // put the fired employee back into employement tree
            myCompany.fireEmployees(a); // remove employee from hired tree
            fireTable.getItems().remove(selectedIndex);                                 //remove the selected item from TableView 
            totalHiredLabel.setText("Total Hired : " + myCompany.getTotalHiredEmployees());

        } else {
            System.out.println(" nothing");
        }
    }

    public void setCompany(Company x) throws IOException {
        myCompany = x;
        currentCompanyLabel.setText(myCompany.getCompanyName());
        int s = myCompany.employmentTree.size(); //get the size of Employee Tree Map
        System.out.println("Company empTr  is " + myCompany.employmentTree.size());
        System.out.println("Company hiredTr is " + myCompany.getTotalHiredEmployees());

    }
}
