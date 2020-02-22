package com.ecotourism.manage.order.service;

import com.ecotourism.manage.order.domain.OrderSupplierLogDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-11-22 10:19:11
 */
public interface OrderSupplierLogService {
	
	List<OrderSupplierLogDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);

}
