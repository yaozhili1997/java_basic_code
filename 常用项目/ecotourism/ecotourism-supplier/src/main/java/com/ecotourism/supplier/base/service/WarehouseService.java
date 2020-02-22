package com.ecotourism.supplier.base.service;

import com.ecotourism.supplier.base.domain.WarehouseDO;

import java.util.List;
import java.util.Map;

/**
 * 仓库管理
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-04 21:07:44
 */
public interface WarehouseService {
	
	WarehouseDO get(Integer id);
	
	List<WarehouseDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(WarehouseDO warehouse);
	
	int update(WarehouseDO warehouse);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
