package com.cskaoyan.sb.springboot_project.controller;

import com.cskaoyan.sb.springboot_project.bean.User_statistics;
import com.cskaoyan.sb.springboot_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/admin")
public class StatisticsController {
    @Autowired
    UserService userService;
    @RequestMapping("/stat/user")
    public Map<String,Object> statistics_user() throws ParseException {
        Map<String,Object> map = new HashMap<>();
        Map<String,Object> mapInfo = new HashMap<>();
        List list_columns = new LinkedList();

        //查询前端需要的数据
        List<User_statistics> user_statistics_list = userService.query_user_statistics_bean();



        list_columns.add("day");
        list_columns.add("users");
        mapInfo.put("columns",list_columns);


        //封装javaBean为lists数组


        mapInfo.put("rows",user_statistics_list);
        map.put("errmsg","成功");
        map.put("errno",0);
        map.put("data",mapInfo);
        return map;
    }
}
