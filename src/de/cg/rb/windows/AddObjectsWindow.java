package de.cg.rb.windows;

import de.cg.rb.ctrl.GameObject;
import de.cg.rb.ctrl.GlobalSettings;
import de.cg.rb.ctrl.SettingsQuestion;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

public class AddObjectsWindow extends SettingsWindow {
    public AddObjectsWindow() {
        super("Add Object",
                new SettingsQuestion("Name"),
                new SettingsQuestion("Display as rectangle", SettingsQuestion.Type.CHECKBOX),
                new SettingsQuestion("Or as Sprite"),
                new SettingsQuestion("Width"),
                new SettingsQuestion("Height"),
                new SettingsQuestion("Include Width and Height in constructor?", SettingsQuestion.Type.CHECKBOX, true)
        );
    }

    @Override
    public void onConfirm() {
        //Fetch object data from questions.
        var name = questions[iota()].getResult();
        var asRect = questions[iota()].getBoolResult();
        var spritePath = questions[iota()].getResult();
        var width = Integer.parseInt(questions[iota()].getResult());
        var height = Integer.parseInt(questions[iota()].getResult());
        var include = questions[iota()].getBoolResult();


        GlobalSettings.initializedObjects.add((new GameObject(
               width, height, asRect, include, name, spritePath
        )));

        GlobalSettings.updateElements();

        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));

    }
}
