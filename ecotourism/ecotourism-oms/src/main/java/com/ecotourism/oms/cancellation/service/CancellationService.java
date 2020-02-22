package com.ecotourism.oms.cancellation.service;

import com.ecotourism.oms.cancellation.domain.UscCancellationDO;

import java.util.List;

public interface CancellationService {

    /**
     * 优讯订单核销
     * @param list
     * @return
     */
    String cancellationUscOrder(List<UscCancellationDO> list);
}
