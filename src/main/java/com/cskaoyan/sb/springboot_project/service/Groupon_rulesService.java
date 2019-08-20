package com.cskaoyan.sb.springboot_project.service;

import com.cskaoyan.sb.springboot_project.bean.Groupon_rules;
import com.cskaoyan.sb.springboot_project.bean.Popularize.PopPage;

import java.util.Map;

public interface Groupon_rulesService {
    abstract Map<String,Object> listGroupon_rules(PopPage popPage);

    Groupon_rules createGroupon_rules(Groupon_rules groupon_rules);

    Groupon_rules updateGroupon_rules(Groupon_rules groupon_rules);

    Map<String, Object> searchGroupon_rules(PopPage popPage, String name);

    Groupon_rules readGroupon_rulesById(String id);
}
