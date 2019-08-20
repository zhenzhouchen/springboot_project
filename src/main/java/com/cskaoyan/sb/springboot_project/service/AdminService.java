package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Admin;
import com.cskaoyan.sb.springboot_project.bean.AdminRoles;

import java.util.List;

public interface AdminService {
    List<Admin> queryAlladminlist( String sort,String order);
    List<Admin> queryAdminList( String username, String sort, String order);
    List<AdminRoles> queryAdminRole();
    int upadte_admin (Admin admin);
    int delete_admin(Admin admin);
    int create_admin(Admin admin);
    int[] queryRoleIds(String username);
    List<String> queryPermissionsByRoleIds(int[] rolesIds);


    String[] queryRolesByroleIds(int[] roleIds);
}
