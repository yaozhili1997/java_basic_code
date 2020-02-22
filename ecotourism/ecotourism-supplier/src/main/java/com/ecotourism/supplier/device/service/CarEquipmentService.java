package com.ecotourism.supplier.device.service;

import com.ecotourism.supplier.device.domain.CarEquipmentDO;

import java.util.List;
import java.util.Map;

/**
 * 设备表
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-07-09 19:17:58
 */
public interface CarEquipmentService {
	
	CarEquipmentDO get(Integer id);
	
	List<CarEquipmentDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CarEquipmentDO carEquipment);
	
	int update(CarEquipmentDO carEquipment);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
