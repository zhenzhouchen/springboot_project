package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Goods;
import com.cskaoyan.sb.springboot_project.bean.Groupon_rules;
import com.cskaoyan.sb.springboot_project.bean.Popularize.PopPage;
import com.cskaoyan.sb.springboot_project.mapper.GoodsMapper;
import com.cskaoyan.sb.springboot_project.mapper.Groupon_rulesMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Groupon_rulesServiceImp implements Groupon_rulesService {

    @Autowired
    Groupon_rulesMapper groupon_rulesMapper;

    @Autowired
    GoodsMapper goodsMapper;

    /**
     * —— 查询所有 groupon_rules ——
     * 1、传入分页参数
     * 2、利用 mapper 进行查询
     */
    @Override
    public Map<String,Object> listGroupon_rules(PopPage popPage) {

        PageHelper.startPage(popPage.getPage(), popPage.getLimit());
        List<Groupon_rules> groupon_ruless = groupon_rulesMapper.listGroupon_rulesByCondition(popPage.getSort(),popPage.getOrder());

        PageInfo<Groupon_rules> pageInfo = new PageInfo<>(groupon_ruless);
        long total = pageInfo.getTotal();

        Map<String, Object> data = new HashMap<>();
        data.put("items", groupon_ruless);
        data.put("total",total);

        return data;
    }

    @Override
    public Groupon_rules createGroupon_rules(Groupon_rules groupon_rules) {

        // 设置团购信息
        Date date = new Date();
        groupon_rules.setAddTime(date);
        groupon_rules.setUpdateTime(date);
        groupon_rules.setDeleted(false);

        // 根据 id 查询 商品内容
        Goods goods = goodsMapper.queryById(groupon_rules.getGoodsId());
        groupon_rules.setGoodsName(goods.getName());
        groupon_rules.setPicUrl(goods.getPicUrl());

        int insert = groupon_rulesMapper.insert(groupon_rules);

        if (insert > 0) {
            return groupon_rules;
        } else
            return null;
    }

    @Override
    public Groupon_rules updateGroupon_rules(Groupon_rules groupon_rules) {
        Date date = new Date();
        groupon_rules.setUpdateTime(date);

        // 根据 id 查询 商品内容
        Goods goods = goodsMapper.queryById(groupon_rules.getGoodsId());
        groupon_rules.setGoodsName(goods.getName());
        groupon_rules.setPicUrl(goods.getPicUrl());

        int update = groupon_rulesMapper.updateByPrimaryKey(groupon_rules);
        if (update > 0) {
            return groupon_rules;
        } else
            return null;
    }

    @Override
    public Map<String, Object> searchGroupon_rules(PopPage popPage, String id) {

        PageHelper.startPage(popPage.getPage(), popPage.getLimit());
        List<Groupon_rules> groupon_ruless = groupon_rulesMapper.searchGroupon_rulesByCondition(popPage.getSort(),popPage.getOrder(),"%"+id+"%");

        PageInfo<Groupon_rules> pageInfo = new PageInfo<>(groupon_ruless);
        long total = pageInfo.getTotal();

        Map<String, Object> data = new HashMap<>();
        data.put("items", groupon_ruless);
        data.put("total",total);

        return data;
    }

    @Override
    public Groupon_rules readGroupon_rulesById(String id) {

        Groupon_rules groupon_rules = groupon_rulesMapper.selectByPrimaryKey(Integer.valueOf(id));

        return groupon_rules;
    }
}
