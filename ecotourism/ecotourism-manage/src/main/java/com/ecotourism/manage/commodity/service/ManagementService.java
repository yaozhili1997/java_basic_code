package com.ecotourism.manage.commodity.service;

import com.ecotourism.manage.commodity.domain.ManagementDO;

import java.util.List;
import java.util.Map;

/**
 * 属性管理
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-02 11:12:41
 */
public interface ManagementService {
	
	ManagementDO get(Integer id);
	
	List<ManagementDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ManagementDO management);
	
	int update(ManagementDO management);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
