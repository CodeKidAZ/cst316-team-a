package application;

import cst316.Management;
import cst316.Employee;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class HireController extends AnchorPane {
     Main application;
     Player player;
     Employee val = new Employee();
     Set<String> empObjects;
     int s = Management.empTree.size(); //get the size of Employee Tree Map
    String[] namesArray = new String[s]; //this array will store all Employee Names
    String[] wagesArray = new String[s];
    Image image;
 
    private ObservableList<Employee> tableData = FXCollections.observableArrayList(); 
    private TreeMap<String, Label> nameLabels = new TreeMap<String,Label>();
   
    

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Label hireTitleLabel;
    @FXML
    private Button backButton;
    @FXML
    private Button doneButton;
    @FXML
    private Label nameLabel1;
    @FXML
    private Label wageLabel1;
    @FXML
    private ImageView imageEmployee1;
    @FXML
    private Label wageLabel2;
    @FXML
    private Label nameLabel2;
    @FXML
    private ImageView imageEmployee2;
    @FXML
    private Label wageLabel3;
    @FXML
    private Label nameLabel3;
    @FXML
    private ImageView imageEmployee3;
    @FXML
    private Label wageLabel4;
    @FXML
    private Label nameLabel4;
    @FXML
    private ImageView imageEmployee4;
    @FXML
    private Label wageLabel5;
    @FXML
    private Label nameLabel5;
    @FXML
    private ImageView imageEmployee5;
    @FXML
    private Label wageLabel11;
    @FXML
    private Label nameLabel11;
    @FXML
    private Label wageLabel12;
    @FXML
    private Label nameLabel12;
    @FXML
    private ImageView imageEmployee12;
    @FXML
    private Label wageLabel6;
    @FXML
    private Label nameLabel6;
    @FXML
    private ImageView imageEmployee6;
    @FXML
    private Label wageLabel7;
    @FXML
    private Label nameLabel7;
    @FXML
    private Label wageLabel8;
    @FXML
    private Label nameLabel8;
    @FXML
    private Label wageLabel9;
    @FXML
    private Label nameLabel9;
    @FXML
    private Label wageLabel10;
    @FXML
    private Label nameLabel10;
    @FXML
    private Label wageLabel13;
    @FXML
    private Label nameLabel13;
    @FXML
    private Label wageLabel14;
    @FXML
    private Label nameLabel14;
    @FXML
    private Label wageLabel15;
    @FXML
    private Label nameLabel15;
    @FXML
    private ImageView imageEmployee7;
    @FXML
    private ImageView imageEmployee8;
    @FXML
    private ImageView imageEmployee9;
    @FXML
    private ImageView imageEmployee10;
    @FXML
    private ImageView imageEmployee11;
    @FXML
    private ImageView imageEmployee13;
    @FXML
    private ImageView imageEmployee14;
    @FXML
    private ImageView imageEmployee15;
    @FXML
    private TableView<Employee> table1;
    @FXML
    private TableColumn<Employee, String> nameColumn;
    @FXML
    private TableColumn<Employee, Number> wageColumn;
    @FXML
    private Button undoButton;
    @FXML
    private Label totalLabel;
    
    //_______________________________________________ BACK BUTTON
    @FXML
    private void backMethod(ActionEvent event) throws Exception {
        System.out.println("YOU CLICKED BACK");
        HRController ctr = (HRController) application.replaceSceneContent("HR.fxml", HRController.class);
        ctr.setApp(application);
        ctr.setPlayer(player);
    }
   //________________________________________________ DONE BUTTON
    @FXML
    private void doneMethod(ActionEvent event) 
    {
          for(Employee currentTab : tableData) //remove employees from Employement Tree and put them in Hired Tree
          {
              Management.empTree.remove(currentTab.getName());
              Management.hiredTree.put(currentTab.getName(), currentTab);
              
              createNameArray();                                        // refresh the array with new names
              createWageArray();                                       // refresh the array with new wages
              createEmployeeLabels();                                // show new employees on GUI after they are hired
              linkImagesToNames();              
          }
          System.out.println("Employment Tree is "+Management.empTree.size());
          System.out.println("Hired Tree is "+Management.hiredTree.size());
        
          totalLabel.setText("You have Hired : "+ tableData.size()+ "           Total Hired : "+ Management.hiredTree.size());
         clearTheTable();
         
    }
    //_________________________________________________CLEAR THE TABLE
    public void clearTheTable()
    {
        tableData.removeAll(tableData);                            // remove all nodes from linked list used by TableView
    }

    public void setPlayer(Player player) 
    {
        this.player = player;
    }

    public void setApp(Main app) {
        this.application = app;
        
        //____________________________________________________ Array of names , Array of wages
        createNameArray();
        createWageArray();
        image = new Image(this.getClass().getClassLoader().getResourceAsStream("res/employeeImage.png"));
        createEmployeeImages();
        createEmployeeLabels();
        linkImagesToNames();
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());    // -> is lambda expression
        wageColumn.setCellValueFactory(cellData -> cellData.getValue().getWageProperty()); 
        totalLabel.setText(" ");

    }

    //________________________________________________ IMAGE CLICK METHOD
    @FXML
    private void emp1Clicked(MouseEvent event) throws IOException
    {   
        System.out.println("  ");
        Object source = event.getSource();                                                    // getting the event source object
        String imageName = ((ImageView) source).getId();                              // converting  the source object to image object and then getting its name

        String employeeName = nameLabels.get(imageName).getText();            // get the employee name
        int employeeWage = Management.empTree.get(employeeName).getWage();   // get the employee wage
        Employee a = new Employee(employeeName, employeeWage);
         
        tableData.add(a);                                                                            // add Employee object to linked list 
        table1.setItems(tableData);                                                             // add the linked list to the TableView
        totalLabel.setText("You selected : "+ Integer.toString(tableData.size()) + "           Total Hired : "+ Management.hiredTree.size());              // show total employees clicked to hire

    }
    
    //_______________________________________________ CREATE NAME ARRAY 
    public void createNameArray()
    {
        Set<String> setNames = Management.empTree.keySet();  //get keys from Employee Tree Map
        int p = 0;
        for (String key: setNames)
        {
            String value = Management.empTree.get(key).getName();
            namesArray[p] = value;
            p++;
        }
        
    }
    public void createWageArray()
    {
         Set<String> setNames = Management.empTree.keySet();  //get keys from Employee Tree Map
          int q=0;
         for (String key: setNames)
        {
            String u = Integer.toString(Management.empTree.get(key).getWage());
            wagesArray[q] = u;
            q++;
        }
        
    }

    @FXML
    private void undoMethod(ActionEvent event) 
    {
        int selectedIndex = table1.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) 
        {
            table1.getItems().remove(selectedIndex);                               //remove the selected item from TableView
            totalLabel.setText(Integer.toString(tableData.size()));               // show total employees selected to hire
            
            System.out.println("empTree is "+Management.empTree.size());
            System.out.println("HireTree is  "+Management.hiredTree.size());
            
        }
        else
        {
            System.out.println(" nothing");
        }
    }

    //__________________________________________________Shows employee images on GUI
    private void createEmployeeImages() 
    {
        imageEmployee1.setImage(image);
        imageEmployee2.setImage(image);
        imageEmployee3.setImage(image);
        imageEmployee4.setImage(image);
        imageEmployee5.setImage(image);
        
        imageEmployee6.setImage(image);
        imageEmployee7.setImage(image);
        imageEmployee8.setImage(image);
        imageEmployee9.setImage(image);
        imageEmployee10.setImage(image);
        
        imageEmployee11.setImage(image);
        imageEmployee12.setImage(image);
        imageEmployee13.setImage(image);
        imageEmployee14.setImage(image);
        imageEmployee15.setImage(image);
    }

    //___________________________________________________ Shows employee names on GUI  (2 arrays used here)
    private void createEmployeeLabels() 
    {
         nameLabel1.setText(namesArray[0]);
         wageLabel1.setText(wagesArray[0]+"/hr");
         nameLabel2.setText(namesArray[1]);
         wageLabel2.setText(wagesArray[1]+"/hr");
         nameLabel3.setText(namesArray[2]);
         wageLabel3.setText(wagesArray[2]+"/hr");
         nameLabel4.setText(namesArray[3]);
         wageLabel4.setText(wagesArray[3]+"/hr");
         nameLabel5.setText(namesArray[4]);
         wageLabel5.setText(wagesArray[4]+"/hr");  
         nameLabel6.setText(namesArray[5]);
         wageLabel6.setText(wagesArray[5]+"/hr");
         
         nameLabel7.setText(namesArray[6]);
         wageLabel7.setText(wagesArray[6]+"/hr");
         nameLabel8.setText(namesArray[7]);
         wageLabel8.setText(wagesArray[7]+"/hr");
         nameLabel9.setText(namesArray[8]);
         wageLabel9.setText(wagesArray[8]+"/hr");
         nameLabel10.setText(namesArray[9]);
         wageLabel10.setText(wagesArray[9]+"/hr");  
         nameLabel11.setText(namesArray[10]);
         wageLabel11.setText(wagesArray[10]+"/hr");
         
         nameLabel12.setText(namesArray[11]);
         wageLabel12.setText(wagesArray[11]+"/hr");
         nameLabel13.setText(namesArray[12]);
         wageLabel13.setText(wagesArray[12]+"/hr");
         nameLabel14.setText(namesArray[13]);
         wageLabel14.setText(wagesArray[13]+"/hr");
         nameLabel15.setText(namesArray[14]);
         wageLabel15.setText(wagesArray[14]+"/hr");
        
    }

    private void linkImagesToNames() 
    {
        //________________________________________________KEY: ImageName VALUE: LabelName ( 1 Tree Map nameLabels)
         nameLabels.put(imageEmployee1.getId(), nameLabel1);
         nameLabels.put(imageEmployee2.getId(), nameLabel2);
         nameLabels.put(imageEmployee3.getId(), nameLabel3);
         nameLabels.put(imageEmployee4.getId(), nameLabel4);
         nameLabels.put(imageEmployee5.getId(), nameLabel5);
         
         nameLabels.put(imageEmployee6.getId(), nameLabel6);
         nameLabels.put(imageEmployee7.getId(), nameLabel7);
         nameLabels.put(imageEmployee8.getId(), nameLabel8);
         nameLabels.put(imageEmployee9.getId(), nameLabel9);
         nameLabels.put(imageEmployee10.getId(), nameLabel10);
         
         nameLabels.put(imageEmployee11.getId(), nameLabel11);
         nameLabels.put(imageEmployee12.getId(), nameLabel12);
         nameLabels.put(imageEmployee13.getId(), nameLabel13);
         nameLabels.put(imageEmployee14.getId(), nameLabel14);
         nameLabels.put(imageEmployee15.getId(), nameLabel15);
    }
}
