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
        
	public void setApp(Main app) throws Exception {
		application = app;

        InstallController installer = new InstallController();
        installer.setGlobal(false);
        if (installer.getCurrentInstallLocation() != null) {
          installer = (InstallController) application.replaceSceneContent("Install.fxml", InstallController.class);
          installer.setApp(application);
          installer.setGlobal(false);
          installer.setInstallLocation(installer.getCurrentInstallLocation());
          installer.startUninstall();
        } else {
            installer.setGlobal(true);
            if (installer.getCurrentInstallLocation() != null) {
                installer = (InstallController) application.replaceSceneContent("Install.fxml", InstallController.class);
                installer.setApp(application);
                installer.setGlobal(true);
                installer.setInstallLocation(installer.getCurrentInstallLocation());
                installer.startUninstall();
            }
        }
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
            System.getenv("PROGRAMFILES") + "\\Entrepreneurship Simulator\\",
            System.getenv("USERPROFILE") + "\\Entrepreneurship Simulator\\"
        });
        installLocationText.getSelectionModel().select(System.getenv("PROGRAMFILES") + "\\Entrepreneurship Simulator\\");
	}


}
