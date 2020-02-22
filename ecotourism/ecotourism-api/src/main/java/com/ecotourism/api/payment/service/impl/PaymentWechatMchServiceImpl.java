package com.ecotourism.api.payment.service.impl;

import com.ecotourism.api.payment.dao.PaymentWechatMchDao;
import com.ecotourism.api.payment.domain.PaymentWechatMchDO;
import com.ecotourism.api.payment.service.PaymentWechatMchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PaymentWechatMchServiceImpl implements PaymentWechatMchService {
	@Autowired
	private PaymentWechatMchDao paymentWechatMchDao;
	
	@Override
	public PaymentWechatMchDO getWechatMch(String wechatMchNo){
		return paymentWechatMchDao.getWechatMch(wechatMchNo);
	}

}
