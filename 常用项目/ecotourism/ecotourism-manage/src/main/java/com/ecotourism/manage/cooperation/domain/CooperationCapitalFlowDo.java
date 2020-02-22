package com.ecotourism.manage.cooperation.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * auther by Sea
 */
public class CooperationCapitalFlowDo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer capitalId;   //资金流水ID
    private String distributionNo;   //合作商编码
    private String settlementNo;   //结算编码
    private String orderNo;   //订单编号
    private String payType;   //支付方式
    private Double houston;   //进账（收款）
    private Double outOfAccount;   //出账（付款）
    private Date transactionTime;   //交易时间
    private String remarks;   //备注
    private String createUser;   //操作人
    private Date createTime;   //操作时间
    private String companyNo;

    public CooperationCapitalFlowDo() {
    }

    public Integer getCapitalId() {
        return capitalId;
    }

    public void setCapitalId(Integer capitalId) {
        this.capitalId = capitalId;
    }

    public String getDistributionNo() {
        return distributionNo;
    }

    public void setDistributionNo(String distributionNo) {
        this.distributionNo = distributionNo;
    }

    public String getSettlementNo() {
        return settlementNo;
    }

    public void setSettlementNo(String settlementNo) {
        this.settlementNo = settlementNo;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public Double getHouston() {
        return houston;
    }

    public void setHouston(Double houston) {
        this.houston = houston;
    }

    public Double getOutOfAccount() {
        return outOfAccount;
    }

    public void setOutOfAccount(Double outOfAccount) {
        this.outOfAccount = outOfAccount;
    }

    public Date getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(Date transactionTime) {
        this.transactionTime = transactionTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCompanyNo() {
        return companyNo;
    }

    public void setCompanyNo(String companyNo) {
        this.companyNo = companyNo;
    }
}
