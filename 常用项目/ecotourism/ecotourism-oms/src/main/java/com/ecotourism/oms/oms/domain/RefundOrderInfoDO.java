package com.ecotourism.oms.oms.domain;

import java.io.Serializable;

public class RefundOrderInfoDO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String orderNo;
    private String isSelf;
    private String url;
    private String cid;
    private String appId;
    private String appKey;
    private String piaogoOrderNo;
    private String serviceClass;
    //电子票
    private String electronicTicket;

    private String threeOrderId;
    private String accessToken;
    private int quantity;
    private String uid;
    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getIsSelf() {
        return isSelf;
    }

    public void setIsSelf(String isSelf) {
        this.isSelf = isSelf;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getPiaogoOrderNo() {
        return piaogoOrderNo;
    }

    public void setPiaogoOrderNo(String piaogoOrderNo) {
        this.piaogoOrderNo = piaogoOrderNo;
    }

    public String getElectronicTicket() {
        return electronicTicket;
    }

    public void setElectronicTicket(String electronicTicket) {
        this.electronicTicket = electronicTicket;
    }

    public String getServiceClass() {
        return serviceClass;
    }

    public void setServiceClass(String serviceClass) {
        this.serviceClass = serviceClass;
    }

    public String getThreeOrderId() {
        return threeOrderId;
    }

    public void setThreeOrderId(String threeOrderId) {
        this.threeOrderId = threeOrderId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
