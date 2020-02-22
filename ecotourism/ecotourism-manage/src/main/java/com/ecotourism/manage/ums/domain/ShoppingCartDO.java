package com.ecotourism.manage.ums.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 购物车表
 * 
 * @date 2018-10-26 11:34:07
 */
public class ShoppingCartDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//用户唯一id
	private String openId;
	//产品编号
	private String productNo;
	//产品数量
	private String productNum;
	//姓名
	private String customerName;
	//身份证号
	private String idCard;
	//手机号
	private String phoneNum;
	//游玩时间
	private Date playTime;
	//状态 1:正常，0：失效
	private String status;
	//顺序
	private String sort;
	//是否选中 1：选中，0：未选
	private String checked;
	//
	private Date createTime;
	//
	private Date updateTime;
	//来源支付应用编号
	private String applicationNo;
	private String productName;
	private String productImg;
	private String nickName;
	private String avatar;
	private String searchName;

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
	 * 设置：用户唯一id
	 */
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	/**
	 * 获取：用户唯一id
	 */
	public String getOpenId() {
		return openId;
	}
	/**
	 * 设置：产品编号
	 */
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	/**
	 * 获取：产品编号
	 */
	public String getProductNo() {
		return productNo;
	}
	/**
	 * 设置：产品数量
	 */
	public void setProductNum(String productNum) {
		this.productNum = productNum;
	}
	/**
	 * 获取：产品数量
	 */
	public String getProductNum() {
		return productNum;
	}
	/**
	 * 设置：姓名
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	/**
	 * 获取：姓名
	 */
	public String getCustomerName() {
		return customerName;
	}
	/**
	 * 设置：身份证号
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	/**
	 * 获取：身份证号
	 */
	public String getIdCard() {
		return idCard;
	}
	/**
	 * 设置：手机号
	 */
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	/**
	 * 获取：手机号
	 */
	public String getPhoneNum() {
		return phoneNum;
	}
	/**
	 * 设置：游玩时间
	 */
	public void setPlayTime(Date playTime) {
		this.playTime = playTime;
	}
	/**
	 * 获取：游玩时间
	 */
	public Date getPlayTime() {
		return playTime;
	}
	/**
	 * 设置：状态 1:正常，0：失效
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态 1:正常，0：失效
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：顺序
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}
	/**
	 * 获取：顺序
	 */
	public String getSort() {
		return sort;
	}
	/**
	 * 设置：是否选中 1：选中，0：未选
	 */
	public void setChecked(String checked) {
		this.checked = checked;
	}
	/**
	 * 获取：是否选中 1：选中，0：未选
	 */
	public String getChecked() {
		return checked;
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
	 * 设置：来源支付应用编号
	 */
	public void setApplicationNo(String applicationNo) {
		this.applicationNo = applicationNo;
	}
	/**
	 * 获取：来源支付应用编号
	 */
	public String getApplicationNo() {
		return applicationNo;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
}
