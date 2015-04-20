package application;

import cst316.Employee;
import cst316.Management;
import cst316.Player;
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


public class WorkersListController extends AnchorPane
{
     Main application;
     Player player;
    @FXML
    private Label hrTitleLabel;
     @FXML
    private TableView<Employee> workerTable;
    private ObservableList<Employee> workerData = FXCollections.observableArrayList(); 
    @FXML
    private TableColumn<Employee, String> nameColumn;
    @FXML
    private TableColumn<Employee, Number> wageColumn;
    @FXML
    private Button backButton;
    
    //___________________________________________________________BACK BUTTON
     @FXML
    private void backMethod(ActionEvent event) throws Exception 
    {
        HRController ctr = (HRController) application.replaceSceneContent("HR.fxml", null);
        ctr.setApp(application);
    }
   
    //___________________________________________________________SET METHODS
     public void setApp(Main app) {
        this.application = app;
        
        System.out.println("init worker list controller");
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());    
        wageColumn.setCellValueFactory(cellData -> cellData.getValue().getWageProperty()); 
        
        System.out.println("hired Tree is : "+ Management.hiredTree.size());
        Set<String> setNames = Management.hiredTree.keySet();      //get keys from Employee Tree Map
      
        for (String key: setNames)
        {
            
            String employeeName = Management.hiredTree.get(key).getName();
             System.out.println("EmployeeNames are " + key);
            
            int employeeWage = Management.hiredTree.get(key).getWage();
            Employee node = new Employee(employeeName, employeeWage);
            workerData.add(node);
        }
         workerTable.setItems(workerData);
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
