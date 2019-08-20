package com.cskaoyan.sb.springboot_project.controller.popluarizeController;

import com.cskaoyan.sb.springboot_project.bean.Popularize.PopBaseResp;
import com.cskaoyan.sb.springboot_project.bean.Popularize.PopPage;
import com.cskaoyan.sb.springboot_project.service.GrouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
@RequestMapping("admin")
@RestController
public class GrouponController {

    @Autowired
    GrouponService grouponService;
    
    /**
     * —— 查询内容、模糊查询 ——
     * 1、判断是否有 name、content，
     *      可以在这里判断，也可以直接在数据库底层 if test判断
     */
    @RequestMapping("groupon/listRecord")
    public PopBaseResp<Map<String, Object>> listGroupon(PopPage popPage, String goodsId) {


        Map<String, Object> grouponResult = null;
        if (goodsId != null) {
            grouponResult = grouponService.searchGroupon(popPage, goodsId);
        } else {
            grouponResult = grouponService.listGroupon(popPage);
        }

        PopBaseResp<Map<String, Object>> grouponPopBaseResp = new PopBaseResp<>();
        if (grouponResult == null) {
            setErrorInfo(grouponPopBaseResp, 1);
        } else {
            grouponPopBaseResp.setData(grouponResult);
            setErrorInfo(grouponPopBaseResp, 0);
        }

        return grouponPopBaseResp;
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
