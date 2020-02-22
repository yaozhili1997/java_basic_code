package com.ecotourism.manage.fin.domain;

import java.io.Serializable;
import java.math.BigDecimal;


/**
 * 财务结算
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-07-10 20:14:13
 */
public class SettlementDetailsDO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String productName;

	private BigDecimal payPrice;
	//结算数量
	private Integer settlementNumber;
	//结算金额
	private BigDecimal settlementAcoumt;
	//退票金额
	private BigDecimal refundAcoumt;
	//退票数量
	private Integer refundNum;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public BigDecimal getPayPrice() {
		return payPrice;
	}

	public void setPayPrice(BigDecimal payPrice) {
		this.payPrice = payPrice;
	}

	public Integer getSettlementNumber() {
		return settlementNumber;
	}

	public void setSettlementNumber(Integer settlementNumber) {
		this.settlementNumber = settlementNumber;
	}

	public BigDecimal getSettlementAcoumt() {
		return settlementAcoumt;
	}

	public void setSettlementAcoumt(BigDecimal settlementAcoumt) {
		this.settlementAcoumt = settlementAcoumt;
	}

	public BigDecimal getRefundAcoumt() {
		return refundAcoumt;
	}

	public void setRefundAcoumt(BigDecimal refundAcoumt) {
		this.refundAcoumt = refundAcoumt;
	}

	public Integer getRefundNum() {
		return refundNum;
	}

	public void setRefundNum(Integer refundNum) {
		this.refundNum = refundNum;
	}
}
