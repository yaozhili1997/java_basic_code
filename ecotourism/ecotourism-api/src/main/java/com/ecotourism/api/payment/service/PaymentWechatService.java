package com.ecotourism.api.payment.service;

import com.ecotourism.api.payment.domain.PaymentWechatDO;

import java.util.List;
import java.util.Map;

/**
 * 微信公众号或小程序信息管理
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-08-21 10:24:25
 */
public interface PaymentWechatService {
	
	PaymentWechatDO getWechat(String wechatNo);
}
