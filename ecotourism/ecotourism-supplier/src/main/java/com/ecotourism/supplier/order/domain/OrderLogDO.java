package com.ecotourism.supplier.order.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 订单日志
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-11 10:23:50
 */
public class OrderLogDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//日志id
	private Integer id;
	//订单编号
	private String orderNo;
	//日志类型
	private String logType;
	//日志内容
	private String logContent;
	//操作人
	private String createUser;
	//操作时间
	private Date createTime;
	//分销商
	private String orderDistributor;
	//取票设备编码
	private String selfMachineNo;
	//电子票号
	private String electronicTicket;
	//取票数量
	private Integer orderQuantity;
	//公司编号
	private String companyNo;

	/**
	 * 设置：日志id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：日志id
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
	 * 设置：日志类型
	 */
	public void setLogType(String logType) {
		this.logType = logType;
	}
	/**
	 * 获取：日志类型
	 */
	public String getLogType() {
		return logType;
	}
	/**
	 * 设置：日志内容
	 */
	public void setLogContent(String logContent) {
		this.logContent = logContent;
	}
	/**
	 * 获取：日志内容
	 */
	public String getLogContent() {
		return logContent;
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
	 * 设置：分销商
	 */
	public void setOrderDistributor(String orderDistributor) {
		this.orderDistributor = orderDistributor;
	}
	/**
	 * 获取：分销商
	 */
	public String getOrderDistributor() {
		return orderDistributor;
	}
	/**
	 * 设置：取票设备编码
	 */
	public void setSelfMachineNo(String selfMachineNo) {
		this.selfMachineNo = selfMachineNo;
	}
	/**
	 * 获取：取票设备编码
	 */
	public String getSelfMachineNo() {
		return selfMachineNo;
	}
	/**
	 * 设置：电子票号
	 */
	public void setElectronicTicket(String electronicTicket) {
		this.electronicTicket = electronicTicket;
	}
	/**
	 * 获取：电子票号
	 */
	public String getElectronicTicket() {
		return electronicTicket;
	}
	/**
	 * 设置：取票数量
	 */
	public void setOrderQuantity(Integer orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	/**
	 * 获取：取票数量
	 */
	public Integer getOrderQuantity() {
		return orderQuantity;
	}

	public String getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(String companyNo) {
		this.companyNo = companyNo;
	}
}
