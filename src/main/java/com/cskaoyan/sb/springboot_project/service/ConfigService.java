package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Litemall;

public interface ConfigService {
    Litemall query_litemall();
    int update_litemall(Litemall litemall);

}
