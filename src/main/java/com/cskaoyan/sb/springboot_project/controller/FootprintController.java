package com.cskaoyan.sb.springboot_project.controller;

import com.cskaoyan.sb.springboot_project.bean.Footprint;
import com.cskaoyan.sb.springboot_project.service.FootprintService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class FootprintController {
    @Autowired
    FootprintService footprintService;
    @RequestMapping("/footprint/list")
    @ResponseBody
    public Map<String,Object> query_footprint_list(int page,int limit,Integer userId,Integer goodsId){
        PageHelper.startPage(page,limit);
        Map<String,Object> map = new HashMap<>();
        Map<String,Object> info_map = new HashMap<>();
        List<Footprint> items =null;
        if(userId == null && goodsId ==null){
            items = footprintService.queryAllFootprintList();

        }else{
            items = footprintService.queryFootprintList(userId,goodsId);
        }
        PageInfo<Footprint> userPageInfo = new PageInfo<>(items);info_map.put("items",items);
        long total = userPageInfo.getTotal();
        info_map.put("total",total);
        info_map.put("items",items);
        map.put("errmsg","成功");
        map.put("errno",0);
        map.put("data",info_map);
        return map;
    }

}
