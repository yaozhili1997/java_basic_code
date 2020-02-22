package com.ecotourism.api.application.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 接口响应耗时
 * 
 * @author 陈启勇
 * @date 2018-11-02 14:40:32
 */
public class ApplicationApiDetectionDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	private String apiCode;
	//接口名称
	private String apiName;
	//接口地址
	private String apiUrl;
	//
	private String reqParam;
	//损耗时间(毫秒）
	private Long timeConsuming;
	//创建时间
	private Date createTime;
	//完成时间
	private Date completeTime;

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
	 * 设置：接口名称
	 */
	public void setApiName(String apiName) {
		this.apiName = apiName;
	}
	/**
	 * 获取：接口名称
	 */
	public String getApiName() {
		return apiName;
	}
	/**
	 * 设置：接口地址
	 */
	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}
	/**
	 * 获取：接口地址
	 */
	public String getApiUrl() {
		return apiUrl;
	}
	/**
	 * 设置：
	 */
	public void setReqParam(String reqParam) {
		this.reqParam = reqParam;
	}
	/**
	 * 获取：
	 */
	public String getReqParam() {
		return reqParam;
	}
	/**
	 * 设置：损耗时间(毫秒）
	 */
	public void setTimeConsuming(Long timeConsuming) {
		this.timeConsuming = timeConsuming;
	}
	/**
	 * 获取：损耗时间(毫秒）
	 */
	public Long getTimeConsuming() {
		return timeConsuming;
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
	 * 设置：完成时间
	 */
	public void setCompleteTime(Date completeTime) {
		this.completeTime = completeTime;
	}
	/**
	 * 获取：完成时间
	 */
	public Date getCompleteTime() {
		return completeTime;
	}
	public String getApiCode() {
		return apiCode;
	}
	public void setApiCode(String apiCode) {
		this.apiCode = apiCode;
	}
}
