package com.ecotourism.manage.product.dao;

import com.ecotourism.manage.product.domain.SpotTicketDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 景区门票
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-06 21:36:20
 */
@Mapper
public interface SpotTicketDao {

	SpotTicketDO get(Integer productId);
	
	List<SpotTicketDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SpotTicketDO spotTicket);
	
	int update(SpotTicketDO spotTicket);

	int updateSort(SpotTicketDO spotTicket);

	int remove(Integer product_id);
	
	int batchRemove(Integer[] productIds);

	int updateTotalStockNum(SpotTicketDO spotTicket);
}
