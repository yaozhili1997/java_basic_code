package com.ecotourism.oms.oms.config;
/**
 *说明：接口信息常量
 * @author 仇科成
 *创建时间：2017年8月5日
 * @version
 */
public enum ApiEnum {

	createOrder("016001","购票"),
	getTickets("016002","取票"),
	checkOrder("016003","检票"),
	updatePayStatus("016004","修改支付状态"),
	refundOrder("016005","退票"),
	cancelOrder("016006","取消订单"),
	updateOrder("016007","修改订单"),
	refundRetirementAudit("016008","退票审核"),
	checkCreateOrder("016009","检测是否可下单订单已退"),
	CanNotcancelOrder("9000","无法取消"),
	systemError("9001","系统异常,请联系优讯科技!"),
	noJurisdiction("9002","权限不足,请联系优讯科技"),
	productReleased("9003", "产品不存在或产品已下架"),
	orderBuyDateException("9004", "购买时间异常"),
	orderPlayDateException("9005", "游玩时间异常"),
	orderExists("9006","已存在此订单"),
	dataFormatNotAccord("9007","数据格式不符合"),
	amountDataException("9008","金额数据异常！"),
	phoneNumException("9009","手机号格式异常"),
	idCardNumException("9010","身份证格式异常"),
	refundOrderNotAccord("9011","数据不符合退票要求!"),
	refundOrderOutTime("9012","订单已过期，无法退票!"),
	refundOrderNotPay("9013","订单未付款，不能进行退款!"),
	updateOrderNotAccord("9014","数据不符合更改要求!"),
	cancelOrderNotAccord("9015","不符合订单取消要求!"),
	cancelOrderAlreadyConsumed("9016","订单已消费，不能进行取消!"),
	orderChecked("9017","该票已检"),
	orderOutTime("9018","该票已过期"),
	orderYiPay("9019","订单已支付"),
	orderYiRefund("9020","订单已退"),
	orderIsNull("9021","订单号不能为空!"),
	bookTodayNot("9022","没有权限，无法预定当天票"),
	orderCanleRefund("9023","订单已取消,无法退单！"),
	orderCheckedRefund("9024","已检票,无法退单！"),
	orderGetTicketRefund("9025","已取票,无法退单！"),
	orderJsonIsNull("9026","订单信息不能为空!"),
	jsonException("9027","json格式异常！"),
	orderStatusException("9028","订单状态异常！"),
	cooEnable("9029","分销商没有启用"),
	cooEnd("9030","签约已到期"),
	cooIsNOT("9031","分销商没有开启预存款账户"),
	cooPrestore("9032","预存款余额不足"),
	allowCountNull("9033","每月允许最大订购数不足"),
	retirementAudit("9034","退单审核中..."),
	signError("9035","签名验证失败!"),
	distributorNotExists("9036","分销商账户不存在！"),
	orderNotExists("9037","订单不存在"),
	paramError("9038","参数异常！"),
	closeError("9039","该日期闭园维护"),
	pandaError("9040","熊猫基地对接异常"),
	preSaleException("9041","游玩时间不在产品预售期内!"),
	limitSaleException("9042","超出msg限购数，无法下单！"),
	productNotRefundException("9043","该产品不支持退订！"),
	ticketUseNotRefund("9044","已使用,无法退票！"),
	pushUserNotExists("9045","地推用户不存在或已停用!"),
	ipError("9046","ip与配置不匹配!"),
	buyOutTimeError("9047","无法预定过期票!"),
	buyCloseError("9048","景区已闭园!"),
	apiNotOpen("9049","接口未开通!"),
	productStockNotExists("9050","产品库存不存在!"),
	productStockNotNum("9051","产品库存不足!"),
	productRepeat("9052","产品重复，无法下单!"),
	updateOrderError("9053","修改订单失败!"),
	refundOrderError("9054","退票失败!"),
	apiException("9055","系统维护中!"),
	spotFreeTicket("9056","景区当日免票,请根据相关政策有序入园!"),
	supplierNull("9057","供应商不存在或已停用!"),
	refundRetirementAuditError("9058","退订审核未通过!"),
	ElectronicException("9059","电子票号为空"),
	productStockDayNotNum("9060","游玩日产品库存不足"),
	;
	
	
	public String code;
	public String msg;
	ApiEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}
