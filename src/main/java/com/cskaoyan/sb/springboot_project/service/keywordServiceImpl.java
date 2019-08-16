package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Keyword;
import com.cskaoyan.sb.springboot_project.mapper.KeywordMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class keywordServiceImpl implements KeywordService {

    @Autowired
    KeywordMapper keywordMapper;

    @Override
    public Map<String, Object> selectKeywordList(int page, int limit, String sort, String order, String keyword, String url) {
        PageHelper.startPage(page, limit);
        List<Keyword> keywordList = keywordMapper.selectKeywordList(page, limit, sort, order, keyword, url);
        PageInfo<Keyword> keywordPageInfo = new PageInfo<>(keywordList);
        long total = keywordPageInfo.getTotal();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("items", keywordList);
        hashMap.put("total", total);
        return hashMap;
    }
}
