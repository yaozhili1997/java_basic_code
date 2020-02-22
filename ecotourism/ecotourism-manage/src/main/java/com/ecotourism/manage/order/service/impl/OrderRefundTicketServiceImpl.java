package com.ecotourism.manage.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ecotourism.manage.order.dao.OrderRefundTicketDao;
import com.ecotourism.manage.order.domain.OrderRefundTicketDO;
import com.ecotourism.manage.order.service.OrderRefundTicketService;



@Service
public class OrderRefundTicketServiceImpl implements OrderRefundTicketService {
	@Autowired
	private OrderRefundTicketDao orderRefundTicketDao;
	
	@Override
	public OrderRefundTicketDO get(Integer id){
		return orderRefundTicketDao.get(id);
	}
	
	@Override
	public List<OrderRefundTicketDO> list(Map<String, Object> map){
		return orderRefundTicketDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return orderRefundTicketDao.count(map);
	}
	
	@Override
	public int save(OrderRefundTicketDO orderRefundTicket){
		return orderRefundTicketDao.save(orderRefundTicket);
	}
	
	@Override
	public int update(OrderRefundTicketDO orderRefundTicket){
		return orderRefundTicketDao.update(orderRefundTicket);
	}
	
	@Override
	public int remove(Integer id){
		return orderRefundTicketDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return orderRefundTicketDao.batchRemove(ids);
	}
	
}
