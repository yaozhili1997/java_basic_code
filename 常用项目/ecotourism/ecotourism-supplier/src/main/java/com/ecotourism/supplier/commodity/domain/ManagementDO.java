package com.ecotourism.supplier.commodity.domain;

import java.io.Serializable;


/**
 * 属性管理
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-02 11:12:41
 */
public class ManagementDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private String attributeName;
	//
	private String attributeType;
	//
	private String companyNo;

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
	 * 设置：
	 */
	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}
	/**
	 * 获取：
	 */
	public String getAttributeName() {
		return attributeName;
	}
	/**
	 * 设置：
	 */
	public void setAttributeType(String attributeType) {
		this.attributeType = attributeType;
	}
	/**
	 * 获取：
	 */
	public String getAttributeType() {
		return attributeType;
	}
	/**
	 * 设置：
	 */
	public void setCompanyNo(String companyNo) {
		this.companyNo = companyNo;
	}
	/**
	 * 获取：
	 */
	public String getCompanyNo() {
		return companyNo;
	}
}
