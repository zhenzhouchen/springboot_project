package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.User;

import java.util.Date;
import java.util.List;

public interface UserService {
    List<User> queryAllUserList(String sort,String oder);
    List<User> queryUserList(String username,String mobile,String sort,String order);

    Date query_user_statistics_day();

    int query_user_statistics_users();
}
