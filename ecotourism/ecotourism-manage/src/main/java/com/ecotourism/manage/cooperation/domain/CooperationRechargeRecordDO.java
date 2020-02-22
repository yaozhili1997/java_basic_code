package com.ecotourism.manage.cooperation.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * auther by Sea
 */
public class CooperationRechargeRecordDO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer rechargeId;   //充值记录id
    private String distributionNo;   //分销商编号
    private String rechargeFlowing;   //充值流水号
    private Double rechargePrice;   //充值金额
    private Double preDepositBalance;   //预存款余额
    private Date rechargeTime;   //充值时间
    private String remarks;   //备注
    private String createUser;   //操作人
    private Date createTime;   //操作时间
    private String distributionName;   //合作商名称

    public String getDistributionName() {
        return distributionName;
    }

    public void setDistributionName(String distributionName) {
        this.distributionName = distributionName;
    }

    private String companyNo;   //

    public CooperationRechargeRecordDO() {
    }

    public Integer getRechargeId() {
        return rechargeId;
    }

    public void setRechargeId(Integer rechargeId) {
        this.rechargeId = rechargeId;
    }

    public String getDistributionNo() {
        return distributionNo;
    }

    public void setDistributionNo(String distributionNo) {
        this.distributionNo = distributionNo;
    }

    public String getRechargeFlowing() {
        return rechargeFlowing;
    }

    public void setRechargeFlowing(String rechargeFlowing) {
        this.rechargeFlowing = rechargeFlowing;
    }

    public Double getRechargePrice() {
        return rechargePrice;
    }

    public void setRechargePrice(Double rechargePrice) {
        this.rechargePrice = rechargePrice;
    }

    public Double getPreDepositBalance() {
        return preDepositBalance;
    }

    public void setPreDepositBalance(Double preDepositBalance) {
        this.preDepositBalance = preDepositBalance;
    }

    public Date getRechargeTime() {
        return rechargeTime;
    }

    public void setRechargeTime(Date rechargeTime) {
        this.rechargeTime = rechargeTime;
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
