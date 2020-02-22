package com.ecotourism.manage.base.domain;

import com.ecotourism.manage.common.annotation.Dict;
import com.ecotourism.manage.common.config.DictTypeConfig;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 门票种类
 * 
 * @author chqy
 * @date 2018-05-31 14:38:39
 */
public class TicketTypeDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//票种定义ID
	private Integer ticketId;
	//所属景点编号
	private String spotNo;
	//所属景点名称
	private String spotName;
	//票种编号
	private String ticketNo;
	//票种名称
	private String ticketName;
	//票种供应商
	private String ticketSupplier;
	private String supplierName;//供应商名称
	//票种类型
	@Dict(DictTypeConfig.TYPE_TICKET_TYPE)
	private String ticketType;
	//定价
	private BigDecimal ticketPrice;
	//是否支持取票后退票
	private String afterTakeSceneRefund="0";
	//是否支持过期退票
	private String expiredRefund="0";
	//是否上架
	private String whetherShelves="0";
	//是否为自用票种
	private String isSelf="0";
	//创建人
	private String createUser;
	//创建时间
	private Date createTime;
	//更新人
	private String updateUser;
	//更新时间
	private Date updateTime;
	//门票简称
	private String abbreviation;
	//所属产品类型
	private String productType;
	//
	private String companyNo;

	/**
	 * 设置：票种定义ID
	 */
	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}
	/**
	 * 获取：票种定义ID
	 */
	public Integer getTicketId() {
		return ticketId;
	}
	/**
	 * 设置：所属景点编号
	 */
	public void setSpotNo(String spotNo) {
		this.spotNo = spotNo;
	}
	/**
	 * 获取：所属景点编号
	 */
	public String getSpotNo() {
		return spotNo;
	}
	/**
	 * 设置：所属景点名称
	 */
	public void setSpotName(String spotName) {
		this.spotName = spotName;
	}
	/**
	 * 获取：所属景点名称
	 */
	public String getSpotName() {
		return spotName;
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
	 * 设置：票种名称
	 */
	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}
	/**
	 * 获取：票种名称
	 */
	public String getTicketName() {
		return ticketName;
	}
	/**
	 * 设置：票种供应商
	 */
	public void setTicketSupplier(String ticketSupplier) {
		this.ticketSupplier = ticketSupplier;
	}
	/**
	 * 获取：票种供应商
	 */
	public String getTicketSupplier() {
		return ticketSupplier;
	}
	/**
	 * 设置：票种类型
	 */
	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}
	/**
	 * 获取：票种类型
	 */
	public String getTicketType() {
		return ticketType;
	}
	/**
	 * 设置：定价
	 */
	public void setTicketPrice(BigDecimal ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	/**
	 * 获取：定价
	 */
	public BigDecimal getTicketPrice() {
		return ticketPrice;
	}
	/**
	 * 设置：是否支持取票后退票
	 */
	public void setAfterTakeSceneRefund(String afterTakeSceneRefund) {
		this.afterTakeSceneRefund = afterTakeSceneRefund;
	}
	/**
	 * 获取：是否支持取票后退票
	 */
	public String getAfterTakeSceneRefund() {
		return afterTakeSceneRefund;
	}
	/**
	 * 设置：是否支持过期退票
	 */
	public void setExpiredRefund(String expiredRefund) {
		this.expiredRefund = expiredRefund;
	}
	/**
	 * 获取：是否支持过期退票
	 */
	public String getExpiredRefund() {
		return expiredRefund;
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
	 * 设置：创建人
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreateUser() {
		return createUser;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：更新人
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	/**
	 * 获取：更新人
	 */
	public String getUpdateUser() {
		return updateUser;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：门票简称
	 */
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	/**
	 * 获取：门票简称
	 */
	public String getAbbreviation() {
		return abbreviation;
	}
	/**
	 * 设置：所属产品类型
	 */
	public void setProductType(String productType) {
		this.productType = productType;
	}
	/**
	 * 获取：所属产品类型
	 */
	public String getProductType() {
		return productType;
	}
	/**
	 * 设置：
	 */
	public void setCompanyNo(String companyNo) {
		this.companyNo = companyNo;
	}
	/**
	 * 获取：
	 */
	public String getCompanyNo() {
		return companyNo;
	}

	public String getIsSelf() {
		return isSelf;
	}

	public void setIsSelf(String isSelf) {
		this.isSelf = isSelf;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
}
