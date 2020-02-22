package com.ecotourism.api.system.dao;

import com.ecotourism.api.system.domain.CompanyDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2018-05-29 21:50:51
 */
@Mapper
public interface CompanyDao {

	CompanyDO get(String departmentId);
	
	List<CompanyDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CompanyDO company);
	
	int update(CompanyDO company);
	
	int remove(String DEPARTMENT_ID);
	
	int batchRemove(String[] departmentIds);
}
