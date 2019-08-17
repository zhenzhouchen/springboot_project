package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Role;
import com.cskaoyan.sb.springboot_project.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;
    @Override
    public List<Role> queryAllRoleList(String sort, String order) {
        return roleMapper.queryAllRoleList(sort, order);
    }

    @Override
    public List<Role> queryRoleList(String name, String sort, String order) {
        return roleMapper.queryRoleList(name, sort, order);
    }

    @Override
    public int update_role(Role role) {
        return roleMapper.update_role(role);
    }

    @Override
    public int create_role(Role role) {
        return roleMapper.create_role(role);
    }

    @Override
    public int delete_role(Role role) {
        return roleMapper.delete_role(role);
    }
}
