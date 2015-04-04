package application;


import java.util.Random;
import cst316.Investment;
import cst316.Player;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class InvestmentController extends AnchorPane {

    @FXML
    Button continueBtn;
    @FXML
    ComboBox<String> companyCombo;
    @FXML
    TextField amountText;

    private Player player;

    private Main application;
    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private Button cancelBtn;
    @FXML
    private ImageView companyImage;
     Image Google = new Image(this.getClass().getClassLoader().getResourceAsStream("res/google.jpg"));
        Image RedHat = new Image(this.getClass().getClassLoader().getResourceAsStream("res/redhat.jpg"));
        Image Microsoft = new Image(this.getClass().getClassLoader().getResourceAsStream("res/microsoft.jpg"));
         //Image SOIL = new Image(this.getClass().getClassLoader().getResourceAsStream("res/soil.jpg"));

    public void setApp(Main app) {
       
        application = app;
        
        String[] allCompanyNames = Investment.getAllCompanyNames();
        ObservableList<String> items = companyCombo.getItems();
        for (String name : allCompanyNames) {
            items.add(name);
        }
        companyCombo.setItems(items);
        this.player = application.getPlayer();

      
    }
    public void setPlayer(Player player) {
        this.player = player;
    }

    @FXML
    public void onContinueClick() throws Exception {
        String companyName = companyCombo.getValue().toString();
        double amount = Double.parseDouble(amountText.getText());
        Random random = new Random();
        Investment investment = new Investment(companyName, amount, random.nextBoolean());
        LandingController ctr = (LandingController) application.replaceSceneContent("Landing.fxml", LandingController.class);
        player.addInvestment(investment);
        ctr.setApp(application);
    }

    @FXML
    public void onCancelClick() throws Exception {
        LandingController ctr = (LandingController) application.replaceSceneContent("Landing.fxml", LandingController.class);
        ctr.setApp(application);
    }

    @FXML
    private void companyDropDown(ActionEvent event) {
        String a = companyCombo.getSelectionModel().getSelectedItem().toString();
        System.out.println("a is" + a);
 
        switch (a) {
            case "SOIL":
                companyImage.setImage(Microsoft);
                break;
            case "Google":
                companyImage.setImage(Google);
                break;
            case "Red Hat":
                companyImage.setImage(RedHat);
                break;
            case "Microsoft":
                companyImage.setImage(Microsoft);
                break;
        }
    }

}
