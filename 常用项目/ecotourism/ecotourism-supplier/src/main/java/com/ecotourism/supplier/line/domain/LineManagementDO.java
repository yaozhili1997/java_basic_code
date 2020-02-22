package com.ecotourism.supplier.line.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-09 16:11:27
 */
public class LineManagementDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//线路编号
	private String lineNo;
	//线路名称
	private String lineName;
	//是否可用
	private String whetherAvailable="0";
	//创建人
	private String createUser;
	//创建时间
	private Date createTime;
	//修改人
	private String updateUser;
	//修改时间
	private Date updateTime;
	//公司编号
	private String companyNo;
	//是否选中
	private String isCheck;

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
	 * 设置：线路编号
	 */
	public void setLineNo(String lineNo) {
		this.lineNo = lineNo;
	}
	/**
	 * 获取：线路编号
	 */
	public String getLineNo() {
		return lineNo;
	}
	/**
	 * 设置：线路名称
	 */
	public void setLineName(String lineName) {
		this.lineName = lineName;
	}
	/**
	 * 获取：线路名称
	 */
	public String getLineName() {
		return lineName;
	}
	/**
	 * 设置：是否可用
	 */
	public void setWhetherAvailable(String whetherAvailable) {
		this.whetherAvailable = whetherAvailable;
	}
	/**
	 * 获取：是否可用
	 */
	public String getWhetherAvailable() {
		return whetherAvailable;
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

	public String getIsCheck() {
		return isCheck;
	}

	public void setIsCheck(String isCheck) {
		this.isCheck = isCheck;
	}
}
