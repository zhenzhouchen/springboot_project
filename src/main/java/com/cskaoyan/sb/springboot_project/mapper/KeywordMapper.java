package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Keyword;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface KeywordMapper {
    int updateByPrimaryKeySelective(Keyword record);

    int updateByPrimaryKey(Keyword record);

    List<Keyword> selectKeywordList(int page, int limit, @Param("sort") String sort, @Param("order") String order, @Param("keyword") String keyword, @Param("url") String url);
}