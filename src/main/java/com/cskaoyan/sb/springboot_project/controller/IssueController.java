package com.cskaoyan.sb.springboot_project.controller;

import com.cskaoyan.sb.springboot_project.bean.Issue;
import com.cskaoyan.sb.springboot_project.service.IssueService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin/issue")
public class IssueController {

    @Autowired
    IssueService issueService;

    @RequestMapping("/list")
    @ApiOperation(value = "获取issue列表")
    public Map<String, Object> selectIssueList(int page, int limit, String sort, String order, String question) {
        Map<String, Object> issueMap = issueService.selectIssueList(page, limit, sort, order, question);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("data", issueMap);
        hashMap.put("errmsg", "成功");
        hashMap.put("errno", 0);
        return hashMap;
    }

    @RequestMapping("update")
    @ApiOperation("updateIssue")
    public Map<String, Object> updateIssue(@RequestBody Issue issue) {
        HashMap<String, Object> hashMap = new HashMap<>();
        int i = issueService.updateIssueById(issue);
        if(i == 1) {
            hashMap.put("data", issue);
            hashMap.put("errmsg", "成功");
            hashMap.put("errno", 0);
        }
        return hashMap;
    }

    @RequestMapping("delete")
    @ApiOperation("deleteIssue")
    public Map<String, Object> deleteIssue(@RequestBody Issue issue) {
        HashMap<String, Object> hashMap = new HashMap<>();
        int i = issueService.deleteIssueById(issue);
        if(i == 1) {
            hashMap.put("errmsg", "成功");
            hashMap.put("errno", 0);
        }
        return hashMap;
    }

    @RequestMapping("create")
    @ApiOperation("createIssue")
    public Map<String, Object> createIssue(@RequestBody Issue issue) {
        HashMap<String, Object> hashMap = new HashMap<>();
        Issue iss = issueService.insertIssue(issue);
        if(iss != null) {
            hashMap.put("data", iss);
            hashMap.put("errmsg", "成功");
            hashMap.put("errno", 0);
        }
        return hashMap;
    }
}
