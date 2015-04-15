package setup;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import com.sun.jna.platform.win32.Advapi32Util;
import com.sun.jna.platform.win32.WinReg;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;

public class InstallController extends AnchorPane{
	@FXML
	Button continueBtn;
	@FXML
	ProgressBar progress;

	private Main application;
    private String installLocation;
    private boolean global;

	public void setApp(Main app){
		application = app;
	}

    public void setGlobal(boolean bool) {
        global = bool;
    }

    public void setInstallLocation(String str) {
        installLocation = str;
    }

    public void startInstall() throws Exception {
        (new File(installLocation)).mkdir();
        progress.setProgress(0.00);
        copyFile("dist/Cst316.jar", installLocation + "\\Cst316.jar");
        progress.setProgress(0.14);
        copyFile("dist/enterpreneurship-simulator.png", installLocation + "\\enterpreneurship-simulator.png");
        progress.setProgress(0.28);
        Advapi32Util.registryCreateKey(
            WinReg.HKEY_LOCAL_MACHINE,
            "SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Uninstall",
            "EnterpreneurshipSimulator"
        );
        progress.setProgress(0.42);
        Advapi32Util.registrySetStringValue(
            WinReg.HKEY_LOCAL_MACHINE,
            "SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\EnterpreneurshipSimulator",
            "DisplayName",
            "Enterprensurship Simulator"
        );
        progress.setProgress(0.56);
        Advapi32Util.registrySetStringValue(
            WinReg.HKEY_LOCAL_MACHINE,
            "SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\EnterpreneurshipSimulator",
            "UninstallString",
            installLocation + "\\Uninstall.jar"
        );
        progress.setProgress(0.70);
        Advapi32Util.registrySetStringValue(
            WinReg.HKEY_LOCAL_MACHINE,
            "SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\EnterpreneurshipSimulator",
            "DisplayIcon",
            installLocation + "\\enterpreneurship-simulator.png"
        );
        progress.setProgress(0.84);
        Advapi32Util.registrySetStringValue(
            WinReg.HKEY_LOCAL_MACHINE,
            "SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\EnterpreneurshipSimulator",
            "DisplayVersion",
            "0.1"
        );
        progress.setProgress(1.00);
        continueBtn.setDisable(false);
    }

    private void copyFile(String src, String dest) throws Exception {
        InputStream in = getClass().getClassLoader().getResourceAsStream(src);
        FileOutputStream out = new FileOutputStream(dest);
        byte[] buffer = new byte[1024];
        int amount = in.read(buffer);
        while (amount != -1) {
          out.write(buffer, 0, amount);
          amount = in.read(buffer);
        }
    }
	
	@FXML
	void continueBtnClicked() throws Exception {
        System.exit(0);
	}

}
