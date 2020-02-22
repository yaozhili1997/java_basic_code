package com.ecotourism.supplier.order.dao;

import com.ecotourism.supplier.order.domain.OrderUserDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 订单用户
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-11 10:23:50
 */
@Mapper
public interface OrderUserDao {

	OrderUserDO get(Integer id);
	
	List<OrderUserDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(OrderUserDO orderUser);
	
	int update(OrderUserDO orderUser);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
