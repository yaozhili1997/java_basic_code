package com.ecotourism.supplier.base.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 期限管理
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-06-23 15:17:10
 */
public class TermManagementDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//期限管理ID
	private Integer termId;
	//期限管理编码
	private String termNo;
	//期限管理名称
	private String termName;
	//使用类型
	private String termUseType;
	//间隔时长
	private Integer termTime;
	//备注
	private String remarks;
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
	//有效开始时间
	private Date effectiveStartDate;
	//结束时间
	private Date effectiveEndDate;
	//是否次数限制
	private String whetherLimitNumber;
	//次数
	private Integer frequency;

	private String companyNo;

	/**
	 * 设置：期限管理ID
	 */
	public void setTermId(Integer termId) {
		this.termId = termId;
	}
	/**
	 * 获取：期限管理ID
	 */
	public Integer getTermId() {
		return termId;
	}
	/**
	 * 设置：期限管理编码
	 */
	public void setTermNo(String termNo) {
		this.termNo = termNo;
	}
	/**
	 * 获取：期限管理编码
	 */
	public String getTermNo() {
		return termNo;
	}
	/**
	 * 设置：期限管理名称
	 */
	public void setTermName(String termName) {
		this.termName = termName;
	}
	/**
	 * 获取：期限管理名称
	 */
	public String getTermName() {
		return termName;
	}
	/**
	 * 设置：使用类型
	 */
	public void setTermUseType(String termUseType) {
		this.termUseType = termUseType;
	}
	/**
	 * 获取：使用类型
	 */
	public String getTermUseType() {
		return termUseType;
	}
	/**
	 * 设置：间隔时长
	 */
	public void setTermTime(Integer termTime) {
		this.termTime = termTime;
	}
	/**
	 * 获取：间隔时长
	 */
	public Integer getTermTime() {
		return termTime;
	}
	/**
	 * 设置：备注
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * 获取：备注
	 */
	public String getRemarks() {
		return remarks;
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
	/**
	 * 设置：有效开始时间
	 */
	public void setEffectiveStartDate(Date effectiveStartDate) {
		this.effectiveStartDate = effectiveStartDate;
	}
	/**
	 * 获取：有效开始时间
	 */
	public Date getEffectiveStartDate() {
		return effectiveStartDate;
	}

	public Date getEffectiveEndDate() {
		return effectiveEndDate;
	}

	public void setEffectiveEndDate(Date effectiveEndDate) {
		this.effectiveEndDate = effectiveEndDate;
	}

	/**
	 * 设置：是否次数限制
	 */
	public void setWhetherLimitNumber(String whetherLimitNumber) {
		this.whetherLimitNumber = whetherLimitNumber;
	}
	/**
	 * 获取：是否次数限制
	 */
	public String getWhetherLimitNumber() {
		return whetherLimitNumber;
	}
	/**
	 * 设置：次数
	 */
	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}
	/**
	 * 获取：次数
	 */
	public Integer getFrequency() {
		return frequency;
	}

	public String getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(String companyNo) {
		this.companyNo = companyNo;
	}
}
