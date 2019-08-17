package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Issue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IssueMapper {
    int updateByPrimaryKeySelective(Issue record);

    int updateByPrimaryKey(Issue record);

    List<Issue> selectIssueList(int page, int limit, @Param("sort") String sort, @Param("order") String order, @Param("question") String question);

}