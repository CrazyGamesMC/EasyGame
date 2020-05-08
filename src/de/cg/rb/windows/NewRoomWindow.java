package de.cg.rb.windows;

import de.cg.rb.ctrl.Main;
import de.cg.rb.ctrl.RoomSettings;
import de.cg.rb.ctrl.SettingsQuestion;

import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class NewRoomWindow extends SettingsWindow {
    public NewRoomWindow() {
        super("New Room", new SettingsQuestion("Name / Path", "room1"));
    }

    @Override
    public void onConfirm() {
        var name = questions[0].getResult();

        RoomSettings.roomObjects = new ArrayList<>();
        RoomSettings.name = name;
        RoomSettings.isInit = true;

        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
}
