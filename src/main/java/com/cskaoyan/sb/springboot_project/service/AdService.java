package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Ad;
import com.cskaoyan.sb.springboot_project.bean.Popularize.PopPage;

import java.util.Map;


public interface AdService {

    Map<String,Object> listAd(PopPage popPage);

    Ad createAd(Ad ad);

    Ad updateAd(Ad ad);
}
