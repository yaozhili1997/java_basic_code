package com.ecotourism.manage.base.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;


/**
 * 退票策略明细
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-06-23 15:17:10
 */
public class RefundStrategyDetailsDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//退票策略明细ID
	private Integer strategyDetailId;
	//明细编号
	private String strategyDetailNo;
	//
	private String strategyDetailName;
	//购票后时长（小时）
	private Integer strategyDetailTime;
	//所属退票策略
	private String strategyNo;
	//退票比例
	private Float refundProportion;
	//备注
	private String remarks;

	private String companyNo;

	/**
	 * 设置：退票策略明细ID
	 */
	public void setStrategyDetailId(Integer strategyDetailId) {
		this.strategyDetailId = strategyDetailId;
	}
	/**
	 * 获取：退票策略明细ID
	 */
	public Integer getStrategyDetailId() {
		return strategyDetailId;
	}
	/**
	 * 设置：明细编号
	 */
	@JsonIgnore
	public void setStrategyDetailNo(String strategyDetailNo) {
		this.strategyDetailNo = strategyDetailNo;
	}
	/**
	 * 获取：明细编号
	 */
	@JsonIgnore
	public String getStrategyDetailNo() {
		return strategyDetailNo;
	}
	/**
	 * 设置：
	 */
	public void setStrategyDetailName(String strategyDetailName) {
		this.strategyDetailName = strategyDetailName;
	}
	/**
	 * 获取：
	 */
	public String getStrategyDetailName() {
		return strategyDetailName;
	}
	/**
	 * 设置：购票后时长（小时）
	 */
	public void setStrategyDetailTime(Integer strategyDetailTime) {
		this.strategyDetailTime = strategyDetailTime;
	}
	/**
	 * 获取：购票后时长（小时）
	 */
	public Integer getStrategyDetailTime() {
		return strategyDetailTime;
	}
	/**
	 * 设置：所属退票策略
	 */
	@JsonBackReference
	public void setStrategyNo(String strategyNo) {
		this.strategyNo = strategyNo;
	}
	/**
	 * 获取：所属退票策略
	 */

	public String getStrategyNo() {
		return strategyNo;
	}
	/**
	 * 设置：退票比例
	 */
	public void setRefundProportion(Float refundProportion) {
		this.refundProportion = refundProportion;
	}
	/**
	 * 获取：退票比例
	 */
	public Float getRefundProportion() {
		return refundProportion;
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

	public String getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(String companyNo) {
		this.companyNo = companyNo;
	}
}
