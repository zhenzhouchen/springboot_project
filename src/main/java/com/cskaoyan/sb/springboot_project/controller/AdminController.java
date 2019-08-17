package com.cskaoyan.sb.springboot_project.controller;


import com.cskaoyan.sb.springboot_project.bean.Admin;
import com.cskaoyan.sb.springboot_project.bean.AdminRoles;
import com.cskaoyan.sb.springboot_project.service.AdminService;
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
@RequestMapping("admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @RequestMapping("admin/list")
    public Map<String, Object> list(int page, int limit, String username,String sort, String order) {
        PageHelper.startPage(page,limit);
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> info_map = new HashMap<>();
        List<Admin> items =null;
        if(username == null){
            items = adminService.queryAlladminlist(sort,order);

        }else{
            items = adminService.queryAdminList(username,sort,order);
        }
        //获取每页的总记录数
        PageInfo<Admin> userPageInfo = new PageInfo<>(items);info_map.put("items",items);
        long total = userPageInfo.getTotal();
        info_map.put("total",total);
        info_map.put("items",items);
        map.put("errmsg","成功");
        map.put("errno",0);
        map.put("data",info_map);
        return map;
    }

    @RequestMapping("role/options")
    public Map<String, Object> option() {
        Map<String, Object> map = new HashMap<>();
        List<AdminRoles> adminRolesList = adminService.queryAdminRole();
        map.put("data",adminRolesList);
        map.put("errmsg", "成功");
        map.put("errno", 0);
        return map;
    }

    @RequestMapping("admin/update")
    public Map<String,Object> admin_update(@RequestBody Admin admin){
        Map<String, Object> map = new HashMap<>();
        int result = adminService.upadte_admin(admin);
        if(result ==1) {
            map.put("errmsg", "成功");
        }
        map.put("errno", 0);
        return map;
    }

    @RequestMapping(value = "admin/delete")
    public Map<String,Object> admin_delete(@RequestBody Admin admin){
        Map<String, Object> map = new HashMap<>();
        int result = adminService.delete_admin(admin);
        if(result ==1) {
            map.put("errmsg", "成功");
        }
        map.put("errno", 0);
        return map;
    }

    @RequestMapping(value = "admin/create")
    public Map<String,Object> admin_create(@RequestBody Admin admin){
          Map<String, Object> map = new HashMap<>();
          int result = adminService.create_admin(admin);
          if(result ==1) {
            map.put("errmsg", "成功");
          }
          map.put("errno", 0);
          return map;
    }
}
