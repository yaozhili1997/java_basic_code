package com.ecotourism.api.pay.wechat.domain.pay;

import java.util.Map;

/**
 * 说明：微信用户参数
 * 作者： scotte
 * 创建时间：上午11:28:20
 */
public class WechatUserParams {
	/**
	 * appid(若传入，则会替换后台配置)
	 */
    private String paramAppid;
    /**
     * 附加数据
     */
    private String attach;
    /**
	 * 商品描述  
	 */
    private String body;
    /**
	 * 商品详情  
	 */
    private String detail;
    /**
	 * 通知地址  
	 */
    private String notify_url;
    /**
	 * 用户标识
	 */
    private String openid;
    /**
	 * 商户订单号
	 */
    private String out_trade_no;
    /**
	 * 终端IP
	 */
    private String spbill_create_ip;
    /**
	 * 总金额
	 */
    private int total_fee;
    /**
	 * 交易类型    
	 */
    private String trade_type;
    /**
	 * 签名
	 */
    private String sign;
    /**
	 * 随机字符串
	 */
    private String nonce_str;
    /**
	 * 设备号
	 */
    private String device_info;
    /**
	 * 货币类型
	 */
    private String fee_type;
    /**
	 * 交易起始时间
	 */
    private String time_start;
    /**
	 * 交易结束时间 
	 */
    private String time_expire;
    /**
	 * 商品标记
	 */
    private String goods_tag;
    /**
	 * 指定支付方式
	 */
    private String limit_pay;
    private String baseUrl;
    /**
	 * 额外参数
	 */
    private Map<?, ?> extr_param;
	public String getAttach() {
		return attach;
	}
	public void setAttach(String attach) {
		this.attach = attach;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getNotify_url() {
		return notify_url;
	}
	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}
	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}
	public int getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(int total_fee) {
		this.total_fee = total_fee;
	}
	public String getTrade_type() {
		return trade_type;
	}
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getNonce_str() {
		return nonce_str;
	}
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	public String getDevice_info() {
		return device_info;
	}
	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}
	public String getFee_type() {
		return fee_type;
	}
	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}
	public String getTime_start() {
		return time_start;
	}
	public void setTime_start(String time_start) {
		this.time_start = time_start;
	}
	public String getTime_expire() {
		return time_expire;
	}
	public void setTime_expire(String time_expire) {
		this.time_expire = time_expire;
	}
	public String getGoods_tag() {
		return goods_tag;
	}
	public void setGoods_tag(String goods_tag) {
		this.goods_tag = goods_tag;
	}
	public String getLimit_pay() {
		return limit_pay;
	}
	public void setLimit_pay(String limit_pay) {
		this.limit_pay = limit_pay;
	}
	public Map<?, ?> getExtr_param() {
		return extr_param;
	}
	public void setExtr_param(Map<?, ?> extr_param) {
		this.extr_param = extr_param;
	}
	public String getParamAppid() {
		return paramAppid;
	}
	public void setParamAppid(String paramAppid) {
		this.paramAppid = paramAppid;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
}
