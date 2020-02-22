package com.ecotourism.manage.product.dao;

import com.ecotourism.manage.product.domain.CarTicketDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 车票
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-06 21:36:20
 */
@Mapper
public interface CarTicketDao {

	CarTicketDO get(Integer productId);
	
	List<CarTicketDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CarTicketDO carTicket);
	
	int update(CarTicketDO carTicket);
	
	int remove(Integer product_id);
	
	int batchRemove(Integer[] productIds);
}
