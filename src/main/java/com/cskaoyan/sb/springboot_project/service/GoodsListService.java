package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.GoodsList;

public interface GoodsListService {
    GoodsList[] queryGoodsList(Integer orderId);
}
