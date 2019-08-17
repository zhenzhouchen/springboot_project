package com.cskaoyan.sb.springboot_project.bean;

public class AdminRoles {
    int value;
    String label;

    public AdminRoles() {
    }

    public AdminRoles(int value, String label) {
        this.value = value;
        this.label = label;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "AdminRoles{" +
                "value=" + value +
                ", label='" + label + '\'' +
                '}';
    }
}
