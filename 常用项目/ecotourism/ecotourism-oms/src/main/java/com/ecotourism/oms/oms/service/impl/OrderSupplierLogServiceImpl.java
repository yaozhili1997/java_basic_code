package com.ecotourism.oms.oms.service.impl;

import com.ecotourism.oms.oms.dao.OrderSupplierLogDao;
import com.ecotourism.oms.oms.domain.OrderSpotDO;
import com.ecotourism.oms.oms.domain.OrderSupplierLogDO;
import com.ecotourism.oms.oms.service.OrderSupplierLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class OrderSupplierLogServiceImpl implements OrderSupplierLogService {
	@Autowired
	private OrderSupplierLogDao OrderSupplierLogDao;
	
	@Override
	public int save(OrderSpotDO order){
		OrderSupplierLogDO orderSupplierLog = new OrderSupplierLogDO();
		orderSupplierLog.setOrderNo(order.getOrderNo());
		orderSupplierLog.setPiaogoOrderNo(order.getPiaogoOrderNo());
		orderSupplierLog.setMsg(order.getSupplierResultMsg());
		orderSupplierLog.setStatus(order.getSupplierResultStatus());
		orderSupplierLog.setElectronicTicket(order.getElectronicTicket());
		orderSupplierLog.setCrateTime(new Date());
		return OrderSupplierLogDao.save(orderSupplierLog);
	}

	
}
