package com.cskaoyan.sb.springboot_project;

import com.cskaoyan.sb.springboot_project.bean.Goods;
import com.cskaoyan.sb.springboot_project.bean.Groupon;
import com.cskaoyan.sb.springboot_project.bean.Groupon_rules;
import com.cskaoyan.sb.springboot_project.bean.Log;
import com.cskaoyan.sb.springboot_project.bean.Popularize.GrouponDetail;
import com.cskaoyan.sb.springboot_project.mapper.GoodsMapper;
import com.cskaoyan.sb.springboot_project.mapper.GrouponMapper;
import com.cskaoyan.sb.springboot_project.mapper.Groupon_rulesMapper;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootProjectApplicationTests {

    /*@Autowired
    GrouponMapper grouponMapper;

    @Autowired
    Groupon_rulesMapper groupon_rulesMapper;

    @Autowired
    GoodsMapper goodsMapper;

    Logger logger = Logger.getLogger(this.getClass());*/

    @Test
    public void contextLoads() {
        /*List<Groupon> groupons = grouponMapper.listGrouponByCondition("add_time","desc");

        List<GrouponDetail> items = new ArrayList<>();

        for (Groupon groupon : groupons) {
            Groupon_rules groupon_rules = groupon_rulesMapper.selectByPrimaryKey(groupon.getRulesId());
            Goods goods = goodsMapper.queryById(groupon_rules.getGoodsId());

            GrouponDetail grouponDetail = new GrouponDetail();
            grouponDetail.setGroupon(groupon);
            grouponDetail.setRules(groupon_rules);
            grouponDetail.setGoods(goods);
            grouponDetail.setSubGroupons(new ArrayList<>());

            items.add(grouponDetail);
        }

        logger.info("——————————");
        */
    }

}
