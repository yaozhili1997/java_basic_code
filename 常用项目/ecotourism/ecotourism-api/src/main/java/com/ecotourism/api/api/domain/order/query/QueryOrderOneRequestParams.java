package com.ecotourism.api.api.domain.order.query;

import com.ecotourism.api.api.domain.common.OpenIdRequestParams;
import com.ecotourism.api.common.annotation.Param;

/**
 * 说明：单订单查询
 * 创建人：陈启勇
 * 创建时间: 2018/10/22 10:55
 **/
public class QueryOrderOneRequestParams extends OpenIdRequestParams {
    @Param(notEmpty = true,errorMsg = "订单号不能为空!")
    private String orderNo;//订单号

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
