package com.ecotourism.supplier.base.dao;

import com.ecotourism.supplier.base.domain.AreaManagementDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 景区管理
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-06-23 15:17:10
 */
@Mapper
public interface AreaManagementDao {

	AreaManagementDO get(Integer areaId);
	
	List<AreaManagementDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(AreaManagementDO areaManagement);
	
	int update(AreaManagementDO areaManagement);
	
	int remove(Integer area_id);
	
	int batchRemove(Integer[] areaIds);
}
