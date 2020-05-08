package de.cg.rb.windows;

import de.cg.rb.ctrl.FileManager;
import de.cg.rb.ctrl.GlobalSettings;
import de.cg.rb.ctrl.KeyManager;
import de.cg.rb.ctrl.ResizeManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

public class MainWindow extends JFrame {

    public EditPanel editPanel;
    public RoomPanel roomPanel;

    private JMenuBar bar = new JMenuBar();

    private JMenu menuFile = new JMenu("File");
    private JMenu menuProject = new JMenu("Project");
    private JMenu menuEdit = new JMenu("Edit");

    private JMenuItem itemFileNew = new JMenuItem("New Room");
    private JMenuItem itemFileOpen = new JMenuItem("Open Room");
    private JMenuItem itemFileSave = new JMenuItem("Save Room");

    private JMenuItem itemProjectAddObject = new JMenuItem("Add Object");

    private JMenuItem itemEditGrid = new JMenuItem("Grid");

    public MainWindow() {

        initSelf();

        initMenuBar();

        initPanels();

        initEvents();

        repaint(); validate();

    }

    void initSelf() {
        setVisible(true);
        setSize(1280, 720);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        addComponentListener(new ResizeManager(this));

    }

    void initMenuBar() {
        bar.setBounds(0,0,210,40);

        itemFileNew.addActionListener(e -> new NewRoomWindow());
        menuFile.add(itemFileNew);

        itemFileOpen.addActionListener(e -> {
            var fc = new JFileChooser();
            fc.setCurrentDirectory(new File("").getAbsoluteFile());
            int result = fc.showOpenDialog(getParent());
            if (result == JFileChooser.APPROVE_OPTION) {
                var selected = fc.getSelectedFile();
                FileManager.loadRoom(selected.getAbsolutePath());
            }
        });
        menuFile.add(itemFileOpen);

        itemFileSave.addActionListener(e -> FileManager.saveRoom());
        menuFile.add(itemFileSave);

        bar.add(menuFile);



        itemProjectAddObject.addActionListener(e -> new AddObjectsWindow());
        menuProject.add(itemProjectAddObject);

        bar.add(menuProject);


        itemEditGrid.addActionListener(e -> new GridWindow());
        menuEdit.add(itemEditGrid);

        bar.add(menuEdit);

        add(bar);
    }

    void initPanels() {
        editPanel = new EditPanel();
        editPanel.setBounds(10, 50, 200, getHeight()-120);
        add(editPanel);

        roomPanel = new RoomPanel();
        roomPanel.setBounds(230, 50, getWidth()-250, getHeight()-60);
        roomPanel.setFocusable(true);
        add(roomPanel);

    }

    void initEvents() {
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                FileManager.saveConfig();
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }

}
