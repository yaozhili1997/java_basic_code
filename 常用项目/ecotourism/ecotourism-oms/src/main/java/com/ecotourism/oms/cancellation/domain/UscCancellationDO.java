package com.ecotourism.oms.cancellation.domain;

import java.io.Serializable;
import java.util.Date;

public class UscCancellationDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String orderNo;
    private String productNo;
    private String electTicket;
    private Date checkTime;
    private int nums;
    private String noticeType;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getElectTicket() {
        return electTicket;
    }

    public void setElectTicket(String electTicket) {
        this.electTicket = electTicket;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public int getNums() {
        return nums;
    }

    public void setNums(int nums) {
        this.nums = nums;
    }

    public String getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType;
    }
}
