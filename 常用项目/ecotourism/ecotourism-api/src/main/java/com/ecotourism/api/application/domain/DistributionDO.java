package com.ecotourism.api.application.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 分销商管理
 * @author 陈启勇
 * @date 2018-08-23 15:37:38
 */
public class DistributionDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String distributionNo;
	//合作商名称
	private String name;
	//客服电话
	private String customerServicePhone;
	//渠道
	private String saleChannelCode;
	//商户号
	private String adminLoginId;
	//appSecret
	private String appSecret;
	//appID
	private String appId;
	//支付方式
	private String payType;
	//是否开启高级加密
	private String whetherMoreEncode;
	private String baseUrl;

	/**
	 * 设置：
	 */
	public void setDistributionNo(String distributionNo) {
		this.distributionNo = distributionNo;
	}
	/**
	 * 获取：
	 */
	public String getDistributionNo() {
		return distributionNo;
	}
	/**
	 * 设置：合作商名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：合作商名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：客服电话
	 */
	public void setCustomerServicePhone(String customerServicePhone) {
		this.customerServicePhone = customerServicePhone;
	}
	/**
	 * 获取：客服电话
	 */
	public String getCustomerServicePhone() {
		return customerServicePhone;
	}
	/**
	 * 设置：商户号
	 */
	public void setAdminLoginId(String adminLoginId) {
		this.adminLoginId = adminLoginId;
	}
	/**
	 * 获取：商户号
	 */
	public String getAdminLoginId() {
		return adminLoginId;
	}
	/**
	 * 设置：appSecret
	 */
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
	/**
	 * 获取：appSecret
	 */
	public String getAppSecret() {
		return appSecret;
	}
	/**
	 * 设置：appID
	 */
	public void setAppId(String appId) {
		this.appId = appId;
	}
	/**
	 * 获取：appID
	 */
	public String getAppId() {
		return appId;
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
	 * 设置：是否开启高级加密
	 */
	public void setWhetherMoreEncode(String whetherMoreEncode) {
		this.whetherMoreEncode = whetherMoreEncode;
	}
	/**
	 * 获取：是否开启高级加密
	 */
	public String getWhetherMoreEncode() {
		return whetherMoreEncode;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getSaleChannelCode() {
		return saleChannelCode;
	}

	public void setSaleChannelCode(String saleChannelCode) {
		this.saleChannelCode = saleChannelCode;
	}
}
