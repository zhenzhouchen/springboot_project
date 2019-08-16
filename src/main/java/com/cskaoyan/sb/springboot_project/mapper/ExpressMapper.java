package com.cskaoyan.sb.springboot_project.mapper;

import com.cskaoyan.sb.springboot_project.bean.Express;
import org.apache.ibatis.annotations.Param;

public interface ExpressMapper {
    Express query_express();

    int update_express(@Param("express") Express express);
}
