package com.ecotourism.api.application.domain;

import java.io.Serializable;


/**
 * 调用支付接口应用信息
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-08-20 17:08:55
 */
public class ApplicationDO implements Serializable {
	private static final long serialVersionUID = 1L;
	//用户编号
	private String userNo;
	//
	private String userName;
	//
	private String appId;
	//
	private String appKey;
	//微信
	private String wechatId;
	//支付宝
	private String alipayId;
	//分销商账号
	private String distributionNo;
	//微信支付宝授权回掉地址
	private String authorizedAddress;
	//oms接口地址
	private String baseUrlNo;
	//图片编号
	private String imgNo;
	//接口版本
	private String version;
	private String noticeBaseUrl;
	private String companyNo;
	private DistributionDO distribution;//供应商实体
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
	 * 设置：图片编号
	 */
	public void setImgNo(String imgNo) {
		this.imgNo = imgNo;
	}
	/**
	 * 获取：图片编号
	 */
	public String getImgNo() {
		return imgNo;
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

	public DistributionDO getDistribution() {
		return distribution;
	}
	public void setDistribution(DistributionDO distribution) {
		this.distribution = distribution;
	}

	public String getNoticeBaseUrl() {
		return noticeBaseUrl;
	}

	public void setNoticeBaseUrl(String noticeBaseUrl) {
		this.noticeBaseUrl = noticeBaseUrl;
	}

	public String getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(String companyNo) {
		this.companyNo = companyNo;
	}
}
