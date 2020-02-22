package com.ecotourism.mobile.common.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderApiUrlConfig {

    @Value("${ecotourism.orderApiBaseUrl}")
    private String baseUrl;

    @Value("${ecotourism.orderMobileApiBaseUrl}")
    private String orderMobileApiBaseUrl;

    @Value("${ecotourism.applicationNo}")
    private String applicationNo;

    public String getListProductsUrl() {
        return getBaseUrl() +  "app/clientHelper/listProducts?applicationNo=" + applicationNo;
    }

    public String getProductUrl() {
        return getBaseUrl() +  "app/clientHelper/getProduct?applicationNo=" + applicationNo;
    }

    public String getCreateOrderUrl() {
        return getBaseUrl() +  "app/clientHelper/createOrder?applicationNo=" + applicationNo;
    }

    public String getWechatUserinfo() {
        return getBaseUrl() +  "app/clientHelper/getWechatUserinfo?applicationNo=" + applicationNo;
    }

    public String getAlipayUserinfo() {
        return getBaseUrl() +  "app/clientHelper/getAlipayUserinfo?applicationNo=" + applicationNo;
    }

    public String getWxPayUrl() {
        return getBaseUrl() +  "app/clientHelper/wechatPay?applicationNo=" + applicationNo;
    }

    public String getAlipayParams() {
        return getBaseUrl() +  "app/clientHelper/alipayPay?applicationNo=" + applicationNo;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(String applicationNo) {
        this.applicationNo = applicationNo;
    }

    public String getOrderMobileApiBaseUrl() {
        return orderMobileApiBaseUrl;
    }

    public void setOrderMobileApiBaseUrl(String orderMobileApiBaseUrl) {
        this.orderMobileApiBaseUrl = orderMobileApiBaseUrl;
    }
}
