package com.ecotourism.api.api.domain.order.refund;

import com.ecotourism.api.api.domain.common.CommonOrderRequest;
import com.ecotourism.api.common.annotation.Param;

/**
 * 说明：退单请求
 * 创建人：陈启勇
 * 创建时间: 2018/9/7 14:19
 **/
public class RefundRequestParams extends CommonOrderRequest {
    @Param(notEmpty = true,errorMsg = "用户唯一标识不能为空!")
    private String openId;//用户唯一标识
    private String productNo;
    private String subOrderNo;
    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getSubOrderNo() {
        return subOrderNo;
    }

    public void setSubOrderNo(String subOrderNo) {
        this.subOrderNo = subOrderNo;
    }
}
