package com.ecotourism.supplier.device.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 设备表
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-07-09 19:17:58
 */
public class CarEquipmentDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//设备编码
	private String deviceNo;
	//设备名称
	private String deviceName;
	//设备mac地址
	private String deviceMac;
	//景点编号
	private String spotNo;
	//是否可用
	private Integer enable;
	//创建时间
	private Date createTime;
	//更新时间
	private Date updateTime;
	//创建人
	private String createUser;
	//修改人
	private String updateUser;
	//
	private String deviceMacEncrypt;
	//分销商编号
	private String distributionNo;
	//模板id
	private String templateNo;
	//设备编号
	private String equipmentNumber;
	//设备类型
	private String deviceType;
	//欢迎乘坐
	private String welcomeText;
	//贵港5号
	private String transitNo;
	//基础票价
	private BigDecimal basePrice;
	//车牌号
	private String carNo;
	//请刷卡
	private String prompt;
	//心跳时间
	private Date heartbeatTime;
	//
	private String longitude;
	//
	private String latitude;
	//基础信息
	private String baseText;
	//所属线路
	private String subordinateLine;
	//公司编号
	private String companyNo;
	//车辆编号
	private String vehicleNumber;
	//剩余纸张数
	private Integer leavePaper;
	//购票开关 0表示关，1表示开
	private String gouP;
	//取票开关 0表示关 1表示开
	private String quP;
	//
	private String passworldU;
	//总纸张数
	private Integer totalPaper;
	//取票模板
	private String getTicketTemplate;

	/**
	 * 设置：id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：设备编码
	 */
	public void setDeviceNo(String deviceNo) {
		this.deviceNo = deviceNo;
	}
	/**
	 * 获取：设备编码
	 */
	public String getDeviceNo() {
		return deviceNo;
	}
	/**
	 * 设置：设备名称
	 */
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	/**
	 * 获取：设备名称
	 */
	public String getDeviceName() {
		return deviceName;
	}
	/**
	 * 设置：设备mac地址
	 */
	public void setDeviceMac(String deviceMac) {
		this.deviceMac = deviceMac;
	}
	/**
	 * 获取：设备mac地址
	 */
	public String getDeviceMac() {
		return deviceMac;
	}
	/**
	 * 设置：景点编号
	 */
	public void setSpotNo(String spotNo) {
		this.spotNo = spotNo;
	}
	/**
	 * 获取：景点编号
	 */
	public String getSpotNo() {
		return spotNo;
	}
	/**
	 * 设置：是否可用
	 */
	public void setEnable(Integer enable) {
		this.enable = enable;
	}
	/**
	 * 获取：是否可用
	 */
	public Integer getEnable() {
		return enable;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreateUser() {
		return createUser;
	}
	/**
	 * 设置：修改人
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	/**
	 * 获取：修改人
	 */
	public String getUpdateUser() {
		return updateUser;
	}
	/**
	 * 设置：
	 */
	public void setDeviceMacEncrypt(String deviceMacEncrypt) {
		this.deviceMacEncrypt = deviceMacEncrypt;
	}
	/**
	 * 获取：
	 */
	public String getDeviceMacEncrypt() {
		return deviceMacEncrypt;
	}
	/**
	 * 设置：分销商编号
	 */
	public void setDistributionNo(String distributionNo) {
		this.distributionNo = distributionNo;
	}
	/**
	 * 获取：分销商编号
	 */
	public String getDistributionNo() {
		return distributionNo;
	}
	/**
	 * 设置：模板id
	 */
	public void setTemplateNo(String templateNo) {
		this.templateNo = templateNo;
	}
	/**
	 * 获取：模板id
	 */
	public String getTemplateNo() {
		return templateNo;
	}
	/**
	 * 设置：设备编号
	 */
	public void setEquipmentNumber(String equipmentNumber) {
		this.equipmentNumber = equipmentNumber;
	}
	/**
	 * 获取：设备编号
	 */
	public String getEquipmentNumber() {
		return equipmentNumber;
	}
	/**
	 * 设置：设备类型
	 */
	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}
	/**
	 * 获取：设备类型
	 */
	public String getDeviceType() {
		return deviceType;
	}
	/**
	 * 设置：欢迎乘坐
	 */
	public void setWelcomeText(String welcomeText) {
		this.welcomeText = welcomeText;
	}
	/**
	 * 获取：欢迎乘坐
	 */
	public String getWelcomeText() {
		return welcomeText;
	}
	/**
	 * 设置：贵港5号
	 */
	public void setTransitNo(String transitNo) {
		this.transitNo = transitNo;
	}
	/**
	 * 获取：贵港5号
	 */
	public String getTransitNo() {
		return transitNo;
	}
	/**
	 * 设置：基础票价
	 */
	public void setBasePrice(BigDecimal basePrice) {
		this.basePrice = basePrice;
	}
	/**
	 * 获取：基础票价
	 */
	public BigDecimal getBasePrice() {
		return basePrice;
	}
	/**
	 * 设置：车牌号
	 */
	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}
	/**
	 * 获取：车牌号
	 */
	public String getCarNo() {
		return carNo;
	}
	/**
	 * 设置：请刷卡
	 */
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}
	/**
	 * 获取：请刷卡
	 */
	public String getPrompt() {
		return prompt;
	}
	/**
	 * 设置：心跳时间
	 */
	public void setHeartbeatTime(Date heartbeatTime) {
		this.heartbeatTime = heartbeatTime;
	}
	/**
	 * 获取：心跳时间
	 */
	public Date getHeartbeatTime() {
		return heartbeatTime;
	}
	/**
	 * 设置：
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	/**
	 * 获取：
	 */
	public String getLongitude() {
		return longitude;
	}
	/**
	 * 设置：
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	/**
	 * 获取：
	 */
	public String getLatitude() {
		return latitude;
	}
	/**
	 * 设置：基础信息
	 */
	public void setBaseText(String baseText) {
		this.baseText = baseText;
	}
	/**
	 * 获取：基础信息
	 */
	public String getBaseText() {
		return baseText;
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
	/**
	 * 设置：车辆编号
	 */
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	/**
	 * 获取：车辆编号
	 */
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	/**
	 * 设置：剩余纸张数
	 */
	public void setLeavePaper(Integer leavePaper) {
		this.leavePaper = leavePaper;
	}
	/**
	 * 获取：剩余纸张数
	 */
	public Integer getLeavePaper() {
		return leavePaper;
	}
	/**
	 * 设置：购票开关 0表示关，1表示开
	 */
	public void setGouP(String gouP) {
		this.gouP = gouP;
	}
	/**
	 * 获取：购票开关 0表示关，1表示开
	 */
	public String getGouP() {
		return gouP;
	}
	/**
	 * 设置：取票开关 0表示关 1表示开
	 */
	public void setQuP(String quP) {
		this.quP = quP;
	}
	/**
	 * 获取：取票开关 0表示关 1表示开
	 */
	public String getQuP() {
		return quP;
	}
	/**
	 * 设置：
	 */
	public void setPassworldU(String passworldU) {
		this.passworldU = passworldU;
	}
	/**
	 * 获取：
	 */
	public String getPassworldU() {
		return passworldU;
	}
	/**
	 * 设置：总纸张数
	 */
	public void setTotalPaper(Integer totalPaper) {
		this.totalPaper = totalPaper;
	}
	/**
	 * 获取：总纸张数
	 */
	public Integer getTotalPaper() {
		return totalPaper;
	}
	/**
	 * 设置：取票模板
	 */
	public void setGetTicketTemplate(String getTicketTemplate) {
		this.getTicketTemplate = getTicketTemplate;
	}
	/**
	 * 获取：取票模板
	 */
	public String getGetTicketTemplate() {
		return getTicketTemplate;
	}
}
