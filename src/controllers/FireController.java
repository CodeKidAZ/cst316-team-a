package controllers;
import application.MainA;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class FireController implements Initializable 
{
    private MainA a;
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
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());    // -> is lambda expression
        wageColumn.setCellValueFactory(cellData -> cellData.getValue().getWageProperty()); 
        
        System.out.println("hired Tree is : "+ MainA.hiredTree.size());
        Set<String> setNames = MainA.hiredTree.keySet();  //get keys from Employee Tree Map
        System.out.println("Names are " + setNames);
        for (String key: setNames)
        {
            
            String employeeName = MainA.hiredTree.get(key).getName();
             System.out.println("EmployeeNames are " + key);
            
            int employeeWage = MainA.hiredTree.get(key).getWage();
            Employee node = new Employee(employeeName, employeeWage);
            tableData.add(node);
        }
        fireTable.setItems(tableData);
        totalHiredLabel.setText("Total Hired : "+MainA.hiredTree.size());
    }    
    public void setMainA(MainA a)
    {
        this.a = a;
    }

    @FXML
    private void backMethod(ActionEvent event) 
    {
        System.out.println("YOU CLICKED BACK");
        a.openHRScreen();
    }

    @FXML
    private void fireMethod(ActionEvent event) 
    {
        int selectedIndex = fireTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) 
        {
            Employee a = new Employee(fireTable.getSelectionModel().getSelectedItem().getName(),fireTable.getSelectionModel().getSelectedItem().getWage());
            MainA.empTree.put(a.getName(), a);                                            // put the fired employee back into employement tree
            MainA.hiredTree.remove(fireTable.getSelectionModel().getSelectedItem().getName()); // remove employee from hired tree
            fireTable.getItems().remove(selectedIndex);                                 //remove the selected item from TableView 
            totalHiredLabel.setText("Total Hired : "+MainA.hiredTree.size());
            
            System.out.println("empTree is "+MainA.empTree.size());
            System.out.println("HireTree is  "+MainA.hiredTree.size());
        }
        else
        {
            System.out.println(" nothing");
        }
    }
}
