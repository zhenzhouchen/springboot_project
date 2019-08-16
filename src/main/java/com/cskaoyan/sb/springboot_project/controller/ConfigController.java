package com.cskaoyan.sb.springboot_project.controller;

import com.cskaoyan.sb.springboot_project.bean.Express;
import com.cskaoyan.sb.springboot_project.bean.Litemall;
import com.cskaoyan.sb.springboot_project.bean.Order_config;
import com.cskaoyan.sb.springboot_project.mapper.ConfigMapper;
import com.cskaoyan.sb.springboot_project.mapper.ExpressMapper;
import com.cskaoyan.sb.springboot_project.mapper.Order_configMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class ConfigController {

    @Autowired
    ConfigMapper configMapper;
    @Autowired
    ExpressMapper expressMapper;
    @Autowired
    Order_configMapper order_configMapper;

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


    @GetMapping("/config/express")
    public Map<String,Object> config_express_get(){
        Map<String,Object> map =new HashMap<>();
        Express express = expressMapper.query_express();
        map.put("data",express);
        map.put("errmsg","成功");
        map.put("errno",0);
        return map;
    }

    @PostMapping("/config/express")
    public Map<String,Object> config_express_post(@RequestBody Express express){
        Map<String,Object> map =new HashMap<>();
        int result  = expressMapper.update_express(express);
        if(result==1) {
            map.put("errmsg", "成功");
        }
        map.put("errno",0);
        return map;
    }

    @GetMapping("/config/order")
    public Map<String,Object> config_order_get(){
        Map<String,Object> map =new HashMap<>();
        Order_config order_config = order_configMapper.query_order_config();
        map.put("data",order_config);
        map.put("errmsg","成功");
        map.put("errno",0);
        return map;
    }

    @PostMapping("/config/order")
    public Map<String,Object> config_order_post(@RequestBody Order_config order_config){
        Map<String,Object> map =new HashMap<>();
        int result  = order_configMapper.update_order_config(order_config);
        if(result==1) {
            map.put("errmsg", "成功");
        }
        map.put("errno",0);
        return map;
    }
}
