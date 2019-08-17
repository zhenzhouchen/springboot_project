package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Goods_statistics;

import java.util.List;

public interface GoodsService {
    List<Goods_statistics> query_goods_statistics();
}
