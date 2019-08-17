package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Goods_attribute;
import com.cskaoyan.sb.springboot_project.mapper.Goods_attributeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
