package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Keyword;

public interface KeywordMapper {
    int updateByPrimaryKeySelective(Keyword record);

    int updateByPrimaryKey(Keyword record);
}