package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Log;
import com.cskaoyan.sb.springboot_project.mapper.LogMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    LogMapper logMapper;

    @Override
    public Map<String, Object> selectLogList(int page, int limit, String name, String sort, String order) {
        PageHelper.startPage(page, limit);
        List<Log> logList = logMapper.selectLogList(page, limit, name, sort, order);
        PageInfo<Log> logPageInfo = new PageInfo<>(logList);
        long total = logPageInfo.getTotal();
        HashMap<String, Object> hashMap = new HashMap<>();
        if(logList.size() > 0) {
            hashMap.put("items", logList);
            hashMap.put("total", total);
            return hashMap;
        } else {
            return null;
        }
    }

    @Override
    public void insertLog(Log log) {
        logMapper.insertLog(log);
    }
}
