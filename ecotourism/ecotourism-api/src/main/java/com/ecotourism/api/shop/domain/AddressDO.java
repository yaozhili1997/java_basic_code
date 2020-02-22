package com.ecotourism.api.shop.domain;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;



/**
 * @Description 收货地址
 * @author 陈启勇
 * @Date 2018/9/19 15:11
 * @Param
 * @return
 */
public class AddressDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//地址编号
	private String addressNo;
	//国家
	private String country;
	//省
	private String province;
	//
	private String city;
	//地区
	private String region;
	//收货人姓名
	private String consigneeName;
	//收货人联系方式
	private String consigneePhone;
	//详细地址
	private String detailAddress;
	//邮政编码
	private String postalCode;
	//是否默认
	private String isDefault;
	//状态（1 正常，0 失效）
	private String status;
	//创建时间
	@JSONField(serialize = false)
	private String createTime;
	//更新时间
	@JSONField(serialize = false)
	private String updateTime;
	//用户唯一id
	@JSONField(serialize = false)
	private String openId;
	@JSONField(serialize = false)
	private String applicationNo;

	/**
	 * 设置：地址编号
	 */
	public void setAddressNo(String addressNo) {
		this.addressNo = addressNo;
	}
	/**
	 * 获取：地址编号
	 */
	public String getAddressNo() {
		return addressNo;
	}
	/**
	 * 设置：国家
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * 获取：国家
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * 设置：省
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * 获取：省
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * 设置：
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * 获取：
	 */
	public String getCity() {
		return city;
	}
	/**
	 * 设置：地区
	 */
	public void setRegion(String region) {
		this.region = region;
	}
	/**
	 * 获取：地区
	 */
	public String getRegion() {
		return region;
	}
	/**
	 * 设置：收货人姓名
	 */
	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}
	/**
	 * 获取：收货人姓名
	 */
	public String getConsigneeName() {
		return consigneeName;
	}
	/**
	 * 设置：收货人联系方式
	 */
	public void setConsigneePhone(String consigneePhone) {
		this.consigneePhone = consigneePhone;
	}
	/**
	 * 获取：收货人联系方式
	 */
	public String getConsigneePhone() {
		return consigneePhone;
	}
	/**
	 * 设置：详细地址
	 */
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	/**
	 * 获取：详细地址
	 */
	public String getDetailAddress() {
		return detailAddress;
	}
	/**
	 * 设置：邮政编码
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	/**
	 * 获取：邮政编码
	 */
	public String getPostalCode() {
		return postalCode;
	}
	/**
	 * 设置：是否默认
	 */
	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}
	/**
	 * 获取：是否默认
	 */
	public String getIsDefault() {
		return isDefault;
	}
	/**
	 * 设置：状态（1 正常，0 失效）
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态（1 正常，0 失效）
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public String getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新时间
	 */
	public String getUpdateTime() {
		return updateTime;
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
	public String getApplicationNo() {
		return applicationNo;
	}
	public void setApplicationNo(String applicationNo) {
		this.applicationNo = applicationNo;
	}
}
