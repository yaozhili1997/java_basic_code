package com.ecotourism.api.payment.dao;


import com.ecotourism.api.payment.domain.PaymentWechatMchDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 微信商户号管理配置
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-08-21 10:24:25
 */
@Mapper
public interface PaymentWechatMchDao {

	PaymentWechatMchDO getWechatMch(String wechatMchNo);
}
