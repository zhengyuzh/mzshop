package com.example.utils;

/**
 * @BelongsProject: meizhuang_update
 * @BelongsPackage: com.example.utils
 * @Author: author
 * @CreateTime: 2025-02-08  14:34
 * @Description: TODO  基于物品:入参是当前用户曾经评过高分的商品id，以此通过算法推荐和此商品相似度高的商品
 * @Version: 1.0
 */


import com.example.entity.RelateDTO;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class Recommend{

    /**
     * 方法描述: 猜你喜欢
     * 入参是当前用户曾经评过高分的商品id，以此通过算法推荐和此商品相似度高的商品
     *
     * @param itemId 电影id
     */
    public static List<Integer>  userCfRecommend(int itemId){
        //Sql获取不同用户对不同商品评分关系
        List<RelateDTO> data= null;
        // 获取到推荐的商品id
        List<Integer> recommendations = ItemCF.recommend(itemId, data);
        return recommendations ;
    }


}