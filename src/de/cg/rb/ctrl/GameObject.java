package de.cg.rb.ctrl;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GameObject {

    public int width = 0;
    public int height = 0;

    public boolean displayAsRect;
    public boolean includeWAndHInConstructor;

    public String name;
    public String imgPath;

    public Image img;

    public GameObject(int width, int height, boolean displayAsRect, boolean includeWAndHInConstructor, String name, String imgPath) {
        this.width = width;
        this.height = height;
        this.displayAsRect = displayAsRect;
        this.includeWAndHInConstructor = includeWAndHInConstructor;
        this.name = name;
        this.imgPath = imgPath;

        if (imgPath != null && !imgPath.equals("")) {
            try {
                img = ImageIO.read(new File(imgPath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
