package com.ecotourism.supplier.fin.dao;

import com.ecotourism.supplier.fin.domain.FinancialSettlementDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface FinancialSettlementDao {

    FinancialSettlementDO get(Integer orderId);

    List<FinancialSettlementDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);
}
