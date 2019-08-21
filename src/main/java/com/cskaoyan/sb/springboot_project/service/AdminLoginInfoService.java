package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.AdminLoginInfo;


public interface AdminLoginInfoService {
    AdminLoginInfo queryAdminLoginInfo(String username);
}
