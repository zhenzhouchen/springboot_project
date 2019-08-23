package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Goods;
import com.cskaoyan.sb.springboot_project.bean.Goods_statistics;
import com.cskaoyan.sb.springboot_project.mapper.GoodsMapper;
import com.cskaoyan.sb.springboot_project.mapper.Goods_attributeMapper;
import com.cskaoyan.sb.springboot_project.mapper.Goods_productMapper;
import com.cskaoyan.sb.springboot_project.mapper.Goods_specificationMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    Goods_attributeMapper attributeMapper;

    @Autowired
    Goods_specificationMapper specificationMapper;

    @Autowired
    Goods_productMapper productMapper;

    @Override
    public List<Goods> queryAllGoodsList(Integer goodsSn, String name) {
        List<Goods> Goodss = goodsMapper.queryAllGoodsList(goodsSn, name);
        return Goodss;
    }

    @Override
    public int updateDeleteById(Goods goods) {
        int i = goodsMapper.updateDeleteById(goods);
        int j = attributeMapper.deleteAttribute(goods);
        int m = productMapper.deleteProduct(goods);
        int n = specificationMapper.deleteSpecification(goods);
        int k = i + j + m + n;
        return k;
    }

    @Override
    public Goods queryById(Integer id) {
        return goodsMapper.queryById(id);
    }

    @Override
    public int queryByIdReturnInt(Integer id) {
        return goodsMapper.queryByIdReturnInt(id);
    }

    @Override
    public Integer queryCategoryIds(Integer id) {
        return goodsMapper.queryCategoryIds(id);
    }

    @Override
    public List<Goods_statistics> query_goods_statistics() {
        return goodsMapper.query_goods_statistics();
    }

    public int insertGoods(Goods goods) {
        return goodsMapper.insertGoods(goods);
    }

    @Override
    public int updateGoods(Goods goods) {
        return goodsMapper.updateByPrimaryKey(goods);
    }


    @Override
    public Map<String, Object> queryGoodsById(int categoryId, int page, int size){
        PageHelper.startPage(page, size);
        List<Goods> goods = goodsMapper.queryGoodsById(categoryId);


        PageInfo<Goods> total = new PageInfo<>(goods);

        Map<String, Object> goodsDetail = new HashMap<>();
        goodsDetail.put("goodsList", goods);
        goodsDetail.put("count", total);

        return goodsDetail;
    }

    @Override
    public Map<String, Object> queryRelatedByCateId(int id) {
        Goods goods = goodsMapper.queryById(id);
        List<Goods> goodsList = goodsMapper.queryGoodsById(goods.getCategoryId());
        Map<String, Object> map = new HashMap<>();
        map.put("goodsList", goodsList);

        return map;
    }
}
