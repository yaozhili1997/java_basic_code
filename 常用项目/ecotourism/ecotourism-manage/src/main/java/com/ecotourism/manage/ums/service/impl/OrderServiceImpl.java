package com.ecotourism.manage.ums.service.impl;

import com.ecotourism.manage.common.utils.PageTotal;
import com.ecotourism.manage.ums.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import com.ecotourism.manage.ums.domain.OrderDO;
import com.ecotourism.manage.ums.service.OrderService;



@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao orderDao;
	
	@Override
	public OrderDO get(Integer orderId){
		return orderDao.get(orderId);
	}
	
	@Override
	public List<OrderDO> list(Map<String, Object> map){
		return orderDao.list(map);
	}
	@Override
	public PageTotal selectTotalCount(Map<String, Object> map){
		return orderDao.selectTotalCount(map);
	}

	@Override
	public int count(Map<String, Object> map){
		return orderDao.count(map);
	}
	
	@Override
	public int save(OrderDO order){
		return orderDao.save(order);
	}
	
	@Override
	public int update(OrderDO order){
		return orderDao.update(order);
	}
	
	@Override
	public int remove(Integer orderId){
		return orderDao.remove(orderId);
	}
	
	@Override
	public int batchRemove(Integer[] orderIds){
		return orderDao.batchRemove(orderIds);
	}
	
}
