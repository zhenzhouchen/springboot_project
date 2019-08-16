package com.cskaoyan.sb.springboot_project.controller;

import com.cskaoyan.sb.springboot_project.bean.User;
import com.cskaoyan.sb.springboot_project.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class UserController {
    @Autowired
    UserService userService;


//会员管理列表
    @RequestMapping("/user/list")
    @ResponseBody
    public Map<String,Object> query_user_list(int page,int limit,String username,String mobile,String sort,String order){
        PageHelper.startPage(page,limit);
        Map<String,Object> map = new HashMap<>();
        Map<String,Object> info_map = new HashMap<>();
        List<User> items = null;
        if(username==null && mobile ==null){
            items = userService.queryAllUserList(sort,order);
        }else{
            items = userService.queryUserList(username,mobile,sort,order);
        }
        PageInfo<User> userPageInfo = new PageInfo<>(items);
        long total = userPageInfo.getTotal();
        info_map.put("items",items);
        info_map.put("total",total);
        map.put("errmsg","成功");
        map.put("errno",0);
        map.put("data",info_map);
        return map;
    }


}
