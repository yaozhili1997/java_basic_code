package com.ecotourism.oms.product.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 产品价格库存日历表
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-12-18 09:10:33
 */
public class PriceStockDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//产品编号
	private String productNo;
	//日期
	private Date date;
	//结算价格
	private BigDecimal settlementPrice;
	//售价
	private BigDecimal salePrice;
	//已售数量
	private Integer saleNum;
	//库存数量
	private Integer stockNum;
	//创建人
	private String createUser;
	//创建时间
	private Date createTime;
	//更新人
	private String updateUser;
	//更新时间
	private Date updateTime;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
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
	 * 设置：日期
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * 获取：日期
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * 设置：结算价格
	 */
	public void setSettlementPrice(BigDecimal settlementPrice) {
		this.settlementPrice = settlementPrice;
	}
	/**
	 * 获取：结算价格
	 */
	public BigDecimal getSettlementPrice() {
		return settlementPrice;
	}
	/**
	 * 设置：售价
	 */
	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}
	/**
	 * 获取：售价
	 */
	public BigDecimal getSalePrice() {
		return salePrice;
	}
	/**
	 * 设置：已售数量
	 */
	public void setSaleNum(Integer saleNum) {
		this.saleNum = saleNum;
	}
	/**
	 * 获取：已售数量
	 */
	public Integer getSaleNum() {
		return saleNum;
	}
	/**
	 * 设置：库存数量
	 */
	public void setStockNum(Integer stockNum) {
		this.stockNum = stockNum;
	}
	/**
	 * 获取：库存数量
	 */
	public Integer getStockNum() {
		return stockNum;
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
}
