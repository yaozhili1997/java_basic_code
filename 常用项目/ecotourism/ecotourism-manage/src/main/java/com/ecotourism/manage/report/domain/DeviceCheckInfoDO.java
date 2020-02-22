package com.ecotourism.manage.report.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-11-14 10:02:02
 */
public class DeviceCheckInfoDO implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	private Integer id;
	//电子票号
	private String electronicTicket;
	//分销商编号
	private String orderDistributor;
	//检票设备
	private String checkEquipmentNo;
	//检票时间
	private Date checkTime;
	//所属线路
	private String subordinateLine;
	//乘车人数
	private Integer rideNumber;
	//产品名称
	private String productName;
	//公司编号
	private String companyNo;
	private String vehicleNumber;
	private String lineName;
	private String carNo;

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
	 * 设置：分销商编号
	 */
	public void setOrderDistributor(String orderDistributor) {
		this.orderDistributor = orderDistributor;
	}
	/**
	 * 获取：分销商编号
	 */
	public String getOrderDistributor() {
		return orderDistributor;
	}
	/**
	 * 设置：检票设备
	 */
	public void setCheckEquipmentNo(String checkEquipmentNo) {
		this.checkEquipmentNo = checkEquipmentNo;
	}
	/**
	 * 获取：检票设备
	 */
	public String getCheckEquipmentNo() {
		return checkEquipmentNo;
	}
	/**
	 * 设置：检票时间
	 */
	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}
	/**
	 * 获取：检票时间
	 */
	public Date getCheckTime() {
		return checkTime;
	}
	/**
	 * 设置：所属线路
	 */
	public void setSubordinateLine(String subordinateLine) {
		this.subordinateLine = subordinateLine;
	}
	/**
	 * 获取：所属线路
	 */
	public String getSubordinateLine() {
		return subordinateLine;
	}
	/**
	 * 设置：乘车人数
	 */
	public void setRideNumber(Integer rideNumber) {
		this.rideNumber = rideNumber;
	}
	/**
	 * 获取：乘车人数
	 */
	public Integer getRideNumber() {
		return rideNumber;
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
	 * 设置：公司编号
	 */
	public void setCompanyNo(String companyNo) {
		this.companyNo = companyNo;
	}
	/**
	 * 获取：公司编号
	 */
	public String getCompanyNo() {
		return companyNo;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	public String getCarNo() {
		return carNo;
	}

	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
}
