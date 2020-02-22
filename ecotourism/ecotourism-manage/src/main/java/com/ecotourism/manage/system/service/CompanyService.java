package com.ecotourism.manage.system.service;

import com.ecotourism.manage.system.domain.CompanyDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-05-29 21:50:51
 */
public interface CompanyService {
	
	CompanyDO get(String departmentId);
	
	List<CompanyDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CompanyDO company);
	
	int update(CompanyDO company);
	
	int remove(String departmentId);
	
	int batchRemove(String[] departmentIds);
}
