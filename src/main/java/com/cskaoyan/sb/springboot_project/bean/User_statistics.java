package com.cskaoyan.sb.springboot_project.bean;



public class User_statistics {
    String day;
    Integer users;

    public User_statistics() {
    }

    public User_statistics(String day, Integer users) {
        this.day = day;
        this.users = users;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Integer getUsers() {
        return users;
    }

    public void setUsers(Integer users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "User_statistics{" +
                "day='" + day + '\'' +
                ", users=" + users +
                '}';
    }
}
