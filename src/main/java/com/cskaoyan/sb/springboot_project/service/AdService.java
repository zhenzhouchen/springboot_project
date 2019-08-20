package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Ad;
import com.cskaoyan.sb.springboot_project.bean.Popularize.PopPage;

import java.util.Map;


public interface AdService {

    Ad createAd(Ad ad);

    Ad updateAd(Ad ad);

    Map<String, Object> listAdByCondition(PopPage popPage, String name, String content);
}
