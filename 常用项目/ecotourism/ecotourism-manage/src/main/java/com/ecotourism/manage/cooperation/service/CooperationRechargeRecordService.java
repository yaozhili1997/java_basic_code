package com.ecotourism.manage.cooperation.service;

import com.ecotourism.manage.common.utils.R;
import com.ecotourism.manage.cooperation.domain.CooperationPrestoreDo;
import com.ecotourism.manage.cooperation.domain.CooperationRechargeRecordDO;

import java.util.List;
import java.util.Map;

/**
 * auther by Sea
 */
public interface CooperationRechargeRecordService {
    List<CooperationRechargeRecordDO> list(Map<String, Object> map);

    int count(Map<String, Object> map);

    R save(CooperationPrestoreDo cooperationPrestore);
}
