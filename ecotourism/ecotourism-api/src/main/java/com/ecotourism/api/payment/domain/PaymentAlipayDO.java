package com.ecotourism.api.payment.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-08-21 10:24:25
 */
public class PaymentAlipayDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String domain="https://openapi.alipay.com/gateway.do";//支付宝网关地址
	private Long id;
	//名称
	private String name;
	//支付宝编码
	private String alipayNo;
	//商户appid
	private String appid;
	//私钥 pkcs8格式的
	private String rsaPrivateKey;
	//支付宝公钥
	private String alipayPublicKey;
	//服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	private String notifyUrl;
	//页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
	private String returnUrl;
	//编码
	private String charset;
	//返回格式
	private String format;
	//RSA2
	private String signtype;
	//系统商编号，该参数作为系统商返佣数据提取的依据，请填写系统商签约协议的PID
	private String sysserviceproviderid;
	//是否启用
	private String available;
	//
	private String createUser;
	//
	private Date createTime;
	//
	private String updateUser;
	//
	private Date updateTime;
	//备注
	private String bz;
	//所属公司
	private String companyNo;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
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
	 * 设置：支付宝编码
	 */
	public void setAlipayNo(String alipayNo) {
		this.alipayNo = alipayNo;
	}
	/**
	 * 获取：支付宝编码
	 */
	public String getAlipayNo() {
		return alipayNo;
	}
	/**
	 * 设置：商户appid
	 */
	public void setAppid(String appid) {
		this.appid = appid;
	}
	/**
	 * 获取：商户appid
	 */
	public String getAppid() {
		return appid;
	}
	/**
	 * 设置：私钥 pkcs8格式的
	 */
	public void setRsaPrivateKey(String rsaPrivateKey) {
		this.rsaPrivateKey = rsaPrivateKey;
	}
	/**
	 * 获取：私钥 pkcs8格式的
	 */
	public String getRsaPrivateKey() {
		return rsaPrivateKey;
	}
	/**
	 * 设置：支付宝公钥
	 */
	public void setAlipayPublicKey(String alipayPublicKey) {
		this.alipayPublicKey = alipayPublicKey;
	}
	/**
	 * 获取：支付宝公钥
	 */
	public String getAlipayPublicKey() {
		return alipayPublicKey;
	}
	/**
	 * 设置：服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	 */
	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}
	/**
	 * 获取：服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	 */
	public String getNotifyUrl() {
		return notifyUrl;
	}
	/**
	 * 设置：页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
	 */
	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}
	/**
	 * 获取：页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
	 */
	public String getReturnUrl() {
		return returnUrl;
	}
	/**
	 * 设置：编码
	 */
	public void setCharset(String charset) {
		this.charset = charset;
	}
	/**
	 * 获取：编码
	 */
	public String getCharset() {
		return charset;
	}
	/**
	 * 设置：返回格式
	 */
	public void setFormat(String format) {
		this.format = format;
	}
	/**
	 * 获取：返回格式
	 */
	public String getFormat() {
		return format;
	}
	/**
	 * 设置：RSA2
	 */
	public void setSigntype(String signtype) {
		this.signtype = signtype;
	}
	/**
	 * 获取：RSA2
	 */
	public String getSigntype() {
		return signtype;
	}
	/**
	 * 设置：系统商编号，该参数作为系统商返佣数据提取的依据，请填写系统商签约协议的PID
	 */
	public void setSysserviceproviderid(String sysserviceproviderid) {
		this.sysserviceproviderid = sysserviceproviderid;
	}
	/**
	 * 获取：系统商编号，该参数作为系统商返佣数据提取的依据，请填写系统商签约协议的PID
	 */
	public String getSysserviceproviderid() {
		return sysserviceproviderid;
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


	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}
}
