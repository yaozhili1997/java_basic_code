package com.ecotourism.supplier.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ecotourism.supplier.order.dao.OrderLogDao;
import com.ecotourism.supplier.order.domain.OrderLogDO;
import com.ecotourism.supplier.order.service.OrderLogService;



@Service
public class OrderLogServiceImpl implements OrderLogService {
	@Autowired
	private OrderLogDao orderLogDao;
	
	@Override
	public OrderLogDO get(Integer id){
		return orderLogDao.get(id);
	}
	
	@Override
	public List<OrderLogDO> list(Map<String, Object> map){
		return orderLogDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return orderLogDao.count(map);
	}
	
	@Override
	public int save(OrderLogDO orderLog){
		return orderLogDao.save(orderLog);
	}
	
	@Override
	public int update(OrderLogDO orderLog){
		return orderLogDao.update(orderLog);
	}
	
	@Override
	public int remove(Integer id){
		return orderLogDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return orderLogDao.batchRemove(ids);
	}
	
}
