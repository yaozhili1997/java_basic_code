package com.ecotourism.supplier.sms.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 短信模板
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-07 20:53:33
 */
public class TemplateDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//模板id
	private Integer templateId;
	//模板编号
	private String templateNo;
	//模板名称
	private String templateName;
	//模板内容
	private String content;
	//彩信标题
	private String mmsTitle;
	//发送供应商编号
	private String supplierNo;
	//发送方式
	private String sendWay;
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
	//公司编号
	private String companyNo;

	/**
	 * 设置：模板id
	 */
	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}
	/**
	 * 获取：模板id
	 */
	public Integer getTemplateId() {
		return templateId;
	}
	/**
	 * 设置：模板编号
	 */
	public void setTemplateNo(String templateNo) {
		this.templateNo = templateNo;
	}
	/**
	 * 获取：模板编号
	 */
	public String getTemplateNo() {
		return templateNo;
	}
	/**
	 * 设置：模板名称
	 */
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	/**
	 * 获取：模板名称
	 */
	public String getTemplateName() {
		return templateName;
	}
	/**
	 * 设置：模板内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：模板内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：彩信标题
	 */
	public void setMmsTitle(String mmsTitle) {
		this.mmsTitle = mmsTitle;
	}
	/**
	 * 获取：彩信标题
	 */
	public String getMmsTitle() {
		return mmsTitle;
	}
	/**
	 * 设置：发送供应商编号
	 */
	public void setSupplierNo(String supplierNo) {
		this.supplierNo = supplierNo;
	}
	/**
	 * 获取：发送供应商编号
	 */
	public String getSupplierNo() {
		return supplierNo;
	}
	/**
	 * 设置：发送方式
	 */
	public void setSendWay(String sendWay) {
		this.sendWay = sendWay;
	}
	/**
	 * 获取：发送方式
	 */
	public String getSendWay() {
		return sendWay;
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
