package com.ecotourism.manage.cooperation.dao;

import com.ecotourism.manage.cooperation.domain.CooperationCapitalFlowDo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * auther by Sea
 */
@Mapper
public interface CooperationCapitalFlowDao {
    List<CooperationCapitalFlowDo> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(CooperationCapitalFlowDo cooperationCapitalFlow);

    int update(CooperationCapitalFlowDo cooperationCapitalFlow);

    CooperationCapitalFlowDo get(Integer id);
}
