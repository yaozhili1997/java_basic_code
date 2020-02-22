package com.ecotourism.manage.base.dao;

import com.ecotourism.manage.base.domain.RefundStrategyDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 退票策略
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-06-23 15:17:10
 */
@Mapper
public interface RefundStrategyDao {

	RefundStrategyDO get(Integer strategyId);
	
	List<RefundStrategyDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(RefundStrategyDO refundStrategy);
	
	int update(RefundStrategyDO refundStrategy);
	
	int remove(Integer strategy_id);
	
	int batchRemove(Integer[] strategyIds);
}
