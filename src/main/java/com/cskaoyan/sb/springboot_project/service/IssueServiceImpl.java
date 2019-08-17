package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Issue;
import com.cskaoyan.sb.springboot_project.mapper.IssueMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IssueServiceImpl implements IssueService {

    @Autowired
    IssueMapper issueMapper;

    @Override
    public Map<String, Object> selectIssueList(int page, int limit, String sort, String order, String question) {
        PageHelper.startPage(page, limit);
        List<Issue> issueList = issueMapper.selectIssueList(page, limit, sort, order, question);
        PageInfo<Issue> issuePageInfo = new PageInfo<>(issueList);
        long total = issuePageInfo.getTotal();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("items", issueList);
        hashMap.put("total", total);
        return hashMap;
    }
}
