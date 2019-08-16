package com.cskaoyan.sb.springboot_project.controller;

import com.cskaoyan.sb.springboot_project.service.KeywordService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/admin//keyword")
@RestController
public class keywordController {

    @Autowired
    KeywordService keywordService;

    @RequestMapping("list")
    @ApiOperation(value = "获取keyword列表")
    public Map<String, Object> selectKeywordList(int page, int limit, String sort, String order, String keyword, String url) {
        Map<String, Object> keywordMap = keywordService.selectKeywordList(page, limit, sort, order, keyword, url);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("data", keywordMap);
        hashMap.put("errmsg", "成功");
        hashMap.put("errno", 0);
        return hashMap;
    }
}
