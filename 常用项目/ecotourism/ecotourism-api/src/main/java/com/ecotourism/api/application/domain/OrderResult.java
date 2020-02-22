package com.ecotourism.api.application.domain;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;
import java.util.List;

/**
 * 说明：查询订单返回
 * 创建人：陈启勇
 * 创建时间: 2018/8/31 17:58
 **/
public class OrderResult {
    private String openId;
    //订单编号
    private String orderNo;
    //产品编号
    private BigDecimal totalAmount;
    //购买时间
    private String purchaseTime;
    private String payType;
    //支付状态
    private String payStatus;
    @JSONField(serialize = false)
    private String applicationNo;
    private String pushUserNo;//地推用户编号
    private List<OrderDo> orders;

    public String getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(String applicationNo) {
        this.applicationNo = applicationNo;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(String purchaseTime) {
        this.purchaseTime = purchaseTime;
    }
    public List<OrderDo> getOrders() {
        return orders;
    }
    public void setOrders(List<OrderDo> orders) {
        this.orders = orders;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getPayStatus() {
        return payStatus;
    }
    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }
    public String getPushUserNo() {
        return pushUserNo;
    }
    public void setPushUserNo(String pushUserNo) {
        this.pushUserNo = pushUserNo;
    }
}
