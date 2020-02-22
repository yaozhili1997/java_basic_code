package com.ecotourism.manage.order.dao;

import com.ecotourism.manage.order.domain.OrderSpotSecondDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 子订单表
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-11 10:23:50
 */
@Mapper
public interface OrderSpotSecondDao {

	OrderSpotSecondDO get(Integer orderId);
	
	List<OrderSpotSecondDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(OrderSpotSecondDO orderSpotSecond);
	
	int update(OrderSpotSecondDO orderSpotSecond);
	
	int remove(Integer order_id);
	
	int batchRemove(Integer[] orderIds);
}
