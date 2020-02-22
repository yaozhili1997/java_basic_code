package com.ecotourism.mobile.mobile.dao;

import com.ecotourism.mobile.mobile.domain.OrderCustomerIdCardDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderCustomerIdCardDao {
    List<OrderCustomerIdCardDO> getListByOpenid(@Param("openid") String openid);
    int insert(OrderCustomerIdCardDO params);
    int update(OrderCustomerIdCardDO params);
    List<OrderCustomerIdCardDO> findByIdCardNo(@Param("idCardNo") String idCardNo, @Param("openid") String openid);
}
