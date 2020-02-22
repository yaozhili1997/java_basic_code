package com.ecotourism.supplier.product.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author chqy
 * @email chqy_ljy@163.com
 * @date 2018-06-15 09:47:13
 */
public class ProductTypeDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//产品类型编号
	private String productTypeNo;
	//产品类型名称
	private String productTypeName;
	//父类编号
	private String parentTypeNo;
	//小图标
	private String icon;
	//状态
	private String status="0";
	//
	private Date createTime;
	//
	private String createUser;
	//
	private Date updateTime;
	//
	private String updateUser;
	//所属公司编号
	private String companyNo;
	//别名
	private String alias;
	//图片编号
	private String imgNo;
	private String sort;
	//跳转地址
	private String turnUrl;
	private String baseUrl;

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
	 * 设置：产品类型编号
	 */
	public void setProductTypeNo(String productTypeNo) {
		this.productTypeNo = productTypeNo;
	}
	/**
	 * 获取：产品类型编号
	 */
	public String getProductTypeNo() {
		return productTypeNo;
	}
	/**
	 * 设置：产品类型名称
	 */
	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}
	/**
	 * 获取：产品类型名称
	 */
	public String getProductTypeName() {
		return productTypeName;
	}
	/**
	 * 设置：父类编号
	 */
	public void setParentTypeNo(String parentTypeNo) {
		this.parentTypeNo = parentTypeNo;
	}
	/**
	 * 获取：父类编号
	 */
	public String getParentTypeNo() {
		return parentTypeNo;
	}
	/**
	 * 设置：小图标
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
	/**
	 * 获取：小图标
	 */
	public String getIcon() {
		return icon;
	}
	/**
	 * 设置：状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取：
	 */
	public String getCreateUser() {
		return createUser;
	}
	/**
	 * 设置：
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	/**
	 * 获取：
	 */
	public String getUpdateUser() {
		return updateUser;
	}
	/**
	 * 设置：所属公司编号
	 */
	public void setCompanyNo(String companyNo) {
		this.companyNo = companyNo;
	}
	/**
	 * 获取：所属公司编号
	 */
	public String getCompanyNo() {
		return companyNo;
	}
	/**
	 * 设置：别名
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}
	/**
	 * 获取：别名
	 */
	public String getAlias() {
		return alias;
	}
	/**
	 * 设置：图片编号
	 */
	public void setImgNo(String imgNo) {
		this.imgNo = imgNo;
	}
	/**
	 * 获取：图片编号
	 */
	public String getImgNo() {
		return imgNo;
	}
	/**
	 * 设置：跳转地址
	 */
	public void setTurnUrl(String turnUrl) {
		this.turnUrl = turnUrl;
	}
	/**
	 * 获取：跳转地址
	 */
	public String getTurnUrl() {
		return turnUrl;
	}

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
}
