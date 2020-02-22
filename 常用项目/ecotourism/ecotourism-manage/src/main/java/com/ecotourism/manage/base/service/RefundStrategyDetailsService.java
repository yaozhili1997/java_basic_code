package com.ecotourism.manage.base.service;

import com.ecotourism.manage.base.domain.RefundStrategyDO;
import com.ecotourism.manage.base.domain.RefundStrategyDetailsDO;
import com.ecotourism.manage.common.domain.Tree;

import java.util.List;
import java.util.Map;

/**
 * 退票策略明细
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-06-23 15:17:10
 */
public interface RefundStrategyDetailsService {
	
	RefundStrategyDetailsDO get(Integer strategyDetailId);
	
	List<RefundStrategyDetailsDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(RefundStrategyDetailsDO refundStrategyDetails);
	
	int update(RefundStrategyDetailsDO refundStrategyDetails);
	
	int remove(Integer strategyDetailId);
	
	int batchRemove(Integer[] strategyDetailIds);
	Tree<RefundStrategyDO> getTree(Map<String, Object> map);
}
