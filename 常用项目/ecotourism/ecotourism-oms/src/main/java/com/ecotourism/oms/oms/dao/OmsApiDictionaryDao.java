package com.ecotourism.oms.oms.dao;

import com.ecotourism.oms.oms.domain.OmsApiDictionaryDO;
import org.apache.ibatis.annotations.Mapper;


/**
 * 
 * @author 陈启勇
 * @email 1992lcg@163.com
 * @date 2018-06-05 19:39:45
 */
@Mapper
public interface OmsApiDictionaryDao {

	OmsApiDictionaryDO get(OmsApiDictionaryDO omsApiDictionaryDO);
}
