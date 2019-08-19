package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Goods;
import com.cskaoyan.sb.springboot_project.bean.Goods_statistics;
import com.cskaoyan.sb.springboot_project.mapper.GoodsMapper;
import com.cskaoyan.sb.springboot_project.mapper.Goods_attributeMapper;
import com.cskaoyan.sb.springboot_project.mapper.Goods_productMapper;
import com.cskaoyan.sb.springboot_project.mapper.Goods_specificationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<String> queryCategoryIds(Integer id) {
        List<String> list = goodsMapper.queryCategoryIds(id);
        return list;
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
}
