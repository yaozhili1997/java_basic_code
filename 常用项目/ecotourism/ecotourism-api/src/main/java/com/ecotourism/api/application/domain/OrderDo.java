package com.ecotourism.api.application.domain;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;

/**
 * 说明：订单信息
 * 创建人：陈启勇
 * 创建时间: 2018/9/3 9:26
 **/
public class OrderDo {
    private String subOrderNo;
    //客户名称
    private String customerName;
    //客户电话
    private String customerPhone;
    //客户身份证
    private String customerUserId;
    //产品编号
    private String productNo;
    //产品名称
    private String productName;
    //产品图片
    private String productImg;
    //数量
    private Integer orderQuantity;
    private String electronicTicket;
    //售价
    private BigDecimal payPrice;
    //支付方式
    private String payType;
    //总金额
    private BigDecimal totalAmount;
    //退票金额
    @JSONField(serialize = false)
    private BigDecimal refundAmount;
    //订单状态
    private String orderStatus;
    //退款状态
    private String refundStatus;
    //游玩时间
    private String playTime;
    //取票凭证码
    private String orderVoucherno;
    //二维码地址
    private String qrcodeUrl;
    private String checkTime;
    //商户退款单号
    @JSONField(serialize = false)
    private String outRefundNo;
    //国家
    private String country;
    //省
    private String province;
    private String city;
    //地区
    private String region;
    //详细地址
    private String detailAddress;
    public String getSubOrderNo() {
        return subOrderNo;
    }

    public void setSubOrderNo(String subOrderNo) {
        this.subOrderNo = subOrderNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerUserId() {
        return customerUserId;
    }

    public void setCustomerUserId(String customerUserId) {
        this.customerUserId = customerUserId;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(Integer orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public BigDecimal getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(BigDecimal payPrice) {
        this.payPrice = payPrice;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
    }
    public String getPlayTime() {
        return playTime;
    }
    public void setPlayTime(String playTime) {
        this.playTime = playTime;
    }
    public String getOrderVoucherno() {
        return orderVoucherno;
    }
    public void setOrderVoucherno(String orderVoucherno) {
        this.orderVoucherno = orderVoucherno;
    }
    public String getQrcodeUrl() {
        return qrcodeUrl;
    }
    public void setQrcodeUrl(String qrcodeUrl) {
        this.qrcodeUrl = qrcodeUrl;
    }
    public String getElectronicTicket() {
        return electronicTicket;
    }
    public void setElectronicTicket(String electronicTicket) {
        this.electronicTicket = electronicTicket;
    }
    public BigDecimal getRefundAmount() {
        return refundAmount;
    }
    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public String getOutRefundNo() {
        return outRefundNo;
    }

    public void setOutRefundNo(String outRefundNo) {
        this.outRefundNo = outRefundNo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }
}
