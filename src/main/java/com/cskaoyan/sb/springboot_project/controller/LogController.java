package com.cskaoyan.sb.springboot_project.controller;

import com.cskaoyan.sb.springboot_project.service.LogService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("admin/log")
@RestController
public class LogController {

    @Autowired
    LogService logService;

    @RequestMapping("list")
    @ApiOperation(value = "selectLogList")
    public Map<String, Object> selectLogList(int page, int limit, String name, String sort, String order) {
        Map<String, Object> logMap = logService.selectLogList(page, limit, name, sort, order);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("data", logMap);
        if(logMap != null) {
            hashMap.put("errmsg", "成功");
            hashMap.put("errno", 0);
        } else {
            hashMap.put("errmag", "失败");
            hashMap.put("errno", 1);
        }
        return hashMap;
    }
}
