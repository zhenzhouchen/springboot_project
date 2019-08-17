package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Admin;
import com.cskaoyan.sb.springboot_project.bean.Log;
import com.cskaoyan.sb.springboot_project.mapper.LogMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OperatorLogServiceImpl implements OperatorLogService {
    @Autowired
    LogMapper operatorLogMapper;
    @Override
    public List<Log> returnList() {
        return operatorLogMapper.returnList();
    }
    @Override
    public int querytotals(String page, String limit, List<Log> list) {
        PageHelper.startPage(1,5);
        PageInfo<Log> pageInfo=new PageInfo<>(list);
        int totals= (int) pageInfo.getTotal();
        return totals;
    }
}
