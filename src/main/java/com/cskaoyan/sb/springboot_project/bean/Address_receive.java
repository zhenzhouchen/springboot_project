package com.cskaoyan.sb.springboot_project.bean;

public class Address_receive {
    String detailedAddress;
    int id;
    boolean isDefault;
    String mobile;
    String name;

    public Address_receive() {
    }

    public Address_receive(String detailedAddress, int id, boolean isDefault, String mobile, String name) {
        this.detailedAddress = detailedAddress;
        this.id = id;
        this.isDefault = isDefault;
        this.mobile = mobile;
        this.name = name;
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(int aDefault) {
        if(aDefault==1)
            isDefault = true;
        else
            isDefault = false;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Address_receive{" +
                "detailedAddress='" + detailedAddress + '\'' +
                ", id=" + id +
                ", isDefault=" + isDefault +
                ", mobile='" + mobile + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
