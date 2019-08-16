package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Express;

public interface ExpressService {
    Express query_express();
    int update_express( Express express);

}
