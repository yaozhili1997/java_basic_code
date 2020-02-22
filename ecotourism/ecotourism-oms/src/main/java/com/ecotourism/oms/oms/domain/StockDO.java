package com.ecotourism.oms.oms.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 产品库存表
 * 
 * @author ³ÂÆôÓÂ
 * @email chqy_ljy@163.com
 * @date 2018-10-12 09:21:06
 */
public class StockDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//产品编号
	private String productNo;
	//库存使用时间开始
	private Date userStartTime;
	//库存使用时间结束
	private Date userEndTime;
	//库存编号
	private String stocketNo;
	//库存名称
	private String stocketName;
	//库存数量
	private Integer stocketNumber;
	//剩余库存
	private Integer surplusStockNum;
	//是否启用
	private String abbreviation;
	//创建人
	private String createUser;
	//创建时间
	private Date createTime;
	//更新人
	private String updateUser;
	//更新时间
	private Date updateTime;
	//公司编号
	private String companyNo;

	private Date nowTime;

	private int num;

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
	 * 设置：库存使用时间开始
	 */
	public void setUserStartTime(Date userStartTime) {
		this.userStartTime = userStartTime;
	}
	/**
	 * 获取：库存使用时间开始
	 */
	public Date getUserStartTime() {
		return userStartTime;
	}
	/**
	 * 设置：库存使用时间结束
	 */
	public void setUserEndTime(Date userEndTime) {
		this.userEndTime = userEndTime;
	}
	/**
	 * 获取：库存使用时间结束
	 */
	public Date getUserEndTime() {
		return userEndTime;
	}
	/**
	 * 设置：库存编号
	 */
	public void setStocketNo(String stocketNo) {
		this.stocketNo = stocketNo;
	}
	/**
	 * 获取：库存编号
	 */
	public String getStocketNo() {
		return stocketNo;
	}
	/**
	 * 设置：库存名称
	 */
	public void setStocketName(String stocketName) {
		this.stocketName = stocketName;
	}
	/**
	 * 获取：库存名称
	 */
	public String getStocketName() {
		return stocketName;
	}
	/**
	 * 设置：库存数量
	 */
	public void setStocketNumber(Integer stocketNumber) {
		this.stocketNumber = stocketNumber;
	}
	/**
	 * 获取：库存数量
	 */
	public Integer getStocketNumber() {
		return stocketNumber;
	}
	/**
	 * 设置：剩余库存
	 */
	public void setSurplusStockNum(Integer surplusStockNum) {
		this.surplusStockNum = surplusStockNum;
	}
	/**
	 * 获取：剩余库存
	 */
	public Integer getSurplusStockNum() {
		return surplusStockNum;
	}
	/**
	 * 设置：是否启用
	 */
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	/**
	 * 获取：是否启用
	 */
	public String getAbbreviation() {
		return abbreviation;
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

	public Date getNowTime() {
		return nowTime;
	}

	public void setNowTime(Date nowTime) {
		this.nowTime = nowTime;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
}
