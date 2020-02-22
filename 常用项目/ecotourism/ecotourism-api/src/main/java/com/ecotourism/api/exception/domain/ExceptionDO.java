package com.ecotourism.api.exception.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 异常信息记录
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-08-20 18:04:38
 */
public class ExceptionDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//批次
	private String batchNumber;
	private String apiCode;
	private String apiName;
	//来源系统
	private String sysresource;
	//访问的参数
	private String reqParam;
	//访问的路径
	private String exUrl;
	//操作者
	private String operator;
	//异常信息
	private String exceptionMsg;
	//异常发生时间
	private Date createTime;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：来源系统
	 */
	public void setSysresource(String sysresource) {
		this.sysresource = sysresource;
	}
	/**
	 * 获取：来源系统
	 */
	public String getSysresource() {
		return sysresource;
	}
	/**
	 * 设置：访问的参数
	 */
	public void setReqParam(String reqParam) {
		this.reqParam = reqParam;
	}
	/**
	 * 获取：访问的参数
	 */
	public String getReqParam() {
		return reqParam;
	}
	/**
	 * 设置：访问的路径
	 */
	public void setExUrl(String exUrl) {
		this.exUrl = exUrl;
	}
	/**
	 * 获取：访问的路径
	 */
	public String getExUrl() {
		return exUrl;
	}
	/**
	 * 设置：操作者
	 */
	public void setOperator(String operator) {
		this.operator = operator;
	}
	/**
	 * 获取：操作者
	 */
	public String getOperator() {
		return operator;
	}
	/**
	 * 设置：异常信息
	 */
	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}
	/**
	 * 获取：异常信息
	 */
	public String getExceptionMsg() {
		return exceptionMsg;
	}
	/**
	 * 设置：异常发生时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：异常发生时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	public String getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public String getApiCode() {
		return apiCode;
	}

	public void setApiCode(String apiCode) {
		this.apiCode = apiCode;
	}

	public String getApiName() {
		return apiName;
	}

	public void setApiName(String apiName) {
		this.apiName = apiName;
	}
}
