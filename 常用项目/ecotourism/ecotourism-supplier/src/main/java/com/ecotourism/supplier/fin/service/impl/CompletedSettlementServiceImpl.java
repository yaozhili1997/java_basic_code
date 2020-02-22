package com.ecotourism.supplier.fin.service.impl;

import com.ecotourism.supplier.fin.dao.CompletedSettlementDao;
import com.ecotourism.supplier.fin.domain.CompletedSettlementDO;
import com.ecotourism.supplier.fin.domain.SettlementDetailsDO;
import com.ecotourism.supplier.fin.service.CompletedSettlementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class CompletedSettlementServiceImpl implements CompletedSettlementService {
	@Autowired
	private CompletedSettlementDao completedSettlementDao;
	
	@Override
	public CompletedSettlementDO get(String id){
		return completedSettlementDao.get(id);
	}
	
	@Override
	public List<CompletedSettlementDO> list(Map<String, Object> map){
		return completedSettlementDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return completedSettlementDao.count(map);
	}

	@Override
	public CompletedSettlementDO getCompletedSettlement(Map<String, Object> map) {
		return completedSettlementDao.getCompletedSettlement(map);
	}

	@Override
	public List<SettlementDetailsDO> getSettlementDetail(Map<String, Object> map) {
		return completedSettlementDao.getSettlementDetail(map);
	}


}
