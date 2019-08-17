package com.cskaoyan.sb.springboot_project.bean;

import java.util.Date;

public class User_statistics {
    Date day;
    int users;

    public User_statistics() {
    }

    public User_statistics(Date day, int users) {
        this.day = day;
        this.users = users;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public int getUsers() {
        return users;
    }

    public void setUsers(int users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "User_statistics{" +
                "day=" + day +
                ", users=" + users +
                '}';
    }
}
