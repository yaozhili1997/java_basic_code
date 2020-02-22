package com.ecotourism.api.api.domain.order.notice;

import com.ecotourism.api.application.domain.ApplicationDO;
import com.ecotourism.api.application.domain.OrderResult;
import com.ecotourism.api.common.annotation.Param;

/**
 * 说明：支付通知参数类
 * 创建人：陈启勇
 * 创建时间: 2018/8/24 11:07
 **/
public class PayNoticeVo {
    @Param(notEmpty = true,errorMsg = "支付通知参数：商户号不能为空!")
    private String outTradeNo;//商户号
    private String tradeNo;//交易流水号
    /**
     * @Description 单位:分
     * @Author scotte
     * @Date 2018/8/24 11:13
     * @Param
     * @return
     */
    @Param(notEmpty = true,errorMsg = "支付通知参数：总金额不能为空!")
    private int totalAmount;//总金额
    @Param(notEmpty = true,errorMsg = "用户openId不能为空!")
    private String openId;//openId
    @Param(notEmpty = true,errorMsg = "应用不存在!")
    private ApplicationDO app;
    @Param(notEmpty = true,errorMsg = "订单不存在!")
    private OrderResult order;
    private String basePath;

    public String getTradeNo() {
        return tradeNo;
    }
    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }
    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }
    public String getOpenId() {
        return openId;
    }
    public void setOpenId(String openId) {
        this.openId = openId;
    }
    public ApplicationDO getApp() {
        return app;
    }
    public void setApp(ApplicationDO app) {
        this.app = app;
    }
    public OrderResult getOrder() {
        return order;
    }
    public void setOrder(OrderResult order) {
        this.order = order;
    }
    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }
}
