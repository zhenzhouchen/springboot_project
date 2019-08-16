package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Ad;
import com.cskaoyan.sb.springboot_project.bean.Popularize.PopPage;

import java.util.List;

public interface AdService {

    List<Ad> listAd(PopPage popPage);
}
