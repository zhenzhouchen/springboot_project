package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Popularize.PopPage;

import java.util.Map;

public interface GrouponService {
    Map<String,Object> listGroupon(PopPage popPage);

    Map<String, Object> searchGroupon(PopPage popPage, String goodsId);
}
