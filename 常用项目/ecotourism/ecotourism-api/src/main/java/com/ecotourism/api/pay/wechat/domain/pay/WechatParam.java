package com.ecotourism.api.pay.wechat.domain.pay;


import com.ecotourism.api.pay.wechat.domain.WechatConfig;
import com.ecotourism.api.pay.wechat.domain.WechatMch;
import com.ecotourism.api.pay.wechat.domain.WechatProvider;

/**
 * 说明：微信支付参数实体
 * 作者： scotte
 * 创建时间：下午5:15:52
 */
public class WechatParam {
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 微信商户号
	 */
	private WechatMch wechatMch;
	/**
	 * 微信服务商
	 */
	private WechatProvider wechatProvider;
	/**
	 * 微信
	 */
	private WechatConfig wechatConfig;
	/**
	 * 公众账号ID
	 */
	private String appId;
	/**
	 * 密钥
	 */
	private String appSecret;
	/**
	 * 通知地址
	 */
	private String notifyUrl;
	/**
	 * 商品描述
	 */
	private String body;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public WechatMch getWechatMch() {
		return wechatMch;
	}
	public void setWechatMch(WechatMch wechatMch) {
		this.wechatMch = wechatMch;
	}
	public WechatProvider getWechatProvider() {
		return wechatProvider;
	}
	public void setWechatProvider(WechatProvider wechatProvider) {
		this.wechatProvider = wechatProvider;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getAppSecret() {
		return appSecret;
	}
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
	public String getNotifyUrl() {
		return notifyUrl;
	}
	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}

	public WechatConfig getWechatConfig() {
		return wechatConfig;
	}

	public void setWechatConfig(WechatConfig wechatConfig) {
		this.wechatConfig = wechatConfig;
	}
}
