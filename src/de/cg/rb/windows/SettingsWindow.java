package de.cg.rb.windows;

import de.cg.rb.ctrl.SettingsQuestion;

import javax.swing.*;
import java.awt.*;

public class SettingsWindow extends JFrame {

    protected SettingsQuestion[] questions;

    public SettingsWindow(String title, SettingsQuestion... questions) {
        this.questions = questions;

        setTitle(title);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setSize(500, 150+questions.length*70);

        initFields(questions);

        repaint(); validate();
    }

    private void initFields(SettingsQuestion[] questions) {
        var lblTitle = new JLabel(getTitle());
        lblTitle.setFont(new Font("Calibri", Font.BOLD, 30));
        lblTitle.setBounds(30,0, 300, 60);
        add(lblTitle);

        for (int i = 0; i<questions.length; i++) {
            var q = questions[i];

            var lbl = new JLabel(q.name);
            lbl.setBounds(10, 70+i*(40), 200, 30);
            add(lbl);

            if (q.type == SettingsQuestion.Type.STRING) {
                var textField = new JTextField();
                textField.setText(q.defaultString);
                textField.setBounds(220, 70 + i * (40), 200, 30);
                add(textField);

                q.textField = textField;
            }

            else if (q.type == SettingsQuestion.Type.CHECKBOX) {
                var checkBox = new JCheckBox();
                checkBox.setSelected(q.defaultBool);
                checkBox.setBounds(220, 70 + i * (40), 30, 30);
                add(checkBox);

                q.checkBox = checkBox;
            }
            questions[i] = q;
        }

        var btnConfirm = new JButton("CONFIRM");
        btnConfirm.setBounds(getWidth()/2-50, getHeight()-100, 100, 45);
        btnConfirm.addActionListener(e -> {
            onConfirm();
        });
        add(btnConfirm);
    }

    public void onConfirm() {

    }

}
