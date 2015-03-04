
package application;

import controllers.*;
import java.io.BufferedReader;
import java.io.FileReader;

import java.io.IOException;
import static java.lang.System.in;
import java.util.TreeMap;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.json.JSONObject;
import CorpProcess.*;

public class MainA extends Application 
{
    Stage primaryStage;
    private AnchorPane root;
    public static int Number = 0;
    //public static TreeMap<String, Employee> empTree = new TreeMap<String,Employee>(); //to store all employee data
    //public static  TreeMap<String, Employee> hiredTree = new TreeMap<String,Employee>(); // to store all hired employees data
    
    
    
    @Override
    public void start(Stage primaryStage) 
    {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("The Entreprenuership Game");
        //openBuildingChoice();
        //openHRScreen();
        openCorpProcess();
    }
    public static void main(String[] args) 
    {
        launch(args);
    }
    public Stage getPrimaryStage() 
    {
        return primaryStage;
    }
    //___________________________________________________HR SCREEN
    public void openHRScreen() 
    {
        try 
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainA.class.getResource("/fxmlFiles/HR.fxml"));

            root = (AnchorPane) loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
            
           HRController controller = loader.getController();
           controller.setMainA(this);
            
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
    //____________________________________________________HIRE SCREEN
    public void openHireScreen()
    {
         try 
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainA.class.getResource("/fxmlFiles/hire.fxml"));
            
            root = (AnchorPane) loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
            
            HireController controller = loader.getController();
            controller.setMainA(this);
        } 
         catch (IOException e)
         {
             e.printStackTrace();
         }
    }
    //____________________________________________________FIRE SCREEN
    public void openFireScreen()
    {
         try 
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainA.class.getResource("/fxmlFiles/fire.fxml"));
            
            root = (AnchorPane) loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
            
            FireController controller = loader.getController();
            controller.setMainA(this);
        } 
         catch (IOException e)
         {
             e.printStackTrace();
         }
        
    }
    //_______________________________________________________ WORKERS LIST SCREEN
      public void openWorkersListScreen()
    {
         try 
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainA.class.getResource("/fxmlFiles/workersList.fxml"));
            
            root = (AnchorPane) loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
            
            WorkersListController controller = loader.getController();
            controller.setMainA(this);
        } 
         catch (IOException e)
         {
             e.printStackTrace();
         }
        
    }
      //__________________________________________________CORP PROCESS
      public void openCorpProcess()
      {
           try 
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainA.class.getResource("/CorpProcess/corp.fxml"));
            
            root = (AnchorPane) loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
            
            CorpController controller = loader.getController();
            controller.setMainA(this);
        } 
         catch (IOException e)
         {
             e.printStackTrace();
         }
      }
      //__________________________________________________CORP PROCESS 2 OF 5   
       public void openCorpProcess2of5()
      {
           try 
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainA.class.getResource("/CorpProcess/corp2of5.fxml"));
            
            root = (AnchorPane) loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
            
            Corp2of5Controller controller = loader.getController();
            controller.setMainA(this);
        } 
         catch (IOException e)
         {
             e.printStackTrace();
         }
      }
      
      
      
       //__________________________________________________CORP PROCESS 3 OF 5  
         public void openCorpProcess3of5()
      {
           try 
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainA.class.getResource("/CorpProcess/corp3of5.fxml"));
            
            root = (AnchorPane) loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
            
            Corp3of5Controller controller = loader.getController();
            controller.setMainA(this);
        } 
         catch (IOException e)
         {
             e.printStackTrace();
         }
      }
      
       //__________________________________________________CORP PROCESS 4 OF 5 
         public void openCorpProcess4of5()
      {
           try 
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainA.class.getResource("/CorpProcess/corp4of5.fxml"));
            
            root = (AnchorPane) loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
            
            Corp4of5Controller controller = loader.getController();
            controller.setMainA(this);
        } 
         catch (IOException e)
         {
             e.printStackTrace();
         }
      }
      
       //__________________________________________________CORP PROCESS 5 OF 5    
         public void openCorpProcess5of5()
      {
           try 
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainA.class.getResource("/CorpProcess/corp5of5.fxml"));
            
            root = (AnchorPane) loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
            
            Corp5of5Controller controller = loader.getController();
            controller.setMainA(this);
        } 
         catch (IOException e)
         {
             e.printStackTrace();
         }
      }
}
