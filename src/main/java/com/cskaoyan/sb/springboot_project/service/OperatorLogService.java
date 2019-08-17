package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Log;

import java.util.List;

public interface OperatorLogService {
    List<Log> returnList();

    int querytotals(String page, String limit, List<Log> list);
}
