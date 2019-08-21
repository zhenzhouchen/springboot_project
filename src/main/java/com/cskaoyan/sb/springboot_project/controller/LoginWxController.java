package com.cskaoyan.sb.springboot_project.controller;

import com.cskaoyan.sb.springboot_project.bean.User;
import com.cskaoyan.sb.springboot_project.bean.UserInfo;
import com.cskaoyan.sb.springboot_project.mapper.UserMapper;
import com.cskaoyan.sb.springboot_project.realm.MallToken;
import com.cskaoyan.sb.springboot_project.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/wx")
public class LoginWxController {
    @Autowired
    UserService userService;
    @RequestMapping("/auth/login")
    public Map<String,Object> login(@RequestBody User user, HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        Map<String,Object> intermap = new HashMap<>();

        Subject subject = SecurityUtils.getSubject();
        String username = user.getUsername();
        String password = user.getPassword();
        //UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        MallToken mallToken = new MallToken(username, password, "wx");

        //如果用户名和密码不正确会报异常，要处理
        try {
            subject.login(mallToken);
        }catch (Exception e){
            map.put("errmsg","用户帐号或密码不正确");
            map.put("errno",605);
            return map;
        }
        UserInfo userInfo = userService.query_UserInfoByUsername(username);
        Serializable id = subject.getSession().getId();
        Date startTimestamp = subject.getSession().getStartTimestamp();
        intermap.put("userInfo",userInfo);
        intermap.put("token",id);
        intermap.put("tokenExpire",startTimestamp);
        map.put("data",intermap);
        map.put("errmsg","成功");
        map.put("errno",0);
        return map;
    }
}
