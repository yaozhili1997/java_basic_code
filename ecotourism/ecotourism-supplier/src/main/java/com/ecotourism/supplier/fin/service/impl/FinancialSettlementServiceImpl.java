package com.ecotourism.supplier.fin.service.impl;

import com.ecotourism.supplier.fin.dao.FinancialSettlementDao;
import com.ecotourism.supplier.fin.domain.FinancialSettlementDO;
import com.ecotourism.supplier.fin.service.FinancialSettlementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FinancialSettlementServiceImpl implements FinancialSettlementService {
    @Autowired
    private FinancialSettlementDao financialSettlementDao;

    @Override
    public FinancialSettlementDO get(Integer orderId){
        return financialSettlementDao.get(orderId);
    }

    @Override
    public List<FinancialSettlementDO> list(Map<String, Object> map){
        return financialSettlementDao.list(map);
    }

    @Override
    public int count(Map<String, Object> map){
        return financialSettlementDao.count(map);
    }

}
