package com.cskaoyan.sb.springboot_project.controller;

import com.cskaoyan.sb.springboot_project.service.IssueService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
}
