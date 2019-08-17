package com.cskaoyan.sb.springboot_project.controller;

import com.cskaoyan.sb.springboot_project.bean.Keyword;
import com.cskaoyan.sb.springboot_project.service.KeywordService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ApiOperation("更新keywork")
    public Map<String, Object> updateKeywordById(@RequestBody Keyword keyword) {
        HashMap<String, Object> hashMap = new HashMap<>();
        int i = keywordService.updateKeywordById(keyword);
        if(i == 1) {
            hashMap.put("data", keyword);
            hashMap.put("errmsg", "成功");
            hashMap.put("errno", 0);
        }
        return hashMap;
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ApiOperation("删除keyword")
    public Map<String, Object> deleteKeywordById(@RequestBody Keyword keyword) {
        HashMap<String, Object> hashMap = new HashMap<>();
        int i = keywordService.deleteKeywordById(keyword);
        if(i == 1) {
            hashMap.put("errmsg", "成功");
            hashMap.put("errno", 0);
        }
        return hashMap;
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ApiOperation("新增keyword")
    public Map<String, Object> createKeyword(@RequestBody Keyword keyword) {
        HashMap<String, Object> hashMap = new HashMap<>();
        Keyword kd = keywordService.insertKeyword(keyword);
        if(kd != null) {
            hashMap.put("data", kd);
            hashMap.put("errmsg", "成功");
            hashMap.put("errno", 0);
        }
        return hashMap;
    }
}
