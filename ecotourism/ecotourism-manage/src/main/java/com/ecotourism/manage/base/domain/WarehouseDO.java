package com.ecotourism.manage.base.domain;

import java.io.Serializable;


/**
 * 仓库管理
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-04 21:16:13
 */
public class WarehouseDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//ID
	private Integer id;
	//仓库编号
	private String warehouseNo;
	//仓库名称
	private String warehouseName;
	//地址
	private String address;
	//电话
	private String phone;
	//联系人
	private String contacts;
	//备注
	private String remarks;
	//默认
	private Integer whetherDefault;
	//公司编号
	private String companyNo;

	/**
	 * 设置：ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：ID
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：仓库编号
	 */
	public void setWarehouseNo(String warehouseNo) {
		this.warehouseNo = warehouseNo;
	}
	/**
	 * 获取：仓库编号
	 */
	public String getWarehouseNo() {
		return warehouseNo;
	}
	/**
	 * 设置：仓库名称
	 */
	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}
	/**
	 * 获取：仓库名称
	 */
	public String getWarehouseName() {
		return warehouseName;
	}
	/**
	 * 设置：地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：电话
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：电话
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：联系人
	 */
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	/**
	 * 获取：联系人
	 */
	public String getContacts() {
		return contacts;
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
	/**
	 * 设置：默认
	 */
	public void setWhetherDefault(Integer whetherDefault) {
		this.whetherDefault = whetherDefault;
	}
	/**
	 * 获取：默认
	 */
	public Integer getWhetherDefault() {
		return whetherDefault;
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
}
