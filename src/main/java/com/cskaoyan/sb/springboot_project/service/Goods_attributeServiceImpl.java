package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Goods;
import com.cskaoyan.sb.springboot_project.bean.Goods_attribute;
import com.cskaoyan.sb.springboot_project.bean.Goods_create;
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
    public void updateAttribute(Goods_create update) {
//        List<Integer> before = goodsAttributeMapper.queryDeleteId(goods);
//        List<Integer> after = new ArrayList<>();
//        for (Goods_attribute attribute:attributes){
//            Integer id = attribute.getId();
//            after.add(id);
//        }
//        List<Integer> delete = new ArrayList<>();
        if (goodsAttributeMapper.queryByGoodsId(update.getGoods().getId()).size() != 0) {
            goodsAttributeMapper.deleteAttribute(update.getGoods());
            if (update.getAttributes().size() != 0) {
                for (Goods_attribute attribute : update.getAttributes()) {
                    attribute.setGoodsId(update.getGoods().getId());
                }
                goodsAttributeMapper.insertAttribute(update.getAttributes());
            }
        } else {
            if (update.getAttributes().size() != 0) {
                for (Goods_attribute attribute : update.getAttributes()) {
                    attribute.setGoodsId(update.getGoods().getId());
                }
                goodsAttributeMapper.insertAttribute(update.getAttributes());
            }
        }
    }
}