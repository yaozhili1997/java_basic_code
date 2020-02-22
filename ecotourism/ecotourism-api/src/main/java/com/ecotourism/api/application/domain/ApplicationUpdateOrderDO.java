package com.ecotourism.api.application.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 订单修改实体
 * @author 陈启勇
 * @date 2018-08-21 10:00:53
 */
public class ApplicationUpdateOrderDO implements Serializable {
	private static final long serialVersionUID = 1L;
	//订单编号
	private String orderNo;
	//商户订单号
	private String outTradeNo;
	//电子票
	private String electronicTicket;
	//支付状态
	private String payStatus;
	//订单状态
	private String orderStatus;
	//退款状态
	private String refundStatus;
	//短信状态
	private String messageStatus;
	//检票设备编码
	private String checkEquipmentNo;
	//检票时间
	private String checkTime;
	//取票凭证码
	private String orderVoucherno;
	//退票(审核)时间
	private String refundTime;
	//是否使用公交
	private Integer isTransit;
	//乘车时间
	private String transitTime;
	//设备编号
	private String deviceNo;
	//应用用户唯一标识
	private String openId;
	//二维码地址
	private String qrcodeUrl;
	private String applicationNo;
	private String omsResult;
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
	 * 设置：短信状态
	 */
	public void setMessageStatus(String messageStatus) {
		this.messageStatus = messageStatus;
	}
	/**
	 * 获取：短信状态
	 */
	public String getMessageStatus() {
		return messageStatus;
	}
	/**
	 * 设置：检票设备编码
	 */
	public void setCheckEquipmentNo(String checkEquipmentNo) {
		this.checkEquipmentNo = checkEquipmentNo;
	}
	/**
	 * 获取：检票设备编码
	 */
	public String getCheckEquipmentNo() {
		return checkEquipmentNo;
	}
	/**
	 * 设置：检票时间
	 */
	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}
	/**
	 * 获取：检票时间
	 */
	public String getCheckTime() {
		return checkTime;
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
	 * 设置：是否使用公交
	 */
	public void setIsTransit(Integer isTransit) {
		this.isTransit = isTransit;
	}
	/**
	 * 获取：是否使用公交
	 */
	public Integer getIsTransit() {
		return isTransit;
	}
	/**
	 * 设置：乘车时间
	 */
	public void setTransitTime(String transitTime) {
		this.transitTime = transitTime;
	}
	/**
	 * 获取：乘车时间
	 */
	public String getTransitTime() {
		return transitTime;
	}
	/**
	 * 设置：设备编号
	 */
	public void setDeviceNo(String deviceNo) {
		this.deviceNo = deviceNo;
	}
	/**
	 * 获取：设备编号
	 */
	public String getDeviceNo() {
		return deviceNo;
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

	public String getApplicationNo() {
		return applicationNo;
	}
	public void setApplicationNo(String applicationNo) {
		this.applicationNo = applicationNo;
	}

	public String getOmsResult() {
		return omsResult;
	}

	public void setOmsResult(String omsResult) {
		this.omsResult = omsResult;
	}
}
