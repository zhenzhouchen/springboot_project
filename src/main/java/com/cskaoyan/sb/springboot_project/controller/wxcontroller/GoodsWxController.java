package com.cskaoyan.sb.springboot_project.controller.wxcontroller;

import com.cskaoyan.sb.springboot_project.bean.ResponseVo;
import com.cskaoyan.sb.springboot_project.service.GoodsWxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("wx/goods")
@RestController
public class GoodsWxController {

    @Autowired
    GoodsWxService goodsWxService;

    @RequestMapping("detail")
    public ResponseVo goodsDetail(int id, HttpServletRequest request) {
        return goodsWxService.selectGoodsDetail(id, request);
    }

    @RequestMapping("related")
    public ResponseVo goodsRelated(int id) {
        return goodsWxService.selectRelatedGoods(id);
    }
}
