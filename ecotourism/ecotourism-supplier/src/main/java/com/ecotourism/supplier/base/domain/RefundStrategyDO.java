package com.ecotourism.supplier.base.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 退票策略
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-06-23 15:17:10
 */
public class RefundStrategyDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//退票策略ID
	private Integer strategyId;
	//退票策略编号
	private String strategyNo;
	//退票策略名称
	private String strategyName;
	//是否启用
	private String available;
	//创建人
	private String createUser;
	//创建时间
	private Date createTime;
	//更新人
	private String updateUser;
	//更新时间
	private Date updateTime;

	private String companyNo;

	/**
	 * 设置：退票策略ID
	 */
	public void setStrategyId(Integer strategyId) {
		this.strategyId = strategyId;
	}
	/**
	 * 获取：退票策略ID
	 */
	public Integer getStrategyId() {
		return strategyId;
	}
	/**
	 * 设置：退票策略编号
	 */
	public void setStrategyNo(String strategyNo) {
		this.strategyNo = strategyNo;
	}
	/**
	 * 获取：退票策略编号
	 */
	public String getStrategyNo() {
		return strategyNo;
	}
	/**
	 * 设置：退票策略名称
	 */
	public void setStrategyName(String strategyName) {
		this.strategyName = strategyName;
	}
	/**
	 * 获取：退票策略名称
	 */
	public String getStrategyName() {
		return strategyName;
	}
	/**
	 * 设置：是否启用
	 */
	public void setAvailable(String available) {
		this.available = available;
	}
	/**
	 * 获取：是否启用
	 */
	public String getAvailable() {
		return available;
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

	public String getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(String companyNo) {
		this.companyNo = companyNo;
	}
}
