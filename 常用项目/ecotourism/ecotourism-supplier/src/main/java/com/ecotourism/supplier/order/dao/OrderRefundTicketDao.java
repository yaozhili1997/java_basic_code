package com.ecotourism.supplier.order.dao;

import com.ecotourism.supplier.order.domain.OrderRefundTicketDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 退票管理
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-11 10:23:50
 */
@Mapper
public interface OrderRefundTicketDao {

	OrderRefundTicketDO get(Integer id);
	
	List<OrderRefundTicketDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(OrderRefundTicketDO orderRefundTicket);
	
	int update(OrderRefundTicketDO orderRefundTicket);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
