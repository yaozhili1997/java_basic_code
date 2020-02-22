package com.ecotourism.manage.base.dao;

import com.ecotourism.manage.base.domain.TermManagementDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 期限管理
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-06-23 15:17:10
 */
@Mapper
public interface TermManagementDao {

	TermManagementDO get(Integer termId);
	
	List<TermManagementDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TermManagementDO termManagement);
	
	int update(TermManagementDO termManagement);
	
	int remove(Integer term_id);
	
	int batchRemove(Integer[] termIds);
}
