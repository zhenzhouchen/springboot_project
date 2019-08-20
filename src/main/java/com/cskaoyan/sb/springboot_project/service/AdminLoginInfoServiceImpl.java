package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.AdminLoginInfo;
import com.cskaoyan.sb.springboot_project.mapper.AdminLoginInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminLoginInfoServiceImpl implements AdminLoginInfoService {
    @Autowired
    AdminLoginInfoMapper adminLoginInfoMapper;
    @Override
    public AdminLoginInfo queryAdminLoginInfo(String username) {
        return adminLoginInfoMapper.queryAdminLoginInfo(username);
    }
}
