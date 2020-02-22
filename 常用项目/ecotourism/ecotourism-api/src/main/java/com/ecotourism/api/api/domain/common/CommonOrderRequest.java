package com.ecotourism.api.api.domain.common;

import com.ecotourism.api.common.annotation.Param;

/**
 * 说明：公共订单接口请求参数
 * 创建人：陈启勇
 * 创建时间: 2018/8/23 9:58
 **/
public class CommonOrderRequest {
    @Param(notEmpty = true,errorMsg = "订单号不能为空!")
    private String orderNo;//订单号

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
