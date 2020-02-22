package com.ecotourism.supplier.device.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ecotourism.supplier.device.dao.CarEquipmentDao;
import com.ecotourism.supplier.device.domain.CarEquipmentDO;
import com.ecotourism.supplier.device.service.CarEquipmentService;



@Service
public class CarEquipmentServiceImpl implements CarEquipmentService {
	@Autowired
	private CarEquipmentDao carEquipmentDao;
	
	@Override
	public CarEquipmentDO get(Integer id){
		return carEquipmentDao.get(id);
	}
	
	@Override
	public List<CarEquipmentDO> list(Map<String, Object> map){
		return carEquipmentDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return carEquipmentDao.count(map);
	}
	
	@Override
	public int save(CarEquipmentDO carEquipment){
		return carEquipmentDao.save(carEquipment);
	}
	
	@Override
	public int update(CarEquipmentDO carEquipment){
		return carEquipmentDao.update(carEquipment);
	}
	
	@Override
	public int remove(Integer id){
		return carEquipmentDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return carEquipmentDao.batchRemove(ids);
	}
	
}
