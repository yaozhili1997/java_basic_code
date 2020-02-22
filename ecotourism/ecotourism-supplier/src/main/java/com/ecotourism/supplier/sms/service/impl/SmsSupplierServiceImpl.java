package com.ecotourism.supplier.sms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ecotourism.supplier.sms.dao.SmsSupplierDao;
import com.ecotourism.supplier.sms.domain.SmsSupplierDO;
import com.ecotourism.supplier.sms.service.SmsSupplierService;



@Service
public class SmsSupplierServiceImpl implements SmsSupplierService {
	@Autowired
	private SmsSupplierDao supplierDao;
	
	@Override
	public SmsSupplierDO get(Integer supplierId){
		return supplierDao.get(supplierId);
	}
	
	@Override
	public List<SmsSupplierDO> list(Map<String, Object> map){
		return supplierDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return supplierDao.count(map);
	}
	
	@Override
	public int save(SmsSupplierDO supplier){
		return supplierDao.save(supplier);
	}
	
	@Override
	public int update(SmsSupplierDO supplier){
		return supplierDao.update(supplier);
	}
	
	@Override
	public int remove(Integer supplierId){
		return supplierDao.remove(supplierId);
	}
	
	@Override
	public int batchRemove(Integer[] supplierIds){
		return supplierDao.batchRemove(supplierIds);
	}
	
}
