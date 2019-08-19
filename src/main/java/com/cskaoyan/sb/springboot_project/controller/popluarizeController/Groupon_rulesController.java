package com.cskaoyan.sb.springboot_project.controller.popluarizeController;

import com.cskaoyan.sb.springboot_project.bean.Coupon;
import com.cskaoyan.sb.springboot_project.bean.Groupon;
import com.cskaoyan.sb.springboot_project.bean.Groupon_rules;
import com.cskaoyan.sb.springboot_project.bean.Popularize.PopBaseResp;
import com.cskaoyan.sb.springboot_project.bean.Popularize.PopPage;
import com.cskaoyan.sb.springboot_project.service.CouponService;
import com.cskaoyan.sb.springboot_project.service.Groupon_rulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@ResponseBody
@RequestMapping("admin")
public class Groupon_rulesController {
    @Autowired
    Groupon_rulesService groupon_rulesService;

    /**
     * —— 查询内容、模糊查询 ——
     * 1、判断是否有 name、content，
     *      可以在这里判断，也可以直接在数据库底层 if test判断
     */
    @RequestMapping("groupon/list")
    public PopBaseResp<Map<String, Object>> listGroupon_rules(PopPage popPage, String goodsId) {


        Map<String, Object> groupon_rulesResult = null;
        if (goodsId != null) {
            groupon_rulesResult = groupon_rulesService.searchGroupon_rules(popPage, goodsId);
        } else {
            groupon_rulesResult = groupon_rulesService.listGroupon_rules(popPage);
        }

        PopBaseResp<Map<String, Object>> groupon_rulesPopBaseResp = new PopBaseResp<>();
        if (groupon_rulesResult == null) {
            setErrorInfo(groupon_rulesPopBaseResp, 1);
        } else {
            groupon_rulesPopBaseResp.setData(groupon_rulesResult);
            setErrorInfo(groupon_rulesPopBaseResp, 0);
        }

        return groupon_rulesPopBaseResp;
    }


    /**
     * —— 添加 groupon ——
     */
    @RequestMapping("groupon/create")
    public PopBaseResp<Groupon_rules> createGroupon_rules(@RequestBody Groupon_rules groupon_rules) {

        Groupon_rules createGroupon_rules = groupon_rulesService.createGroupon_rules(groupon_rules);

        PopBaseResp<Groupon_rules> mapPopBaseResp = new PopBaseResp<>();
        if (createGroupon_rules != null) {
            mapPopBaseResp.setData(createGroupon_rules);
            setErrorInfo(mapPopBaseResp, 0);
        } else {
            mapPopBaseResp.setData(createGroupon_rules);
            setErrorInfo(mapPopBaseResp, 1);
        }

        return mapPopBaseResp;
    }

    /**
     * —— 修改 coupon ——
     */
    @RequestMapping("groupon/update")
    public PopBaseResp<Groupon_rules> updateGroupon_rules(@RequestBody Groupon_rules groupon_rules) {
        Groupon_rules updateGroupon_rules = groupon_rulesService.updateGroupon_rules(groupon_rules);

        PopBaseResp<Groupon_rules> mapPopBaseResp = new PopBaseResp<>();
        if (updateGroupon_rules != null) {
            setErrorInfo(mapPopBaseResp, 0);
        } else {
            mapPopBaseResp.setData(updateGroupon_rules);
            setErrorInfo(mapPopBaseResp, 1);
        }

        return mapPopBaseResp;
    }

    /**
     * —— 删除 groupon_rules ——
     */
    @RequestMapping("groupon/delete")
    public PopBaseResp<Groupon_rules> deleteGroupon_rules(@RequestBody Groupon_rules groupon_rules) {
        groupon_rules.setDeleted(true);
        Groupon_rules deleteGroupon_rules = groupon_rulesService.updateGroupon_rules(groupon_rules);

        PopBaseResp<Groupon_rules> mapPopBaseResp = new PopBaseResp<>();
        if (deleteGroupon_rules != null) {
            setErrorInfo(mapPopBaseResp, 0);
        } else {
            setErrorInfo(mapPopBaseResp, 1);
        }

        return mapPopBaseResp;
    }

    /**
     * —— 显示详情 ——
     */
    @RequestMapping("groupon/read")
    public PopBaseResp<Groupon_rules> readGroupon_rules(@RequestBody String id) {
        Groupon_rules readGroupon_rules = groupon_rulesService.readGroupon_rulesById(id);
        PopBaseResp<Groupon_rules> mapPopBaseResp = new PopBaseResp<>();
        if (readGroupon_rules != null) {
            mapPopBaseResp.setData(readGroupon_rules);
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
