package com.ecotourism.supplier.ums.dao;

import com.ecotourism.supplier.common.utils.PageTotal;
import com.ecotourism.supplier.ums.domain.OrderDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 应用订单
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-10-19 09:30:15
 */
@Mapper
public interface OrderDao {

	OrderDO get(Integer orderId);
	PageTotal selectTotalCount(Map<String, Object> map);
	List<OrderDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(OrderDO order);
	
	int update(OrderDO order);
	
	int remove(Integer order_id);
	
	int batchRemove(Integer[] orderIds);
}
