package com.cskaoyan.sb.springboot_project.service;
import com.cskaoyan.sb.springboot_project.bean.Goods;
import com.cskaoyan.sb.springboot_project.bean.Goods_statistics;
import java.util.List;
import java.util.Map;

public interface GoodsService {
    List<Goods> queryAllGoodsList(Integer goodsSn, String name);

    int updateDeleteById(Goods goods);

    Goods queryById(Integer id);

    int queryByIdReturnInt(Integer id);

    Integer queryCategoryIds(Integer id);

    List<Goods_statistics> query_goods_statistics();

    int insertGoods(Goods goods);

    int updateGoods(Goods goods);

    Map<String, Object> queryGoodsById(int categoryId, int page, int size);

    Map<String, Object> queryRelatedByCateId(int id);
}
