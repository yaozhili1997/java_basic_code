package com.ecotourism.api.application.service;

import com.ecotourism.api.application.domain.ApplicationApiDetectionDO;

import java.util.List;
import java.util.Map;

/**
 * 接口响应耗时
 * 
 * @author 陈启勇
 * @date 2018-11-02 14:40:32
 */
public interface ApplicationApiDetectionService {
	
	ApplicationApiDetectionDO get(Integer id);
	
	List<ApplicationApiDetectionDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ApplicationApiDetectionDO applicationApiDetection);
	
	int update(ApplicationApiDetectionDO applicationApiDetection);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
