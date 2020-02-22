package com.ecotourism.manage.report.service;


import com.ecotourism.manage.common.utils.PageTotal;
import com.ecotourism.manage.report.domain.LineReportDO;

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
