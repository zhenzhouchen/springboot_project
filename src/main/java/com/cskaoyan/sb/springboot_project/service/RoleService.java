package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Role;

import java.util.List;

public interface RoleService {
    List<Role> queryAllRoleList(String sort, String order);

    List<Role> queryRoleList(String name, String sort, String order);

    int update_role(Role role);

    int create_role(Role role);

    int delete_role(Role role);
}
