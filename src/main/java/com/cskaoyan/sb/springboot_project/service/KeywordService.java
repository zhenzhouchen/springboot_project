package com.cskaoyan.sb.springboot_project.service;

import java.util.Map;

public interface KeywordService {

    Map<String, Object> selectKeywordList(int page, int limit, String sort, String order, String keyword, String url);
}
