package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Keyword;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface KeywordMapper {
    int updateByPrimaryKeySelective(Keyword record);

    int updateByPrimaryKey(Keyword record);

    List<Keyword> selectKeywordList(int page, int limit, @Param("sort") String sort, @Param("order") String order, @Param("keyword") String keyword, @Param("url") String url);

    @Update("update cskaoyan_mall_keyword set deleted = 1 where id = #{id}")
    int deleteKeywordById(Integer id);

    int insertKeyword(Keyword keyword);

    Keyword selectKeywordById(@Param("id") int id);

    Keyword defaultKeyword();

    List<Keyword> hotKeywordList();
}