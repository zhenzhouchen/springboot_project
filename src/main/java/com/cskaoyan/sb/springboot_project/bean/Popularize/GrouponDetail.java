package com.cskaoyan.sb.springboot_project.bean.Popularize;

import com.cskaoyan.sb.springboot_project.bean.Goods;
import com.cskaoyan.sb.springboot_project.bean.Groupon;
import com.cskaoyan.sb.springboot_project.bean.Groupon_rules;
import javafx.scene.Group;

import java.util.List;

public class GrouponDetail {

    private Groupon groupon;

    private Goods goods;

    private Groupon_rules rules;

    private List<String> subGroupons;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Groupon_rules getRules() {
        return rules;
    }

    public void setRules(Groupon_rules rules) {
        this.rules = rules;
    }

    public Groupon getGroupon() {
        return groupon;
    }

    public void setGroupon(Groupon groupon) {
        this.groupon = groupon;
    }

    public List<String> getSubGroupons() {
        return subGroupons;
    }

    public void setSubGroupons(List<String> subGroupons) {
        this.subGroupons = subGroupons;
    }
}
