package de.cg.rb.ctrl;

import de.cg.rb.windows.MainWindow;
import de.cg.rb.windows.SettingsWindow;
import mdlaf.MaterialLookAndFeel;
import mdlaf.themes.JMarsDarkTheme;
import mdlaf.themes.MaterialLiteTheme;
import mdlaf.themes.MaterialOceanicTheme;

import javax.swing.*;
import java.util.Set;

public class Main {

    public static MainWindow mainWindow;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new MaterialLookAndFeel());
            MaterialLookAndFeel.changeTheme(new JMarsDarkTheme());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        mainWindow = new MainWindow();

        FileManager.loadConfig();

        Clock.start();
    }
}
