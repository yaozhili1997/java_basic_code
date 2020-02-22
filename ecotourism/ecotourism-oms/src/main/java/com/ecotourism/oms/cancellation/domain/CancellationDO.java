package com.ecotourism.oms.cancellation.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 门票订单
 * 
 * @author 陈启勇
 * @email 1992lcg@163.com
 * @date 2018-06-11 10:23:50
 */
public class CancellationDO implements Serializable {
	private static final long serialVersionUID = 1L;
	//订单编号
	private String orderNo;
	//电子票
	private String electronicTicket;
	//产品编号
	private String productNo;
	//订单状态
	private String orderStatus;
	//退款状态
	private String refundStatus;
	//检票时间
	private Date checkTime;
	//退票(审核)时间
	private Date refundTime;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getElectronicTicket() {
		return electronicTicket;
	}

	public void setElectronicTicket(String electronicTicket) {
		this.electronicTicket = electronicTicket;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
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

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	public Date getRefundTime() {
		return refundTime;
	}

	public void setRefundTime(Date refundTime) {
		this.refundTime = refundTime;
	}
}
