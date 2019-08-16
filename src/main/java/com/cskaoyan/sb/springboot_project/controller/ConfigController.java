package com.cskaoyan.sb.springboot_project.controller;

import com.cskaoyan.sb.springboot_project.bean.Litemall;
import com.cskaoyan.sb.springboot_project.mapper.ConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class ConfigController {

    @Autowired
    ConfigMapper configMapper;

    @GetMapping("/config/mall")
    public Map<String,Object> config_mall_get(){
        Map<String,Object> map =new HashMap<>();
        Litemall litemall = configMapper.query_litemall();
        map.put("data",litemall);
        map.put("errmsg","成功");
        map.put("errno",0);
        return map;
    }

    @PostMapping("/config/mall")
    public Map<String,Object> config_mall_post(@RequestBody Litemall litemall){
        Map<String,Object> map =new HashMap<>();
        int result  = configMapper.update_litemall(litemall);
        if(result==1) {
            map.put("errmsg", "成功");
        }
        map.put("errno",0);
        return map;
    }
}
