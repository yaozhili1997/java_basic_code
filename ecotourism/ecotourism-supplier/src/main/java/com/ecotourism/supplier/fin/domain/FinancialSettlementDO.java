package com.ecotourism.supplier.fin.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class FinancialSettlementDO implements Serializable {

    private static final long serialVersionUID = 1L;
    private String orderDistributor;
    private String spotNo;
    private Integer  orderQuantity;
    private BigDecimal  totalAmount;
    private Integer  totalCount;
    private BigDecimal  refundAmount;
    private BigDecimal  receivableAmount;
    private Integer  refundNum;
    public String getOrderDistributor() {
        return orderDistributor;
    }

    public void setOrderDistributor(String orderDistributor) {
        this.orderDistributor = orderDistributor;
    }

    public String getSpotNo() {
        return spotNo;
    }

    public void setSpotNo(String spotNo) {
        this.spotNo = spotNo;
    }

    public Integer getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(Integer orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public BigDecimal getReceivableAmount() {
        return receivableAmount;
    }

    public void setReceivableAmount(BigDecimal receivableAmount) {
        this.receivableAmount = receivableAmount;
    }

    public Integer getRefundNum() {
        return refundNum;
    }

    public void setRefundNum(Integer refundNum) {
        this.refundNum = refundNum;
    }
}
