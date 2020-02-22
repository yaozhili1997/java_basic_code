package com.ecotourism.mobile.mobile.dao;

import com.ecotourism.mobile.mobile.domain.ProductCollectionDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductCollectionDao {
    List<ProductCollectionDO> get(@Param("openId") String openId, @Param("productNo") String productNo);
    void remove(@Param("openId") String openId, @Param("productNo") String productNo);
    void insert(@Param("openId") String openId, @Param("productNo") String productNo);
    List<ProductCollectionDO> getList(@Param("openId") String openId, @Param("offset") Integer offset, @Param("limit") Integer limit);
}
