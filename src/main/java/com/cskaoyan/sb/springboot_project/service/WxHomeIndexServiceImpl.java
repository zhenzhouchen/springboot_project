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

    @Autowired
    CommentMapper commentMapper;

    @Autowired
    UserMapper userMapper;

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
        List<Keyword> defaultKeyword = keywordMapper.defaultKeyword();
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
        for (Integer i : categoryIdList) {
            Category category = categoryMapper.searchCategoryById(i);
            filterCategoryList.add(category);
        }
        data.put("count", count);
        data.put("filterCategoryList", filterCategoryList);
        data.put("goodsList", goodsList);
        return data;
    }

    @Override
    public List<String> searchHelper(String keyword) {
        List<String> list = searchHistoryMapper.searchHelper(keyword);
        return list;
    }

    @Override
    public void updateSearchHistory(Integer userId, String keyword) {
        //先在表里查找有无此搜索记录，若无则插入
        int i = searchHistoryMapper.selectByKeyword(userId, keyword);
        if (i == 0) {
            searchHistoryMapper.insertSearchHistory(userId, keyword);
        }
    }

    @Override
    public int clearHistory(Integer userId) {
        int i = searchHistoryMapper.updateDeletedByUserId(userId);
        return i;
    }

    @Override
    public Map<String, Object> couponMyList() {
        Map<String, Object> map = new HashMap<>();
        int count = couponMapper.countCouponMyList();
        List<Coupon> data = couponMapper.couponMyList();
        map.put("count", count);
        map.put("data", data);
        return map;
    }

    @Override//专题详情
    public Map<String, Object> topicDetail(Integer id) {
        Map<String, Object> data = new HashMap<>();
        List<Goods> goods = new ArrayList<>();
        Topic topic = topicMapper.topicDetail(id);
        data.put("goods", goods);
        data.put("topic", topic);
        return data;
    }

    @Override//专题联想
    public List<Topic> topicRelated(Integer id) {
        List<Topic> topics = topicMapper.topicRelated(id);
        return topics;
    }

    @Override//专题评论
    public Map<String, Object> commentList(Integer page, Integer valueId) {
        Map<String, Object> map = new HashMap<>();
        int count = commentMapper.selectCount(valueId);
        int currentPage = page;
        List<Object> data = new ArrayList<>();
        List<Comment> commentList = commentMapper.queryCommentListByValueId(valueId);
        for (Comment comment : commentList) {
            Map<String, Object> commentmap = new HashMap<>();
            Date addTime = comment.getAddTime();
            String content = comment.getContent();
            String[] picList = comment.getPicUrls();
            User userInfo = userMapper.queryAvatarUrlAndNickNameById(comment.getUserId());
            commentmap.put("addTime", addTime);
            commentmap.put("content", content);
            commentmap.put("picList", picList);
            commentmap.put("userInfo", userInfo);
            data.add(commentmap);
        }
        map.put("count", count);
        map.put("currentPage", currentPage);
        map.put("data", data);
        return map;
    }

    @Override
    public Comment commentPost(Comment comment) {
        //插入新评论，主键id和时间均为自增
        int i = commentMapper.insertComment(comment);
        //返回插入后自增的主键id，通过id查询刚刚插入的记录并返回data
        Comment comment1 = null;
        if (i == 1) {
            comment1 = commentMapper.selectCommentById(comment.getId());
        }
        return comment1;
    }

    @Override
    public Map<String, Object> commentCount(Integer valueId) {
        Map<String, Object> data = new HashMap<>();
        int allCount = commentMapper.selectCount(valueId);
        int hasPicCount = commentMapper.hasPicCountCount(valueId);
        data.put("allCount",allCount);
        data.put("hasPicCount",hasPicCount);
        return data;
    }
}
