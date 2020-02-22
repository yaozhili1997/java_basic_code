package com.ecotourism.api.api.domain.order.refund;

import java.math.BigDecimal;

/**
 * 说明：退款参数
 * 创建人：陈启勇
 * 创建时间: 2018/8/24 10:31
 **/
public class RefundMoneyDo {
    //订单编号
    private String orderNo;
    //商户退款单号
    private String outRefundNo;
    //退款金额
    private BigDecimal refundAmount;
    //总金额
    private BigDecimal totalAmount;
    private String applicationNo;
    private String refundMsg;//退票备注

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(String applicationNo) {
        this.applicationNo = applicationNo;
    }

    public String getRefundMsg() {
        return refundMsg;
    }

    public void setRefundMsg(String refundMsg) {
        this.refundMsg = refundMsg;
    }
}
