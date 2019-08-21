package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.mapper.CartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CartWxServiceImpl implements CartWxService {

    @Autowired
    CartMapper cartMapper;

    @Override
    public Map<String, Object> selectCartListByUsername(String username) {
        return null;
    }
}
