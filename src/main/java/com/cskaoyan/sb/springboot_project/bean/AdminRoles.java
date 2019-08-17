package com.cskaoyan.sb.springboot_project.bean;

public class AdminRoles {
    private int id;
    private int roleIds;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(int roleIds) {
        this.roleIds = roleIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AdminRoles{" +
                "id=" + id +
                ", roleIds=" + roleIds +
                ", name='" + name + '\'' +
                '}';
    }
}
