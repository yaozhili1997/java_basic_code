package com.ecotourism.manage.fin.service;

import com.ecotourism.manage.common.utils.PageTotal;
import com.ecotourism.manage.common.utils.R;
import com.ecotourism.manage.fin.domain.FinancialManagementDO;

import java.util.List;
import java.util.Map;

public interface FinancialManagementService {
    FinancialManagementDO get(Integer orderId);

    List<FinancialManagementDO> list(Map<String, Object> map);
    PageTotal findTotalCount(Map<String, Object> map);
    int count(Map<String, Object> map);

    R settlement(Map<String, Object> map);

}
