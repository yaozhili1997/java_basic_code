package com.ecotourism.mobile.common.controller;

import com.ecotourism.mobile.common.config.OrderApiUrlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.ecotourism.mobile.common.utils.ShiroUtils;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BaseController {
	@Autowired
	public HttpServletRequest request;

	@Autowired
	private OrderApiUrlConfig orderApiUrlConfig;

	private static String  LOGIN_OPENID_KEY = "session_login_open_id";
	private static String  LOGIN_PLATFORM_KEY = "session_login_platform";
	public static String LOGIN_PLATFORM_WX = "wx";
	public static String LOGIN_PLATFORM_ALIPAY = "alipay";

	public void setLoginOpenid(String openid, String platform) {
		request.getSession().setAttribute(LOGIN_OPENID_KEY, openid);
		request.getSession().setAttribute(LOGIN_PLATFORM_KEY, platform);
		setConfig();
	}

	public void setConfig() {
		request.getSession().setAttribute("orderMobileApiBaseUrl", orderApiUrlConfig.getOrderMobileApiBaseUrl());
		request.getSession().setAttribute("applicationNo", orderApiUrlConfig.getApplicationNo());
		request.getSession().setAttribute("orderApiBaseUrl", orderApiUrlConfig.getBaseUrl());
	}

	public String getLoginOpenid() {
		String openId = (String)request.getSession().getAttribute(LOGIN_OPENID_KEY);
		/*if (openId == null) {
			openId = "2088702101104222";
		}*/
		return openId;
	}

	public String getLoginPlatform() {
		String  loginPlatform = (String)request.getSession().getAttribute(LOGIN_PLATFORM_KEY);
		// 默认支付宝平台
		if (loginPlatform == null) {
			loginPlatform = LOGIN_PLATFORM_ALIPAY;
		}
		return loginPlatform;
	}
}