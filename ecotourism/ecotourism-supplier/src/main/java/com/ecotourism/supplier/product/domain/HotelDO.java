package com.ecotourism.supplier.product.domain;

import com.ecotourism.supplier.common.annotation.Dict;
import com.ecotourism.supplier.common.config.DictTypeConfig;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 文创产品
 *
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-06 21:36:20
 */
public class HotelDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//景区门票id
	private Integer productId;
	//票种编号
	private String ticketNo;
	//产品编号
	private String productNo;
	//
	private String termNo;
	//产品名称
	private String productName;
	//销售渠道
	@Dict(DictTypeConfig.DISTRIBUTION_CHANNEL)
	private String distributionChannel;
	//支付方式
	private String payType;
	//售价
	private BigDecimal payPrice;
	//订单取消设置
	private String orderCancel="0";
	//是否需要联系人手机
	private String whetherUserPhone="0";
	//是否需要身份证
	private String whetherUserId="0";
	//是否需要预约
	private String whetherMake="0";
	//兑换凭证
	private String certificateExchange;
	//入园方式
	private String parkWay;
	//入园地址
	private String parkAddress;
	//门票类型
	private String tickType;
	//使用说明
	private String useExplain;
	//是否可以退款
	private String whetherRefund="0";
	//是否需要审核
	private String whetherExamine="0";
	//退款说明
	private String refundExplain;
	//费用包含
	private String costIncludes;
	//费用不含
	private String costNotIncludes;
	//是否需要联系人
	private String whetherUserName="0";
	//是否上架
	private String whetherShelves="0";
	//短信模板id
	private String templateSmsNo;
	//彩信模板id
	private String templateMmsNo;
	//结算单价
	private BigDecimal settlementPrice;
	//票种分组
	@Dict(DictTypeConfig.TICKET_GROUP)
	private String ticketGrouping;
	//有效天数
	private Integer effectiveDays;
	//是否预售
	private String whetherShelvesAdvance="0";
	//预售开始时间
	private Date advanceStartDate;
	//预售结束时间
	private Date advanceEndDate;
	//售票用户组
	private String userRoleId;
	//打印模板
	private String templateNo;
	//主图
	private String imgUrl;
	//是否可以乘车
	private String whetherSureRide="0";
	//可乘线路
	private String subordinateLine;
	//是否使用退票策略
	private String whetherRefundStrategy="0";
	//退票策略
	private String strategyNo;
	//退票策略明细编号
	private String refundStrategyDetailNo;
	//是否限购
	private String whetherLimitSell="0";
	//限购日期类型
	private String sellDateType;
	//限购数量
	private String limitSellNum;
	//产品提供商
	private String productProvider;
	//
	private String carFee;
	//
	private String productType;
	//公司编号
	private String companyNo;
	//是否启用库存
	private String whetherLimitStock="0";
	//
	private String productSecondType;
	private String strategyDetailName;
	private String productTypeName;
	private String baseUrl;
	private String isEntity="0";//是否为实体类产品
	private int sort;
	private String whetherRealName="0"; //是否实名

	public String getWhetherRealName() {
		return whetherRealName;
	}

	public void setWhetherRealName(String whetherRealName) {
		this.whetherRealName = whetherRealName;
	}

	/**
	 * 设置：景区门票id
	 */
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	/**
	 * 获取：景区门票id
	 */
	public Integer getProductId() {
		return productId;
	}
	/**
	 * 设置：票种编号
	 */
	public void setTicketNo(String ticketNo) {
		this.ticketNo = ticketNo;
	}
	/**
	 * 获取：票种编号
	 */
	public String getTicketNo() {
		return ticketNo;
	}
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
	 * 设置：
	 */
	public void setTermNo(String termNo) {
		this.termNo = termNo;
	}
	/**
	 * 获取：
	 */
	public String getTermNo() {
		return termNo;
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
	 * 设置：销售渠道
	 */
	public void setDistributionChannel(String distributionChannel) {
		this.distributionChannel = distributionChannel;
	}
	/**
	 * 获取：销售渠道
	 */
	public String getDistributionChannel() {
		return distributionChannel;
	}
	/**
	 * 设置：支付方式
	 */
	public void setPayType(String payType) {
		this.payType = payType;
	}
	/**
	 * 获取：支付方式
	 */
	public String getPayType() {
		return payType;
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
	 * 设置：订单取消设置
	 */
	public void setOrderCancel(String orderCancel) {
		this.orderCancel = orderCancel;
	}
	/**
	 * 获取：订单取消设置
	 */
	public String getOrderCancel() {
		return orderCancel;
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
	 * 设置：是否需要预约
	 */
	public void setWhetherMake(String whetherMake) {
		this.whetherMake = whetherMake;
	}
	/**
	 * 获取：是否需要预约
	 */
	public String getWhetherMake() {
		return whetherMake;
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
	 * 设置：门票类型
	 */
	public void setTickType(String tickType) {
		this.tickType = tickType;
	}
	/**
	 * 获取：门票类型
	 */
	public String getTickType() {
		return tickType;
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
	 * 设置：是否需要审核
	 */
	public void setWhetherExamine(String whetherExamine) {
		this.whetherExamine = whetherExamine;
	}
	/**
	 * 获取：是否需要审核
	 */
	public String getWhetherExamine() {
		return whetherExamine;
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
	 * 设置：是否需要联系人
	 */
	public void setWhetherUserName(String whetherUserName) {
		this.whetherUserName = whetherUserName;
	}
	/**
	 * 获取：是否需要联系人
	 */
	public String getWhetherUserName() {
		return whetherUserName;
	}
	/**
	 * 设置：是否上架
	 */
	public void setWhetherShelves(String whetherShelves) {
		this.whetherShelves = whetherShelves;
	}
	/**
	 * 获取：是否上架
	 */
	public String getWhetherShelves() {
		return whetherShelves;
	}
	/**
	 * 设置：短信模板id
	 */
	public void setTemplateSmsNo(String templateSmsNo) {
		this.templateSmsNo = templateSmsNo;
	}
	/**
	 * 获取：短信模板id
	 */
	public String getTemplateSmsNo() {
		return templateSmsNo;
	}
	/**
	 * 设置：彩信模板id
	 */
	public void setTemplateMmsNo(String templateMmsNo) {
		this.templateMmsNo = templateMmsNo;
	}
	/**
	 * 获取：彩信模板id
	 */
	public String getTemplateMmsNo() {
		return templateMmsNo;
	}
	/**
	 * 设置：结算单价
	 */
	public void setSettlementPrice(BigDecimal settlementPrice) {
		this.settlementPrice = settlementPrice;
	}
	/**
	 * 获取：结算单价
	 */
	public BigDecimal getSettlementPrice() {
		return settlementPrice;
	}
	/**
	 * 设置：票种分组
	 */
	public void setTicketGrouping(String ticketGrouping) {
		this.ticketGrouping = ticketGrouping;
	}
	/**
	 * 获取：票种分组
	 */
	public String getTicketGrouping() {
		return ticketGrouping;
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
	 * 设置：售票用户组
	 */
	public void setUserRoleId(String userRoleId) {
		this.userRoleId = userRoleId;
	}
	/**
	 * 获取：售票用户组
	 */
	public String getUserRoleId() {
		return userRoleId;
	}
	/**
	 * 设置：打印模板
	 */
	public void setTemplateNo(String templateNo) {
		this.templateNo = templateNo;
	}
	/**
	 * 获取：打印模板
	 */
	public String getTemplateNo() {
		return templateNo;
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
	 * 设置：是否使用退票策略
	 */
	public void setWhetherRefundStrategy(String whetherRefundStrategy) {
		this.whetherRefundStrategy = whetherRefundStrategy;
	}
	/**
	 * 获取：是否使用退票策略
	 */
	public String getWhetherRefundStrategy() {
		return whetherRefundStrategy;
	}
	/**
	 * 设置：退票策略
	 */
	public void setStrategyNo(String strategyNo) {
		this.strategyNo = strategyNo;
	}
	/**
	 * 获取：退票策略
	 */
	public String getStrategyNo() {
		return strategyNo;
	}
	/**
	 * 设置：退票策略明细编号
	 */
	public void setRefundStrategyDetailNo(String refundStrategyDetailNo) {
		this.refundStrategyDetailNo = refundStrategyDetailNo;
	}
	/**
	 * 获取：退票策略明细编号
	 */
	public String getRefundStrategyDetailNo() {
		return refundStrategyDetailNo;
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
	 * 设置：产品提供商
	 */
	public void setProductProvider(String productProvider) {
		this.productProvider = productProvider;
	}
	/**
	 * 获取：产品提供商
	 */
	public String getProductProvider() {
		return productProvider;
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
	 * 设置：公司编号
	 */
	public void setCompanyNo(String companyNo) {
		this.companyNo = companyNo;
	}
	/**
	 * 获取：公司编号
	 */
	public String getCompanyNo() {
		return companyNo;
	}
	/**
	 * 设置：是否启用库存
	 */
	public void setWhetherLimitStock(String whetherLimitStock) {
		this.whetherLimitStock = whetherLimitStock;
	}
	/**
	 * 获取：是否启用库存
	 */
	public String getWhetherLimitStock() {
		return whetherLimitStock;
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

	public String getStrategyDetailName() {
		return strategyDetailName;
	}

	public void setStrategyDetailName(String strategyDetailName) {
		this.strategyDetailName = strategyDetailName;
	}

	public String getProductTypeName() {
		return productTypeName;
	}

	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getIsEntity() {
		return isEntity;
	}

	public void setIsEntity(String isEntity) {
		this.isEntity = isEntity;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}
}
