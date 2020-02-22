package com.ecotourism.manage.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ecotourism.manage.base.dao.SupplierDao;
import com.ecotourism.manage.base.domain.SupplierDO;
import com.ecotourism.manage.base.service.SupplierService;



@Service
public class SupplierServiceImpl implements SupplierService {
	@Autowired
	private SupplierDao supplierDao;
	
	@Override
	public SupplierDO get(Integer id){
		return supplierDao.get(id);
	}
	
	@Override
	public List<SupplierDO> list(Map<String, Object> map){
		return supplierDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return supplierDao.count(map);
	}
	
	@Override
	public int save(SupplierDO supplier){
		return supplierDao.save(supplier);
	}
	
	@Override
	public int update(SupplierDO supplier){
		return supplierDao.update(supplier);
	}
	
	@Override
	public int remove(Integer id){
		return supplierDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return supplierDao.batchRemove(ids);
	}
	
}
