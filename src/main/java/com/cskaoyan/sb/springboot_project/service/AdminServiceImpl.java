package com.cskaoyan.sb.springboot_project.service;

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

    @Override
    public int upadte_admin(Admin admin) {
        return adminMapper.upadte_admin(admin);
    }

    @Override
    public int delete_admin(Admin admin) {
        return adminMapper.delete_admin(admin);
    }

    @Override
    public int create_admin(Admin admin) {
        return adminMapper.create_admin(admin);
    }

    @Override
    public int[] queryRoleIds(String username) {
        return adminMapper.queryRoleIds(username);
    }

    @Override
    public List<String> queryPermissionsByRoleIds(int[] rolesIds) {
        return adminMapper.queryPermissionsByRoleIds(rolesIds);
    }

    @Override
    public String[] queryRolesByroleIds(int[] roleIds) {
        return adminMapper.queryRolesByroleIds(roleIds);
    }


}
