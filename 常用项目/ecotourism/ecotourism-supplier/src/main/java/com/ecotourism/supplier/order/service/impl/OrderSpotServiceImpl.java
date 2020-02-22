package com.ecotourism.supplier.order.service.impl;

import com.ecotourism.supplier.order.domain.OrderAddressDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ecotourism.supplier.order.dao.OrderSpotDao;
import com.ecotourism.supplier.order.domain.OrderSpotDO;
import com.ecotourism.supplier.order.service.OrderSpotService;



@Service
public class OrderSpotServiceImpl implements OrderSpotService {
	@Autowired
	private OrderSpotDao orderSpotDao;
	
	@Override
	public OrderSpotDO get(Integer orderId){
		return orderSpotDao.get(orderId);
	}

	@Override
	public OrderAddressDO getAddress(Integer orderId) {
		return orderSpotDao.getAddress(orderId);
	}

	@Override
	public List<OrderSpotDO> list(Map<String, Object> map){
		return orderSpotDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return orderSpotDao.count(map);
	}
	
	@Override
	public int save(OrderSpotDO orderSpot){
		return orderSpotDao.save(orderSpot);
	}

	@Override
	public int updateAddress(OrderAddressDO orderAddress) {
		return orderSpotDao.updateAddress(orderAddress);
	}

	@Override
	public int update(OrderSpotDO orderSpot){
		return orderSpotDao.update(orderSpot);
	}
	
	@Override
	public int remove(Integer orderId){
		return orderSpotDao.remove(orderId);
	}
	
	@Override
	public int batchRemove(Integer[] orderIds){
		return orderSpotDao.batchRemove(orderIds);
	}

	@Override
	public int updateOrderStatus(Integer orderId,String checkInOperator) {
		OrderSpotDO orderSpotDO = new OrderSpotDO();
		orderSpotDO.setOrderId(orderId);
		orderSpotDO.setOrderStatus("004002");
		orderSpotDO.setCheckTime(new Date());
		orderSpotDO.setCheckInOperator(checkInOperator);
		return orderSpotDao.update(orderSpotDO);
	}

	@Override
	public int updateRefundStatus(Integer orderId, String checkInOperator) {
		OrderSpotDO orderSpotDO = new OrderSpotDO();
		orderSpotDO.setOrderId(orderId);
		orderSpotDO.setOrderStatus("004004");
		orderSpotDO.setRefundStatus("002003");
		orderSpotDO.setRefundTime(new Date());
		orderSpotDO.setCheckInOperator(checkInOperator);
		return orderSpotDao.update(orderSpotDO);
	}

}
