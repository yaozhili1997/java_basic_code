package com.ecotourism.supplier.report.service;


import com.ecotourism.supplier.common.utils.PageTotal;
import com.ecotourism.supplier.report.domain.LineReportDO;

import java.util.List;
import java.util.Map;

public interface ReportService {
    String getTodaySaleTotal(Map<String, Object> map);
    String getTodayLineTotal(Map<String, Object> map);
    String getTodayDeviceTotal(Map<String, Object> map);
    List<LineReportDO> getLineReport(Map<String, Object> map);
    int getLineReportCount(Map<String, Object> map);
    PageTotal getLineReportSum(Map<String, Object> map);

    List<LineReportDO> getCarReport(Map<String, Object> map);
    int getCarReportCount(Map<String, Object> map);
    PageTotal getCarReportSum(Map<String, Object> map);

}
