package com.cskaoyan.sb.springboot_project.controller;

import com.cskaoyan.sb.springboot_project.bean.Search_history;
import com.cskaoyan.sb.springboot_project.service.Search_historyService;
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
public class Search_historyController {
    @Autowired
    Search_historyService search_historyService;
    @RequestMapping("/history/list")
    @ResponseBody
    public Map<String,Object> query_search_history_list(int page,int limit,Integer userId,String keyword,String sort,String order){
        PageHelper.startPage(page,limit);
        Map<String,Object> map = new HashMap<>();
        Map<String,Object> info_map = new HashMap<>();
        List<Search_history> items =null;
        if(userId == null && keyword ==null){
            items = search_historyService.queryAllHistoryList(sort,order);

        }else{
            items = search_historyService.queryHistoryList(userId,keyword,sort,order);
        }
        PageInfo<Search_history> userPageInfo = new PageInfo<>(items);info_map.put("items",items);
        long total = userPageInfo.getTotal();
        info_map.put("total",total);
        info_map.put("items",items);
        map.put("errmsg","成功");
        map.put("errno",0);
        map.put("data",info_map);
        return map;
    }
}
