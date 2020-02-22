package com.ecotourism.supplier.base.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 景点管理
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-06-23 15:17:10
 */
public class SpotManagementDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//景点ID
	private Integer spotId;
	//景点编号
	private String spotNo;
	//景点名称
	private String spotName;
	//景点介绍
	private String spotIntroduct;
	//景点电话
	private String spotPhone;
	//所属景区
	private String areaNo;
	//是否可用
	private String available;
	//创建人
	private String createUser;
	//创建时间
	private Date createTime;
	//更新人
	private String updateUser;
	//更新时间
	private Date updateTime;
	//开园时间
	private String openingHours;
	//闭园时间
	private String closingHours;
	//停止售票时间
	private String stopSellingTicketsTime;
	//停止检票时间
	private String stopCheckingTime;
	//是否闭园
	private String whetherClose;
	//闭园日期
	private String closeDate;

	/**
	 * 设置：景点ID
	 */
	public void setSpotId(Integer spotId) {
		this.spotId = spotId;
	}
	/**
	 * 获取：景点ID
	 */
	public Integer getSpotId() {
		return spotId;
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
	 * 设置：景点名称
	 */
	public void setSpotName(String spotName) {
		this.spotName = spotName;
	}
	/**
	 * 获取：景点名称
	 */
	public String getSpotName() {
		return spotName;
	}
	/**
	 * 设置：景点介绍
	 */
	public void setSpotIntroduct(String spotIntroduct) {
		this.spotIntroduct = spotIntroduct;
	}
	/**
	 * 获取：景点介绍
	 */
	public String getSpotIntroduct() {
		return spotIntroduct;
	}
	/**
	 * 设置：景点电话
	 */
	public void setSpotPhone(String spotPhone) {
		this.spotPhone = spotPhone;
	}
	/**
	 * 获取：景点电话
	 */
	public String getSpotPhone() {
		return spotPhone;
	}
	/**
	 * 设置：所属景区
	 */
	public void setAreaNo(String areaNo) {
		this.areaNo = areaNo;
	}
	/**
	 * 获取：所属景区
	 */
	public String getAreaNo() {
		return areaNo;
	}
	/**
	 * 设置：是否可用
	 */
	public void setAvailable(String available) {
		this.available = available;
	}
	/**
	 * 获取：是否可用
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
	 * 设置：开园时间
	 */
	public void setOpeningHours(String openingHours) {
		this.openingHours = openingHours;
	}
	/**
	 * 获取：开园时间
	 */
	public String getOpeningHours() {
		return openingHours;
	}
	/**
	 * 设置：闭园时间
	 */
	public void setClosingHours(String closingHours) {
		this.closingHours = closingHours;
	}
	/**
	 * 获取：闭园时间
	 */
	public String getClosingHours() {
		return closingHours;
	}
	/**
	 * 设置：停止售票时间
	 */
	public void setStopSellingTicketsTime(String stopSellingTicketsTime) {
		this.stopSellingTicketsTime = stopSellingTicketsTime;
	}
	/**
	 * 获取：停止售票时间
	 */
	public String getStopSellingTicketsTime() {
		return stopSellingTicketsTime;
	}
	/**
	 * 设置：停止检票时间
	 */
	public void setStopCheckingTime(String stopCheckingTime) {
		this.stopCheckingTime = stopCheckingTime;
	}
	/**
	 * 获取：停止检票时间
	 */
	public String getStopCheckingTime() {
		return stopCheckingTime;
	}
	/**
	 * 设置：是否闭园
	 */
	public void setWhetherClose(String whetherClose) {
		this.whetherClose = whetherClose;
	}
	/**
	 * 获取：是否闭园
	 */
	public String getWhetherClose() {
		return whetherClose;
	}
	/**
	 * 设置：闭园日期
	 */
	public void setCloseDate(String closeDate) {
		this.closeDate = closeDate;
	}
	/**
	 * 获取：闭园日期
	 */
	public String getCloseDate() {
		return closeDate;
	}
}
