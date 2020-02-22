package com.ecotourism.manage.fin.dao;

import com.ecotourism.manage.fin.domain.DataStatisticsDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface DataStatisticsDao {

    List<DataStatisticsDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);
}
