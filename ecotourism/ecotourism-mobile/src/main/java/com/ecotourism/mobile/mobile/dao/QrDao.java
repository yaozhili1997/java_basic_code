package com.ecotourism.mobile.mobile.dao;

import com.ecotourism.mobile.mobile.domain.QrDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QrDao {
    List<QrDO> queryOrderInfoList(@Param("orderNo") String orderNo);
}
