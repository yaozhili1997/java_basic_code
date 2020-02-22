package com.ecotourism.manage.sms.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 短信发送日志
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-07 20:53:33
 */
public class SendLogDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//短信id
	private Integer id;
	//手机号码
	private String mobile;
	//短信内容
	private String content;
	//订单编号
	private String orderNo;
	//短信供应商编号
	private String supplierNo;
	//发送状态
	private String sendStatus;
	//错误信息
	private String errorMsg;
	//短信内容
	private String smsType;
	//电子票号
	private String tickets;
	//彩信标题
	private String mmsTitle;
	//发送方式
	private String sendWay;
	//发送者编号
	private String senderNo;
	//创建时间
	private Date createTime;
	//更新时间
	private Date updateTime;
	//分销商编号
	private String distributionNo;
	//公司编号
	private String companyNo;


	/**
	 * 设置：短信id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：短信id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：手机号码
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：手机号码
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置：短信内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：短信内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：订单编号
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	/**
	 * 获取：订单编号
	 */
	public String getOrderNo() {
		return orderNo;
	}
	/**
	 * 设置：短信供应商编号
	 */
	public void setSupplierNo(String supplierNo) {
		this.supplierNo = supplierNo;
	}
	/**
	 * 获取：短信供应商编号
	 */
	public String getSupplierNo() {
		return supplierNo;
	}
	/**
	 * 设置：发送状态
	 */
	public void setSendStatus(String sendStatus) {
		this.sendStatus = sendStatus;
	}
	/**
	 * 获取：发送状态
	 */
	public String getSendStatus() {
		return sendStatus;
	}
	/**
	 * 设置：错误信息
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	/**
	 * 获取：错误信息
	 */
	public String getErrorMsg() {
		return errorMsg;
	}
	/**
	 * 设置：短信内容
	 */
	public void setSmsType(String smsType) {
		this.smsType = smsType;
	}
	/**
	 * 获取：短信内容
	 */
	public String getSmsType() {
		return smsType;
	}
	/**
	 * 设置：电子票号
	 */
	public void setTickets(String tickets) {
		this.tickets = tickets;
	}
	/**
	 * 获取：电子票号
	 */
	public String getTickets() {
		return tickets;
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
	 * 设置：发送者编号
	 */
	public void setSenderNo(String senderNo) {
		this.senderNo = senderNo;
	}
	/**
	 * 获取：发送者编号
	 */
	public String getSenderNo() {
		return senderNo;
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

	public String getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(String companyNo) {
		this.companyNo = companyNo;
	}
}
