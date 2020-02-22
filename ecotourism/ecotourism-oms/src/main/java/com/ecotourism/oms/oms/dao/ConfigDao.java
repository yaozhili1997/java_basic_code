package com.ecotourism.oms.oms.dao;

import com.ecotourism.oms.oms.domain.ConfigDO;

import org.apache.ibatis.annotations.Mapper;

/**
 * 分销商oms产品接口配置
 * @author ³ÂÆôÓÂ
 * @email chqy_ljy@163.com
 * @date 2018-10-12 14:11:45
 */
@Mapper
public interface ConfigDao {

	ConfigDO get(String distributionNo);
}
