package com.ecotourism.manage.payment.service;

import com.ecotourism.manage.payment.domain.AlipayDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-06-08 10:43:48
 */
public interface AlipayService {
	
	AlipayDO get(Long id);
	
	List<AlipayDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(AlipayDO alipay);
	
	int update(AlipayDO alipay);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
