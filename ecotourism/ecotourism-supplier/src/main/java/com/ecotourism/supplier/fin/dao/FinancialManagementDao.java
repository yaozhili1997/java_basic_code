package com.ecotourism.supplier.fin.dao;

import com.ecotourism.supplier.common.utils.PageTotal;
import com.ecotourism.supplier.fin.domain.FinancialManagementDO;
import com.ecotourism.supplier.fin.domain.FinancialSettlementDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface FinancialManagementDao {

    FinancialManagementDO get(Integer orderId);

    List<FinancialManagementDO> list(Map<String, Object> map);
    PageTotal findTotalCount(Map<String, Object> map);

    int count(Map<String, Object> map);

    List<FinancialSettlementDO> settlement(Map<String, Object> map);

    int update(Map<String, Object> map);
}
