package application;

import java.net.URL;
import java.util.ResourceBundle;

import cst316.Building;
import cst316.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class BuildingChoiceController extends AnchorPane {

    @FXML
    private TextArea descriptionBox;
    @FXML
    private ComboBox<String> dropMenu;
    @FXML
    private Button returnButton;
    @FXML
    private ImageView buildingPicture;
    @FXML
    private Button purchaseButton;

    private Building output;
    private Main application;
    private Player player;
    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private Text doneText;

	public void setBuilding(Building output) {
		this.output = output;
		dropMenu.getSelectionModel().select(output.getName());
		Image image = new Image(getClass().getClassLoader().getResourceAsStream(output.getImage()));
		buildingPicture.setImage(image);
		descriptionBox.clear();
		descriptionBox.appendText("Cost: " + output.getTotalCost() + "\n");
		descriptionBox.appendText("Description: " + output.getDescription() + "\n");
	}

	// Event Listener on ComboBox[#dropMenu].onAction
	@FXML
	public void dropMenuFired(ActionEvent event) throws Exception {
		String name = (String) dropMenu.getSelectionModel().getSelectedItem().toString();
		setBuilding(new Building(name));
	}

	// Event Listener on Button[#returnButton].onAction
	@FXML
    public void returnButtonFired(ActionEvent event) throws Exception {
        LandingController ctr = (LandingController) application.replaceSceneContent("Landing.fxml", LandingController.class);
        ctr.setApp(application);
    }

    //@Override
    public void setApp(Main app) {
        application = app;
        player = app.getPlayer();
        dropMenu.getItems().addAll(Building.getAllBuildingNames());
         doneText.setText(null);
    }

    @FXML
    public void purchaseButtonFired(ActionEvent event) {
        if (player.getMoney() >= output.getTotalCost()) {
            player.getBuildings().add(output);
            player.setMoney(player.getMoney() - output.getTotalCost());
            doneText.setText("DONE");
        }
    }

}
