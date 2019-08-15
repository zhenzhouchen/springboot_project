package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Search_history;

public interface Search_historyMapper {
    int updateByPrimaryKeySelective(Search_history record);

    int updateByPrimaryKey(Search_history record);
}