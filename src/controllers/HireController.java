package controllers;
import application.MainA;
import java.net.URL;
import java.util.Hashtable;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class HireController implements Initializable 
{
     MainA a;
   
     Employee val = new Employee();
     Set<String> empObjects;
     
    //protected Hashtable<String, Employee> employees = new Hashtable<String,Employee>();
     TreeMap<String, Label> employeeLables = new TreeMap<String,Label>();
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
    
    int s = MainA.empTree.size(); //get the size of Employee Tree Map
    String[] namesArray = new String[s]; //this array will store all Employee Names
    String[] wagesArray = new String[s];
    Set<String> setNames = MainA.empTree.keySet();  //get keys from Employee Tree Map
    
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        Image image = new Image("images/employeeImage.png");
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
        
        
        
     
        int p = 0;
        for (String key: setNames)
        {
            String value = MainA.empTree.get(key).getName();
            namesArray[p] = value;
            p++;
        }
        int q=0;
         for (String key: setNames)
        {
            String u = Integer.toString(MainA.empTree.get(key).getWage());
            wagesArray[q] = u;
            //System.out.println("wages Array"+ q+ "is "+wagesArray[q]);
            q++;
        }
        System.out.println("wages Array length is "+wagesArray.length);
        
         nameLabel1.setText("Name: "+ namesArray[0]);
         wageLabel1.setText("Wage: "+ wagesArray[0]+"/hr");
         nameLabel2.setText("Name: "+namesArray[1]);
         wageLabel2.setText("Wage: "+wagesArray[1]+"/hr");
         nameLabel3.setText("Name: "+namesArray[2]);
         wageLabel3.setText("Wage: "+wagesArray[2]+"/hr");
         nameLabel4.setText("Name: "+namesArray[3]);
         wageLabel4.setText("Wage: "+wagesArray[3]+"/hr");
         nameLabel5.setText("Name: "+namesArray[4]);
         wageLabel5.setText("Wage: "+wagesArray[4]+"/hr");  
         
         
        
        
    }    

    @FXML
    private void backMethod(ActionEvent event) 
    {
        System.out.println("YOU CLICKED BACK");
        a.openHRScreen();
    }

    @FXML
    private void doneMethod(ActionEvent event) 
    {
         System.out.println("YOU CLICKED DONE");
         a.openHRScreen();
    }

    public void setMainA(MainA a) 
    {
        this.a = a;
    }

    @FXML
    private void emp1Clicked(MouseEvent event) 
    {
        nameLabel1.setText("this is employee 1");
        System.out.println("Source is "+ event.getSource());
        Object soruce = event.getSource();
        String imageName = ((Label) soruce).getId();
        System.out.println("imageName is "+imageName);
        
        
    }

    @FXML
    private void selectedEmployeeName(MouseEvent event) 
    {
        Object source = event.getSource();
        nameLabel1.textProperty().bind(nameLabel2.textProperty());
        String imageName = ((Label) source).getId();
        
        
        System.out.println("imageName is "+imageName);
        
    }
}
