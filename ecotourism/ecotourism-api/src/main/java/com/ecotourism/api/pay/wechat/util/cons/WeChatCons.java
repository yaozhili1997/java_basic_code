package com.ecotourism.api.pay.wechat.util.cons;

/**
 * 
 * 说明：微信api接口
 * @author 陈启勇
 * 创建时间：2017年9月26日
 * @version
 */
public class WeChatCons {
		/**
		 * 微信获取网页授权access_token地址
		 */
		public static String oauth2AccessTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token";
		/**
		 * 微信网页授权获取用户授权地址
		 */
		public static String oauth2UserInfoUrl = "https://api.weixin.qq.com/sns/userinfo";
		/**
		 * 获取公众号的全局唯一接口调用凭据
		 */
		public static String AccessToken = "https://api.weixin.qq.com/cgi-bin/token";
		/**
		 *sapi_ticket是公众号用于调用微信JS接口的临时票据。正常情况下，jsapi_ticket的有效期为7200秒
		 */
		public static String jsapi_ticket = "https://api.weixin.qq.com/cgi-bin/ticket/getticket";
		/**
		 * 微信短链接转换
		 */
		public static String longToShortUrl = "https://api.weixin.qq.com/cgi-bin/shorturl";
		
		/**
		 * 微信未授权用户昵称
		 */
		public static String WECHAT_NICK_NAME ="微信用户";
		public static String ALIPAY_NICK_NAME ="支付宝用户";
		public static String WECHAT ="wechat";
		public static String ALIPAY ="alipay";
		/**
		 * 用户session中的key
		 */
		public static String WEIXIN_ALIPAY_IN_SESSION ="WEIXIN_ALIPAY_IN_SESSION";


	/**
	 * 微信小程序登陆获取openid
	 */
	public static String jscode2session = "https://api.weixin.qq.com/sns/jscode2session";

}
