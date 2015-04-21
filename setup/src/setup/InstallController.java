package setup;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
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
    private WinReg.HKEY regRootKey;
    private String startMenuLocation;

	public void setApp(Main app){
		application = app;
	}

    public void setGlobal(boolean bool) {
        global = bool;
        regRootKey = global ? WinReg.HKEY_LOCAL_MACHINE : WinReg.HKEY_CURRENT_USER;
        startMenuLocation = global ? "C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\Enterpreneurship Simulator" : System.getenv("APPDATA") + "\\Microsoft\\Windows\\Start Menu\\Programs\\Enterpreneurship Simulator";
    }

    public void setInstallLocation(String str) {
        installLocation = str;
    }

    public String getCurrentInstallLocation() {
        try {
            return Advapi32Util.registryGetStringValue(
                regRootKey,
                "SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\EnterpreneurshipSimulator",
                "InstallLocation"
            );
        } catch (Exception e) {
            return null;
        }
    }

    public void startUninstall() throws Exception {
        recursiveDelete(new File(installLocation));
        progress.setProgress(0.33);
        recursiveDelete(new File(startMenuLocation));
        progress.setProgress(0.66);
        Advapi32Util.registryDeleteKey(
            regRootKey,
            "SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Uninstall",
            "EnterpreneurshipSimulator"
        );
        progress.setProgress(1.00);
        continueBtn.setDisable(false);
    }

    public void startInstall() throws Exception {
        (new File(installLocation)).mkdir();
        progress.setProgress(0.00);
        copyFile("dist/Cst316.jar", installLocation + "\\Cst316.jar");
        copy((new File(Main.findPathJar(Main.class))).getCanonicalPath(), installLocation + "\\Cst316Setup.jar");
        progress.setProgress(0.14);
        copyFile("dist/enterpreneurship-simulator.ico", installLocation + "\\enterpreneurship-simulator.ico");
        progress.setProgress(0.28);
        Advapi32Util.registryCreateKey(
            regRootKey,
            "SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Uninstall",
            "EnterpreneurshipSimulator"
        );
        progress.setProgress(0.42);
        Advapi32Util.registrySetStringValue(
           regRootKey, 
            "SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\EnterpreneurshipSimulator",
            "DisplayName",
            "Enterprensurship Simulator"
        );
        progress.setProgress(0.56);
        Advapi32Util.registrySetStringValue(
            regRootKey,
            "SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\EnterpreneurshipSimulator",
            "UninstallString",
            Main.findPathJava() + " -jar \"" + installLocation + "\\Cst316Setup.jar\" admin"
        );
        progress.setProgress(0.70);
        Advapi32Util.registrySetStringValue(
            regRootKey,
            "SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\EnterpreneurshipSimulator",
            "DisplayIcon",
            installLocation + "\\enterpreneurship-simulator.ico"
        );
        Advapi32Util.registrySetStringValue(
            regRootKey,
            "SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\EnterpreneurshipSimulator",
            "InstallLocation",
            installLocation
        );
        progress.setProgress(0.84);
        Advapi32Util.registrySetStringValue(
            regRootKey,
            "SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Uninstall\\EnterpreneurshipSimulator",
            "DisplayVersion",
            "0.1"
        );
        progress.setProgress(0.98);
        (new File(startMenuLocation)).mkdir();
        createShortcut(installLocation + "\\Cst316.jar", startMenuLocation + "\\Enterprensurship Simulator", installLocation + "\\enterpreneurship-simulator.ico");
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

    private void copy(String src, String dest) throws Exception {
        FileInputStream in = new FileInputStream(src);
        FileOutputStream out = new FileOutputStream(dest);
        byte[] buffer = new byte[1024];
        int amount = in.read(buffer);
        while (amount != -1) {
          out.write(buffer, 0, amount);
          amount = in.read(buffer);
        }
    }

    private void createShortcut(String src, String dest, String icon) throws Exception {
        FileWriter out = new FileWriter(dest + ".URL");
        out.write("[InternetShortcut]\n");
        out.write("URL=file://" + src.replace("\\", "/") + "\n");
        if (!"".equals(icon)) {
            out.write("IconFile=" + icon + "\n");
        }
        out.flush();
        out.close();
    }

    private void recursiveDelete(File file) throws Exception {
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                recursiveDelete(f);
            }
        }
        file.delete();
    }
	
	@FXML
	void continueBtnClicked() throws Exception {
        System.exit(0);
	}

}
