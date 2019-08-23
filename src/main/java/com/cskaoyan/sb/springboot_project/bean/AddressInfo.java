package com.cskaoyan.sb.springboot_project.bean;

public class AddressInfo {
    int userId;
    String address;
    int areaId;
    int cityId;
    int id;
    boolean isDefault;
    String mobile;
    String name;
    int provinceId;

    public AddressInfo() {
    }

    public AddressInfo(int userId, String address, int areaId, int cityId, int id, boolean isDefault, String mobile, String name, int provinceId) {
        this.userId = userId;
        this.address = address;
        this.areaId = areaId;
        this.cityId = cityId;
        this.id = id;
        this.isDefault = isDefault;
        this.mobile = mobile;
        this.name = name;
        this.provinceId = provinceId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
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

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    @Override
    public String toString() {
        return "AddressInfo{" +
                "userId=" + userId +
                ", address='" + address + '\'' +
                ", areaId=" + areaId +
                ", cityId=" + cityId +
                ", id=" + id +
                ", isDefault=" + isDefault +
                ", mobile='" + mobile + '\'' +
                ", name='" + name + '\'' +
                ", provinceId=" + provinceId +
                '}';
    }
}
