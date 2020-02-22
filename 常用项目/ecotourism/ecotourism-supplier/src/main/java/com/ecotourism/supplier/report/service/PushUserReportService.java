package com.ecotourism.supplier.report.service;

import com.ecotourism.supplier.common.utils.PageTotal;
import com.ecotourism.supplier.report.domain.PushUserReportDO;

import java.util.List;
import java.util.Map;

public interface PushUserReportService {

    List<PushUserReportDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    PageTotal getPushUserReportSum(Map<String, Object> map);
}
