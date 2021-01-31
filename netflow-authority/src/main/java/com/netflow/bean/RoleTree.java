package com.netflow.bean;

import java.util.List;

/**
 * @author 汪培林
 * @data 2021-01-12  11:04:53
 */
public class RoleTree {

    private String id;
    private String label;
    private String type;
    private List<RoleVo> children;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<RoleVo> getChildren() {
        return children;
    }

    public void setChildren(List<RoleVo> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "RoleTree{" +
                "id='" + id + '\'' +
                ", label='" + label + '\'' +
                ", type='" + type + '\'' +
                ", children=" + children +
                '}';
    }
}
