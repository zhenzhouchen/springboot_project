package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Issue;

import java.util.Map;

public interface IssueService {
    int updateIssueById(Issue issue);

    Map<String, Object> selectIssueList(int page, int limit, String sort, String order, String question);

    int deleteIssueById(Issue issue);

    Issue insertIssue(Issue issue);
}
