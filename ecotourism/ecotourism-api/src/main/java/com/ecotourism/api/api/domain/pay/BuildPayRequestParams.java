package com.ecotourism.api.api.domain.pay;

import com.ecotourism.api.api.domain.common.OpenIdRequestParams;
import com.ecotourism.api.common.annotation.Param;

/**
 * 说明：创建支付请求参数
 * 创建人：陈启勇
 * 创建时间: 2018/10/31 16:55
 **/
public class BuildPayRequestParams extends OpenIdRequestParams {
    @Param(notEmpty = true,errorMsg = "订单号不能为空!")
    private String orderNo;//订单号

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
