package com.ecotourism.supplier.payment.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 调用支付接口用户信息
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-06-08 10:43:48
 */
public class PaymentUserDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//用户编号
	private String userNo;
	//应用名称
	private String userName;
	//appId
	private String appId;
	//appKey
	private String appKey;
	//微信
	private String wechatId;
	private String wechatName;
	//支付宝
	private String alipayId;
	private String alipayName;
	//分销商账号
	private String distributionNo;
	private String distributionName;
	//微信支付宝授权回掉地址
	private String authorizedAddress;
	//oms接口地址
	private String baseUrlNo;
	//接口版本
	private String version;
	//备注
	private String bz;
	//是否启用
	private String available="0";
	//
	private Date createTime;
	//
	private Date updateTime;
	//
	private String createUser;
	//
	private String updateUser;
	//所属公司
	private String companyNo;

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
	 * 设置：用户编号
	 */
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	/**
	 * 获取：用户编号
	 */
	public String getUserNo() {
		return userNo;
	}
	/**
	 * 设置：
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：
	 */
	public void setAppId(String appId) {
		this.appId = appId;
	}
	/**
	 * 获取：
	 */
	public String getAppId() {
		return appId;
	}
	/**
	 * 设置：
	 */
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}
	/**
	 * 获取：
	 */
	public String getAppKey() {
		return appKey;
	}
	/**
	 * 设置：微信
	 */
	public void setWechatId(String wechatId) {
		this.wechatId = wechatId;
	}
	/**
	 * 获取：微信
	 */
	public String getWechatId() {
		return wechatId;
	}
	/**
	 * 设置：支付宝
	 */
	public void setAlipayId(String alipayId) {
		this.alipayId = alipayId;
	}
	/**
	 * 获取：支付宝
	 */
	public String getAlipayId() {
		return alipayId;
	}
	/**
	 * 设置：分销商账号
	 */
	public void setDistributionNo(String distributionNo) {
		this.distributionNo = distributionNo;
	}
	/**
	 * 获取：分销商账号
	 */
	public String getDistributionNo() {
		return distributionNo;
	}
	/**
	 * 设置：微信支付宝授权回掉地址
	 */
	public void setAuthorizedAddress(String authorizedAddress) {
		this.authorizedAddress = authorizedAddress;
	}
	/**
	 * 获取：微信支付宝授权回掉地址
	 */
	public String getAuthorizedAddress() {
		return authorizedAddress;
	}
	/**
	 * 设置：oms接口地址
	 */
	public void setBaseUrlNo(String baseUrlNo) {
		this.baseUrlNo = baseUrlNo;
	}
	/**
	 * 获取：oms接口地址
	 */
	public String getBaseUrlNo() {
		return baseUrlNo;
	}
	/**
	 * 设置：接口版本
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	/**
	 * 获取：接口版本
	 */
	public String getVersion() {
		return version;
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
	/**
	 * 设置：是否启用
	 */
	public void setAvailable(String available) {
		this.available = available;
	}
	/**
	 * 获取：是否启用
	 */
	public String getAvailable() {
		return available;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取：
	 */
	public String getCreateUser() {
		return createUser;
	}
	/**
	 * 设置：
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	/**
	 * 获取：
	 */
	public String getUpdateUser() {
		return updateUser;
	}
	/**
	 * 设置：所属公司
	 */
	public void setCompanyNo(String companyNo) {
		this.companyNo = companyNo;
	}
	/**
	 * 获取：所属公司
	 */
	public String getCompanyNo() {
		return companyNo;
	}

	public String getWechatName() {
		return wechatName;
	}

	public void setWechatName(String wechatName) {
		this.wechatName = wechatName;
	}

	public String getAlipayName() {
		return alipayName;
	}

	public void setAlipayName(String alipayName) {
		this.alipayName = alipayName;
	}

	public String getDistributionName() {
		return distributionName;
	}

	public void setDistributionName(String distributionName) {
		this.distributionName = distributionName;
	}
}
