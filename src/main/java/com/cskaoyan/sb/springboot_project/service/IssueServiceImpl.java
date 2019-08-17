package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Issue;
import com.cskaoyan.sb.springboot_project.mapper.IssueMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IssueServiceImpl implements IssueService {

    @Autowired
    IssueMapper issueMapper;

    @Override
    public int updateIssueById(Issue issue) {
        Date date = new Date();
        issue.setUpdateTime(date);
        return issueMapper.updateByPrimaryKey(issue);
    }

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

    @Override
    public int deleteIssueById(Issue issue) {
        return issueMapper.deleteIssueById(issue);
    }

    @Override
    public Issue insertIssue(Issue issue) {
        issue.setDeleted(false);
        Date date = new Date();
        issue.setAddTime(date);
        issue.setUpdateTime(date);
        int i = issueMapper.insertIssue(issue);
        if(i == 1) {
            return issue;
        } else {
            return null;
        }
    }
}
