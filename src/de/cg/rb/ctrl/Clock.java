package de.cg.rb.ctrl;

public class Clock {

    public static void start() {
        while (true) {
            Main.mainWindow.roomPanel.repaint();
        }
    }

}
