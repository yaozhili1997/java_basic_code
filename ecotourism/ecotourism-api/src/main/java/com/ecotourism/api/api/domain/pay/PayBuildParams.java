package com.ecotourism.api.api.domain.pay;

import com.ecotourism.api.api.domain.common.CommonOrderRequest;
import com.ecotourism.api.application.domain.OrderResult;

/**
 * 说明：创建支付传入参数
 * 创建人：陈启勇
 * 创建时间: 2018/9/4 10:37
 **/
public class PayBuildParams extends CommonOrderRequest {
    private OrderResult order;//需支付的订单
    private String body;//支付body
    private String jsonDetail;//支付详情

    public OrderResult getOrder() {
        return order;
    }
    public void setOrder(OrderResult order) {
        this.order = order;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public String getJsonDetail() {
        return jsonDetail;
    }

    public void setJsonDetail(String jsonDetail) {
        this.jsonDetail = jsonDetail;
    }
}
