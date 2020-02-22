package com.ecotourism.manage.exception.domain;

import com.ecotourism.manage.common.utils.StringUtils;

import java.io.Serializable;
import java.util.Date;



/**
 * 异常信息记录
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-10-15 16:39:30
 */
public class ExceptionDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//异常批次号
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
	private String appName;
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
	 * 设置：异常批次号
	 */
	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}
	/**
	 * 获取：异常批次号
	 */
	public String getBatchNumber() {
		return batchNumber;
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
		return StringUtils.isBlank(reqParam)?reqParam:reqParam.replaceAll("\"", "'");
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
		return StringUtils.isBlank(exceptionMsg)?exceptionMsg:exceptionMsg.replaceAll("\"", "'");
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

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
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
