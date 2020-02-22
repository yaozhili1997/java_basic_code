package com.ecotourism.api.application.dao;

import com.ecotourism.api.application.domain.ApplicationDO;

import com.ecotourism.api.application.domain.DistributionDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 调用支付接口应用信息
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-08-20 17:08:55
 */
@Mapper
public interface ApplicationDao {

	ApplicationDO get(String applicationNo);
	ApplicationDO getApplyByOutTradeNo(String outTradeNo);
	DistributionDO getDistribution(String distributionNo);
}
