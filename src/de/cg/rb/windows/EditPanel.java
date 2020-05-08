package de.cg.rb.windows;

import de.cg.rb.ctrl.GlobalSettings;

import javax.swing.*;

public class EditPanel extends JPanel {

    public JList<String> elements = new JList<>();

    public EditPanel() {
        setVisible(true);
        setLayout(null);
        setBounds(0, 0, 1000, 700);


        elements.setBounds(0, 0, 200, 1000);
        add(elements);


        elements.addListSelectionListener((e) -> {
            GlobalSettings.selected = e.getFirstIndex();
        });
    }

}
