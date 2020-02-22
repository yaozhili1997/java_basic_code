package com.ecotourism.api.oms.domain;

import java.util.List;

/**
 * 产品
 * @author 陈启勇
 *
 */
public class Product {
	private String canRefund;//是否可以退款
	private String certificate;//兑换凭证
	private String costIncludes;//费用包含
	private String costNotIncludes;//费用不含
	private String explain;//使用说明
	private String needMake;//是否需要预约
	private String needUserId;//是否需要用户身份证号
	private String needUserName;//
	private String needUserPhone;//
	private String parkAddress;//入园地址
	private String parkWay;//入园方式
	private String payPrice;//售价
	private String refund_explain;//退款说明
	private String productName;//产品名
	private String productNo;//产品编号
	private String whether_shelves_advance;//是否预售
	private String effective_days;//有效天数
	private String advance_start_date;//预售开始时间
	private String advance_end_date;//预售结束时间
	private String imgUrl;//主图
	private List<String> imgs;//附图
	private int imgSize;//附图数量
	private String ticketPrice;//定价
	private String ticketType;//门票类型
	private String ticktNo;//票种
	private String url;//图片地址
	private List<String> chirldrenUrls;//子地址
	private String sellMonthNum;//月销量
	private String sellDayNum;//日销量
	private String termTime;//间隔时长
	private String termUseType;//使用类型
	private String effectiveStartDate;//有效开始时间
	private String effectiveEndDate;//结束时间
	private String whetherLimitNumber;//是否次数限制
	private String frequency;//次数
	private String isSelf;//是否自用
	private String ticketDelivery;//供应商产品取票方式
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public List<String> getImgs() {
		return imgs;
	}
	public void setImgs(List<String> imgs) {
		this.imgs = imgs;
	}

	public int getImgSize() {
		return imgSize;
	}

	public void setImgSize(int imgSize) {
		this.imgSize = imgSize;
	}

	public String getRefund_explain() {
		return refund_explain;
	}

	public void setRefund_explain(String refund_explain) {
		this.refund_explain = refund_explain;
	}

	public String getCanRefund() {
		return canRefund;
	}
	public void setCanRefund(String canRefund) {
		this.canRefund = canRefund;
	}
	public String getCertificate() {
		return certificate;
	}
	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	public String getCostIncludes() {
		return costIncludes;
	}
	public void setCostIncludes(String costIncludes) {
		this.costIncludes = costIncludes;
	}
	public String getCostNotIncludes() {
		return costNotIncludes;
	}
	public void setCostNotIncludes(String costNotIncludes) {
		this.costNotIncludes = costNotIncludes;
	}
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
	public String getNeedMake() {
		return needMake;
	}
	public void setNeedMake(String needMake) {
		this.needMake = needMake;
	}
	public String getNeedUserId() {
		return needUserId;
	}
	public void setNeedUserId(String needUserId) {
		this.needUserId = needUserId;
	}
	public String getNeedUserName() {
		return needUserName;
	}
	public void setNeedUserName(String needUserName) {
		this.needUserName = needUserName;
	}
	public String getNeedUserPhone() {
		return needUserPhone;
	}
	public void setNeedUserPhone(String needUserPhone) {
		this.needUserPhone = needUserPhone;
	}
	public String getParkAddress() {
		return parkAddress;
	}
	public void setParkAddress(String parkAddress) {
		this.parkAddress = parkAddress;
	}
	public String getParkWay() {
		return parkWay;
	}
	public void setParkWay(String parkWay) {
		this.parkWay = parkWay;
	}
	public String getPayPrice() {
		return payPrice;
	}
	public void setPayPrice(String payPrice) {
		this.payPrice = payPrice;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(String ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public String getTicketType() {
		return ticketType;
	}
	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}
	public String getTicktNo() {
		return ticktNo;
	}
	public void setTicktNo(String ticktNo) {
		this.ticktNo = ticktNo;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<String> getChirldrenUrls() {
		return chirldrenUrls;
	}
	public void setChirldrenUrls(List<String> chirldrenUrls) {
		this.chirldrenUrls = chirldrenUrls;
	}
	public String getWhether_shelves_advance() {
		return whether_shelves_advance;
	}
	public void setWhether_shelves_advance(String whether_shelves_advance) {
		this.whether_shelves_advance = whether_shelves_advance;
	}
	public String getEffective_days() {
		return effective_days;
	}

	public void setEffective_days(String effective_days) {
		this.effective_days = effective_days;
	}

	public String getAdvance_start_date() {
		return advance_start_date;
	}

	public void setAdvance_start_date(String advance_start_date) {
		this.advance_start_date = advance_start_date;
	}

	public String getAdvance_end_date() {
		return advance_end_date;
	}

	public void setAdvance_end_date(String advance_end_date) {
		this.advance_end_date = advance_end_date;
	}

	public String getSellMonthNum() {
		return sellMonthNum;
	}

	public void setSellMonthNum(String sellMonthNum) {
		this.sellMonthNum = sellMonthNum;
	}

	public String getSellDayNum() {
		return sellDayNum;
	}

	public void setSellDayNum(String sellDayNum) {
		this.sellDayNum = sellDayNum;
	}

	public String getTermTime() {
		return termTime;
	}

	public void setTermTime(String termTime) {
		this.termTime = termTime;
	}

	public String getTermUseType() {
		return termUseType;
	}

	public void setTermUseType(String termUseType) {
		this.termUseType = termUseType;
	}

	public String getEffectiveStartDate() {
		return effectiveStartDate;
	}

	public void setEffectiveStartDate(String effectiveStartDate) {
		this.effectiveStartDate = effectiveStartDate;
	}

	public String getEffectiveEndDate() {
		return effectiveEndDate;
	}

	public void setEffectiveEndDate(String effectiveEndDate) {
		this.effectiveEndDate = effectiveEndDate;
	}

	public String getWhetherLimitNumber() {
		return whetherLimitNumber;
	}

	public void setWhetherLimitNumber(String whetherLimitNumber) {
		this.whetherLimitNumber = whetherLimitNumber;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public String getIsSelf() {
		return isSelf;
	}
	public void setIsSelf(String isSelf) {
		this.isSelf = isSelf;
	}

	public String getTicketDelivery() {
		return ticketDelivery;
	}

	public void setTicketDelivery(String ticketDelivery) {
		this.ticketDelivery = ticketDelivery;
	}
}
