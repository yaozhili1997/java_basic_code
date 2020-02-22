package com.ecotourism.manage.base.service;

import com.ecotourism.manage.base.domain.SupplierDO;

import java.util.List;
import java.util.Map;

/**
 * 供应商管理
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-04 21:48:30
 */
public interface SupplierService {
	
	SupplierDO get(Integer id);
	
	List<SupplierDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SupplierDO supplier);
	
	int update(SupplierDO supplier);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
