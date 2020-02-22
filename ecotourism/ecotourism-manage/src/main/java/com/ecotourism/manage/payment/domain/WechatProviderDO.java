package com.ecotourism.manage.payment.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 微信商户号管理配置
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-06-08 10:43:48
 */
public class WechatProviderDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//服务商户编号
	private String providerNo;
	//服务商名称
	private String providerName;
	//服务商appid
	private String appId;
	//服务商户私有密钥
	private String privateKey;
	//服务商户号ID
	private String mchId;
	//HTTPS证书的本地路径
	private String certLocalPath;
	//HTTPS证书密码
	private String certPassword;
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
	private String baseUrl;
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
	 * 设置：服务商户编号
	 */
	public void setProviderNo(String providerNo) {
		this.providerNo = providerNo;
	}
	/**
	 * 获取：服务商户编号
	 */
	public String getProviderNo() {
		return providerNo;
	}
	/**
	 * 设置：服务商名称
	 */
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	/**
	 * 获取：服务商名称
	 */
	public String getProviderName() {
		return providerName;
	}
	/**
	 * 设置：服务商appid
	 */
	public void setAppId(String appId) {
		this.appId = appId;
	}
	/**
	 * 获取：服务商appid
	 */
	public String getAppId() {
		return appId;
	}
	/**
	 * 设置：服务商户私有密钥
	 */
	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}
	/**
	 * 获取：服务商户私有密钥
	 */
	public String getPrivateKey() {
		return privateKey;
	}
	/**
	 * 设置：服务商户号ID
	 */
	public void setMchId(String mchId) {
		this.mchId = mchId;
	}
	/**
	 * 获取：服务商户号ID
	 */
	public String getMchId() {
		return mchId;
	}
	/**
	 * 设置：HTTPS证书的本地路径
	 */
	public void setCertLocalPath(String certLocalPath) {
		this.certLocalPath = certLocalPath;
	}
	/**
	 * 获取：HTTPS证书的本地路径
	 */
	public String getCertLocalPath() {
		return certLocalPath;
	}
	/**
	 * 设置：HTTPS证书密码
	 */
	public void setCertPassword(String certPassword) {
		this.certPassword = certPassword;
	}
	/**
	 * 获取：HTTPS证书密码
	 */
	public String getCertPassword() {
		return certPassword;
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

	public String getBaseUrl() {
		return baseUrl;
	}
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
}
