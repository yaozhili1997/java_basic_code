package com.ecotourism.supplier.fin.dao;

import com.ecotourism.supplier.fin.domain.FinancialManagementDO;
import com.ecotourism.supplier.fin.domain.TicketSettlementDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 财务结算
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-07-10 20:14:13
 */
@Mapper
public interface TicketSettlementDao {

	TicketSettlementDO get(String id);
	
	List<TicketSettlementDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(TicketSettlementDO ticketSettlement);
	
	int update(TicketSettlementDO ticketSettlement);

	int updateOrderSettlementStatus(TicketSettlementDO ticketSettlement);

	int remove(Integer id);
	
	int batchRemove(Integer[] ids);

	List<FinancialManagementDO> listExcel(Map<String, Object> map);
}
