package com.ecotourism.manage.fin.service;

import com.ecotourism.manage.fin.domain.CompletedSettlementDO;
import com.ecotourism.manage.fin.domain.SettlementDetailsDO;

import java.util.List;
import java.util.Map;

/**
 * 财务结算
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-07-10 20:14:13
 */
public interface CompletedSettlementService {

	CompletedSettlementDO get(String id);
	
	List<CompletedSettlementDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);

	CompletedSettlementDO getCompletedSettlement(Map<String, Object> map);

	List<SettlementDetailsDO> getSettlementDetail(Map<String, Object> map);
}
