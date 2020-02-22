package com.ecotourism.supplier.payment.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 微信公众号或小程序信息管理
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-06-08 10:43:48
 */
public class WechatDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//微信编号
	private String wechatNo;
	//名称
	private String name;
	//支付商户编号
	private String mchNo;
	private String mchName;
	//公众账号ID
	private String appId;
	//密钥
	private String appSecret;
	//通知地址
	private String notifyUrl;
	//商品描述
	private String body;
	//备注
	private String bz;
	//是否启用
	private String available;
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
	 * 设置：微信编号
	 */
	public void setWechatNo(String wechatNo) {
		this.wechatNo = wechatNo;
	}
	/**
	 * 获取：微信编号
	 */
	public String getWechatNo() {
		return wechatNo;
	}
	/**
	 * 设置：名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：支付商户编号
	 */
	public void setMchNo(String mchNo) {
		this.mchNo = mchNo;
	}
	/**
	 * 获取：支付商户编号
	 */
	public String getMchNo() {
		return mchNo;
	}
	/**
	 * 设置：公众账号ID
	 */
	public void setAppId(String appId) {
		this.appId = appId;
	}
	/**
	 * 获取：公众账号ID
	 */
	public String getAppId() {
		return appId;
	}
	/**
	 * 设置：密钥
	 */
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
	/**
	 * 获取：密钥
	 */
	public String getAppSecret() {
		return appSecret;
	}
	/**
	 * 设置：通知地址
	 */
	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}
	/**
	 * 获取：通知地址
	 */
	public String getNotifyUrl() {
		return notifyUrl;
	}
	/**
	 * 设置：商品描述
	 */
	public void setBody(String body) {
		this.body = body;
	}
	/**
	 * 获取：商品描述
	 */
	public String getBody() {
		return body;
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

	public String getMchName() {
		return mchName;
	}

	public void setMchName(String mchName) {
		this.mchName = mchName;
	}

}
