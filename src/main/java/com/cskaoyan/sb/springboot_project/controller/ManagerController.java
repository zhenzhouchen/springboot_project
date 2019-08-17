package com.cskaoyan.sb.springboot_project.controller;


import com.cskaoyan.sb.springboot_project.service.ManagerService;
import com.cskaoyan.sb.springboot_project.bean.Admin;
import com.cskaoyan.sb.springboot_project.bean.AdminRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
//@RequestMapping("admin")
public class ManagerController {
    @Autowired
    ManagerService managerService;

    @RequestMapping("admin/list")
    @ResponseBody
    public Map<String, Object> list(String page, String limit, String add_time, String desc) {
        List<Admin> list = managerService.returnList();
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> mapdata = new HashMap<>();
        int totals = managerService.querytotals(page, limit, list);
        mapdata.put("items", list);
        mapdata.put("total", totals);
        map.put("data", mapdata);
        if (list != null) {
            map.put("errmsg", "成功");
            map.put("errno", 0);
        }
        return map;
    }

    @RequestMapping("role/options")
    @ResponseBody
    //value对应的是admin中的是roleIds，label对应的是role中的name；
    //根据左连接查询，分别查出roleIds和name然后封装到自建AdminRoles中，返回给list
    public Map<String, Object> option() {
        Map<String, Object> map = new HashMap<>();
        List<AdminRoles> list = managerService.queryRoles();
        map.put("data", list);
        if (list != null) {
            map.put("errmsg", "成功");
            map.put("errno", 0);
        }
        return map;
    }
}
