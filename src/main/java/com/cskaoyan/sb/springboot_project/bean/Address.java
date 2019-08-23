package com.cskaoyan.sb.springboot_project.bean;

import java.util.Date;

public class Address {
    private Integer id;

    private String name;

    private Integer userId;

    private Integer provinceId;

    private Integer cityId;

    private Integer areaId;

    private String address;

    private String mobile;

    boolean isDefault;

    private Date addTime;

    private Date updateTime;

    private Boolean deleted;

    String areaName;
    String cityName;
    String provinceName;

    public Address() {
    }

    public Address(Integer id, String name, Integer userId, Integer provinceId, Integer cityId, Integer areaId, String address, String mobile, boolean isDefault, Date addTime, Date updateTime, Boolean deleted, String areaName, String cityName, String provinceName) {
        this.id = id;
        this.name = name;
        this.userId = userId;
        this.provinceId = provinceId;
        this.cityId = cityId;
        this.areaId = areaId;
        this.address = address;
        this.mobile = mobile;
        this.isDefault = isDefault;
        this.addTime = addTime;
        this.updateTime = updateTime;
        this.deleted = deleted;
        this.areaName = areaName;
        this.cityName = cityName;
        this.provinceName = provinceName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

}