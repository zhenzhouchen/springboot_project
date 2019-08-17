package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Admin;
import com.cskaoyan.sb.springboot_project.bean.AdminRoles;
import com.cskaoyan.sb.springboot_project.service.AdminService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {
    List<Admin> queryAlladminlist(@Param("sort") String sort, @Param("order") String order);
    List<Admin> queryAdminList(@Param("username") String username,@Param("sort") String sort, @Param("order") String order);
    List<AdminRoles> queryAdminRole();
    int upadte_admin(@Param("admin") Admin admin);
    int delete_admin(@Param("admin") Admin admin);
    int create_admin(@Param("admin") Admin admin);




    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}