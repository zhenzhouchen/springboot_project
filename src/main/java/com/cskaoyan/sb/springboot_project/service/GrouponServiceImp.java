package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.*;
import com.cskaoyan.sb.springboot_project.bean.Popularize.GrouponDetail;
import com.cskaoyan.sb.springboot_project.bean.Popularize.PopPage;
import com.cskaoyan.sb.springboot_project.mapper.GoodsMapper;
import com.cskaoyan.sb.springboot_project.mapper.GrouponMapper;
import com.cskaoyan.sb.springboot_project.mapper.Groupon_rulesMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.acl.Group;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GrouponServiceImp implements GrouponService {

    @Autowired
    GrouponMapper grouponMapper;

    @Autowired
    Groupon_rulesMapper groupon_rulesMapper;

    @Autowired
    GoodsMapper goodsMapper;

    Logger logger = Logger.getLogger(this.getClass());

    /**
     * —— 查询所有 groupon ——
     * 1、根据 rulesid 查 rules
     * 2、得到 goodsId 查 goods
     * 3、
     */
    @Override
    public Map<String,Object> listGroupon(PopPage popPage) {

        // 先将 groupons 查出来，遍历一个一个装载到 GrouponDetail
        PageHelper.startPage(popPage.getPage(), popPage.getLimit());
        List<Groupon> groupons = grouponMapper.listGrouponByCondition(popPage.getSort(),popPage.getOrder());

        List<GrouponDetail> items = new ArrayList<>();

        // 遍历 groupons，查 rules、goods
        for (Groupon groupon : groupons) {
            Groupon_rules groupon_rules = groupon_rulesMapper.selectByPrimaryKey(groupon.getRulesId());
            Goods goods = goodsMapper.queryById(groupon_rules.getGoodsId());

            GrouponDetail grouponDetail = new GrouponDetail();
            grouponDetail.setGroupon(groupon);
            grouponDetail.setRules(groupon_rules);
            grouponDetail.setGoods(goods);
            grouponDetail.setSubGroupons(new ArrayList<>());

            items.add(grouponDetail);
        }

        logger.info("————————————————");

        // 对 GrouponDetail 分页
        PageInfo<GrouponDetail> pageInfo = new PageInfo<>(items);
        long total = pageInfo.getTotal();

        Map<String, Object> data = new HashMap<>();
        data.put("items", items);
        data.put("total",total);

        return data;

    }


    /**
     * —— 团购活动搜索 ——
     * 1、根据商品 id 搜索 团购规则
     * 2、根据团购规则列出 团购活动
     * 3、装载到 {@link GrouponDetail}
     */
    @Override
    public Map<String, Object> searchGroupon(PopPage popPage, String goodsId) {

        PageHelper.startPage(popPage.getPage(), popPage.getLimit());

        // 根据商品 id 获取团购规则 —— 从团购规则中查找，遍历 rules_id 获取 所有 id
        List<Groupon_rules> groupon_rules = groupon_rulesMapper.searchGroupon_rulesByCondition(popPage.getSort(), popPage.getOrder(), goodsId);
        List<Integer> rulesIds = new ArrayList<>();
        for (Groupon_rules groupon_rule : groupon_rules) {
            Integer id = groupon_rule.getId();
            rulesIds.add(id);
        }

        // 根据所有 rules_id，获取团购活动，并按规定内容排序
        List<Groupon> groupons = grouponMapper.listGrouponByRulesId(rulesIds);



        // 装载到 goodsDetail ，排序本来应该是前端干的，这里由于商品 id 有的可能不参加团购，还需要重新查
        List<GrouponDetail> items = new ArrayList<>();
        for (Groupon groupon : groupons) {
            Groupon_rules groupon_rule = groupon_rulesMapper.selectByPrimaryKey(groupon.getRulesId());
            Goods goods = goodsMapper.queryById(groupon_rule.getGoodsId());

            GrouponDetail grouponDetail = new GrouponDetail();
            grouponDetail.setGroupon(groupon);
            grouponDetail.setRules(groupon_rule);
            grouponDetail.setGoods(goods);
            grouponDetail.setSubGroupons(new ArrayList<>());

            items.add(grouponDetail);
        }


        PageInfo<GrouponDetail> pageInfo = new PageInfo<>(items);
        long total = pageInfo.getTotal();

        Map<String, Object> data = new HashMap<>();
        data.put("items", items);
        data.put("total",total);

        return data;
    }
}
