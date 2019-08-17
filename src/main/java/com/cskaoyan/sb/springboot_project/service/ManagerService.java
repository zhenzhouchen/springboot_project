package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Admin;
import com.cskaoyan.sb.springboot_project.bean.AdminRoles;

import java.util.List;

public interface ManagerService {
    List<Admin> returnList();

    int querytotals(String page, String limit, List<Admin> list);

    List<AdminRoles> queryRoles();
}
