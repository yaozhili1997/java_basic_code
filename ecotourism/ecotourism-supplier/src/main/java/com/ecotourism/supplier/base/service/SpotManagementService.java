package com.ecotourism.supplier.base.service;

import com.ecotourism.supplier.base.domain.SpotManagementDO;

import java.util.List;
import java.util.Map;

/**
 * 景点管理
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-06-23 15:17:10
 */
public interface SpotManagementService {
	
	SpotManagementDO get(Integer spotId);
	
	List<SpotManagementDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SpotManagementDO spotManagement);
	
	int update(SpotManagementDO spotManagement);
	
	int remove(Integer spotId);
	
	int batchRemove(Integer[] spotIds);
}
