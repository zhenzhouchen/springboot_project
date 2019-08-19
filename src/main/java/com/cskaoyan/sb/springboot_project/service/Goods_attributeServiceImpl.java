package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Goods;
import com.cskaoyan.sb.springboot_project.bean.Goods_attribute;
import com.cskaoyan.sb.springboot_project.mapper.Goods_attributeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Goods_attributeServiceImpl implements Goods_attributeService {
    @Autowired
    Goods_attributeMapper goodsAttributeMapper;

    @Override
    public List<Goods_attribute> queryByGoodsId(Integer goodsId) {
        List<Goods_attribute> list = goodsAttributeMapper.queryByGoodsId(goodsId);
        return list;
    }

    public int insertAttribute(List<Goods_attribute> attributes, Goods goods) {
        for (Goods_attribute attribute : attributes) {
            attribute.setGoodsId(Integer.valueOf(goods.getGoodsSn()));
        }
        return goodsAttributeMapper.insertAttribute(attributes);
    }

    @Override
    public int updateAttribute(List<Goods_attribute> attributes, Goods goods) {
//        List<Integer> before = goodsAttributeMapper.queryDeleteId(goods);
//        List<Integer> after = new ArrayList<>();
//        for (Goods_attribute attribute:attributes){
//            Integer id = attribute.getId();
//            after.add(id);
//        }
//        List<Integer> delete = new ArrayList<>();
        int i = goodsAttributeMapper.deleteAttribute(goods);
        for (Goods_attribute attribute : attributes) {
            attribute.setGoodsId(goods.getId());
        }
        int j = goodsAttributeMapper.insertAttribute(attributes);
        if (i > 0 && j > 0) {
            return 1;
        }
        return 0;
    }
}
