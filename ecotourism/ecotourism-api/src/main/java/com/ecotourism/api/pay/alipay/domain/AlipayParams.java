package com.ecotourism.api.pay.alipay.domain;

/**
 * 说明：支付宝支付参数实体
 * 作者： scotte
 * 创建时间：下午5:15:31
 */
public class AlipayParams {
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 商户appid
	 */
	private String appId;
	/**
	 * 网关地址
	 */
	private String url;
	/**
	 * 私钥 pkcs8格式的
	 */
	private String rsaPrivateKey;
	/**
	 * 编码
	 */
	private String charset;
	/**
	 * 支付宝公钥
	 */
	private String alipayPublicKey;
	/**
	 * 系统商编号，该参数作为系统商返佣数据提取的依据，请填写系统商签约协议的PID
	 */
	private String sysServiceProviderId;
	/**
	 * RSA2
	 */
	private String signType;
	/**
	 * 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问'
	 */
	private String notifyUrl;
	/**
	 * 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
	 */
	private String returnUrl;
	/**
	 * 返回格式
	 */
	private String format;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getRsaPrivateKey() {
		return rsaPrivateKey;
	}
	public void setRsaPrivateKey(String rsaPrivateKey) {
		this.rsaPrivateKey = rsaPrivateKey;
	}
	public String getAlipayPublicKey() {
		return alipayPublicKey;
	}
	public void setAlipayPublicKey(String alipayPublicKey) {
		this.alipayPublicKey = alipayPublicKey;
	}
	public String getSysServiceProviderId() {
		return sysServiceProviderId;
	}
	public void setSysServiceProviderId(String sysServiceProviderId) {
		this.sysServiceProviderId = sysServiceProviderId;
	}
	public String getSignType() {
		return signType;
	}
	public void setSignType(String signType) {
		this.signType = signType;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getNotifyUrl() {
		return notifyUrl;
	}
	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}
	public String getReturnUrl() {
		return returnUrl;
	}
	public void setReturnUrl(String returnUrl) {
		this.returnUrl = returnUrl;
	}
	public String getCharset() {
		return charset;
	}
	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
