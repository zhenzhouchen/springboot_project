package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Ad;
import com.cskaoyan.sb.springboot_project.bean.Popularize.PopPage;
import com.cskaoyan.sb.springboot_project.mapper.AdMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map<String,Object> listAdByCondition(PopPage popPage,String name,String content) {

        PageHelper.startPage(popPage.getPage(), popPage.getLimit());
        String a = "%" + name + "%";
        List<Ad> ads = adMapper.listAdByCondition(popPage.getSort(),popPage.getOrder(),name,content);

        PageInfo<Ad> pageInfo = new PageInfo<>(ads);
        long total = pageInfo.getTotal();

        Map<String, Object> data = new HashMap<>();
        data.put("items", ads);
        data.put("total",total);



        return data;
    }

    @Override
    public Ad createAd(Ad ad) {

        Date date = new Date();
        ad.setAddTime(date);
        ad.setUpdateTime(date);
        ad.setDeleted(false);

        int insert = adMapper.insert(ad);

        if (insert > 0) {
            return ad;
        } else
            return null;
    }

    @Override
    public Ad updateAd(Ad ad) {
        Date date = new Date();
        ad.setUpdateTime(date);

        int update = adMapper.updateByPrimaryKey(ad);
        if (update > 0) {
            return ad;
        } else
            return null;
    }
}
