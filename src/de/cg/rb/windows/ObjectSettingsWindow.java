package de.cg.rb.windows;

import de.cg.rb.ctrl.RoomObject;
import de.cg.rb.ctrl.SettingsQuestion;

public class ObjectSettingsWindow extends SettingsWindow{

    private RoomObject ro;

    public ObjectSettingsWindow(RoomObject obj) {
        super("",
                new SettingsQuestion("X", "" + obj.x),
                new SettingsQuestion("Y", "" + obj.y),
                new SettingsQuestion("W", "" + obj.w),
                new SettingsQuestion("H", "" + obj.h));

        this.ro = obj;
    }

    @Override
    public void onConfirm() {
        int nx = Integer.parseInt(questions[0].getResult());
        int ny = Integer.parseInt(questions[1].getResult());
        int nw = Integer.parseInt(questions[2].getResult());
        int nh = Integer.parseInt(questions[3].getResult());

        ro.x = nx;
        ro.y = ny;
        ro.w = nw;
        ro.h = nh;

    }
}
