package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.User;

import java.util.List;

public interface UserService {
    List<User> queryAllUserList(String sort,String oder);
    List<User> queryUserList(String username,String mobile,String sort,String order);


}
