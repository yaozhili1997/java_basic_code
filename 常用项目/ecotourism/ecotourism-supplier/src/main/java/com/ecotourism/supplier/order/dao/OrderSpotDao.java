package com.ecotourism.supplier.order.dao;

import com.ecotourism.supplier.order.domain.OrderAddressDO;
import com.ecotourism.supplier.order.domain.OrderSpotDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 门票订单
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-11 10:23:50
 */
@Mapper
public interface OrderSpotDao {

	OrderSpotDO get(Integer orderId);

	OrderAddressDO getAddress(Integer orderId);

	List<OrderSpotDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(OrderSpotDO orderSpot);
	
	int update(OrderSpotDO orderSpot);

	int updateAddress(OrderAddressDO orderAddress);

	int remove(Integer order_id);
	
	int batchRemove(Integer[] orderIds);
}
