package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Issue;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface IssueMapper {
    int updateByPrimaryKeySelective(Issue record);

    int updateByPrimaryKey(Issue record);

    List<Issue> selectIssueList(int page, int limit, @Param("sort") String sort, @Param("order") String order, @Param("question") String question);

    @Update("update cskaoyan_mall_issue set deleted = 1 where id = #{id}")
    int deleteIssueById(Issue issue);

    int insertIssue(Issue issue);
}