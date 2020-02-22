package com.ecotourism.supplier.base.dao;

import com.ecotourism.supplier.base.domain.SupplierDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 供应商管理
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-04 21:48:30
 */
@Mapper
public interface SupplierDao {

	SupplierDO get(Integer id);
	
	List<SupplierDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SupplierDO supplier);
	
	int update(SupplierDO supplier);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
