package com.netflow.bean;

/**
 * @author 汪培林
 * @data 2021-01-06  21:49:11
 */
public class ResourceRole {

    private String id;
    private String roleId;
    private String resourceId;
    private Integer resourceType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public Integer getResourceType() {
        return resourceType;
    }

    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
    }

    @Override
    public String toString() {
        return "ResourceRole{" +
                "id='" + id + '\'' +
                ", roleId='" + roleId + '\'' +
                ", resourceId='" + resourceId + '\'' +
                ", resourceType=" + resourceType +
                '}';
    }
}
