package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.*;
import com.cskaoyan.sb.springboot_project.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class WxHomeIndexServiceImpl implements WxHomeIndexService {
    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    AdMapper adMapper;

    @Autowired
    BrandMapper brandMapper;

    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    CouponMapper couponMapper;

    @Autowired
    Groupon_rulesMapper grouponRulesMapper;

    @Autowired
    TopicMapper topicMapper;

    @Autowired
    KeywordMapper keywordMapper;

    @Autowired
    Search_historyMapper searchHistoryMapper;

    //    private Map<String,Object> floorGoodsList;//category-id,name;goods
    @Override
    public Map<String, Object> queryAllIndexList() {
        Map<String, Object> data = new HashMap<>();
        List<Ad> banner = adMapper.banner();
        data.put("banner", banner);
        List<Brand> brandList = brandMapper.brandList();
        data.put("brandList", brandList);
        List<Category> channel = categoryMapper.channel();
        data.put("channel", channel);
        List<Coupon> couponList = couponMapper.couponList();
        data.put("couponList", couponList);
        //查询所有一级目录(id,name)，再查出这个一级目录所有的子目录，再查出所有属于子目录的商品
        List<Object> floorGoodsList = new ArrayList<>();
        List<Category> level1 = categoryMapper.queryIdForfloorGoodsList();
        for (Category category : level1) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", category.getId());
            map.put("name", category.getName());
            List<Integer> level2 = categoryMapper.queryId2ForfloorGoodsList(category.getId());
            List<Goods> goodsList = new ArrayList<>();
            for (Integer i : level2) {
                List<Goods> goods = goodsMapper.queryGoodsForfloorGoodsList(i);
                for (Goods goods1 : goods) {
                    goodsList.add(goods1);
                }
            }
            map.put("goodsList", goodsList);
            floorGoodsList.add(map);
        }
        data.put("floorGoodsList", floorGoodsList);
        //先查出所有团购规则，再通过团购规则的商品ID查出该商品，再做折扣计算
        List<Object> grouponList = new ArrayList<>();
        List<Groupon_rules> grouponRulesList = grouponRulesMapper.grouponList();
        for (Groupon_rules grouponRules : grouponRulesList) {
            Map<String, Object> list = new HashMap<>();
            Goods goods = goodsMapper.grouponList(grouponRules.getGoodsId());
            list.put("goods", goods);
            Integer groupon_member = grouponRules.getDiscountMember();
            list.put("groupon_member", groupon_member);
            BigDecimal groupon_price = goods.getRetailPrice().subtract(grouponRules.getDiscount());
            list.put("groupon_price", groupon_price);
            grouponList.add(list);
        }
        data.put("grouponList", grouponList);
        List<Goods> hotGoodsList = goodsMapper.hotGoodsList();
        data.put("hotGoodsList", hotGoodsList);
        List<Goods> newGoodsList = goodsMapper.newGoodsList();
        data.put("newGoodsList", newGoodsList);
        List<Topic> topicList = topicMapper.topicList();
        data.put("topicList", topicList);
        return data;
    }

    @Override
    public List<Integer> goodsCount() {
        Integer count = goodsMapper.count();
        List<Integer> goodsCount = new ArrayList<>();
        goodsCount.add(count);
        return goodsCount;
    }

    @Override
    public Map<String, Object> searchGoods() {
        Map<String, Object> data = new HashMap<>();
        Keyword defaultKeyword = keywordMapper.defaultKeyword();
        List<Keyword> hotKeywordList = keywordMapper.hotKeywordList();
        List<Search_history> historyKeywordList = searchHistoryMapper.historyKeywordList();
        data.put("defaultKeyword", defaultKeyword);
        data.put("historyKeywordList", historyKeywordList);
        data.put("hotKeywordList", hotKeywordList);
        return data;
    }

    @Override
    public Map<String, Object> searchGoodslist(String keyword) {
        Map<String, Object> data = new HashMap<>();
        Integer count = goodsMapper.searchGoodsCount(keyword);
        List<Goods> goodsList = goodsMapper.searchGoodslist(keyword);
        //将商品列表的目录id存入不重复的set集合中
        Set<Integer> categoryIdList = new HashSet<>();
        for (Goods goods : goodsList) {
            categoryIdList.add(goods.getCategoryId());
        }
        //遍历set集合取出该目录的所有信息，即category的bean
        List<Category> filterCategoryList = new ArrayList<>();
        for (Integer i:categoryIdList){
            Category category = categoryMapper.searchCategoryById(i);
            filterCategoryList.add(category);
        }
        data.put("count", count);
        data.put("filterCategoryList", filterCategoryList);
        data.put("goodsList", goodsList);
        return data;
    }
}
