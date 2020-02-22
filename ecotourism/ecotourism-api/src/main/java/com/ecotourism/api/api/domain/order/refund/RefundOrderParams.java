package com.ecotourism.api.api.domain.order.refund;

import com.ecotourism.api.application.domain.ApplicationOrderDO;
import com.ecotourism.api.oms.domain.RefundFromOmsDo;

import java.util.ArrayList;
import java.util.List;

/**
 * 说明：退单参数
 * 创建人：陈启勇
 * 创建时间: 2018/10/17 17:38
 **/
public class RefundOrderParams {
    private RefundFromOmsDo OmsDo = new RefundFromOmsDo();//需要到oms退订的订单
    private List<ApplicationOrderDO> orders=new ArrayList<>();//需要到oms退订的订单与OmsDo中data对应

    private List<ApplicationOrderDO> failureOrders=new ArrayList<>();//出票失败或退款失败的订单

    public RefundFromOmsDo getOmsDo() {
        return OmsDo;
    }

    public void setOmsDo(RefundFromOmsDo omsDo) {
        OmsDo = omsDo;
    }

    public List<ApplicationOrderDO> getOrders() {
        return orders;
    }

    public void setOrders(List<ApplicationOrderDO> orders) {
        this.orders = orders;
    }

    public List<ApplicationOrderDO> getFailureOrders() {
        return failureOrders;
    }
    public void setFailureOrders(List<ApplicationOrderDO> failureOrders) {
        this.failureOrders = failureOrders;
    }
}
