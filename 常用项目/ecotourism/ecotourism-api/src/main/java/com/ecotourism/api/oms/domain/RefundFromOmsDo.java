package com.ecotourism.api.oms.domain;

import com.ecotourism.api.api.domain.order.refund.RefundElectronic;

import java.util.List;

/**
 * 说明：从oms退票实体
 * 创建人：陈启勇
 * 创建时间: 2018/9/7 16:01
 **/
public class RefundFromOmsDo {
    private String orderNo;//订单号
    private List<RefundElectronic> data;
    public String getOrderNo() {
        return orderNo;
    }
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
    public List<RefundElectronic> getData() {
        return data;
    }
    public void setData(List<RefundElectronic> data) {
        this.data = data;
    }
}
