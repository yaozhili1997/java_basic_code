package com.ecotourism.supplier.cooperation.service;

import com.ecotourism.supplier.common.utils.R;
import com.ecotourism.supplier.cooperation.domain.CooperationPrestoreDo;
import com.ecotourism.supplier.cooperation.domain.CooperationRechargeRecordDO;

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
