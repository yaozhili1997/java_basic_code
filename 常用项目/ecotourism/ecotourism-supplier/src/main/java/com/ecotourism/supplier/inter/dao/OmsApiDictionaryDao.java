package com.ecotourism.supplier.inter.dao;

import com.ecotourism.supplier.inter.domain.OmsApiDictionaryDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-05 19:39:45
 */
@Mapper
public interface OmsApiDictionaryDao {

	OmsApiDictionaryDO get(Integer id);
	List<OmsApiDictionaryDO> listByDisNo(Map<String, Object> map);
	List<OmsApiDictionaryDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(OmsApiDictionaryDO omsApiDictionary);
	
	int update(OmsApiDictionaryDO omsApiDictionary);
	
	int remove(Integer id);

	int removeByDistributionNo(String distributionNo);
	
	int batchRemove(Integer[] ids);
}
