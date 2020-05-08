package de.cg.rb.ctrl;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class GlobalSettings {

    public static int selected = -1;
    public static int gridSize = 1;

    public static final String fileExtensionSettings = ".roombuilder";
    public static final String fileExtensionRoom = ".room";

    public static ArrayList<GameObject> initializedObjects = new ArrayList<>();

    public static void updateElements() {
        var em = Main.mainWindow.editPanel.elements;
        var data = new String[initializedObjects.size()];

        for (int i = 0; i<initializedObjects.size(); i++) {
            var obj = initializedObjects.get(i);
            data[i] = obj.name;
        }

        em.setListData(data);
        Main.mainWindow.editPanel.repaint();
        Main.mainWindow.editPanel.validate();
    }

}
