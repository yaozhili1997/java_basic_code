package com.ecotourism.oms.oms.dao;

import com.ecotourism.oms.oms.domain.RefundStrategyDetailsDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 退票策略明细
 * @author ³ÂÆôÓÂ
 * @email chqy_ljy@163.com
 * @date 2018-06-23 15:17:10
 */
@Mapper
public interface RefundStrategyDetailsDao {

	RefundStrategyDetailsDO get(Integer strategyDetailId);
	
	List<RefundStrategyDetailsDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(RefundStrategyDetailsDO refundStrategyDetails);
	
	int update(RefundStrategyDetailsDO refundStrategyDetails);
	
	int remove(Integer strategy_detail_id);
	
	int batchRemove(Integer[] strategyDetailIds);

	RefundStrategyDetailsDO getRefundStrategy(String strategyDetailsNo);
}
