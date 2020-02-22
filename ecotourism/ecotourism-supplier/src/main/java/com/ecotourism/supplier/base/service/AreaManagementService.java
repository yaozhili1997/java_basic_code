package com.ecotourism.supplier.base.service;

import com.ecotourism.supplier.base.domain.AreaManagementDO;
import com.ecotourism.supplier.common.domain.Tree;
import com.ecotourism.supplier.common.utils.R;

import java.util.List;
import java.util.Map;

/**
 * 景区管理
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-06-23 15:17:10
 */
public interface AreaManagementService {
	
	AreaManagementDO get(Integer areaId);
	
	List<AreaManagementDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(AreaManagementDO areaManagement);
	
	int update(AreaManagementDO areaManagement);
	
	R remove(Integer areaId);
	
	R batchRemove(Integer[] areaIds);

	Tree<AreaManagementDO> getTree(Map<String, Object> map);
}
