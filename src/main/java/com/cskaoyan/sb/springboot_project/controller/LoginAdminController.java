package com.cskaoyan.sb.springboot_project.controller;

import com.cskaoyan.sb.springboot_project.bean.Admin;
import com.cskaoyan.sb.springboot_project.bean.AdminLoginInfo;
import com.cskaoyan.sb.springboot_project.realm.MallToken;
import com.cskaoyan.sb.springboot_project.service.AdminLoginInfoService;
import com.cskaoyan.sb.springboot_project.service.AdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
        //这里的custom的相当于admin
        MallToken mallToken = new MallToken(username, password, "custom");

        //UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        //如果用户名和密码不正确会报异常，要处理
        try {
            subject.login(mallToken);
        }catch (Exception e){
            map.put("errmsg","用户帐号或密码不正确");
            map.put("errno",605);
            //日志记录
            request.setAttribute("errno", "0");
            request.setAttribute("result", "密码错误");
            //登录失败标志，gitsubject已经销毁，使用该标志传递登录用户名
            request.setAttribute("logError", username);
            return map;
        }
        Serializable id = subject.getSession().getId();
        map.put("data",id);
        map.put("errmsg","成功");
        map.put("errno",0);
        //日志记录
        request.setAttribute("errno", "1");
        request.setAttribute("result", "登陆成功");
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

        System.out.println(adminLoginInfo);
        map.put("data",adminLoginInfo);
        map.put("errmsg","成功");
        map.put("errno",0);
        return map;
    }

    @RequestMapping("logout")
    public Map<String, Object> logout(HttpServletRequest request) {
        Map<String,Object> map = null;
        try {
            String username = (String) SecurityUtils.getSubject().getPrincipal();
            Subject subject = SecurityUtils.getSubject();
            System.out.println(subject);
            //通过subject执行logout
            SecurityUtils.getSubject().logout();
            map = new HashMap<>();
            map.put("errmsg","成功");
            map.put("errno",0);
            request.setAttribute("result", "退出");
            request.setAttribute("errno", "1");
            //退出成功标志，退出时subject已经销毁，使用该标志传递退出用户名
            request.setAttribute("logout", username);
        } catch (Exception e) {
            request.setAttribute("result", "退出异常");
            request.setAttribute("errno", "0");
        }
        return map;
    }
}
