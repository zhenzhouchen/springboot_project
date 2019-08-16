package com.cskaoyan.sb.springboot_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping("/admin/auth")
public class LoginAdminController {

    @RequestMapping("/login")
    public Map<String,Object> login(){
        Map<String,Object> map = new HashMap<>();
        map.put("data","1");
        map.put("errmsg","成功");
        map.put("errno",0);
        return map;
    }

    @RequestMapping("/info")
    public Map<String,Object> info(){
        Map<String,Object> map = new HashMap<>();
        Map<String , Object> interMap = new HashMap<>();
        interMap.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        interMap.put("name","vincent");
        interMap.put("perms", new String[]{"*"});
        interMap.put("roles", new String[]{"超级管理员"});
        map.put("data",interMap);
        map.put("errmsg","成功");
        map.put("errno",0);
        return map;
    }
}
