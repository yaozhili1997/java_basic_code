package com.ecotourism.manage.report.dao;

import com.ecotourism.manage.common.utils.PageTotal;
import com.ecotourism.manage.report.domain.PushUserReportDO;

import java.util.List;
import java.util.Map;

public interface PushUserReadDao {

    List<PushUserReportDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    PageTotal getPushUserReportSum(Map<String, Object> map);
}
