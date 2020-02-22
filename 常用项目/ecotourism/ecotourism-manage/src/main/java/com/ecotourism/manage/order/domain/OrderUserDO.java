package com.ecotourism.manage.order.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 订单用户
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-11 10:23:50
 */
public class OrderUserDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//订单用户id
	private Integer id;
	//昵称
	private String nickName;
	//头像
	private String avatar;
	//国家
	private String country;
	//省份
	private String province;
	//市县
	private String city;
	//性别（m男/w女）
	private String gender;
	//用户id
	private String alipayUserId;
	//用户类型（1代表公司账户2代表个人账户）
	private String userType;
	//用户状态（q代表快速注册用户 t代表已认证用户 b代表被冻结账户 w代表已注册，未激活的账户）
	private String userStatus;
	//是否通过实名认证（t是通过 f是没有实名认证）
	private String isCertified;
	//是否是学生（t是学生 f不是学生）
	private String isStudentCertified;
	//
	private Date ticketBuyingTime;
	//
	private String priductNo;
	//
	private Integer numberTickets;
	//纬度信息
	private String latitude;
	//经度信息
	private String longitude;
	//精确度
	private String accuracy;

	/**
	 * 设置：订单用户id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：订单用户id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：昵称
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	/**
	 * 获取：昵称
	 */
	public String getNickName() {
		return nickName;
	}
	/**
	 * 设置：头像
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	/**
	 * 获取：头像
	 */
	public String getAvatar() {
		return avatar;
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
	 * 设置：省份
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * 获取：省份
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * 设置：市县
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * 获取：市县
	 */
	public String getCity() {
		return city;
	}
	/**
	 * 设置：性别（m男/w女）
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * 获取：性别（m男/w女）
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * 设置：用户id
	 */
	public void setAlipayUserId(String alipayUserId) {
		this.alipayUserId = alipayUserId;
	}
	/**
	 * 获取：用户id
	 */
	public String getAlipayUserId() {
		return alipayUserId;
	}
	/**
	 * 设置：用户类型（1代表公司账户2代表个人账户）
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}
	/**
	 * 获取：用户类型（1代表公司账户2代表个人账户）
	 */
	public String getUserType() {
		return userType;
	}
	/**
	 * 设置：用户状态（q代表快速注册用户 t代表已认证用户 b代表被冻结账户 w代表已注册，未激活的账户）
	 */
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	/**
	 * 获取：用户状态（q代表快速注册用户 t代表已认证用户 b代表被冻结账户 w代表已注册，未激活的账户）
	 */
	public String getUserStatus() {
		return userStatus;
	}
	/**
	 * 设置：是否通过实名认证（t是通过 f是没有实名认证）
	 */
	public void setIsCertified(String isCertified) {
		this.isCertified = isCertified;
	}
	/**
	 * 获取：是否通过实名认证（t是通过 f是没有实名认证）
	 */
	public String getIsCertified() {
		return isCertified;
	}
	/**
	 * 设置：是否是学生（t是学生 f不是学生）
	 */
	public void setIsStudentCertified(String isStudentCertified) {
		this.isStudentCertified = isStudentCertified;
	}
	/**
	 * 获取：是否是学生（t是学生 f不是学生）
	 */
	public String getIsStudentCertified() {
		return isStudentCertified;
	}
	/**
	 * 设置：
	 */
	public void setTicketBuyingTime(Date ticketBuyingTime) {
		this.ticketBuyingTime = ticketBuyingTime;
	}
	/**
	 * 获取：
	 */
	public Date getTicketBuyingTime() {
		return ticketBuyingTime;
	}
	/**
	 * 设置：
	 */
	public void setPriductNo(String priductNo) {
		this.priductNo = priductNo;
	}
	/**
	 * 获取：
	 */
	public String getPriductNo() {
		return priductNo;
	}
	/**
	 * 设置：
	 */
	public void setNumberTickets(Integer numberTickets) {
		this.numberTickets = numberTickets;
	}
	/**
	 * 获取：
	 */
	public Integer getNumberTickets() {
		return numberTickets;
	}
	/**
	 * 设置：纬度信息
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	/**
	 * 获取：纬度信息
	 */
	public String getLatitude() {
		return latitude;
	}
	/**
	 * 设置：经度信息
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	/**
	 * 获取：经度信息
	 */
	public String getLongitude() {
		return longitude;
	}
	/**
	 * 设置：精确度
	 */
	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}
	/**
	 * 获取：精确度
	 */
	public String getAccuracy() {
		return accuracy;
	}
}
