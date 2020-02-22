package com.ecotourism.manage.device.dao;

import com.ecotourism.manage.device.domain.CarEquipmentDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 设备表
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-07-09 19:17:58
 */
@Mapper
public interface CarEquipmentDao {

	CarEquipmentDO get(Integer id);
	
	List<CarEquipmentDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CarEquipmentDO carEquipment);
	
	int update(CarEquipmentDO carEquipment);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
