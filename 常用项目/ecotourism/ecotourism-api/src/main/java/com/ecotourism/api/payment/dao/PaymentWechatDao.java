package com.ecotourism.api.payment.dao;

import com.ecotourism.api.payment.domain.PaymentWechatDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 微信公众号或小程序信息管理
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-08-21 10:24:25
 */
@Mapper
public interface PaymentWechatDao {

	PaymentWechatDO getWechat(String wechatNo);
}
