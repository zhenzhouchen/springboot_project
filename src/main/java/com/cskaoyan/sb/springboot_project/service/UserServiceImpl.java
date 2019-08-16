package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.User;
import com.cskaoyan.sb.springboot_project.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;


    @Override
    public List<User> queryAllUserList(String sort,String order) {
        return userMapper.queryAllUserList(sort,order);
    }

    @Override
    public List<User> queryUserList(String username, String mobile,String sort,String order) {
        return userMapper.queryUserList(username, mobile,sort,order);
    }
}
