package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Search_history;

import java.util.List;

public interface Search_historyService {
    List<Search_history> queryAllHistoryList(String sort,String order);
    List<Search_history> queryHistoryList(Integer userId,String keyword,String sort,String order);

}
