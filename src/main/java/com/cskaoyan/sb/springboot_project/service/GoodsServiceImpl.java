package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Goods;
import com.cskaoyan.sb.springboot_project.bean.Goods_statistics;
import com.cskaoyan.sb.springboot_project.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;
    
    @Override
    public List<Goods> queryAllGoodsList(Integer goodsSn, String name) {
        List<Goods> Goodss = goodsMapper.queryAllGoodsList(goodsSn,name);
        return Goodss;
    }

    @Override
    public int updateDeleteById(Goods goods) {
        return goodsMapper.updateDeleteById(goods);
    }

    @Override
    public Goods queryById(Integer id) {
        return goodsMapper.queryById(id);
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
}
