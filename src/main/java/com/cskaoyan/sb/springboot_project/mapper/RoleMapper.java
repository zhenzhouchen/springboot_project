package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    List<Role> queryAllRoleList(@Param("sort") String sort, @Param("order")String order);

    List<Role> queryRoleList(@Param("name")String name, @Param("sort")String sort, @Param("order")String order);

    int update_role(@Param("role") Role role);

    int create_role(@Param("role") Role role);

    int delete_role(@Param("role") Role role);

}