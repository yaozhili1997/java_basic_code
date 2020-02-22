package com.ecotourism.supplier.fin.service;

import com.ecotourism.supplier.fin.domain.FinancialSettlementDO;

import java.util.List;
import java.util.Map;

public interface FinancialSettlementService {
    FinancialSettlementDO get(Integer orderId);

    List<FinancialSettlementDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);
}
