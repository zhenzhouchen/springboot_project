package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Goods_specification;

import java.util.List;

public interface Goods_specificationService {
    List<Goods_specification> queryByGoodsId(Integer id);
}
