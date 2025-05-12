package com.example.dao;

import com.example.entity.CommentInfo;
import com.example.entity.RelateDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface CommentInfoDao extends Mapper<CommentInfo> {

    List<CommentInfo> findByContent(@Param("name") String name,
                                    @Param("userId") Long userId,
                                    @Param("level") Integer level);

    List<CommentInfo> findByGoodsIdAndUserId(@Param("goodsId") Long goodsId,
                                             @Param("userId") Long userId,
                                             @Param("level") Integer level);

    List<CommentInfo> findByGoodsId(@Param("goodsId") Long goodsId);

    @Select("select count(id) from comment_info")
    Integer count();

    List<RelateDTO> getAllGoodsComment();

    Map<String, Object> getHighestScoreByUser(@Param("userId") Long userId);
}