package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Admin;
import com.cskaoyan.sb.springboot_project.bean.AdminRoles;
import com.cskaoyan.sb.springboot_project.mapper.AdminMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    AdminMapper managerMapper;
    @Override
    public List<Admin> returnList() {
        return managerMapper.returnList();
    }

    @Override
    public int querytotals(String page, String limit, List<Admin> list) {
            PageHelper.startPage(1,5);
            PageInfo<Admin> pageInfo=new PageInfo<>(list);
            int totals= (int) pageInfo.getTotal();
            return totals;
    }

    @Override
    public List<AdminRoles> queryRoles() {
        return managerMapper.queryRoles();
    }
}
