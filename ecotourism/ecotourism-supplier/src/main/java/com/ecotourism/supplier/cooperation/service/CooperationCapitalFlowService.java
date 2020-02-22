package com.ecotourism.supplier.cooperation.service;
import com.ecotourism.supplier.cooperation.domain.CooperationCapitalFlowDo;

import java.util.List;
import java.util.Map;

/**
 * auther by Sea
 */
public interface CooperationCapitalFlowService {
    List<CooperationCapitalFlowDo> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(CooperationCapitalFlowDo cooperationCapitalFlow);

    int update(CooperationCapitalFlowDo cooperationCapitalFlow);

    CooperationCapitalFlowDo get(Integer id);
}
