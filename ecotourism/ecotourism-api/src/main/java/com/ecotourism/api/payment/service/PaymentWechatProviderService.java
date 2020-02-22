package com.ecotourism.api.payment.service;

import com.ecotourism.api.payment.domain.PaymentWechatProviderDO;

import java.util.List;
import java.util.Map;

/**
 * 微信商户号管理配置
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-08-21 10:24:25
 */
public interface PaymentWechatProviderService {
	
	PaymentWechatProviderDO getWechatProvider(String wechatProviderNo);
}
