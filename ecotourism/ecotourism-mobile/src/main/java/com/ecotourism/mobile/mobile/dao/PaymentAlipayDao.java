package com.ecotourism.mobile.mobile.dao;

import com.ecotourism.mobile.mobile.domain.PaymentAlipayDO;
import com.ecotourism.mobile.mobile.domain.PaymentWechatDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentAlipayDao {
    PaymentAlipayDO getPaymentAlipayByUserNo(@Param("userNo") String userNo);
}