package com.cskaoyan.sb.springboot_project.bean;

import java.util.Date;

public class Order_statistics {
    String day;
    int orders;//订单量
    int customers;//下单的人数
    double amount;//订单总额
    double pcr;//客单价   订单总额/下单用户量

    public Order_statistics() {
    }

    public Order_statistics(String day, int orders, int customers, double amount, double pcr) {
        this.day = day;
        this.orders = orders;
        this.customers = customers;
        this.amount = amount;
        this.pcr = pcr;
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

    public int getCustomers() {
        return customers;
    }

    public void setCustomers(int customers) {
        this.customers = customers;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getPcr() {
        return pcr;
    }

    public void setPcr(double pcr) {
        this.pcr = pcr;
    }

    @Override
    public String toString() {
        return "Order_statistics{" +
                "day='" + day + '\'' +
                ", orders=" + orders +
                ", customers=" + customers +
                ", amount=" + amount +
                ", pcr=" + pcr +
                '}';
    }
}
