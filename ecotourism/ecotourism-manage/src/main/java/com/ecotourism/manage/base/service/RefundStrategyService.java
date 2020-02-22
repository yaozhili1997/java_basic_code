package com.ecotourism.manage.base.service;

import com.ecotourism.manage.base.domain.RefundStrategyDO;
import com.ecotourism.manage.common.domain.Tree;

import java.util.List;
import java.util.Map;

/**
 * 退票策略
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-06-23 15:17:10
 */
public interface RefundStrategyService {
	
	RefundStrategyDO get(Integer strategyId);
	
	List<RefundStrategyDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(RefundStrategyDO refundStrategy);
	
	int update(RefundStrategyDO refundStrategy);
	
	int remove(Integer strategyId);
	
	int batchRemove(Integer[] strategyIds);

	Tree<RefundStrategyDO> getTree(Map<String, Object> map);
}
