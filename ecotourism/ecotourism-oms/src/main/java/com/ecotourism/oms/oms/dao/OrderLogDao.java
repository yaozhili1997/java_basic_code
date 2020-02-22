package com.ecotourism.oms.oms.dao;

import com.ecotourism.oms.oms.domain.OrderLogDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 订单日志
 * @author 陈启勇
 * @email 1992lcg@163.com
 * @date 2018-06-11 10:23:50
 */
@Mapper
public interface OrderLogDao {

	OrderLogDO get(OrderLogDO orderLogDO);

	int save(OrderLogDO orderLog);

	List<OrderLogDO> getOrderStatus(Map<String, Object> map);
}
