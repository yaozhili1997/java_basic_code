package com.ecotourism.supplier.product.dao;

import com.ecotourism.supplier.product.domain.CarAddTicketDO;
import com.ecotourism.supplier.product.domain.CarTicketDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 车+门票
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-06 21:36:20
 */
@Mapper
public interface CarAddTicketDao {

	CarAddTicketDO get(Integer productId);
	
	List<CarAddTicketDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CarAddTicketDO carTicket);
	
	int update(CarAddTicketDO carTicket);
	
	int remove(Integer product_id);
	
	int batchRemove(Integer[] productIds);
}
