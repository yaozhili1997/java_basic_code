package com.ecotourism.supplier.base.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 景区管理
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-06-23 15:17:10
 */
public class AreaManagementDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//景区ID
	private Integer areaId;
	//景区编号
	private String areaNo;
	//景区名称
	private String areaName;
	//景区介绍
	private String areaIntroduce;
	//景区电话
	private String areaPhone;
	//是否可用
	private String available="0";
	//创建人
	private String createUser;
	//创建时间
	private Date createTime;
	//更新人
	private String updateUser;
	//更新时间
	private Date updateTime;

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public String getAreaNo() {
		return areaNo;
	}

	public void setAreaNo(String areaNo) {
		this.areaNo = areaNo;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getAreaIntroduce() {
		return areaIntroduce;
	}

	public void setAreaIntroduce(String areaIntroduce) {
		this.areaIntroduce = areaIntroduce;
	}

	public String getAreaPhone() {
		return areaPhone;
	}

	public void setAreaPhone(String areaPhone) {
		this.areaPhone = areaPhone;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
