package com.ecotourism.manage.base.service;

import com.ecotourism.manage.base.domain.TicketTypeDO;
import com.ecotourism.manage.common.utils.R;

import java.util.List;
import java.util.Map;

/**
 * 门票种类
 * 
 * @author chqy
 * @date 2018-05-31 14:38:39
 */
public interface TicketTypeService {
	
	TicketTypeDO get(Integer ticketId);
	
	List<TicketTypeDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);

	R save(TicketTypeDO ticketType);

	R update(TicketTypeDO ticketType);
	
	int remove(Integer ticketId);
	
	int batchRemove(Integer[] ticketIds);
}
