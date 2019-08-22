package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.GoodsList;
import com.cskaoyan.sb.springboot_project.mapper.GoodsListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsListServiceImpl implements GoodsListService {
    @Autowired
    GoodsListMapper goodsListMapper;
    @Override
    public GoodsList[] queryGoodsList(Integer orderId) {
        return goodsListMapper.queryGoodsList(orderId);
    }
}
