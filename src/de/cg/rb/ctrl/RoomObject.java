package de.cg.rb.ctrl;

public class RoomObject {

    public int x = 0, y = 0, w = 0, h = 0;

    public GameObject gameObject;

    public RoomObject(int x, int y, int w, int h, GameObject gameObject) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.gameObject = gameObject;
    }
}
