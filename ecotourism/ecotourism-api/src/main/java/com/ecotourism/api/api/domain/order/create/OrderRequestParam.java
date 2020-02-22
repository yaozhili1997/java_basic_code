package com.ecotourism.api.api.domain.order.create;

import com.ecotourism.api.common.annotation.Param;

import java.util.List;

/**
 * 说明：创建应用订单请求参数
 * 创建人：陈启勇
 * 创建时间: 2018/8/23 9:45
 **/
public class OrderRequestParam {
    private String orderNo;//订单号
    @Param(notEmpty = true,errorMsg = "用户唯一标识不能为空!")
    private String openId;//用户唯一标识
    private String pushUserNo;//地推用户编号
    @Param(isEntity = true)
    private List<OrderProductData> data;//产品数据

    public String getOrderNo() {
        return orderNo;
    }
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public List<OrderProductData> getData() {
        return data;
    }
    public void setData(List<OrderProductData> data) {
        this.data = data;
    }
    public String getPushUserNo() {
        return pushUserNo;
    }
    public void setPushUserNo(String pushUserNo) {
        this.pushUserNo = pushUserNo;
    }
}
