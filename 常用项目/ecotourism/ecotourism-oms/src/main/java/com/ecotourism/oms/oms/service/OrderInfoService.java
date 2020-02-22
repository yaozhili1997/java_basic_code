package com.ecotourism.oms.oms.service;

import com.alibaba.fastjson.JSONObject;
import com.ecotourism.oms.oms.config.ResultMsg;
import com.ecotourism.oms.oms.domain.OrderSpotDO;
import com.ecotourism.oms.oms.domain.RequestVo;

import java.util.List;
import java.util.Map;

public interface OrderInfoService {

    String getOrderStatus(RequestVo requestVo, String orderType);

    String getOrder(RequestVo requestVo, String orderType);

    ResultMsg allowCancel(RequestVo requestVo, ResultMsg resultMsg);

    int cancelOrder(RequestVo requestVo, ResultMsg resultMsg);

    List<OrderSpotDO> getCancelOrder(RequestVo requestVo, String type);

    ResultMsg allowRefund(RequestVo requestVo, ResultMsg resultMsg);

    int refundOrder(OrderSpotDO orderSpotDO);

    ResultMsg checkUpdateData(RequestVo requestVo);

    ResultMsg allowUpdate(RequestVo requestVo);

    int updateOrder(OrderSpotDO orderSpotDO, RequestVo requestVo);

}
