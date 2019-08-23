package com.cskaoyan.sb.springboot_project.service;


import com.cskaoyan.sb.springboot_project.bean.*;
import com.cskaoyan.sb.springboot_project.mapper.*;
import com.cskaoyan.sb.springboot_project.util.UserTokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsWxServiceImpl implements GoodsWxService {

    @Autowired//info
    GoodsMapper goodsMapper;
    @Autowired
    BrandMapper brandMapper;
    @Autowired
    Goods_attributeMapper goods_attributeMapper;
    @Autowired
    Goods_specificationMapper goods_specificationMapper;
    @Autowired
    CommentMapper commentMapper;
    @Autowired//groupon
    Groupon_rulesMapper groupon_rulesMapper;
    @Autowired
    IssueMapper issueMapper;
    @Autowired
    Goods_productMapper goods_productMapper;
    @Autowired//没有用户收藏商品的表，无法查询
    CollectMapper collectMapper;

    @Override
    public ResponseVo selectGoodsDetail(int goodsId, HttpServletRequest request) {//goodsId
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        Goods goods = goodsMapper.selectGoodByGoodsId(goodsId);//info
        List<Goods_attribute> goods_attributeList = goods_attributeMapper.queryByGoodsId(goodsId);
        Brand brand = brandMapper.queryBrandByBrandId(goods.getBrandId());
        List<Comment> commentList = commentMapper.queryCommentByUserId(goodsId);
        int countComment = commentMapper.queryCommentCount(goodsId);
        Groupon_rulesExample groupon_rulesExample = new Groupon_rulesExample();
        groupon_rulesExample.createCriteria().andGoodsIdEqualTo(goodsId);
        List<Groupon_rules> groupon_rulesList = groupon_rulesMapper.selectByExample(groupon_rulesExample);
        List<Issue> issueList = issueMapper.queryIssueList();
        List<Goods_product> goods_productList = goods_productMapper.queryByGoodsId(goodsId);

        HashMap<String, Object> goodsDetailMap = new HashMap<>();
        goodsDetailMap.put("attribute", goods_attributeList);
        goodsDetailMap.put("brand", brand);
        HashMap<String, Object> comment = new HashMap<>();
        comment.put("count", countComment);
        comment.put("data", commentList);
        goodsDetailMap.put("comment", comment);
        goodsDetailMap.put("groupon", groupon_rulesList);
        goodsDetailMap.put("info", goods);
        goodsDetailMap.put("issue", issueList);
        goodsDetailMap.put("productList", goods_productList);
        goodsDetailMap.put("shareImage", "");
        HashMap<String, Object> specificationMap = new HashMap<>();
        List<String> goods_specificationNameList = goods_specificationMapper.querySpecificationNameByGoodsId(goodsId);
        for (String name : goods_specificationNameList) {
            List<Goods_specification> specificationList = goods_specificationMapper.querySpecificationByName(name, goodsId);
            specificationMap.put("name", name);
            specificationMap.put("valueList", specificationList);
        }
        ArrayList<HashMap> arrayList = new ArrayList<>();
        arrayList.add(specificationMap);
        goodsDetailMap.put("specificationList", arrayList);
        goodsDetailMap.put("userHasCollect", 0);
        return new ResponseVo<>(goodsDetailMap, "成功", 0);
    }

    @Override
    public ResponseVo selectRelatedGoods(int id) {
        id = id / 1000; //取商品号前三位
        List<Goods> goodsList = goodsMapper.selectRelatedGoods(id);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("goodsList", goodsList);
        return new ResponseVo(hashMap, "成功", 0);
}
}
