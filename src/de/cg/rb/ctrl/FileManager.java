package de.cg.rb.ctrl;

import de.cg.utils.data.DataHandler;
import de.cg.utils.files.CGFile;
import de.cg.utils.files.FileContents;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {

    public static void loadConfig() {
        try {
            CGFile cgf = new CGFile("config" + GlobalSettings.fileExtensionSettings);
            File file = cgf.getFile();

            if (!file.exists()) {
                file.createNewFile();
                return;
            }

            cgf.load();

            var contents = cgf.getContents();
            var dh = new DataHandler(contents);

            int len = contents.getArrayList().size();

            for (int i = 0; i<len; i++) {
                var row = dh.getRow(i);
                GameObject obj;

                int width = Integer.parseInt(row[0]);
                int height = Integer.parseInt(row[1]);
                boolean displayAsRect = Boolean.parseBoolean(row[2]);
                boolean include = Boolean.parseBoolean(row[3]);
                String name = row[4];
                String imgPath = row[5];

                if (imgPath.equals("NULL")) imgPath = "";

                obj = new GameObject(width, height, displayAsRect, include, name, imgPath);

                GlobalSettings.initializedObjects.add(obj);
            }

            GlobalSettings.updateElements();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void saveConfig() {
        try {
            var cgf = new CGFile("config" + GlobalSettings.fileExtensionSettings);
            var contents = new FileContents(new ArrayList<String>());

            for (GameObject obj : GlobalSettings.initializedObjects) {
                String toWrite = obj.width + ";" + obj.height + ";" + obj.displayAsRect + ";" + obj.includeWAndHInConstructor + ";" +
                                 obj.name + ";" + (obj.imgPath.equals("") ? "NULL" : obj.imgPath);
                contents.append(toWrite);
            }
            contents.print();
            cgf.setContents(contents);
            cgf.save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadRoom(String path) {

        RoomSettings.name = path;
        RoomSettings.isInit = true;
        RoomSettings.roomObjects.clear();

        try {
            var cgf = new CGFile(path);
            cgf.load();
            var fc = cgf.getContents();
            var dh = new DataHandler(fc);

            for (int i = 0; i<fc.getArrayList().size(); i++) {
                String[] parts = dh.getRow(i);

                String name = parts[0];
                GameObject target = null;

                for (var obj : GlobalSettings.initializedObjects) {
                    if (obj.name.equals(name)) {
                        target = obj;
                    }
                }

                if (target != null) {

                    int x = Integer.parseInt(parts[1]);
                    int y = Integer.parseInt(parts[2]);
                    int w = target.width;
                    int h = target.height;

                    if (target.includeWAndHInConstructor) {
                        w = Integer.parseInt(parts[3]);
                        h = Integer.parseInt(parts[4]);
                    }

                    RoomObject ro = new RoomObject(x,y,w,h,target);

                    RoomSettings.roomObjects.add(ro);
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveRoom() {
        if (RoomSettings.isInit) {
            try {
                var cgf = new CGFile(RoomSettings.name + GlobalSettings.fileExtensionRoom);
                var file = cgf.getFile();

                if (!file.exists()) file.createNewFile();

                var contents = new FileContents(new ArrayList<String>());

                for (RoomObject ro : RoomSettings.roomObjects) {
                    contents.append(

                            ro.gameObject.name + ";" +
                            ro.x + ";" +
                            ro.y + ";" +
                            (ro.gameObject.includeWAndHInConstructor
                                ? ro.w + ";" + ro.h
                                : "")

                    );
                }

                cgf.setContents(contents);
                cgf.save();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
