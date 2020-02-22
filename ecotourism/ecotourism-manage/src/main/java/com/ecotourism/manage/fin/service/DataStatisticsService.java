package com.ecotourism.manage.fin.service;

import com.ecotourism.manage.fin.domain.DataStatisticsDO;

import java.util.List;
import java.util.Map;

public interface DataStatisticsService {
    List<DataStatisticsDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);
}
