package com.ecotourism.api.oms.domain;

public class OmsData {
	private String subOrderNo;
	private String customerName;//用户名
	private String customerPhone;//用户手机号
	private String customerUserId;//身份证
	private String playTime;//游玩时间
	private String productNo;//产品编号
	private String nums;//数量
	private String payPrice;//售价
	private String totalAmount;//总价

	public String getSubOrderNo() {
		return subOrderNo;
	}

	public void setSubOrderNo(String subOrderNo) {
		this.subOrderNo = subOrderNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getNums() {
		return nums;
	}
	public void setNums(String nums) {
		this.nums = nums;
	}
	public String getPayPrice() {
		return payPrice;
	}
	public void setPayPrice(String payPrice) {
		this.payPrice = payPrice;
	}
	public String getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getCustomerPhone() {
		return customerPhone;
	}
	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}
	public String getCustomerUserId() {
		return customerUserId;
	}
	public void setCustomerUserId(String customerUserId) {
		this.customerUserId = customerUserId;
	}
	public String getPlayTime() {
		return playTime;
	}
	public void setPlayTime(String playTime) {
		this.playTime = playTime;
	}
	@Override
	public String toString() {
		return "OmsData{" +
				"subOrderNo='" + subOrderNo + '\'' +
				"customerPhone='" + customerPhone + '\'' +
				", customerUserId='" + customerUserId + '\'' +
				", playTime='" + playTime + '\'' +
				", productNo='" + productNo + '\'' +
				", nums='" + nums + '\'' +
				", payPrice='" + payPrice + '\'' +
				", totalAmount='" + totalAmount + '\'' +
				'}';
	}
}
