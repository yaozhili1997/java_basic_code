package com.ecotourism.supplier.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ecotourism.supplier.order.dao.OrderSpotSecondDao;
import com.ecotourism.supplier.order.domain.OrderSpotSecondDO;
import com.ecotourism.supplier.order.service.OrderSpotSecondService;



@Service
public class OrderSpotSecondServiceImpl implements OrderSpotSecondService {
	@Autowired
	private OrderSpotSecondDao orderSpotSecondDao;
	
	@Override
	public OrderSpotSecondDO get(Integer orderId){
		return orderSpotSecondDao.get(orderId);
	}
	
	@Override
	public List<OrderSpotSecondDO> list(Map<String, Object> map){
		return orderSpotSecondDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return orderSpotSecondDao.count(map);
	}
	
	@Override
	public int save(OrderSpotSecondDO orderSpotSecond){
		return orderSpotSecondDao.save(orderSpotSecond);
	}
	
	@Override
	public int update(OrderSpotSecondDO orderSpotSecond){
		return orderSpotSecondDao.update(orderSpotSecond);
	}
	
	@Override
	public int remove(Integer orderId){
		return orderSpotSecondDao.remove(orderId);
	}
	
	@Override
	public int batchRemove(Integer[] orderIds){
		return orderSpotSecondDao.batchRemove(orderIds);
	}
	
}
