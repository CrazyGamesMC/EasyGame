package de.cg.rb.windows;

import de.cg.rb.ctrl.GlobalSettings;
import de.cg.rb.ctrl.SettingsQuestion;

import java.awt.event.WindowEvent;

public class GridWindow extends SettingsWindow {
    public GridWindow() {
        super("Grid", new SettingsQuestion("Grid Size", "" + GlobalSettings.gridSize));
    }

    @Override
    public void onConfirm() {
        int newSize = Integer.parseInt(questions[0].getResult());
        GlobalSettings.gridSize = newSize;

        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
}
