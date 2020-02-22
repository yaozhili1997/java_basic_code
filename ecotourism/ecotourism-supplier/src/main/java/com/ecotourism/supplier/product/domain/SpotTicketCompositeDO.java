package com.ecotourism.supplier.product.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-06 21:36:20
 */
public class SpotTicketCompositeDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//套票产品编号
	private String compositeNo;
	//父类型
	private String productType;
	//子类型
	private String productSecondType;
	//产品编号
	private String productNo;
	//产品名称
	private String productName;
	//售价
	private BigDecimal payPrice;
	//分成价
	private BigDecimal fractionalPrice;
	//票种编号
	private String ticketNo;
	//票种分组
	private String ticketGrouping;
	//景点编号
	private String spotNo;
	//产品状态
	private String status;
	//创建时间
	private Date createTime;
	//创建人
	private String createUser;
	//修改时间
	private Date updateTime;
	//修改人
	private String updateUser;

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
	 * 设置：套票产品编号
	 */
	public void setCompositeNo(String compositeNo) {
		this.compositeNo = compositeNo;
	}
	/**
	 * 获取：套票产品编号
	 */
	public String getCompositeNo() {
		return compositeNo;
	}
	/**
	 * 设置：父类型
	 */
	public void setProductType(String productType) {
		this.productType = productType;
	}
	/**
	 * 获取：父类型
	 */
	public String getProductType() {
		return productType;
	}
	/**
	 * 设置：子类型
	 */
	public void setProductSecondType(String productSecondType) {
		this.productSecondType = productSecondType;
	}
	/**
	 * 获取：子类型
	 */
	public String getProductSecondType() {
		return productSecondType;
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
	 * 设置：分成价
	 */
	public void setFractionalPrice(BigDecimal fractionalPrice) {
		this.fractionalPrice = fractionalPrice;
	}
	/**
	 * 获取：分成价
	 */
	public BigDecimal getFractionalPrice() {
		return fractionalPrice;
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
	 * 设置：景点编号
	 */
	public void setSpotNo(String spotNo) {
		this.spotNo = spotNo;
	}
	/**
	 * 获取：景点编号
	 */
	public String getSpotNo() {
		return spotNo;
	}
	/**
	 * 设置：产品状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：产品状态
	 */
	public String getStatus() {
		return status;
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
	 * 设置：修改时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：修改人
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	/**
	 * 获取：修改人
	 */
	public String getUpdateUser() {
		return updateUser;
	}
}
