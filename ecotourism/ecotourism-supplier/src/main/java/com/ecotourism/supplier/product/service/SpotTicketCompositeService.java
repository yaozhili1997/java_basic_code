package com.ecotourism.supplier.product.service;

import com.ecotourism.supplier.product.domain.SpotTicketCompositeDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-06 21:36:20
 */
public interface SpotTicketCompositeService {
	
	SpotTicketCompositeDO get(Integer id);
	
	List<SpotTicketCompositeDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(SpotTicketCompositeDO spotTicketComposite);
	
	int update(SpotTicketCompositeDO spotTicketComposite);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
