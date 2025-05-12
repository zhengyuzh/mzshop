package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: author
 * @Description: 关系数据
 * @Version: 1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RelateDTO {
    /** 用户id */
    private Integer userId;
    /** 商品id */
    private Integer itemId;
    /** 评分 */
    private Double score;

}

