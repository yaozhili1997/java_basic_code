package com.ecotourism.oms.oms.dao;


import com.ecotourism.oms.oms.domain.OrderSupplierLogDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-11-22 10:19:11
 */
@Mapper
public interface OrderSupplierLogDao {
	int save(OrderSupplierLogDO orderSupplierLog);
}
