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
    public List<User> queryAllUserList() {
        return userMapper.queryAllUserList();
    }

    @Override
    public List<User> queryUserList(String username, String mobile) {
        return userMapper.queryUserList(username, mobile);
    }
}
