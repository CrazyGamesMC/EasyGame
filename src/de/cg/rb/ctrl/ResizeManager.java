package de.cg.rb.ctrl;

import de.cg.rb.windows.MainWindow;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowListener;

public class ResizeManager implements ComponentListener {

    private MainWindow win;

    public ResizeManager(MainWindow win) {
        this.win = win;
    }

    @Override
    public void componentResized(ComponentEvent e) {
        int nw = win.getWidth();
        int nh = win.getHeight();

        win.roomPanel.setSize(nw-250, nh-100);
        win.editPanel.setSize(win.editPanel.getWidth(), nh-100);

    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }
}
