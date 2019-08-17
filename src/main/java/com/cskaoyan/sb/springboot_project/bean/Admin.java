package com.cskaoyan.sb.springboot_project.bean;


import java.util.Arrays;

public class Admin {
    int id;
    String username;
    String avatar;
    int[] roleIds;
    String password;

    public Admin() {
    }

    public Admin(int id, String username, String avatar, int[] roleIds, String password) {
        this.id = id;
        this.username = username;
        this.avatar = avatar;
        this.roleIds = roleIds;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int[] getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(int[] roleIds) {
        this.roleIds = roleIds;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", avatar='" + avatar + '\'' +
                ", roleIds=" + Arrays.toString(roleIds) +
                ", password='" + password + '\'' +
                '}';
    }
}