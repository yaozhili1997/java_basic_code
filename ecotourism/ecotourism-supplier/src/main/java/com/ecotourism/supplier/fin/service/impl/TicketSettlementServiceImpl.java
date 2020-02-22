package com.ecotourism.supplier.fin.service.impl;

import com.ecotourism.supplier.fin.domain.FinancialManagementDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.ecotourism.supplier.fin.dao.TicketSettlementDao;
import com.ecotourism.supplier.fin.domain.TicketSettlementDO;
import com.ecotourism.supplier.fin.service.TicketSettlementService;
import org.springframework.transaction.annotation.Transactional;


@Service
public class TicketSettlementServiceImpl implements TicketSettlementService {
	@Autowired
	private TicketSettlementDao ticketSettlementDao;
	
	@Override
	public TicketSettlementDO get(String id){
		return ticketSettlementDao.get(id);
	}
	
	@Override
	public List<TicketSettlementDO> list(Map<String, Object> map){
		return ticketSettlementDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return ticketSettlementDao.count(map);
	}
	
	@Override
	public int save(TicketSettlementDO ticketSettlement){
		return ticketSettlementDao.save(ticketSettlement);
	}
	
	@Override
	@Transactional
	public int update(TicketSettlementDO ticketSettlement){
		ticketSettlementDao.updateOrderSettlementStatus(ticketSettlement);
		return ticketSettlementDao.update(ticketSettlement);
	}

	@Override
	public int updateOrderSettlementStatus(TicketSettlementDO ticketSettlement) {
		return ticketSettlementDao.updateOrderSettlementStatus(ticketSettlement);
	}

	@Override
	public int remove(Integer id){
		return ticketSettlementDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return ticketSettlementDao.batchRemove(ids);
	}

	@Override
	public List<FinancialManagementDO> listExcel(Map<String, Object> map) {
		return ticketSettlementDao.listExcel(map);
	}

}
