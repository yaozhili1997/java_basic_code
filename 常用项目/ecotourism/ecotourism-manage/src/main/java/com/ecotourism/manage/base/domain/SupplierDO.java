package com.ecotourism.manage.base.domain;

import java.io.Serializable;


/**
 * 供应商管理
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-04 21:48:30
 */
public class SupplierDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//ID
	private Integer id;
	//供应商编号
	private String supplierNo;
	//供应商名称
	private String supplierName;
	//地址
	private String address;
	//电话
	private String phone;
	//联系人
	private String contacts;
	//公司编码
	private String companyNo;

	private String cid;

	private String url;

	private String appId;

	private String appKey;

	private String whetherOpen="0";

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
	 * 设置：供应商编号
	 */
	public void setSupplierNo(String supplierNo) {
		this.supplierNo = supplierNo;
	}
	/**
	 * 获取：供应商编号
	 */
	public String getSupplierNo() {
		return supplierNo;
	}
	/**
	 * 设置：供应商名称
	 */
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	/**
	 * 获取：供应商名称
	 */
	public String getSupplierName() {
		return supplierName;
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
	 * 设置：公司编码
	 */
	public void setCompanyNo(String companyNo) {
		this.companyNo = companyNo;
	}
	/**
	 * 获取：公司编码
	 */
	public String getCompanyNo() {
		return companyNo;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public String getWhetherOpen() {
		return whetherOpen;
	}

	public void setWhetherOpen(String whetherOpen) {
		this.whetherOpen = whetherOpen;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}
}
