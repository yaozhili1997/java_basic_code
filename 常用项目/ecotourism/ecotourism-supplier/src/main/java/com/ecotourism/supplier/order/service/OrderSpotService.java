package com.ecotourism.supplier.order.service;

import com.ecotourism.supplier.order.domain.OrderAddressDO;
import com.ecotourism.supplier.order.domain.OrderSpotDO;

import java.util.List;
import java.util.Map;

/**
 * 门票订单
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-11 10:23:50
 */
public interface OrderSpotService {
	
	OrderSpotDO get(Integer orderId);

	OrderAddressDO getAddress(Integer orderId);
	
	List<OrderSpotDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(OrderSpotDO orderSpot);
	
	int update(OrderSpotDO orderSpot);

	int updateAddress(OrderAddressDO orderAddress);
	
	int remove(Integer orderId);
	
	int batchRemove(Integer[] orderIds);

	int updateOrderStatus(Integer orderId,String checkInOperator);

	int updateRefundStatus(Integer orderId,String checkInOperator);
}
