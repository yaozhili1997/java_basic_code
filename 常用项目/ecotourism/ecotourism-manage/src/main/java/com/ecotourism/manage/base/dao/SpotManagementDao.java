package com.ecotourism.manage.base.dao;

import com.ecotourism.manage.base.domain.SpotManagementDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 景点管理
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-06-23 15:17:10
 */
@Mapper
public interface SpotManagementDao {

	SpotManagementDO get(Integer spotId);
	
	List<SpotManagementDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);

	int countAll(Map<String, Object> map);
	
	int save(SpotManagementDO spotManagement);
	
	int update(SpotManagementDO spotManagement);
	
	int remove(Integer spot_id);
	
	int batchRemove(Integer[] spotIds);
}
