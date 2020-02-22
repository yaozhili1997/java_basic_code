package com.ecotourism.supplier.order.dao;

import com.ecotourism.supplier.order.domain.OrderSupplierLogDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-11-22 10:19:11
 */
@Mapper
public interface OrderSupplierLogDao {
	
	List<OrderSupplierLogDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
}
