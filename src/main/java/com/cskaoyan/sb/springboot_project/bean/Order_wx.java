package com.cskaoyan.sb.springboot_project.bean;

public class Order_wx {
    int uncomment;
    int unpaid;
    int unrecv;
    int unship;

    public Order_wx() {
    }

    public Order_wx(int uncomment, int unpaid, int unrecv, int unship) {
        this.uncomment = uncomment;
        this.unpaid = unpaid;
        this.unrecv = unrecv;
        this.unship = unship;
    }

    public int getUncomment() {
        return uncomment;
    }

    public void setUncomment(int uncomment) {
        this.uncomment = uncomment;
    }

    public int getUnpaid() {
        return unpaid;
    }

    public void setUnpaid(int unpaid) {
        this.unpaid = unpaid;
    }

    public int getUnrecv() {
        return unrecv;
    }

    public void setUnrecv(int unrecv) {
        this.unrecv = unrecv;
    }

    public int getUnship() {
        return unship;
    }

    public void setUnship(int unship) {
        this.unship = unship;
    }

    @Override
    public String toString() {
        return "Order_wx{" +
                "uncomment=" + uncomment +
                ", unpaid=" + unpaid +
                ", unrecv=" + unrecv +
                ", unship=" + unship +
                '}';
    }
}
