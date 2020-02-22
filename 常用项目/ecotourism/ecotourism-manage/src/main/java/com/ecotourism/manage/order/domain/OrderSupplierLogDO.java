package com.ecotourism.manage.order.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-11-22 10:19:11
 */
public class OrderSupplierLogDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//订单编号
	private String orderNo;
	//内部编号
	private String piaogoOrderNo;
	//状态
	private String status;
	//信息
	private String msg;
	//时间
	private Date crateTime;

	private String electronicTicket;

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
	 * 设置：内部编号
	 */
	public void setPiaogoOrderNo(String piaogoOrderNo) {
		this.piaogoOrderNo = piaogoOrderNo;
	}
	/**
	 * 获取：内部编号
	 */
	public String getPiaogoOrderNo() {
		return piaogoOrderNo;
	}
	/**
	 * 设置：状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：信息
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	/**
	 * 获取：信息
	 */
	public String getMsg() {
		return msg;
	}
	/**
	 * 设置：时间
	 */
	public void setCrateTime(Date crateTime) {
		this.crateTime = crateTime;
	}
	/**
	 * 获取：时间
	 */
	public Date getCrateTime() {
		return crateTime;
	}

	public String getElectronicTicket() {
		return electronicTicket;
	}

	public void setElectronicTicket(String electronicTicket) {
		this.electronicTicket = electronicTicket;
	}
}
