package com.cskaoyan.sb.springboot_project.service;


import java.util.List;
import java.util.Map;

public interface WxHomeIndexService {
    Map<String,Object> queryAllIndexList();

    List<Integer> goodsCount();

    Map<String, Object> searchGoods();

    Map<String, Object> searchGoodslist(String keyword);
}
