package com.ecotourism.supplier.system.dao;

import com.ecotourism.supplier.system.domain.CompanyDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author chqy
 * @email chqy_ljy@163.com
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
