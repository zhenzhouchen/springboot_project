package com.cskaoyan.sb.springboot_project.bean;

import java.util.List;

public class CategoryList {

    private Integer value;

    private String label;

    private List<CategoryList_children> children;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<CategoryList_children> getChildren() {
        return children;
    }

    public void setChildren(List<CategoryList_children> children) {
        this.children = children;
    }
}
