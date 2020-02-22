package com.ecotourism.manage.order.service;

import com.ecotourism.manage.order.domain.OrderLogDO;

import java.util.List;
import java.util.Map;

/**
 * 订单日志
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-11 10:23:50
 */
public interface OrderLogService {
	
	OrderLogDO get(Integer id);
	
	List<OrderLogDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(OrderLogDO orderLog);
	
	int update(OrderLogDO orderLog);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
