package com.ecotourism.oms.oms.dao;

import com.ecotourism.oms.oms.domain.OrderSpotDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 门票订单
 * @author 陈启勇
 * @email 1992lcg@163.com
 * @date 2018-06-11 10:23:50
 */
@Mapper
public interface OrderSpotDao {

	OrderSpotDO get(Integer orderId);
	
	List<OrderSpotDO> list(Map<String, Object> map);

	List<OrderSpotDO> queryOrder(Map<String, Object> map);

	List<OrderSpotDO> getCancelOrder(Map<String, Object> map);

	int refundOrder(OrderSpotDO orderSpotDO);

	int cancelOrder(OrderSpotDO orderSpotDO);

	int updateOrder(OrderSpotDO orderSpotDO);

	int count(Map<String, Object> map);
	
	int save(OrderSpotDO orderSpot);
	
	int update(OrderSpotDO orderSpot);
	
	int remove(Integer order_id);
	
	int batchRemove(Integer[] orderIds);
}
