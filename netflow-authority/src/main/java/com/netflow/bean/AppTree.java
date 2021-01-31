package com.netflow.bean;

/**
 * @author 汪培林
 * @data 2021-01-11  21:56:08
 */
public class AppTree {

    private String id;
    private String label;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "AppTree{" +
                "id='" + id + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}
