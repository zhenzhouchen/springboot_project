package com.cskaoyan.sb.springboot_project.controller;

import com.cskaoyan.sb.springboot_project.bean.Admin;
import com.cskaoyan.sb.springboot_project.bean.AdminLoginInfo;
import com.cskaoyan.sb.springboot_project.service.AdminLoginInfoService;
import com.cskaoyan.sb.springboot_project.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/admin/auth")
public class LoginAdminController {
    @Autowired
    AdminLoginInfoService adminLoginInfoService;
    @Autowired
    AdminService adminService;

    @RequestMapping("/login")
    public Map<String,Object> login(@RequestBody Admin admin, HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        Subject subject = SecurityUtils.getSubject();
        String username = admin.getUsername();
        String password = admin.getPassword();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        //如果用户名和密码不正确会报异常，要处理
        try {
            subject.login(token);
        }catch (Exception e){
            map.put("errmsg","用户帐号或密码不正确");
            map.put("errno",605);
            return map;
        }
        Serializable id = subject.getSession().getId();
        map.put("data",id);
        map.put("errmsg","成功");
        map.put("errno",0);
        return map;
    }

    @RequestMapping("/info")
    public Map<String,Object> info(){

        Map<String,Object> map = new HashMap<>();
        Map<String , Object> interMap = new HashMap<>();
        //获取username根据username查询其他信息
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        AdminLoginInfo adminLoginInfo = adminLoginInfoService.queryAdminLoginInfo(username);
        List<String> strings = adminService.queryPermissionsByRoleIds(adminLoginInfo.getRoleIds());
        String[] perms = new String[strings.size()];
        strings.toArray(perms);
        adminLoginInfo.setPerms(perms);
        String[] roles_str = adminService.queryRolesByroleIds(adminLoginInfo.getRoleIds());
        adminLoginInfo.setRoles(roles_str);
//        interMap.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
//        interMap.put("name","vincent");
//        interMap.put("perms", new String[]{"*"});
//        interMap.put("roles", new String[]{"超级管理员"});

        map.put("data",adminLoginInfo);
        map.put("errmsg","成功");
        map.put("errno",0);
        return map;
    }

    @RequestMapping("logout")
    public Map<String, Object> logout() {
        SecurityUtils.getSubject().logout();
        Map<String,Object> map = new HashMap<>();
        map.put("errmsg","成功");
        map.put("errno",0);
        return map;
    }
}
