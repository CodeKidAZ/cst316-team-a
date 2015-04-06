package setup;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;

public class InstallController extends AnchorPane{
	@FXML
	Button continueBtn;
	@FXML
	ComboBox<String> installLocationText;

	private Main application;
        
	public void setApp(Main app){
		application = app;
	}

    public void setInstallLocation(String str) {
    }
	
	@FXML
	void continueBtnClicked() throws Exception {
        String installLocation = installLocationText.getValue().toString();
		InstallController ctr = (InstallController) application.replaceSceneContent("Install.fxml", InstallController.class);
		ctr.setApp(application);
        ctr.setInstallLocation(installLocation);
	}

	@FXML
	void initialize(){
        installLocationText.getItems().addAll(new String[] {
            System.getenv("PROGRAMFILES") + "\\Enterpreneurship Simulator\\",
            System.getenv("USERPROFILE") + "\\Enterpreneurship Simulator\\"
        });
	}


}
