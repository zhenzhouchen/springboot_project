package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Address;
import com.cskaoyan.sb.springboot_project.bean.Admin;
import com.cskaoyan.sb.springboot_project.bean.AdminRoles;
import com.cskaoyan.sb.springboot_project.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;
    @Override
    public List<Admin> queryAlladminlist(String sort, String order) {
        return adminMapper.queryAlladminlist(sort, order);
    }

    @Override
    public List<Admin> queryAdminList(String username, String sort, String order) {
        return adminMapper.queryAdminList(username, sort, order);
    }

    @Override
    public List<AdminRoles> queryAdminRole() {
        return adminMapper.queryAdminRole();
    }
}
