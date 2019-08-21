package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.User;
import com.cskaoyan.sb.springboot_project.bean.UserInfo;
import com.cskaoyan.sb.springboot_project.bean.User_statistics;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public interface UserService {
    List<User> queryAllUserList(String sort,String oder);
    List<User> queryUserList(String username,String mobile,String sort,String order);


    List<User_statistics> query_user_statistics_bean();

    UserInfo query_UserInfoByUsername(String username);

    int queryIdByName(String username);
}
