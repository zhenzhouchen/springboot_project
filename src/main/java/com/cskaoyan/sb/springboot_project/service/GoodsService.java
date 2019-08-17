package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Goods;

import java.util.List;

public interface GoodsService {
    List<Goods> queryAllGoodsList(Integer goodsSn, String name);

    int updateDeleteById(Goods goods);

    Goods queryById(Integer id);

    List<String> queryCategoryIds(Integer id);
}
