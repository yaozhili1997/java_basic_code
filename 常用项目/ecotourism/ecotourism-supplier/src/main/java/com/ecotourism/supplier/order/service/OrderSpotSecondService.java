package com.ecotourism.supplier.order.service;

import com.ecotourism.supplier.order.domain.OrderSpotSecondDO;

import java.util.List;
import java.util.Map;

/**
 * 子订单表
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-11 10:23:50
 */
public interface OrderSpotSecondService {
	
	OrderSpotSecondDO get(Integer orderId);
	
	List<OrderSpotSecondDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(OrderSpotSecondDO orderSpotSecond);
	
	int update(OrderSpotSecondDO orderSpotSecond);
	
	int remove(Integer orderId);
	
	int batchRemove(Integer[] orderIds);
}
