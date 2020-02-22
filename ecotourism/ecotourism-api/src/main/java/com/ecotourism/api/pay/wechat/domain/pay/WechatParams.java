package com.ecotourism.api.pay.wechat.domain.pay;

import java.util.Map;

/**
 * 说明：微信支付参数
 * 作者： scotte
 * 创建时间：上午11:05:32
 */
public class WechatParams {
		
		/**
		 * 公众号appid
		 */
	    private String appid;
	    /**
		 * 附加数据
		 */
	    private String attach;
	    /**
		 * 商品描述  
		 */
	    private String body;
	    /**
		 * 商户号
		 */
	    private String mch_id;
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
		 * 子商户用户标识
		 */
	    private String sub_openid;
	    /**
		 * 微信支付分配的子商户号
		 */
	    private String sub_mch_id;
	    /**
		 * 微信分配的子商户公众账号ID，如需在支付完成后获取sub_openid则此参数必传
		 */
	    private String sub_appid ;
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
	    /**
		 * 额外参数
		 */
	    private Map<?, ?> extr_param;
	    
		public String getAppid() {
			
			return appid;
		}
		public void setAppid(String appid) {
			this.appid = appid;
		}
		public String getMch_id() {
			return mch_id;
		}
		public void setMch_id(String mch_id) {
			this.mch_id = mch_id;
		}
		public String getDevice_info() {
			return device_info;
		}
		public void setDevice_info(String device_info) {
			this.device_info = device_info;
		}
		public String getNonce_str() {
			return nonce_str;
		}
		public String getSign() {
			return sign;
		}
		public void setSign(String sign) {
			this.sign = sign;
		}
		public String getBody() {
			return body;
		}
		
		public void setBody(String body){
			this.body = body;
		}
		public String getDetail() {
			return detail;
		}
		public void setDetail(String detail) {
			this.detail = detail;
		}
		public String getAttach() {
			return attach;
		}
		public void setAttach(String attach){
				this.attach = attach;
		}
		public String getOut_trade_no() {
			return out_trade_no;
		}
		public void setOut_trade_no(String out_trade_no){
			this.out_trade_no = out_trade_no;
		}
		public String getFee_type() {
			return fee_type;
		}
		public void setFee_type(String fee_type) {
			this.fee_type = fee_type;
		}
		public String getSpbill_create_ip() {
			return spbill_create_ip;
		}
		public void setSpbill_create_ip(String spbill_create_ip) {
			this.spbill_create_ip = spbill_create_ip;
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
		public int getTotal_fee() {
			return total_fee;
		}
		public void setTotal_fee(int total_fee) {
			this.total_fee = total_fee;
		}
		public String getNotify_url() {
			return notify_url;
		}
		public void setNotify_url(String notify_url) {
			this.notify_url = notify_url;
		}
		public String getTrade_type() {
			return trade_type;
		}
		public void setTrade_type(String trade_type) {
			this.trade_type = trade_type;
		}
		public String getLimit_pay() {
			return limit_pay;
		}
		public void setLimit_pay(String limit_pay) {
			this.limit_pay = limit_pay;
		}
		public String getOpenid() {
			return openid;
		}
		public void setOpenid(String openid) {
			this.openid = openid;
		}
		public String getSub_mch_id() {
			return sub_mch_id;
		}
		public void setSub_mch_id(String sub_mch_id) {
			this.sub_mch_id = sub_mch_id;
		}
		public String getSub_appid() {
			return sub_appid;
		}
		public void setSub_appid(String sub_appid) {
			this.sub_appid = sub_appid;
		}
		public String getSub_openid() {
			return sub_openid;
		}
		public void setSub_openid(String sub_openid) {
			this.sub_openid = sub_openid;
		}
		public Map<?, ?> getExtr_param() {
			return extr_param;
		}
		public void setExtr_param(Map<?, ?> extr_param) {
			this.extr_param = extr_param;
		}
		public void setNonce_str(String nonce_str) {
			this.nonce_str = nonce_str;
		}
		@Override
		public String toString() {
			return "WechatParams [appid=" + appid + ", attach=" + attach
					+ ", body=" + body + ", mch_id=" + mch_id + ", detail="
					+ detail + ", notify_url=" + notify_url + ", openid="
					+ openid + ", sub_openid=" + sub_openid + ", sub_mch_id="
					+ sub_mch_id + ", sub_appid=" + sub_appid
					+ ", out_trade_no=" + out_trade_no + ", spbill_create_ip="
					+ spbill_create_ip + ", total_fee=" + total_fee
					+ ", trade_type=" + trade_type + ", sign=" + sign
					+ ", nonce_str=" + nonce_str + ", device_info="
					+ device_info + ", fee_type=" + fee_type + ", time_start="
					+ time_start + ", time_expire=" + time_expire
					+ ", goods_tag=" + goods_tag + ", limit_pay=" + limit_pay
					+ ", extr_param=" + extr_param + "]";
		}
}
