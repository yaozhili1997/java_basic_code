package com.ecotourism.oms.oms.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * auther by Sea
 */
public class CooperationPrestoreDO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer prestoreId;   //主键
    private String prestoreNo;   //预存款编码
    private String distributionNo;   //合作商编码
    private BigDecimal prestoreAmount;   //预存款余额
    private BigDecimal upRechargeAmount;   //上次充值记录
    private BigDecimal totalRechargeAmount;   //累计充值
    private BigDecimal balanceThreshold;   //预警阈值
    private String thresholdPhone;   //阈值联系人
    private String thresholdStatus;   //阈值状态
    private String createUser;   //创建人
    private Date createTime;   //创建时间
    private String updateUser;   //更新人
    private Date updateTime;   //更新时间
    private String companyNo;   //公司编码

    private BigDecimal sellPrestoreAmount;

    private BigDecimal refundPrestoreAmount;

    public CooperationPrestoreDO() {
    }

    public Integer getPrestoreId() {
        return prestoreId;
    }

    public void setPrestoreId(Integer prestoreId) {
        this.prestoreId = prestoreId;
    }

    public String getPrestoreNo() {
        return prestoreNo;
    }

    public void setPrestoreNo(String prestoreNo) {
        this.prestoreNo = prestoreNo;
    }

    public String getDistributionNo() {
        return distributionNo;
    }

    public void setDistributionNo(String distributionNo) {
        this.distributionNo = distributionNo;
    }

    public BigDecimal getPrestoreAmount() {
        return prestoreAmount;
    }

    public void setPrestoreAmount(BigDecimal prestoreAmount) {
        this.prestoreAmount = prestoreAmount;
    }

    public BigDecimal getUpRechargeAmount() {
        return upRechargeAmount;
    }

    public void setUpRechargeAmount(BigDecimal upRechargeAmount) {
        this.upRechargeAmount = upRechargeAmount;
    }

    public BigDecimal getTotalRechargeAmount() {
        return totalRechargeAmount;
    }

    public void setTotalRechargeAmount(BigDecimal totalRechargeAmount) {
        this.totalRechargeAmount = totalRechargeAmount;
    }

    public BigDecimal getBalanceThreshold() {
        return balanceThreshold;
    }

    public void setBalanceThreshold(BigDecimal balanceThreshold) {
        this.balanceThreshold = balanceThreshold;
    }

    public String getThresholdPhone() {
        return thresholdPhone;
    }

    public void setThresholdPhone(String thresholdPhone) {
        this.thresholdPhone = thresholdPhone;
    }

    public String getThresholdStatus() {
        return thresholdStatus;
    }

    public void setThresholdStatus(String thresholdStatus) {
        this.thresholdStatus = thresholdStatus;
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

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCompanyNo() {
        return companyNo;
    }

    public void setCompanyNo(String companyNo) {
        this.companyNo = companyNo;
    }

    public BigDecimal getSellPrestoreAmount() {
        return sellPrestoreAmount;
    }

    public void setSellPrestoreAmount(BigDecimal sellPrestoreAmount) {
        this.sellPrestoreAmount = sellPrestoreAmount;
    }

    public BigDecimal getRefundPrestoreAmount() {
        return refundPrestoreAmount;
    }

    public void setRefundPrestoreAmount(BigDecimal refundPrestoreAmount) {
        this.refundPrestoreAmount = refundPrestoreAmount;
    }
}
