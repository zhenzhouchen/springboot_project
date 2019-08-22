package com.cskaoyan.sb.springboot_project.controller.popluarizeController;

import com.cskaoyan.sb.springboot_project.bean.Ad;
import com.cskaoyan.sb.springboot_project.bean.Popularize.BaseResp;
import com.cskaoyan.sb.springboot_project.bean.Popularize.PopPage;
import com.cskaoyan.sb.springboot_project.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     *
     *      TODO：模糊查询的直接显示（不加入查询内容）
     */
    @RequestMapping("ad/list")
    public BaseResp<Map<String, Object>> listAdByCondition(PopPage popPage, String name, String content) {

        /*System.out.println(name);
        System.out.println(content);*/

        Map<String, Object> map = adService.listAdByCondition(popPage,name,content);

        BaseResp<Map<String, Object>> adPopBaseResp = new BaseResp<>();
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
    public BaseResp<Ad> createAd(@RequestBody Ad ad) {
        Ad addedAd = adService.createAd(ad);

        BaseResp<Ad> mapPopBaseResp = new BaseResp<>();
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
    public BaseResp<Ad> updateAd(@RequestBody Ad ad) {
        Ad updateAd = adService.updateAd(ad);

        BaseResp<Ad> mapPopBaseResp = new BaseResp<>();
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
    public BaseResp<Ad> deleteAd(@RequestBody Ad ad) {
        ad.setDeleted(true);
        Ad deleteAd = adService.updateAd(ad);

        BaseResp<Ad> mapPopBaseResp = new BaseResp<>();
        if (deleteAd != null) {
            setErrorInfo(mapPopBaseResp, 0);
        } else {
            setErrorInfo(mapPopBaseResp, 1);
        }

        return mapPopBaseResp;
    }


    /**
     * —— 添加成功、失败信息 ——
     */
    private void setErrorInfo(BaseResp popBaseResp, int isError) {
        if (isError == 0) {
            popBaseResp.setErrmsg("成功");
            popBaseResp.setErrno(0);
        } else {
            popBaseResp.setErrmsg("失败");
            popBaseResp.setErrno(1);
        }
    }

}
