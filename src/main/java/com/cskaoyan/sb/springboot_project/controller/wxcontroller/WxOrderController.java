package com.cskaoyan.sb.springboot_project.controller.wxcontroller;

import com.cskaoyan.sb.springboot_project.bean.GoodsList;
import com.cskaoyan.sb.springboot_project.bean.OrderInfo_wx;
import com.cskaoyan.sb.springboot_project.service.GoodsListService;
import com.cskaoyan.sb.springboot_project.service.OrderService;
import com.cskaoyan.sb.springboot_project.util.UserTokenManager;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/wx")
public class WxOrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    GoodsListService goodsListService;
    @RequestMapping("order/list")
    public Map<String,Object> order_list(Integer showType, int page, int size, HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        Map<String,Object> intermap = new HashMap<>();
        String tokenKey = request.getHeader("X-Litemall-Token");
        Integer userId = UserTokenManager.getUserId(tokenKey);
        PageHelper.startPage(page,size);

        List<OrderInfo_wx> orderInfo_wxList = null;
        if(userId ==null){
            return map;
        }
        if(showType ==null || showType ==0){
            orderInfo_wxList = orderService.queryOrderInfoById(userId);
        }else if(showType ==1){
            orderInfo_wxList = orderService.queryOrderInfoByIdNoPaied(userId);
        }else if(showType ==2){
            orderInfo_wxList = orderService.queryOrderInfoByIdNoShip(userId);
        }else if(showType ==3){
            orderInfo_wxList = orderService.queryOrderInfoByIdNoReceive(userId);

        }else {
            orderInfo_wxList = orderService.queryOrderInfoByIdNoComment(userId);
        }
        for(OrderInfo_wx i:orderInfo_wxList){
            switch (i.getOrderStatus()){
                case 101:
                    i.setOrderStatusText("未付款");
                    break;
                case 102:
                    i.setOrderStatusText("用户取消");
                    break;
                case 103:
                    i.setOrderStatusText("系统取消");
                    break;
                case 201:
                    i.setOrderStatusText("已付款");
                    break;
                case 202:
                    i.setOrderStatusText("申请退款");
                    break;
                case 203:
                    i.setOrderStatusText("已退款");
                    break;
                case 301:
                    i.setOrderStatusText("已发货");
                    break;
                case 401:
                    i.setOrderStatusText("用户收货");
                    break;
                case 402:
                    i.setOrderStatusText("系统收货");
                    break;
            }
            GoodsList[] goodsLists = goodsListService.queryGoodsList(i.getId());
            i.setGoodsList(goodsLists);
        }
        PageInfo<OrderInfo_wx> orderInfo_wxPageInfo = new PageInfo<>(orderInfo_wxList);
        long count = orderInfo_wxPageInfo.getTotal();
        int pages = orderInfo_wxPageInfo.getPages();
        intermap.put("count",count);
        intermap.put("totalPages",pages);
        intermap.put("data",orderInfo_wxList);
        map.put("data",intermap);
        map.put("errmsg","成功");
        map.put("errno",0);
        return map;
    }
}
