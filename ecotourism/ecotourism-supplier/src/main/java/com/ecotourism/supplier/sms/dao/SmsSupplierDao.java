package com.ecotourism.supplier.sms.dao;

import com.ecotourism.supplier.sms.domain.SmsSupplierDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 短信供应商
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-07 20:53:33
 */
@Mapper
public interface SmsSupplierDao {

	SmsSupplierDO get(Integer supplierId);
	
	List<SmsSupplierDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SmsSupplierDO supplier);
	
	int update(SmsSupplierDO supplier);
	
	int remove(Integer supplier_id);
	
	int batchRemove(Integer[] supplierIds);
}
