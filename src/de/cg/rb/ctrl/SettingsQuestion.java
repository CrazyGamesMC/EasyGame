package de.cg.rb.ctrl;

import javax.swing.*;

public class SettingsQuestion {

    public boolean defaultBool = false;

    public String name;
    public String defaultString = "";

    public Type type = Type.STRING;

    public JTextField textField;
    public JCheckBox checkBox;

    public SettingsQuestion(String name) {
        this.name = name;
    }

    public SettingsQuestion(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    public SettingsQuestion(String name, String defaultString) {
        this(name);
        this.defaultString = defaultString;
    }

    public SettingsQuestion(String name, Type type, String defaultString) {
        this(name, type);
        this.defaultString = defaultString;
    }

    public SettingsQuestion(String name, Type type, boolean defaultBool) {
        this(name, type);
        this.defaultBool = defaultBool;
    }

    public enum Type {
        STRING, OPTIONAL_STRING, CHECKBOX;
    }




    public String getResult() {
        return textField.getText();
    }

    public boolean getBoolResult() {
        return checkBox.isSelected();
    }
}
