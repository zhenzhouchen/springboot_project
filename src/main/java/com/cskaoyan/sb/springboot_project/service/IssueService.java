package com.cskaoyan.sb.springboot_project.service;

import java.util.Map;

public interface IssueService {
    Map<String, Object> selectIssueList(int page, int limit, String sort, String order, String question);
}
