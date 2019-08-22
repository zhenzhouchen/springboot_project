package com.cskaoyan.sb.springboot_project.bean;

import java.util.List;
import java.util.Map;

public class WxHomeIndex {
    private List<Ad> banner;
    private List<Brand> brandList;
    private List<Category> channel;
    private List<Coupon> couponList;
    private Map<String,Object> floorGoodsList;//category-id,name;goods
    private Map<String,Object> grouponList;//groupon_rules;goods
    private List<Goods> hotGoodsList;
    private List<Goods> newGoodsList;
    private List<Topic> topicList;

    public List<Ad> getBanner() {
        return banner;
    }

    public void setBanner(List<Ad> banner) {
        this.banner = banner;
    }

    public List<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<Brand> brandList) {
        this.brandList = brandList;
    }

    public List<Category> getChannel() {
        return channel;
    }

    public void setChannel(List<Category> channel) {
        this.channel = channel;
    }

    public List<Coupon> getCouponList() {
        return couponList;
    }

    public void setCouponList(List<Coupon> couponList) {
        this.couponList = couponList;
    }

    public Map<String, Object> getFloorGoodsList() {
        return floorGoodsList;
    }

    public void setFloorGoodsList(Map<String, Object> floorGoodsList) {
        this.floorGoodsList = floorGoodsList;
    }

    public Map<String, Object> getGrouponList() {
        return grouponList;
    }

    public void setGrouponList(Map<String, Object> grouponList) {
        this.grouponList = grouponList;
    }

    public List<Goods> getHotGoodsList() {
        return hotGoodsList;
    }

    public void setHotGoodsList(List<Goods> hotGoodsList) {
        this.hotGoodsList = hotGoodsList;
    }

    public List<Goods> getNewGoodsList() {
        return newGoodsList;
    }

    public void setNewGoodsList(List<Goods> newGoodsList) {
        this.newGoodsList = newGoodsList;
    }

    public List<Topic> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<Topic> topicList) {
        this.topicList = topicList;
    }
}
