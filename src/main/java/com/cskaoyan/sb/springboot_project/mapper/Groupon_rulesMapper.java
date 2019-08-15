package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Groupon_rules;

public interface Groupon_rulesMapper {
    int updateByPrimaryKeySelective(Groupon_rules record);

    int updateByPrimaryKey(Groupon_rules record);
}