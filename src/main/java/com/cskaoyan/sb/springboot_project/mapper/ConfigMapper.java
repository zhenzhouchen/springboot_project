package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Litemall;
import org.apache.ibatis.annotations.Param;

public interface ConfigMapper {
    Litemall query_litemall();

    int update_litemall(@Param("litemall") Litemall litemall);
}
