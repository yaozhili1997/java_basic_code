package com.ecotourism.api.payment.service.impl;

import com.ecotourism.api.payment.dao.PaymentAlipayDao;
import com.ecotourism.api.payment.domain.PaymentAlipayDO;
import com.ecotourism.api.payment.service.PaymentAlipayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PaymentAlipayServiceImpl implements PaymentAlipayService {
	@Autowired
	private PaymentAlipayDao paymentAlipayDao;
	
	@Override
	public PaymentAlipayDO getAlipayDO(String alipayNo){
		return paymentAlipayDao.getAlipayDO(alipayNo);
	}

}
