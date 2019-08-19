package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Log;

import java.util.Map;

public interface LogService {
    Map<String, Object> selectLogList(int page, int limit, String name, String sort, String order);

    void insertLog(Log log);
}
