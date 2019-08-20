package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.AdminLoginInfo;
import org.apache.ibatis.annotations.Param;

public interface AdminLoginInfoMapper {
    AdminLoginInfo queryAdminLoginInfo(@Param("username") String username);
}
