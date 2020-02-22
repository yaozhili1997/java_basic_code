package com.ecotourism.manage.fin.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 财务结算
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-07-10 20:14:13
 */
public class TicketSettlementDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//结算编码
	private String settlementNo;
	//售票人
	private String sellUser;
	//结算数量
	private Integer settlementNumber;
	//结算金额
	private BigDecimal settlementAcoumt;
	//结算人
	private String settlementUser;
	//结算时间
	private Date settlementTime;
	//景点
	private String spotNo;
	//售票时间
	private Date sellTicketTime;
	//退票金额
	private BigDecimal refundAcoumt;
	//应收金额
	private BigDecimal receivableAmount;
	//退票数量
	private Integer refundNum;
	//结算状态
	private String settlementStatus;
	//审核人
	private String settlementReviewPerson;
	//审核时间
	private Date settlementReviewTime;
	//审核金额
	private BigDecimal reviewAmount;
	//公司编码
	private String companyNo;

	private String remarks;

	//订单状态
	private String orderStatus;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
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
	 * 设置：售票人
	 */
	public void setSellUser(String sellUser) {
		this.sellUser = sellUser;
	}
	/**
	 * 获取：售票人
	 */
	public String getSellUser() {
		return sellUser;
	}
	/**
	 * 设置：结算数量
	 */
	public void setSettlementNumber(Integer settlementNumber) {
		this.settlementNumber = settlementNumber;
	}
	/**
	 * 获取：结算数量
	 */
	public Integer getSettlementNumber() {
		return settlementNumber;
	}
	/**
	 * 设置：结算金额
	 */
	public void setSettlementAcoumt(BigDecimal settlementAcoumt) {
		this.settlementAcoumt = settlementAcoumt;
	}
	/**
	 * 获取：结算金额
	 */
	public BigDecimal getSettlementAcoumt() {
		return settlementAcoumt;
	}
	/**
	 * 设置：结算人
	 */
	public void setSettlementUser(String settlementUser) {
		this.settlementUser = settlementUser;
	}
	/**
	 * 获取：结算人
	 */
	public String getSettlementUser() {
		return settlementUser;
	}
	/**
	 * 设置：结算时间
	 */
	public void setSettlementTime(Date settlementTime) {
		this.settlementTime = settlementTime;
	}
	/**
	 * 获取：结算时间
	 */
	public Date getSettlementTime() {
		return settlementTime;
	}
	/**
	 * 设置：景点
	 */
	public void setSpotNo(String spotNo) {
		this.spotNo = spotNo;
	}
	/**
	 * 获取：景点
	 */
	public String getSpotNo() {
		return spotNo;
	}
	/**
	 * 设置：售票时间
	 */
	public void setSellTicketTime(Date sellTicketTime) {
		this.sellTicketTime = sellTicketTime;
	}
	/**
	 * 获取：售票时间
	 */
	public Date getSellTicketTime() {
		return sellTicketTime;
	}
	/**
	 * 设置：退票金额
	 */
	public void setRefundAcoumt(BigDecimal refundAcoumt) {
		this.refundAcoumt = refundAcoumt;
	}
	/**
	 * 获取：退票金额
	 */
	public BigDecimal getRefundAcoumt() {
		return refundAcoumt;
	}
	/**
	 * 设置：应收金额
	 */
	public void setReceivableAmount(BigDecimal receivableAmount) {
		this.receivableAmount = receivableAmount;
	}
	/**
	 * 获取：应收金额
	 */
	public BigDecimal getReceivableAmount() {
		return receivableAmount;
	}
	/**
	 * 设置：退票数量
	 */
	public void setRefundNum(Integer refundNum) {
		this.refundNum = refundNum;
	}
	/**
	 * 获取：退票数量
	 */
	public Integer getRefundNum() {
		return refundNum;
	}
	/**
	 * 设置：结算状态
	 */
	public void setSettlementStatus(String settlementStatus) {
		this.settlementStatus = settlementStatus;
	}
	/**
	 * 获取：结算状态
	 */
	public String getSettlementStatus() {
		return settlementStatus;
	}
	/**
	 * 设置：审核人
	 */
	public void setSettlementReviewPerson(String settlementReviewPerson) {
		this.settlementReviewPerson = settlementReviewPerson;
	}
	/**
	 * 获取：审核人
	 */
	public String getSettlementReviewPerson() {
		return settlementReviewPerson;
	}
	/**
	 * 设置：审核时间
	 */
	public void setSettlementReviewTime(Date settlementReviewTime) {
		this.settlementReviewTime = settlementReviewTime;
	}
	/**
	 * 获取：审核时间
	 */
	public Date getSettlementReviewTime() {
		return settlementReviewTime;
	}
	/**
	 * 设置：审核金额
	 */
	public void setReviewAmount(BigDecimal reviewAmount) {
		this.reviewAmount = reviewAmount;
	}
	/**
	 * 获取：审核金额
	 */
	public BigDecimal getReviewAmount() {
		return reviewAmount;
	}
	/**
	 * 设置：公司编码
	 */
	public void setCompanyNo(String companyNo) {
		this.companyNo = companyNo;
	}
	/**
	 * 获取：公司编码
	 */
	public String getCompanyNo() {
		return companyNo;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
}
