package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Goods;
import com.cskaoyan.sb.springboot_project.bean.Goods_create;
import com.cskaoyan.sb.springboot_project.bean.Goods_specification;
import com.cskaoyan.sb.springboot_project.mapper.Goods_specificationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Goods_specificationServiceImpl implements Goods_specificationService {
    @Autowired
    Goods_specificationMapper goodsSpecificationMapper;

    @Override
    public List<Goods_specification> queryByGoodsId(Integer id) {
        List<Goods_specification> list = goodsSpecificationMapper.queryByGoodsId(id);
        return list;
    }

    @Override
    public int insertSpecification(List<Goods_specification> specifications, Goods goods) {
        for (Goods_specification specification : specifications) {
            specification.setGoodsId(Integer.valueOf(goods.getGoodsSn()));
        }
        return goodsSpecificationMapper.insertSpecification(specifications);
    }

    @Override
    public void updateSpecification(Goods_create update) {
        goodsSpecificationMapper.deleteSpecification(update.getGoods());
        if (update.getSpecifications().size() != 0) {
            for (Goods_specification specification : update.getSpecifications()) {
                specification.setGoodsId(update.getGoods().getId());
            }
            goodsSpecificationMapper.insertSpecification(update.getSpecifications());
        }
    }
}

