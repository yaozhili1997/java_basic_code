package com.ecotourism.supplier.base.service;

import com.ecotourism.supplier.base.domain.TermManagementDO;

import java.util.List;
import java.util.Map;

/**
 * 期限管理
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-06-23 15:17:10
 */
public interface TermManagementService {
	
	TermManagementDO get(Integer termId);
	
	List<TermManagementDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TermManagementDO termManagement);
	
	int update(TermManagementDO termManagement);
	
	int remove(Integer termId);
	
	int batchRemove(Integer[] termIds);
}
