package com.cskaoyan.sb.springboot_project.controller;

import com.cskaoyan.sb.springboot_project.bean.Role;
import com.cskaoyan.sb.springboot_project.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class RoleController {
    @Autowired
    RoleService roleService;

    @RequestMapping("role/list")
    public Map<String, Object> query_role_list(int page, int limit, String name, String sort, String order) {
        PageHelper.startPage(page, limit);
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> info_map = new HashMap<>();
        List<Role> items = null;
        if (name == null) {
            items = roleService.queryAllRoleList(sort, order);

        } else {
            items = roleService.queryRoleList(name, sort, order);
        }
        PageInfo<Role> userPageInfo = new PageInfo<>(items);
        info_map.put("items", items);
        long total = userPageInfo.getTotal();

        info_map.put("total", total);
        info_map.put("items", items);
        map.put("errmsg", "成功");
        map.put("errno", 0);
        map.put("data", info_map);
        return map;
    }

    @RequestMapping("role/update")
    public Map<String,Object> update_role(@RequestBody Role role){
        Map<String,Object> map = new HashMap<>();
        int result = roleService.update_role(role);
        if(result==1) {
            map.put("errmsg", "成功");
        }
        map.put("errno",0);
        return map;
    }


    @RequestMapping("role/create")
    public Map<String,Object> create_role(@RequestBody Role role){
        Map<String,Object> map = new HashMap<>();
        int result = roleService.create_role(role);
        if(result==1) {
            map.put("errmsg", "成功");
        }
        map.put("errno",0);
        return map;
    }

    @RequestMapping("role/delete")
    public Map<String,Object> delete_role(@RequestBody Role role){
        Map<String,Object> map = new HashMap<>();
        int result = roleService.delete_role(role);
        if(result==1) {
            map.put("errmsg", "成功");
        }
        map.put("errno",0);
        return map;
    }

    @RequestMapping("role/permissions")
    public Map<String,Object> role_permissions(Integer roleId){
        Map<String,Object> map = new HashMap<>();
        map.put("errmsg", "成功");
        map.put("errno", 0);
        return map;
    }
}
