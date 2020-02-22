package com.ecotourism.manage.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ecotourism.manage.order.dao.OrderSupplierLogDao;
import com.ecotourism.manage.order.domain.OrderSupplierLogDO;
import com.ecotourism.manage.order.service.OrderSupplierLogService;



@Service
public class OrderSupplierLogServiceImpl implements OrderSupplierLogService {
	@Autowired
	private OrderSupplierLogDao orderSupplierLogDao;
	
	@Override
	public List<OrderSupplierLogDO> list(Map<String, Object> map){
		return orderSupplierLogDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return orderSupplierLogDao.count(map);
	}
	
}
