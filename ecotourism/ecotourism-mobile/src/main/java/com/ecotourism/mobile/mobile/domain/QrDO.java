package com.ecotourism.mobile.mobile.domain;

import java.sql.Time;
import java.util.Date;

public class QrDO {
    /**
     * 订单号
     */
    private String orderId;

    /**
     * 电子票号
     */
    private String electronicTicket;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 游玩时间
     */
    private Date playTime;

    /**
     * 数量
     */
    private int orderQuantity;

    /**
     * 景区名称
     */
    private String spotName;

    /**
     * 开园时间
     */
    private Time openingHours;

    /**
     * 停止检票时间
     */
    private Time stopCheckingTime;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getElectronicTicket() {
        return electronicTicket;
    }

    public void setElectronicTicket(String electronicTicket) {
        this.electronicTicket = electronicTicket;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getPlayTime() {
        return playTime;
    }

    public void setPlayTime(Date playTime) {
        this.playTime = playTime;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public String getSpotName() {
        return spotName;
    }

    public void setSpotName(String spotName) {
        this.spotName = spotName;
    }

    public Time getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(Time openingHours) {
        this.openingHours = openingHours;
    }

    public Time getStopCheckingTime() {
        return stopCheckingTime;
    }

    public void setStopCheckingTime(Time stopCheckingTime) {
        this.stopCheckingTime = stopCheckingTime;
    }
}
