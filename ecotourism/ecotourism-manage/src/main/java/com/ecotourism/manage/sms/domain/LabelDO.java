package com.ecotourism.manage.sms.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 短信替换标签
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-07 20:53:33
 */
public class LabelDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//标签id
	private Integer id;
	//标签名字
	private String labelName;
	//标签替换值
	private String labelValue;
	//是否可用
	private String enable;
	//创建时间
	private Date createTime;
	//更新时间
	private Date updateTime;
	//创建人
	private String createUser;
	//修改人
	private String updateUser;
	//公司编码
	private String companyNo;

	/**
	 * 设置：标签id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：标签id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：标签名字
	 */
	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}
	/**
	 * 获取：标签名字
	 */
	public String getLabelName() {
		return labelName;
	}
	/**
	 * 设置：标签替换值
	 */
	public void setLabelValue(String labelValue) {
		this.labelValue = labelValue;
	}
	/**
	 * 获取：标签替换值
	 */
	public String getLabelValue() {
		return labelValue;
	}
	/**
	 * 设置：是否可用
	 */
	public void setEnable(String enable) {
		this.enable = enable;
	}
	/**
	 * 获取：是否可用
	 */
	public String getEnable() {
		return enable;
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

	public String getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(String companyNo) {
		this.companyNo = companyNo;
	}
}
