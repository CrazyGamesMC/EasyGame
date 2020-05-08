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
                new SettingsQuestion("Package"),
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
        var pckg = questions[0].getResult();
        var name = questions[1].getResult();
        var asRect = questions[2].getBoolResult();
        var spritePath = questions[3].getResult();
        var width = Integer.parseInt(questions[4].getResult());
        var height = Integer.parseInt(questions[5].getResult());
        var include = questions[6].getBoolResult();


        GlobalSettings.initializedObjects.add((new GameObject(
               width, height, asRect, include, pckg, name, spritePath
        )));

        GlobalSettings.updateElements();

        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));

    }
}
