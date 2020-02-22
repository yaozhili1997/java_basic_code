package com.ecotourism.api.api.config;
/**
 *说明：接口信息常量
 * @author 仇科成
 *创建时间：2017年8月5日
 * @version
 */
public enum ApiEnum {

	systemError("9001","系统异常,请联系优讯科技"),
	success("success","成功"),
	fail("fail","失败"),
	/*--------------接口(0) start--------------*/
	apiError("0001","接口不存在!"),
	getProduct("0002","获取产品接口"),
	listProducts("0003","获取产品列表接口"),
	createOrder("0004","创建应用订单接口"),
	listOrders("0005","用户订单信息列表"),
	wechatPay("0006","应用微信支付接口"),
	alipayPay("0007","应用支付宝支付接口"),
	wechatNotice("0008","应用微信支付通知接口"),
	aliPayNotice("0009","应用支付宝支付通知接口"),
	aliPayPayReturn("0010","应用支付宝支付跳转通知接口"),
	getOrderUserInfo("0011","获取订单中的用户信息接口"),
	getOrder("0012","获取订单接口"),
	listShopCars("0013","购物车-信息列表接口"),
	saveShopCar("0014","购物车-增加接口"),
	deleteShopCar("0015","购物车-删除接口"),
    updateShopCar("0016","购物车-修改接口"),
	getDefault("0017","收获地址-获取默认地址接口"),
	updateDefault("0018","收获地址-设置默认地址接口"),
	deleteAddress("0019","收获地址-删除接口"),
	listAddress("0021","收获地址-列表接口"),
	saveOrUpdate("0021","收获地址-增加或修改接口"),
	getAddress("0022","收获地址-获取接口"),
	getWechatUserinfo("0023","微信-公众号获取用户信息"),
	getAlipayUserinfo("0024","支付宝-获取用户信息"),
	getUserInfo("0025","获取应用用户信息"),
	refundOrder("0026","应用订单退订接口"),
	getAppIndexImgs("0027","应用首页轮播图接口"),
	getShopCarTotalCount("0028","获取购物车总数量接口"),
	productMonthSell("0029","获取产品当月销量接口"),
	/*--------------接口(0) end--------------*/
	/*--------------系统异常(1) start--------------*/
	paramsCheckError("1001","参数检测异常"),
	paramsJsonError("1001-01","json格式异常"),
	paramsJsonNull("1001-02","参数不能为空"),
	OtherCalssError("1001-03","参数检测:外部方法未配置==>"),
	OtherCalssNoBeanError("1001-04","参数检测:容器中没有外部检测bean==>"),
	methodNullError("1001-05","参数检测:外部方法不存在==>"),
	methodReturnNullError("1001-06","参数检测:外部方法返回null==>"),
	phoneNumException("1001-07","手机号格式异常"),
	buyOutTimeError("1001-08","无法预定过期票"),
	playTimeError("1001-09","游玩时间格式异常"),
	paramHasNullStr("1001-10","参数包含空字符串"),
	productNumError("1001-11","产品数量不能小于1"),
	payTypeError("1001-12","支付方式不存在"),
	idCarError("1001-13","身份证号格式异常"),
	numError("1001-14","请输入非负数字"),
	dateError("1001-15","日期格式错误"),

	/*--------------系统异常(1) end--------------*/

	/*--------------应用(2) start--------------*/
	signError("2001","签名验证失败"),
	appNotExists("2002","应用不存在或未启用"),
	appNotDistributionNo("2003","应用oms商户信息未配置"),
	appNotOmsUrl("2004","应用oms Url地址未配置"),
	appNoNull("2005","应用编号不存在"),
	createOrderError("2006","下单失败"),
	orderNull("2007","订单不存在"),
	productNull("2008","产品不存在"),
	moneyError("2009","金额异常"),
	orderPayMoney("2010","订单已支付"),
	orderNotPayMoney("2011","订单未支付"),
	orderOutTime("2012","订单已过期"),
	NoticeMoneyError("2013","支付通知金额异常"),
	refundOrderError("2014","退单失败"),
	OrderYiRefundError("2015","退单已退"),
	OrderRefundMoneyError("2016","退款失败"),
	/*--------------应用(2) end--------------*/

    /*--------------微信(3) start--------------*/
    wechatNull("3001","微信公众号参数未配置"),
    wechatGetOpenidError("3002","微信-获取openId失败"),
    wechatPayError("3003","支付失败,请稍后重试"),
	wechatUserNull("3004","用户不存在"),
	wechatUserDecodeError("3005","解密用户信息失败"),
	wechatNoticeError("3006","微信通知异常"),
	/*--------------微信(3) end--------------*/
    /*--------------支付宝(4) start--------------*/
    alipayNull("4001","支付宝参数未配置"),
    alipayPayError("4002","支付宝支付异常"),
    alipayNoticeError("4003","支付宝支付通知异常"),
    alipayNoticeSignError("4003-01","支付宝支付通知签名验证失败"),
    alipayPayReturnSignError("4003-02","支付宝支付成功跳转签名验证失败"),
    alipayPayReturnError("4004","支付宝支付成功跳转失败"),
    alipayRefundError("4005","支付宝退款失败"),
    alipayGetOpenidError("4006","支付宝-获取openId失败"),
	/*--------------支付宝(4) end--------------*/
	;
	
	
	public String code;
	public String msg;
	ApiEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}
