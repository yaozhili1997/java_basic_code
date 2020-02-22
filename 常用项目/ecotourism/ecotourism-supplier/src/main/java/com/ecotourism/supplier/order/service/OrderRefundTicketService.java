package com.ecotourism.supplier.order.service;

import com.ecotourism.supplier.order.domain.OrderRefundTicketDO;

import java.util.List;
import java.util.Map;

/**
 * 退票管理
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-11 10:23:50
 */
public interface OrderRefundTicketService {
	
	OrderRefundTicketDO get(Integer id);
	
	List<OrderRefundTicketDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(OrderRefundTicketDO orderRefundTicket);
	
	int update(OrderRefundTicketDO orderRefundTicket);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
