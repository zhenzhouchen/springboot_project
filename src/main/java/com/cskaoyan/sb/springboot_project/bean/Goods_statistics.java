package com.cskaoyan.sb.springboot_project.bean;

public class Goods_statistics {
    String day;
    int orders;
    int products;
    double amount;

    public Goods_statistics() {
    }

    public Goods_statistics(String day, int orders, int products, double amount) {
        this.day = day;
        this.orders = orders;
        this.products = products;
        this.amount = amount;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day.substring(0,10);
    }

    public int getOrders() {
        return orders;
    }

    public void setOrders(int orders) {
        this.orders = orders;
    }

    public int getProducts() {
        return products;
    }

    public void setProducts(int products) {
        this.products = products;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Goods_statistics{" +
                "day='" + day + '\'' +
                ", orders=" + orders +
                ", products=" + products +
                ", amount=" + amount +
                '}';
    }
}
