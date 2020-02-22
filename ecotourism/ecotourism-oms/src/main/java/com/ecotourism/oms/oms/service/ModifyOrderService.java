package com.ecotourism.oms.oms.service;

import com.ecotourism.oms.oms.config.Const;
import com.ecotourism.oms.oms.domain.RequestVo;

public interface ModifyOrderService {

    String modifyOrder(RequestVo requestVo);

    String refundOrder(RequestVo requestVo, String orderType);

    String cancelOrder(RequestVo requestVo, String orderType);
}
