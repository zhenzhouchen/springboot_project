package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.ResponseVo;

import javax.servlet.http.HttpServletRequest;

public interface GoodsWxService {
    ResponseVo selectGoodsDetail(int id, HttpServletRequest request);

    ResponseVo selectRelatedGoods(int id);
}
