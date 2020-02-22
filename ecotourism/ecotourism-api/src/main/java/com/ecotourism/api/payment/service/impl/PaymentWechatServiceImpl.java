package com.ecotourism.api.payment.service.impl;

import com.ecotourism.api.payment.dao.PaymentWechatDao;
import com.ecotourism.api.payment.domain.PaymentWechatDO;
import com.ecotourism.api.payment.service.PaymentWechatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PaymentWechatServiceImpl implements PaymentWechatService {
	@Autowired
	private PaymentWechatDao paymentWechatDao;
	
	@Override
	public PaymentWechatDO getWechat(String wechatNo){
		return paymentWechatDao.getWechat(wechatNo);
	}
	

}
