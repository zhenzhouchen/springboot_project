package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Ad;
import com.cskaoyan.sb.springboot_project.bean.Popularize.PopPage;
import com.cskaoyan.sb.springboot_project.mapper.AdMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdServiceImp implements AdService {

    @Autowired
    AdMapper adMapper;


    /**
     * —— 查询所有 ad ——
     * 1、传入分页参数
     * 2、利用 mapper 进行查询
     */
    @Override
    public List<Ad> listAd(PopPage popPage) {

        adMapper.

        return null;
    }
}
