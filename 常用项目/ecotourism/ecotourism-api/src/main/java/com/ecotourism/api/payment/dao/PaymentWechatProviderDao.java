package com.ecotourism.api.payment.dao;

import java.util.List;
import java.util.Map;

import com.ecotourism.api.payment.domain.PaymentWechatProviderDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 微信商户号管理配置
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-08-21 10:24:25
 */
@Mapper
public interface PaymentWechatProviderDao {

	PaymentWechatProviderDO getWechatProvider(String wechatProviderNo);
}
