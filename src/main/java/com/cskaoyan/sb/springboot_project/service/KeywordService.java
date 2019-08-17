package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Keyword;

import java.util.Map;

public interface KeywordService {

    Map<String, Object> selectKeywordList(int page, int limit, String sort, String order, String keyword, String url);

    int updateKeywordById(Keyword keyword);

    int deleteKeywordById(Keyword keyword);

    Keyword insertKeyword(Keyword keyword);

    Keyword selectKeywordById(int id);
}
