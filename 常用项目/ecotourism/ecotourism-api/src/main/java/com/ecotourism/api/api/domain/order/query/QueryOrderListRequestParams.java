package com.ecotourism.api.api.domain.order.query;

import com.ecotourism.api.api.domain.common.OpenIdRequestParams;


/**
 * 说明：查询订单列表请求参数
 * 创建人：陈启勇
 * 创建时间: 2018/9/3 9:46
 **/
public class QueryOrderListRequestParams extends OpenIdRequestParams {
    /**
     * @Description 支付状态
     * @Author scotte
     * @Date 2018/8/29 15:46
     */
    private String payStatus;
    /**
     * @Description 订单状态
     * @Author scotte
     * @Date 2018/8/29 15:46
     */
    private String orderStatus;
    /**
     * @Description 退款状态
     * @Author scotte
     * @Date 2018/8/29 15:46
     */
    private String refundStatus;
    /**
     * @Description 游玩时间
     * @Author scotte
     * @Date 2018/8/29 15:46
     */
    private String playTime;
    /**
     * @Description 分页：当前页
     * @Author scotte
     * @Date 2018/8/29 15:46
     */
    private Integer pageNumber;
    /**
     * @Description 分页：每页行数
     * @Author scotte
     * @Date 2018/8/29 15:46
     */
    private Integer pageSize;

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getPayStatus() {
        return payStatus;
    }
    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
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
    @Override
    public String toString() {
        return "QueryOrderListRequestParams{" +
                "payStatus='" + payStatus + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                ", refundStatus='" + refundStatus + '\'' +
                ", playTime='" + playTime + '\'' +
                ", pageNumber=" + pageNumber +
                ", pageSize=" + pageSize +
                '}';
    }
}
