package com.ecotourism.oms.oms.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 资金流水管理
 * 
 * @author ³ÂÆôÓÂ
 * @email chqy_ljy@163.com
 * @date 2018-10-12 10:14:15
 */
public class CapitalFlowDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//资金流水ID
	private Integer capitalId;
	//合作商编码
	private String distributionNo;
	//结算编码
	private String settlementNo;
	//订单编号
	private String orderNo;
	//支付方式
	private String payType;
	//进账（收款）
	private BigDecimal houston;
	//出账（付款）
	private BigDecimal outOfAccount;
	//交易时间
	private Date transactionTime;
	//备注
	private String remarks;
	//操作人
	private String createUser;
	//操作时间
	private Date createTime;
	//
	private String companyNo;

	/**
	 * 设置：资金流水ID
	 */
	public void setCapitalId(Integer capitalId) {
		this.capitalId = capitalId;
	}
	/**
	 * 获取：资金流水ID
	 */
	public Integer getCapitalId() {
		return capitalId;
	}
	/**
	 * 设置：合作商编码
	 */
	public void setDistributionNo(String distributionNo) {
		this.distributionNo = distributionNo;
	}
	/**
	 * 获取：合作商编码
	 */
	public String getDistributionNo() {
		return distributionNo;
	}
	/**
	 * 设置：结算编码
	 */
	public void setSettlementNo(String settlementNo) {
		this.settlementNo = settlementNo;
	}
	/**
	 * 获取：结算编码
	 */
	public String getSettlementNo() {
		return settlementNo;
	}
	/**
	 * 设置：订单编号
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	/**
	 * 获取：订单编号
	 */
	public String getOrderNo() {
		return orderNo;
	}
	/**
	 * 设置：支付方式
	 */
	public void setPayType(String payType) {
		this.payType = payType;
	}
	/**
	 * 获取：支付方式
	 */
	public String getPayType() {
		return payType;
	}
	/**
	 * 设置：进账（收款）
	 */
	public void setHouston(BigDecimal houston) {
		this.houston = houston;
	}
	/**
	 * 获取：进账（收款）
	 */
	public BigDecimal getHouston() {
		return houston;
	}
	/**
	 * 设置：出账（付款）
	 */
	public void setOutOfAccount(BigDecimal outOfAccount) {
		this.outOfAccount = outOfAccount;
	}
	/**
	 * 获取：出账（付款）
	 */
	public BigDecimal getOutOfAccount() {
		return outOfAccount;
	}
	/**
	 * 设置：交易时间
	 */
	public void setTransactionTime(Date transactionTime) {
		this.transactionTime = transactionTime;
	}
	/**
	 * 获取：交易时间
	 */
	public Date getTransactionTime() {
		return transactionTime;
	}
	/**
	 * 设置：备注
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * 获取：备注
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * 设置：操作人
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取：操作人
	 */
	public String getCreateUser() {
		return createUser;
	}
	/**
	 * 设置：操作时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：操作时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：
	 */
	public void setCompanyNo(String companyNo) {
		this.companyNo = companyNo;
	}
	/**
	 * 获取：
	 */
	public String getCompanyNo() {
		return companyNo;
	}
}
