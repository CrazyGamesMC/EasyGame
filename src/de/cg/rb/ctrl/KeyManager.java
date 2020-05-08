package de.cg.rb.ctrl;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

    public static boolean CTRL_PRESSED = false;
    public static boolean SPACE_PRESSED = false;
    public static boolean SHIFT_PRESSED = false;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("keyPressed event for key " + e.getKeyChar());
        if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
            CTRL_PRESSED = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            SPACE_PRESSED = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
            SHIFT_PRESSED = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("keyReleased event for key " + e.getKeyChar());

        if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
            CTRL_PRESSED = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            SPACE_PRESSED = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
            SHIFT_PRESSED = false;
        }
    }
}
