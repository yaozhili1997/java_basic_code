package com.ecotourism.supplier.base.dao;

import com.ecotourism.supplier.base.domain.TicketTypeDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 门票种类
 * @author chqy
 * @date 2018-05-31 14:38:39
 */
@Mapper
public interface TicketTypeDao {

	TicketTypeDO get(Integer ticketId);
	
	List<TicketTypeDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TicketTypeDO ticketType);
	
	int update(TicketTypeDO ticketType);
	
	int remove(Integer ticket_id);
	
	int batchRemove(Integer[] ticketIds);
}
