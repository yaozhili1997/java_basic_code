package com.ecotourism.api.product.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * 产品
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-08-23 16:31:01
 */
public class ProductDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//产品编号
	private String productNo;
	//产品名称
	private String productName;
	//售价
	private BigDecimal payPrice;
	//是否需要联系人手机
	private String whetherUserPhone;
	//是否需要身份证
	private String whetherUserId;
	//兑换凭证
	private String certificateExchange;
	//入园方式
	private String parkWay;
	//入园地址
	private String parkAddress;
	//使用说明
	private String useExplain;
	//是否可以退款
	private String whetherRefund;
	//退款说明
	private String refundExplain;
	//费用包含
	private String costIncludes;
	//费用不含
	private String costNotIncludes;
	//有效天数
	private Integer effectiveDays;
	//是否预售
	private String whetherShelvesAdvance;
	//预售开始时间
	private Date advanceStartDate;
	//预售结束时间
	private Date advanceEndDate;
	//主图
	private String imgUrl;
	//是否可以乘车
	private String whetherSureRide;
	//可乘线路
	private String subordinateLine;
	//是否限购
	private String whetherLimitSell;
	private String stockType;
	//限购日期类型
	private String sellDateType;
	//限购数量
	private String limitSellNum;
	private String carFee;
	private String productType;
	private String productSecondType;
	//排序
	private Integer sort;
	//产品特征
	private String productFeatures;
	//是否为实体类产品
	private String isEntity;
	//产品类型名称
	private String productTypeName;
	//当天停售时间
	private String stopSellingTicketsTime;
	//是否实名
	private String whetherRealName;
	private List<Img> imgs;
	//价格/库存 日历
	private List<ProductPriceStock> priceStocks;

	/**
	 * 设置：产品编号
	 */
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	/**
	 * 获取：产品编号
	 */
	public String getProductNo() {
		return productNo;
	}
	/**
	 * 设置：产品名称
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * 获取：产品名称
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * 设置：售价
	 */
	public void setPayPrice(BigDecimal payPrice) {
		this.payPrice = payPrice;
	}
	/**
	 * 获取：售价
	 */
	public BigDecimal getPayPrice() {
		return payPrice;
	}
	/**
	 * 设置：是否需要联系人手机
	 */
	public void setWhetherUserPhone(String whetherUserPhone) {
		this.whetherUserPhone = whetherUserPhone;
	}
	/**
	 * 获取：是否需要联系人手机
	 */
	public String getWhetherUserPhone() {
		return whetherUserPhone;
	}
	/**
	 * 设置：是否需要身份证
	 */
	public void setWhetherUserId(String whetherUserId) {
		this.whetherUserId = whetherUserId;
	}
	/**
	 * 获取：是否需要身份证
	 */
	public String getWhetherUserId() {
		return whetherUserId;
	}
	/**
	 * 设置：兑换凭证
	 */
	public void setCertificateExchange(String certificateExchange) {
		this.certificateExchange = certificateExchange;
	}
	/**
	 * 获取：兑换凭证
	 */
	public String getCertificateExchange() {
		return certificateExchange;
	}
	/**
	 * 设置：入园方式
	 */
	public void setParkWay(String parkWay) {
		this.parkWay = parkWay;
	}
	/**
	 * 获取：入园方式
	 */
	public String getParkWay() {
		return parkWay;
	}
	/**
	 * 设置：入园地址
	 */
	public void setParkAddress(String parkAddress) {
		this.parkAddress = parkAddress;
	}
	/**
	 * 获取：入园地址
	 */
	public String getParkAddress() {
		return parkAddress;
	}
	/**
	 * 设置：使用说明
	 */
	public void setUseExplain(String useExplain) {
		this.useExplain = useExplain;
	}
	/**
	 * 获取：使用说明
	 */
	public String getUseExplain() {
		return useExplain;
	}
	/**
	 * 设置：是否可以退款
	 */
	public void setWhetherRefund(String whetherRefund) {
		this.whetherRefund = whetherRefund;
	}
	/**
	 * 获取：是否可以退款
	 */
	public String getWhetherRefund() {
		return whetherRefund;
	}
	/**
	 * 设置：退款说明
	 */
	public void setRefundExplain(String refundExplain) {
		this.refundExplain = refundExplain;
	}
	/**
	 * 获取：退款说明
	 */
	public String getRefundExplain() {
		return refundExplain;
	}
	/**
	 * 设置：费用包含
	 */
	public void setCostIncludes(String costIncludes) {
		this.costIncludes = costIncludes;
	}
	/**
	 * 获取：费用包含
	 */
	public String getCostIncludes() {
		return costIncludes;
	}
	/**
	 * 设置：费用不含
	 */
	public void setCostNotIncludes(String costNotIncludes) {
		this.costNotIncludes = costNotIncludes;
	}
	/**
	 * 获取：费用不含
	 */
	public String getCostNotIncludes() {
		return costNotIncludes;
	}
	/**
	 * 设置：有效天数
	 */
	public void setEffectiveDays(Integer effectiveDays) {
		this.effectiveDays = effectiveDays;
	}
	/**
	 * 获取：有效天数
	 */
	public Integer getEffectiveDays() {
		return effectiveDays;
	}
	/**
	 * 设置：是否预售
	 */
	public void setWhetherShelvesAdvance(String whetherShelvesAdvance) {
		this.whetherShelvesAdvance = whetherShelvesAdvance;
	}
	/**
	 * 获取：是否预售
	 */
	public String getWhetherShelvesAdvance() {
		return whetherShelvesAdvance;
	}
	/**
	 * 设置：预售开始时间
	 */
	public void setAdvanceStartDate(Date advanceStartDate) {
		this.advanceStartDate = advanceStartDate;
	}
	/**
	 * 获取：预售开始时间
	 */
	public Date getAdvanceStartDate() {
		return advanceStartDate;
	}
	/**
	 * 设置：预售结束时间
	 */
	public void setAdvanceEndDate(Date advanceEndDate) {
		this.advanceEndDate = advanceEndDate;
	}
	/**
	 * 获取：预售结束时间
	 */
	public Date getAdvanceEndDate() {
		return advanceEndDate;
	}
	/**
	 * 设置：主图
	 */
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	/**
	 * 获取：主图
	 */
	public String getImgUrl() {
		return imgUrl;
	}
	/**
	 * 设置：是否可以乘车
	 */
	public void setWhetherSureRide(String whetherSureRide) {
		this.whetherSureRide = whetherSureRide;
	}
	/**
	 * 获取：是否可以乘车
	 */
	public String getWhetherSureRide() {
		return whetherSureRide;
	}
	/**
	 * 设置：可乘线路
	 */
	public void setSubordinateLine(String subordinateLine) {
		this.subordinateLine = subordinateLine;
	}
	/**
	 * 获取：可乘线路
	 */
	public String getSubordinateLine() {
		return subordinateLine;
	}
	/**
	 * 设置：是否限购
	 */
	public void setWhetherLimitSell(String whetherLimitSell) {
		this.whetherLimitSell = whetherLimitSell;
	}
	/**
	 * 获取：是否限购
	 */
	public String getWhetherLimitSell() {
		return whetherLimitSell;
	}
	/**
	 * 设置：限购日期类型
	 */
	public void setSellDateType(String sellDateType) {
		this.sellDateType = sellDateType;
	}
	/**
	 * 获取：限购日期类型
	 */
	public String getSellDateType() {
		return sellDateType;
	}
	/**
	 * 设置：限购数量
	 */
	public void setLimitSellNum(String limitSellNum) {
		this.limitSellNum = limitSellNum;
	}
	/**
	 * 获取：限购数量
	 */
	public String getLimitSellNum() {
		return limitSellNum;
	}
	/**
	 * 设置：
	 */
	public void setCarFee(String carFee) {
		this.carFee = carFee;
	}
	/**
	 * 获取：
	 */
	public String getCarFee() {
		return carFee;
	}
	/**
	 * 设置：
	 */
	public void setProductType(String productType) {
		this.productType = productType;
	}
	/**
	 * 获取：
	 */
	public String getProductType() {
		return productType;
	}
	/**
	 * 设置：
	 */
	public void setProductSecondType(String productSecondType) {
		this.productSecondType = productSecondType;
	}
	/**
	 * 获取：
	 */
	public String getProductSecondType() {
		return productSecondType;
	}
	/**
	 * 设置：排序
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * 获取：排序
	 */
	public Integer getSort() {
		return sort;
	}
	/**
	 * 设置：产品特征
	 */
	public void setProductFeatures(String productFeatures) {
		this.productFeatures = productFeatures;
	}
	/**
	 * 获取：产品特征
	 */
	public String getProductFeatures() {
		return productFeatures;
	}
	/**
	 * 设置：是否为实体类产品
	 */
	public void setIsEntity(String isEntity) {
		this.isEntity = isEntity;
	}
	/**
	 * 获取：是否为实体类产品
	 */
	public String getIsEntity() {
		return isEntity;
	}
	/**
	 * 设置：产品类型名称
	 */
	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}
	/**
	 * 获取：产品类型名称
	 */
	public String getProductTypeName() {
		return productTypeName;
	}

	public List<Img> getImgs() {
		return imgs;
	}

	public void setImgs(List<Img> imgs) {
		this.imgs = imgs;
	}

	public String getStopSellingTicketsTime() {
		return stopSellingTicketsTime;
	}

	public void setStopSellingTicketsTime(String stopSellingTicketsTime) {
		this.stopSellingTicketsTime = stopSellingTicketsTime;
	}

	public List<ProductPriceStock> getPriceStocks() {
		return priceStocks;
	}

	public void setPriceStocks(List<ProductPriceStock> priceStocks) {
		this.priceStocks = priceStocks;
	}

	public String getWhetherRealName() {
		return whetherRealName;
	}

	public void setWhetherRealName(String whetherRealName) {
		this.whetherRealName = whetherRealName;
	}

	public String getStockType() {
		return stockType;
	}

	public void setStockType(String stockType) {
		this.stockType = stockType;
	}
}
