package com.ecotourism.supplier.system.domain;

import java.io.Serializable;


/**
 * 
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-05-29 21:50:51
 */
public class CompanyDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String departmentId;
	//名称
	private String name;
	//英文
	private String nameEn;
	//编码
	private String bianma;
	//上级ID
	private String parentId;
	//备注
	private String bz;
	//负责人
	private String headman;
	//电话
	private String tel;
	//部门职能
	private String functions;
	//地址
	private String address;

	private String remarks;

	/**
	 * 设置：
	 */
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	/**
	 * 获取：
	 */
	public String getDepartmentId() {
		return departmentId;
	}
	/**
	 * 设置：名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：英文
	 */
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}
	/**
	 * 获取：英文
	 */
	public String getNameEn() {
		return nameEn;
	}
	/**
	 * 设置：编码
	 */
	public void setBianma(String bianma) {
		this.bianma = bianma;
	}
	/**
	 * 获取：编码
	 */
	public String getBianma() {
		return bianma;
	}
	/**
	 * 设置：上级ID
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	/**
	 * 获取：上级ID
	 */
	public String getParentId() {
		return parentId;
	}
	/**
	 * 设置：备注
	 */
	public void setBz(String bz) {
		this.bz = bz;
	}
	/**
	 * 获取：备注
	 */
	public String getBz() {
		return bz;
	}
	/**
	 * 设置：负责人
	 */
	public void setHeadman(String headman) {
		this.headman = headman;
	}
	/**
	 * 获取：负责人
	 */
	public String getHeadman() {
		return headman;
	}
	/**
	 * 设置：电话
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	 * 获取：电话
	 */
	public String getTel() {
		return tel;
	}
	/**
	 * 设置：部门职能
	 */
	public void setFunctions(String functions) {
		this.functions = functions;
	}
	/**
	 * 获取：部门职能
	 */
	public String getFunctions() {
		return functions;
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
