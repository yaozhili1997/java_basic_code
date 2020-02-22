package com.ecotourism.api.payment.service;

import com.ecotourism.api.payment.domain.PaymentAlipayDO;

/**
 * 
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-08-21 10:24:25
 */
public interface PaymentAlipayService {
	
	PaymentAlipayDO getAlipayDO(String alipayNo);
}
