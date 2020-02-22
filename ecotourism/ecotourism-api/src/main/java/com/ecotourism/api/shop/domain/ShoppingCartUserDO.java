package com.ecotourism.api.shop.domain;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;


/**
 * 购物车用户表
 * 
 * @author 陈启勇
 * @date 2018-09-17 10:50:11
 */
public class ShoppingCartUserDO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String shopCarId;
	//用户名称
	private String customerName;
	//身份证号
	private String idCard;
	//手机号
	private String phoneNum;
	//国家
	private String country;
	//省
	private String province;
	private String city;
	//地区
	private String region;
	//详细地址
	private String detailAddress;

	@JSONField(serialize = false)
	private String createTime;
	@JSONField(serialize = false)
	private String updateTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getShopCarId() {
		return shopCarId;
	}

	public void setShopCarId(String shopCarId) {
		this.shopCarId = shopCarId;
	}
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}


	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
}
