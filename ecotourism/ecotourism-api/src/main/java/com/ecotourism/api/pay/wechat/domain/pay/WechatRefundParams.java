package com.ecotourism.api.pay.wechat.domain.pay;

public class WechatRefundParams{
	private String sign = "";//签名
    private String transaction_id = "";//微信订单号
    private String out_trade_no = "";//商户订单号
    private String out_refund_no = "";//商户退款单号
    private int total_fee = 0;//订单金额
    private int refund_fee = 0;//退款金额
    private String op_user_id = "";//操作员
    private String nonce_str = "";//随机字符串
    private String appid = "";
    private String mch_id = "";//商户号
    private String sub_mch_id;//微信支付分配的子商户号
    private String sub_appid;//微信分配的子商户公众账号ID
    private String paramAppId;//传入的appid
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}
	public String getOut_refund_no() {
		return out_refund_no;
	}
	public void setOut_refund_no(String out_refund_no) {
		this.out_refund_no = out_refund_no;
	}
	public int getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(int total_fee) {
		this.total_fee = total_fee;
	}
	public int getRefund_fee() {
		return refund_fee;
	}
	public void setRefund_fee(int refund_fee) {
		this.refund_fee = refund_fee;
	}
	public String getOp_user_id() {
		return op_user_id;
	}
	public void setOp_user_id(String op_user_id) {
		this.op_user_id = op_user_id;
	}
	public String getNonce_str() {
		return nonce_str;
	}
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
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
	@Override
	public String toString() {
		return "WechatRefundParams [sign=" + sign + ", transaction_id="
				+ transaction_id + ", out_trade_no=" + out_trade_no
				+ ", out_refund_no=" + out_refund_no + ", total_fee="
				+ total_fee + ", refund_fee=" + refund_fee + ", op_user_id="
				+ op_user_id + ", nonce_str=" + nonce_str + ", appid=" + appid
				+ ", mch_id=" + mch_id + ", sub_mch_id=" + sub_mch_id
				+ ", sub_appid=" + sub_appid + ", paramAppId=" + paramAppId
				+ "]";
	}
}
