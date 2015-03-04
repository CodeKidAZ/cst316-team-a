package application;
import cst316.Employee;
import cst316.Management;
import cst316.Player;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

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
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
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

    private ObservableList<Employee> tableData = FXCollections.observableArrayList(); 
    @FXML
    private TableColumn<Employee, String> nameColumn;
    @FXML
    private TableColumn<Employee, Number> wageColumn;

    public void setPlayer(Player player) {
        this.player = player;
    }
    public void setApp(Main app) {
        this.application = app;

        nameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());    // -> is lambda expression
        wageColumn.setCellValueFactory(cellData -> cellData.getValue().getWageProperty()); 
        
        System.out.println("hired Tree is : "+ Management.hiredTree.size());
        Set<String> setNames = Management.hiredTree.keySet();  //get keys from Employee Tree Map
        System.out.println("Names are " + setNames);
        for (String key: setNames) {
            
            String employeeName = Management.hiredTree.get(key).getName();
             System.out.println("EmployeeNames are " + key);
            
            int employeeWage = Management.hiredTree.get(key).getWage();
            Employee node = new Employee(employeeName, employeeWage);
            tableData.add(node);
        }
        fireTable.setItems(tableData);
        totalHiredLabel.setText("Total Hired : "+Management.hiredTree.size());
    }

    @FXML
    private void backMethod(ActionEvent event) throws Exception {
        System.out.println("YOU CLICKED BACK");
        HRController ctr = (HRController) application.replaceSceneContent("HR.fxml", HRController.class);
        ctr.setApp(application);
        ctr.setPlayer(player);
    }

    @FXML
    private void fireMethod(ActionEvent event) {
        int selectedIndex = fireTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) 
        {
            Employee a = new Employee(fireTable.getSelectionModel().getSelectedItem().getName(),fireTable.getSelectionModel().getSelectedItem().getWage());
            Management.empTree.put(player.getName(), a);                                            // put the fired employee back into employement tree
            Management.hiredTree.remove(fireTable.getSelectionModel().getSelectedItem().getName()); // remove employee from hired tree
            fireTable.getItems().remove(selectedIndex);                                 //remove the selected item from TableView 
            totalHiredLabel.setText("Total Hired : "+Management.hiredTree.size());
            
            System.out.println("empTree is "+Management.empTree.size());
            System.out.println("HireTree is  "+Management.hiredTree.size());
        }
        else
        {
            System.out.println(" nothing");
        }
    }
}
