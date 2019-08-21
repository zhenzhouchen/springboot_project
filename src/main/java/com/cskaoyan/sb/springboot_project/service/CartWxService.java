package com.cskaoyan.sb.springboot_project.service;

import java.util.Map;

public interface CartWxService {
    Map<String, Object> selectCartListByUsername(String username);
}
