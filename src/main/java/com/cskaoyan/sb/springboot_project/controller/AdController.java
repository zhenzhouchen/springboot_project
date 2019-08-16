package com.cskaoyan.sb.springboot_project.controller;

import com.cskaoyan.sb.springboot_project.bean.Ad;
import com.cskaoyan.sb.springboot_project.bean.Popularize.PopBaseResp;
import com.cskaoyan.sb.springboot_project.bean.Popularize.PopPage;
import com.cskaoyan.sb.springboot_project.service.AdService;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Controller
@RestController
@RequestMapping("admin")
public class AdController {

    @Autowired
    AdService adService;

    /**
     * —— 查询内容、模糊查询 ——
     * 1、判断是否有 name、content，
     *      可以在这里判断，也可以直接在数据库底层 if test判断
     */
    @RequestMapping("ad/list")
    public PopBaseResp<Map<String, Object>> listAd(PopPage popPage) {

        /*System.out.println(name);
        System.out.println(content);*/

        Map<String, Object> map = adService.listAd(popPage);

        PopBaseResp<Map<String, Object>> adPopBaseResp = new PopBaseResp<>();
        if (map == null) {
            setErrorInfo(adPopBaseResp, 1);
        } else {
            adPopBaseResp.setData(map);
            setErrorInfo(adPopBaseResp, 0);
        }

        return adPopBaseResp;
    }


    /**
     * —— 添加 ad ——
     */
    @RequestMapping("ad/create")
    public PopBaseResp<Ad> createAd(Ad ad) {
        Ad addedAd = adService.createAd(ad);

        PopBaseResp<Ad> mapPopBaseResp = new PopBaseResp<>();
        if (addedAd != null) {
            mapPopBaseResp.setData(addedAd);
            setErrorInfo(mapPopBaseResp, 0);
        } else {
            mapPopBaseResp.setData(addedAd);
            setErrorInfo(mapPopBaseResp, 1);
        }

        return mapPopBaseResp;
    }

    /**
     * —— 修改 ad ——
     */
    @RequestMapping("ad/update")
    public PopBaseResp<Ad> updateAd(Ad ad) {
        Ad updateAd = adService.updateAd(ad);

        PopBaseResp<Ad> mapPopBaseResp = new PopBaseResp<>();
        if (updateAd != null) {
            mapPopBaseResp.setData(updateAd);
            setErrorInfo(mapPopBaseResp, 0);
        } else {
            mapPopBaseResp.setData(updateAd);
            setErrorInfo(mapPopBaseResp, 1);
        }

        return mapPopBaseResp;
    }

    /**
     * —— 删除 ad ——
     */
    @RequestMapping("ad/delete")
    public PopBaseResp<Ad> deleteAd(Ad ad) {
        Ad deleteAd = adService.updateAd(ad);

        PopBaseResp<Ad> mapPopBaseResp = new PopBaseResp<>();
        if (deleteAd != null) {
            mapPopBaseResp.setData(deleteAd);
            setErrorInfo(mapPopBaseResp, 0);
        } else {
            setErrorInfo(mapPopBaseResp, 1);
        }

        return mapPopBaseResp;
    }


    /**
     * —— 添加成功、失败信息 ——
     */
    private void setErrorInfo(PopBaseResp popBaseResp, int isError) {
        if (isError == 0) {
            popBaseResp.setErrmsg("成功");
            popBaseResp.setErrno(0);
        } else {
            popBaseResp.setErrmsg("失败");
            popBaseResp.setErrno(1);
        }
    }

}
