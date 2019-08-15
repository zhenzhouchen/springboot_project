package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Issue;

public interface IssueMapper {
    int updateByPrimaryKeySelective(Issue record);

    int updateByPrimaryKey(Issue record);
}