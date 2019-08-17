package com.cskaoyan.sb.springboot_project.controller;

import com.cskaoyan.sb.springboot_project.bean.User_statistics;
import com.cskaoyan.sb.springboot_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/admin")
public class StatisticsController {
    @Autowired
    UserService userService;
    @RequestMapping("/stat/user")
    public Map<String,Object> statistics_user(){
        Map<String,Object> map = new HashMap<>();
        Map<String,Object> mapInfo = new HashMap<>();
        List list_columns = new LinkedList();

        //查询前端需要的数据
        Date day = userService.query_user_statistics_day();
        int users = userService.query_user_statistics_users();


        list_columns.add("day");
        list_columns.add("users");
        mapInfo.put("columns",list_columns);

        //创建javaBean并将查询出的结果赋值
        User_statistics user_statistics = new User_statistics();
        user_statistics.setDay(day);
        user_statistics.setUsers(users);

        //封装javaBean为lists数组
        List list_bean = new LinkedList();
        list_bean.add(user_statistics);


        mapInfo.put("rows",list_bean);
        map.put("errmsg","成功");
        map.put("errno",0);
        map.put("data",mapInfo);
        return map;
    }
}
