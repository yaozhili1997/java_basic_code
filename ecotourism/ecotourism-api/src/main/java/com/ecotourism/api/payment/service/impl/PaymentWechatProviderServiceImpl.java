package com.ecotourism.api.payment.service.impl;

import com.ecotourism.api.payment.dao.PaymentWechatProviderDao;
import com.ecotourism.api.payment.domain.PaymentWechatProviderDO;
import com.ecotourism.api.payment.service.PaymentWechatProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PaymentWechatProviderServiceImpl implements PaymentWechatProviderService {
	@Autowired
	private PaymentWechatProviderDao paymentWechatProviderDao;
	
	@Override
	public PaymentWechatProviderDO getWechatProvider(String wechatProviderNo){
		return paymentWechatProviderDao.getWechatProvider(wechatProviderNo);
	}
}
