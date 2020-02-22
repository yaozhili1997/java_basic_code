package com.ecotourism.supplier.report.dao;

import com.ecotourism.supplier.common.utils.PageTotal;
import com.ecotourism.supplier.report.domain.PushUserReportDO;

import java.util.List;
import java.util.Map;

public interface PushUserReadDao {

    List<PushUserReportDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    PageTotal getPushUserReportSum(Map<String, Object> map);
}
