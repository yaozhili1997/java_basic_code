package com.ecotourism.manage.common.utils;

/**
 * 说明：统计
 * 创建人：chqy
 * 创建时间: 2018/11/5 15:57
 **/
public class PageTotal {
    private String totalNum;
    private String totalAmount;
    private String refundAmount;

    public String getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(String totalNum) {
        this.totalNum = totalNum;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(String refundAmount) {
        this.refundAmount = refundAmount;
    }
}
