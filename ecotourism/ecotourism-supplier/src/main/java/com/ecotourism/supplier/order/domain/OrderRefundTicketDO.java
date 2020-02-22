package com.ecotourism.supplier.order.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 退票管理
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-11 10:23:50
 */
public class OrderRefundTicketDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//退票id
	private Integer id;
	//订单编号
	private String orderNo;
	//客户名称
	private String customerName;
	//客户手机
	private String customerPhone;
	//申请人
	private String appUser;
	//申请时间
	private Date appTime;
	//退款时间
	private Date refundTime;
	//退票数量
	private Integer orderQuantity;
	//退票金额
	private BigDecimal refundAmount;
	//退票手续费
	private String counterFee;
	//退票状态
	private String refundState;
	//操作人
	private String createUser;
	//操作时间
	private Date createTime;
	//审核状态
	private String reviewState;
	//电子票
	private String electronicTicket;
	//备注
	private String bz;
	//公司编号
	private String companyNo;

	/**
	 * 设置：退票id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：退票id
	 */
	public Integer getId() {
		return id;
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
	 * 设置：客户手机
	 */
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	/**
	 * 获取：客户手机
	 */
	public String getCustomerPhone() {
		return customerPhone;
	}
	/**
	 * 设置：申请人
	 */
	public void setAppUser(String appUser) {
		this.appUser = appUser;
	}
	/**
	 * 获取：申请人
	 */
	public String getAppUser() {
		return appUser;
	}
	/**
	 * 设置：申请时间
	 */
	public void setAppTime(Date appTime) {
		this.appTime = appTime;
	}
	/**
	 * 获取：申请时间
	 */
	public Date getAppTime() {
		return appTime;
	}
	/**
	 * 设置：退款时间
	 */
	public void setRefundTime(Date refundTime) {
		this.refundTime = refundTime;
	}
	/**
	 * 获取：退款时间
	 */
	public Date getRefundTime() {
		return refundTime;
	}
	/**
	 * 设置：退票数量
	 */
	public void setOrderQuantity(Integer orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	/**
	 * 获取：退票数量
	 */
	public Integer getOrderQuantity() {
		return orderQuantity;
	}
	/**
	 * 设置：退票金额
	 */
	public void setRefundAmount(BigDecimal refundAmount) {
		this.refundAmount = refundAmount;
	}
	/**
	 * 获取：退票金额
	 */
	public BigDecimal getRefundAmount() {
		return refundAmount;
	}
	/**
	 * 设置：退票手续费
	 */
	public void setCounterFee(String counterFee) {
		this.counterFee = counterFee;
	}
	/**
	 * 获取：退票手续费
	 */
	public String getCounterFee() {
		return counterFee;
	}
	/**
	 * 设置：退票状态
	 */
	public void setRefundState(String refundState) {
		this.refundState = refundState;
	}
	/**
	 * 获取：退票状态
	 */
	public String getRefundState() {
		return refundState;
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
	 * 设置：审核状态
	 */
	public void setReviewState(String reviewState) {
		this.reviewState = reviewState;
	}
	/**
	 * 获取：审核状态
	 */
	public String getReviewState() {
		return reviewState;
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
	 * 设置：备注
	 */
	public void setBz(String bz) {
		this.bz = bz;
	}
	/**
	 * 获取：备注
	 */
	public String getBz() {
		return bz;
	}

	public String getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(String companyNo) {
		this.companyNo = companyNo;
	}
}
