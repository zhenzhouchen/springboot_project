package com.cskaoyan.sb.springboot_project.bean;

import java.util.Arrays;

public class AdminLoginInfo {
    String name;
    String avatar;
    String[] perms;
    String[] roles;
    int [] roleIds;

    public AdminLoginInfo() {
    }

    public AdminLoginInfo(String name, String avatar, String[] perms, String[] roles, int[] roleIds) {
        this.name = name;
        this.avatar = avatar;
        this.perms = perms;
        this.roles = roles;
        this.roleIds = roleIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String[] getPerms() {
        return perms;
    }

    public void setPerms(String[] perms) {
        this.perms = perms;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public int[] getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(int[] roleIds) {
        this.roleIds = roleIds;
    }

    @Override
    public String toString() {
        return "AdminLoginInfo{" +
                "name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", perms=" + Arrays.toString(perms) +
                ", roles=" + Arrays.toString(roles) +
                ", roleIds=" + Arrays.toString(roleIds) +
                '}';
    }
}
