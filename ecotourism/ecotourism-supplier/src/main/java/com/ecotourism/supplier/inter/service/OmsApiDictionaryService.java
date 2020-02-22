package com.ecotourism.supplier.inter.service;

import com.ecotourism.supplier.inter.domain.OmsApiDO;
import com.ecotourism.supplier.inter.domain.OmsApiDictionaryDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-05 19:39:45
 */
public interface OmsApiDictionaryService {
	
	OmsApiDictionaryDO get(Integer id);

	List<OmsApiDictionaryDO> listByDisNo(Map<String, Object> map);
	
	List<OmsApiDictionaryDO> list(Map<String, Object> map);

	List<OmsApiDO> listCheck(List<OmsApiDictionaryDO> list);
	
	int count(Map<String, Object> map);
	
	int save(OmsApiDictionaryDO omsApiDictionary);
	
	int update(OmsApiDictionaryDO omsApiDictionary);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
