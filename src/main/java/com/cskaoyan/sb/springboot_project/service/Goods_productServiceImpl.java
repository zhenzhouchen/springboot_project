package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Goods_product;
import com.cskaoyan.sb.springboot_project.mapper.Goods_productMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Goods_productServiceImpl implements Goods_productService {
    @Autowired
    Goods_productMapper goodsProductMapper;

    @Override
    public List<Goods_product> queryByGoodsId(Integer id) {
        List<Goods_product> list = goodsProductMapper.queryByGoodsId(id);
        return list;
    }

}
