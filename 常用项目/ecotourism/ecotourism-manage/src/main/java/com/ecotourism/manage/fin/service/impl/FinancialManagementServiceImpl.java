package com.ecotourism.manage.fin.service.impl;

import com.ecotourism.manage.common.utils.PageTotal;
import com.ecotourism.manage.common.utils.R;
import com.ecotourism.manage.common.utils.RandomUtils;
import com.ecotourism.manage.common.utils.ShiroUtils;
import com.ecotourism.manage.fin.domain.FinancialSettlementDO;
import com.ecotourism.manage.fin.domain.TicketSettlementDO;
import com.ecotourism.manage.fin.service.FinancialManagementService;
import com.ecotourism.manage.fin.dao.FinancialManagementDao;
import com.ecotourism.manage.fin.domain.FinancialManagementDO;
import com.ecotourism.manage.fin.service.TicketSettlementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class FinancialManagementServiceImpl implements FinancialManagementService {
    @Autowired
    private FinancialManagementDao financialManagementDao;
    @Autowired
    private TicketSettlementService ticketSettlementService;
    @Override
    public FinancialManagementDO get(Integer orderId){
        return financialManagementDao.get(orderId);
    }

    @Override
    public List<FinancialManagementDO> list(Map<String, Object> map){
        return financialManagementDao.list(map);
    }
    @Override
    public PageTotal findTotalCount(Map<String, Object> map){
        return financialManagementDao.findTotalCount(map);
    }

    @Override
    public int count(Map<String, Object> map){
        return financialManagementDao.count(map);
    }

    @Override
    @Transactional
    public R settlement(Map<String, Object> map) {
        List<FinancialSettlementDO> list = financialManagementDao.settlement(map);
        for(FinancialSettlementDO bean:list){
            TicketSettlementDO ticketSettlement = new TicketSettlementDO();
            String settlementNo = RandomUtils.getSettlementNo(bean.getOrderDistributor());
            ticketSettlement.setCompanyNo(ShiroUtils.getUser().getCompanyNo());
            ticketSettlement.setSettlementNo(settlementNo);
            ticketSettlement.setSellUser(bean.getOrderDistributor());
            ticketSettlement.setSettlementNumber(bean.getOrderQuantity());
            ticketSettlement.setSettlementAcoumt(bean.getTotalAmount());
            ticketSettlement.setSettlementUser(ShiroUtils.getUser().getUsername());
            ticketSettlement.setSettlementTime(new Date());
            ticketSettlement.setSpotNo(bean.getSpotNo());
            ticketSettlement.setSellTicketTime(new Date());
            ticketSettlement.setRefundAcoumt(bean.getRefundAmount());
            ticketSettlement.setReceivableAmount(bean.getReceivableAmount());
            ticketSettlement.setRefundNum(bean.getRefundNum());
            ticketSettlement.setSettlementStatus("031001");
            ticketSettlementService.save(ticketSettlement);
            //更新订单表结算状态
            map.put("settlementNo",settlementNo);
            map.put("whetherSettlement","031001");
            map.put("spotNo",bean.getSpotNo());
            map.put("orderDistributor",bean.getOrderDistributor());
            financialManagementDao.update(map);
        }
        return R.ok();
    }

}
