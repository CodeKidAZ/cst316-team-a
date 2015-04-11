package setup;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;

public class WelcomeController extends AnchorPane{
	@FXML
	Button continueBtn;
	@FXML
	ComboBox<String> installLocationText;
    @FXML
    CheckBox isGlobalCheck;

	private Main application;
        
	public void setApp(Main app){
		application = app;
	}
	
	@FXML
	void continueBtnClicked() throws Exception {
        String installLocation = installLocationText.getValue().toString();
		InstallController ctr = (InstallController) application.replaceSceneContent("Install.fxml", InstallController.class);
		ctr.setApp(application);
        ctr.setInstallLocation(installLocation);
        ctr.setGlobal(isGlobalCheck.isSelected());
        ctr.startInstall();
	}

	@FXML
	void initialize(){
        installLocationText.getItems().addAll(new String[] {
            System.getenv("PROGRAMFILES") + "\\Enterpreneurship Simulator\\",
            System.getenv("USERPROFILE") + "\\Enterpreneurship Simulator\\"
        });
	}


}
