package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Search_history;
import com.cskaoyan.sb.springboot_project.mapper.Search_historyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Search_historyServiceImpl implements Search_historyService {
    @Autowired
    Search_historyMapper search_historyMapper;

    @Override
    public List<Search_history> queryAllHistoryList() {
        return search_historyMapper.queryAllHistoryList();
    }

    @Override
    public List<Search_history> queryHistoryList(Integer userId, String keyword) {
        return search_historyMapper.queryHistoryList(userId, keyword);
    }
}
