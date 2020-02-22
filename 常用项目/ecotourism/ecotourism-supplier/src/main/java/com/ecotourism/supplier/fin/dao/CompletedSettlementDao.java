package com.ecotourism.supplier.fin.dao;

import com.ecotourism.supplier.fin.domain.CompletedSettlementDO;
import com.ecotourism.supplier.fin.domain.SettlementDetailsDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 财务结算
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-07-10 20:14:13
 */
@Mapper
public interface CompletedSettlementDao {

	CompletedSettlementDO get(String id);
	
	List<CompletedSettlementDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);

	CompletedSettlementDO getCompletedSettlement(Map<String, Object> map);

	List<SettlementDetailsDO> getSettlementDetail(Map<String, Object> map);
}
