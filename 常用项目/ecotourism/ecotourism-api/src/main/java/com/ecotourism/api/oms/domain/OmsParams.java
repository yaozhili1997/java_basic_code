package com.ecotourism.api.oms.domain;

import java.util.List;

/**
 * 
 * @author 陈启勇
 *
 */
public class OmsParams {
	private String orderNo;//订单号
	private String payType;//支付类型
	private String payStatus;//支付状态:已支付
	private String pushUserNo;//地推用户编号
	private List<OmsData> data;
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public String getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}
	public List<OmsData> getData() {
		return data;
	}
	public void setData(List<OmsData> data) {
		this.data = data;
	}
	public String getPushUserNo() {
		return pushUserNo;
	}
	public void setPushUserNo(String pushUserNo) {
		this.pushUserNo = pushUserNo;
	}
	@Override
	public String toString() {
		return "OmsParams{" +
				"orderNo='" + orderNo + '\'' +
				", payType='" + payType + '\'' +
				", payStatus='" + payStatus + '\'' +
				", pushUserNo='" + pushUserNo + '\'' +
				", data=" + data +
				'}';
	}
}
