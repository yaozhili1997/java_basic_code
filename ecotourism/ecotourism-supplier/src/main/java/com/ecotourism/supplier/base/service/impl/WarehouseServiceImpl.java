package com.ecotourism.supplier.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ecotourism.supplier.base.dao.WarehouseDao;
import com.ecotourism.supplier.base.domain.WarehouseDO;
import com.ecotourism.supplier.base.service.WarehouseService;



@Service
public class WarehouseServiceImpl implements WarehouseService {
	@Autowired
	private WarehouseDao warehouseDao;
	
	@Override
	public WarehouseDO get(Integer id){
		return warehouseDao.get(id);
	}
	
	@Override
	public List<WarehouseDO> list(Map<String, Object> map){
		return warehouseDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return warehouseDao.count(map);
	}
	
	@Override
	public int save(WarehouseDO warehouse){
		return warehouseDao.save(warehouse);
	}
	
	@Override
	public int update(WarehouseDO warehouse){
		return warehouseDao.update(warehouse);
	}
	
	@Override
	public int remove(Integer id){
		return warehouseDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return warehouseDao.batchRemove(ids);
	}
	
}
