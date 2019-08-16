package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Express;
import com.cskaoyan.sb.springboot_project.mapper.ExpressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpressServiceImpl implements ExpressService {
    @Autowired
    ExpressMapper expressMapper;
    @Override
    public Express query_express() {
        return expressMapper.query_express();
    }

    @Override
    public int update_express(Express express) {
        return expressMapper.update_express(express);
    }
}
