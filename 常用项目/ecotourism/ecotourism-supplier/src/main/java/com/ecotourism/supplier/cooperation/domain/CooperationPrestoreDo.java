package com.ecotourism.supplier.cooperation.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * auther by Sea
 */
public class CooperationPrestoreDo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer prestoreId;   //主键
    private String prestoreNo;   //预存款编码
    private String distributionNo;   //合作商编码
    private String distributionName;   //合作商名称
    private Double prestoreAmount;   //预存款余额
    private Double upRechargeAmount;   //上次充值记录
    private Double totalRechargeAmount;   //累计充值
    private Double balanceThreshold;   //预警阈值
    private String thresholdPhone;   //阈值联系人
    private String thresholdStatus;   //阈值状态
    private String createUser;   //创建人
    private Date createTime;   //创建时间
    private String updateUser;   //更新人
    private Date updateTime;   //更新时间
    private String companyNo;   //公司编码
    private String remarks;

    public CooperationPrestoreDo() {
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

    public Double getPrestoreAmount() {
        return prestoreAmount;
    }

    public void setPrestoreAmount(Double prestoreAmount) {
        this.prestoreAmount = prestoreAmount;
    }

    public Double getUpRechargeAmount() {
        return upRechargeAmount;
    }

    public void setUpRechargeAmount(Double upRechargeAmount) {
        this.upRechargeAmount = upRechargeAmount;
    }

    public Double getTotalRechargeAmount() {
        return totalRechargeAmount;
    }

    public void setTotalRechargeAmount(Double totalRechargeAmount) {
        this.totalRechargeAmount = totalRechargeAmount;
    }

    public Double getBalanceThreshold() {
        return balanceThreshold;
    }

    public void setBalanceThreshold(Double balanceThreshold) {
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
    public String getDistributionName() {
        return distributionName;
    }
    public void setDistributionName(String distributionName) {
        this.distributionName = distributionName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
