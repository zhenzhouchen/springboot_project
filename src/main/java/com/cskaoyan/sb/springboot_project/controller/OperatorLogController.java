package com.cskaoyan.sb.springboot_project.controller;

import com.cskaoyan.sb.springboot_project.bean.Log;
import com.cskaoyan.sb.springboot_project.service.OperatorLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller

public class OperatorLogController {
    @Autowired
    OperatorLogService operatorLogService;
    @RequestMapping("log/list")
    @ResponseBody
    public Map<String, Object> list(String page, String limit, String add_time, String desc) {
        List<Log> list = operatorLogService.returnList();
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> mapdata = new HashMap<>();
        int totals = operatorLogService.querytotals(page, limit, list);
        mapdata.put("items", list);
        mapdata.put("total", totals);
        map.put("data", mapdata);
        if (list != null) {
            map.put("errmsg", "成功");
            map.put("errno", 0);
        }
        return map;
    }
}
