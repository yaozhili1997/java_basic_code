package com.ecotourism.api.payment.dao;

import com.ecotourism.api.payment.domain.PaymentAlipayDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-08-21 10:24:25
 */
@Mapper
public interface PaymentAlipayDao {

	PaymentAlipayDO getAlipayDO(String alipayNo);
}
