package com.ecotourism.oms.oms.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 分销商oms产品接口配置
 * 
 * @author ³ÂÆôÓÂ
 * @email chqy_ljy@163.com
 * @date 2018-10-12 14:11:45
 */
public class ConfigDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//分销商编号
	private String distributionNo;
	//产品编号序列
	private String productNoOrder;
	//显示产品序列
	private String showNoOrder;
	//快捷键值
	private String keyCode;
	//创建人
	private String createUser;
	//创建时间
	private Date createTime;
	//更新时间
	private Date updateTime;
	//更新人
	private String updateUser;
	//公司编码
	private String companyNo;

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
	 * 设置：分销商编号
	 */
	public void setDistributionNo(String distributionNo) {
		this.distributionNo = distributionNo;
	}
	/**
	 * 获取：分销商编号
	 */
	public String getDistributionNo() {
		return distributionNo;
	}
	/**
	 * 设置：产品编号序列
	 */
	public void setProductNoOrder(String productNoOrder) {
		this.productNoOrder = productNoOrder;
	}
	/**
	 * 获取：产品编号序列
	 */
	public String getProductNoOrder() {
		return productNoOrder;
	}
	/**
	 * 设置：显示产品序列
	 */
	public void setShowNoOrder(String showNoOrder) {
		this.showNoOrder = showNoOrder;
	}
	/**
	 * 获取：显示产品序列
	 */
	public String getShowNoOrder() {
		return showNoOrder;
	}
	/**
	 * 设置：快捷键值
	 */
	public void setKeyCode(String keyCode) {
		this.keyCode = keyCode;
	}
	/**
	 * 获取：快捷键值
	 */
	public String getKeyCode() {
		return keyCode;
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
	 * 设置：公司编码
	 */
	public void setCompanyNo(String companyNo) {
		this.companyNo = companyNo;
	}
	/**
	 * 获取：公司编码
	 */
	public String getCompanyNo() {
		return companyNo;
	}
}
