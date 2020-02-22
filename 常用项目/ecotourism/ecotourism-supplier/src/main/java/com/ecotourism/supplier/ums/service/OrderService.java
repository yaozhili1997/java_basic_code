package com.ecotourism.supplier.ums.service;

import com.ecotourism.supplier.common.utils.PageTotal;
import com.ecotourism.supplier.ums.domain.OrderDO;

import java.util.List;
import java.util.Map;

/**
 * 应用订单
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-10-19 09:30:15
 */
public interface OrderService {
	
	OrderDO get(Integer orderId);
	
	List<OrderDO> list(Map<String, Object> map);
	PageTotal selectTotalCount(Map<String, Object> map);
	int count(Map<String, Object> map);
	
	int save(OrderDO order);
	
	int update(OrderDO order);
	
	int remove(Integer orderId);
	
	int batchRemove(Integer[] orderIds);
}
