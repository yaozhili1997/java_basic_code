package com.ecotourism.api.application.domain;

import java.math.BigDecimal;

/**
 * 应用订单
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-08-21 10:00:53
 */
public class ApplicationOrderDO{
	private static final long serialVersionUID = 1L;
	//客户名称
	private String customerName;
	//客户电话
	private String customerPhone;
	//客户身份证
	private String customerUserId;
	//订单编号
	private String orderNo;
	private String subOrderNo;
	//商户订单号
	private String outTradeNo;
	//电子票
	private String electronicTicket;
	//产品编号
	private String productNo;
	//产品名称
	private String productName;
	//数量
	private Integer orderQuantity;
	//售价
	private BigDecimal payPrice;
	//总金额
	private BigDecimal totalAmount;
	private BigDecimal refundAmount;
	//支付方式
	private String payType;
	//支付状态
	private String payStatus;
	//订单状态
	private String orderStatus;
	//退款状态
	private String refundStatus;
	//购买时间
	private String purchaseTime;
	//游玩时间
	private String playTime;
	//取票凭证码
	private String orderVoucherno;
	//退票(审核)时间
	private String refundTime;
	//地推用户编号
	private String pushUserNo;
	//应用用户唯一标识
	private String openId;
	//来源支付应用编号
	private String applicationNo;
	//二维码地址
	private String qrcodeUrl;
	//到供应商下单返回结果
	private String omsResult;
	//商户退款单号
	private String outRefundNo;
	private String checkTime;
	/**
	 * 设置：客户名称
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * 获取：客户名称
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * 设置：客户电话
	 */
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	/**
	 * 获取：客户电话
	 */
	public String getCustomerPhone() {
		return customerPhone;
	}
	/**
	 * 设置：客户身份证
	 */
	public void setCustomerUserId(String customerUserId) {
		this.customerUserId = customerUserId;
	}
	/**
	 * 获取：客户身份证
	 */
	public String getCustomerUserId() {
		return customerUserId;
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
	public String getSubOrderNo() {
		return subOrderNo;
	}
	public void setSubOrderNo(String subOrderNo) {
		this.subOrderNo = subOrderNo;
	}

	/**
	 * 设置：商户订单号
	 */
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}
	/**
	 * 获取：商户订单号
	 */
	public String getOutTradeNo() {
		return outTradeNo;
	}
	/**
	 * 设置：电子票
	 */
	public void setElectronicTicket(String electronicTicket) {
		this.electronicTicket = electronicTicket;
	}
	/**
	 * 获取：电子票
	 */
	public String getElectronicTicket() {
		return electronicTicket;
	}
	/**
	 * 设置：产品编号
	 */
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	/**
	 * 获取：产品编号
	 */
	public String getProductNo() {
		return productNo;
	}
	/**
	 * 设置：产品名称
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * 获取：产品名称
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * 设置：数量
	 */
	public void setOrderQuantity(Integer orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	/**
	 * 获取：数量
	 */
	public Integer getOrderQuantity() {
		return orderQuantity;
	}
	/**
	 * 设置：售价
	 */
	public void setPayPrice(BigDecimal payPrice) {
		this.payPrice = payPrice;
	}
	/**
	 * 获取：售价
	 */
	public BigDecimal getPayPrice() {
		return payPrice;
	}
	/**
	 * 设置：总金额
	 */
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	/**
	 * 获取：总金额
	 */
	public BigDecimal getTotalAmount() {
		return totalAmount;
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
	 * 设置：支付状态
	 */
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}
	/**
	 * 获取：支付状态
	 */
	public String getPayStatus() {
		return payStatus;
	}
	/**
	 * 设置：订单状态
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	/**
	 * 获取：订单状态
	 */
	public String getOrderStatus() {
		return orderStatus;
	}
	/**
	 * 设置：退款状态
	 */
	public void setRefundStatus(String refundStatus) {
		this.refundStatus = refundStatus;
	}
	/**
	 * 获取：退款状态
	 */
	public String getRefundStatus() {
		return refundStatus;
	}
	/**
	 * 设置：购买时间
	 */
	public void setPurchaseTime(String purchaseTime) {
		this.purchaseTime = purchaseTime;
	}
	/**
	 * 获取：购买时间
	 */
	public String getPurchaseTime() {
		return purchaseTime;
	}
	/**
	 * 设置：游玩时间
	 */
	public void setPlayTime(String playTime) {
		this.playTime = playTime;
	}
	/**
	 * 获取：游玩时间
	 */
	public String getPlayTime() {
		return playTime;
	}
	/**
	 * 设置：取票凭证码
	 */
	public void setOrderVoucherno(String orderVoucherno) {
		this.orderVoucherno = orderVoucherno;
	}
	/**
	 * 获取：取票凭证码
	 */
	public String getOrderVoucherno() {
		return orderVoucherno;
	}
	/**
	 * 设置：退票(审核)时间
	 */
	public void setRefundTime(String refundTime) {
		this.refundTime = refundTime;
	}
	/**
	 * 获取：退票(审核)时间
	 */
	public String getRefundTime() {
		return refundTime;
	}
	/**
	 * 设置：地推用户编号
	 */
	public void setPushUserNo(String pushUserNo) {
		this.pushUserNo = pushUserNo;
	}
	/**
	 * 获取：地推用户编号
	 */
	public String getPushUserNo() {
		return pushUserNo;
	}
	/**
	 * 设置：应用用户唯一标识
	 */
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	/**
	 * 获取：应用用户唯一标识
	 */
	public String getOpenId() {
		return openId;
	}
	/**
	 * 设置：来源支付应用编号
	 */
	public void setApplicationNo(String applicationNo) {
		this.applicationNo = applicationNo;
	}
	/**
	 * 获取：来源支付应用编号
	 */
	public String getApplicationNo() {
		return applicationNo;
	}
	/**
	 * 设置：二维码地址
	 */
	public void setQrcodeUrl(String qrcodeUrl) {
		this.qrcodeUrl = qrcodeUrl;
	}
	/**
	 * 获取：二维码地址
	 */
	public String getQrcodeUrl() {
		return qrcodeUrl;
	}
	/**
	 * 设置：到供应商下单返回结果
	 */
	public void setOmsResult(String omsResult) {
		this.omsResult = omsResult;
	}
	/**
	 * 获取：到供应商下单返回结果
	 */
	public String getOmsResult() {
		return omsResult;
	}

	public BigDecimal getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(BigDecimal refundAmount) {
		this.refundAmount = refundAmount;
	}

	public String getOutRefundNo() {
		return outRefundNo;
	}

	public void setOutRefundNo(String outRefundNo) {
		this.outRefundNo = outRefundNo;
	}

	public String getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}
}
