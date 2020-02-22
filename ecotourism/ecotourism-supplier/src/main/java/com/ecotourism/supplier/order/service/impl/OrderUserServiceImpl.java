package com.ecotourism.supplier.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ecotourism.supplier.order.dao.OrderUserDao;
import com.ecotourism.supplier.order.domain.OrderUserDO;
import com.ecotourism.supplier.order.service.OrderUserService;



@Service
public class OrderUserServiceImpl implements OrderUserService {
	@Autowired
	private OrderUserDao orderUserDao;
	
	@Override
	public OrderUserDO get(Integer id){
		return orderUserDao.get(id);
	}
	
	@Override
	public List<OrderUserDO> list(Map<String, Object> map){
		return orderUserDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return orderUserDao.count(map);
	}
	
	@Override
	public int save(OrderUserDO orderUser){
		return orderUserDao.save(orderUser);
	}
	
	@Override
	public int update(OrderUserDO orderUser){
		return orderUserDao.update(orderUser);
	}
	
	@Override
	public int remove(Integer id){
		return orderUserDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return orderUserDao.batchRemove(ids);
	}
	
}
