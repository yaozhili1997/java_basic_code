package com.ecotourism.oms.oms.dao;

import com.ecotourism.oms.oms.domain.CapitalFlowDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 资金流水管理
 * @author ³ÂÆôÓÂ
 * @email chqy_ljy@163.com
 * @date 2018-10-12 10:14:15
 */
@Mapper
public interface CapitalFlowDao {

	CapitalFlowDO get(Integer capitalId);
	
	List<CapitalFlowDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(CapitalFlowDO capitalFlow);
	
	int update(CapitalFlowDO capitalFlow);
	
	int remove(Integer capital_id);
	
	int batchRemove(Integer[] capitalIds);
}
