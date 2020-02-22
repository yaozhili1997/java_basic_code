package com.ecotourism.oms.oms.service;

import com.ecotourism.oms.oms.domain.OrderSpotDO;
import com.ecotourism.oms.oms.domain.RefundOrderInfoDO;

/**
 * 供应商接口
 * @author: scotte
 * @create: 2018-07-07 15:39
 **/
public interface SupplierApi {
    /**
    * 退单
    * @author: scotte
    * @create: 2018/7/10 10:46
    **/
    OrderSpotDO refundOrder(RefundOrderInfoDO refundOrderInfoDO, OrderSpotDO order);


}
