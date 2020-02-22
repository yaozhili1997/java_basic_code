package com.ecotourism.oms.oms.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-30 10:09:13
 */
public class CooperationDistributionDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//
	private String distributionNo;
	//合作商名称
	private String name;
	//合作商类型
	private String type;
	//所属地区
	private String province;
	//
	private String city;
	//联系地址
	private String contactAddress;
	//联系人
	private String contactName;
	//联系方式
	private String contactMobile;
	//客服电话
	private String customerServicePhone;
	//
	private String contactQq;
	//开户行
	private String bank;
	//开户账号
	private String bankAccount;
	//商户号
	private String adminLoginId;
	//是否开通接口
	private String apiIsOpen;
	//是否支持过期取票
	private String expiredTake;
	//是否支持部分取票
	private String partTake;
	//是否支持过期退票
	private String expiredRefund;
	//是否可以预定当天的票
	private String bookToday;
	//是否取票后支持现场退票
	private String afterTakeSceneRefund;
	//appSecret
	private String appSecret;
	//appID
	private String appId;
	//销售渠道
	private String saleChannelCode;
	//支付方式
	private String payType;
	//允许最大用户数
	private Integer allowMaxUserNum;
	//订单推迟入园时间(小时)
	private Integer delayEntryTime;
	//
	private BigDecimal deposit;
	//签约开始日期
	private Date startDate;
	//签约结束日期
	private Date endDate;
	//是否启用
	private String enable;
	//
	private Date createTime;
	//
	private Date updateTime;
	//
	private String createUser;
	//
	private String updateUser;
	//是否打印
	private String whetherPrint;
	//是否发送短信
	private String whetherSendSms;
	//通知URL
	private String noticeUrl;
	//是否开启立即退款
	private String whetherRefund;
	//是否开启自动过期退票
	private String whetherAutoRefundOutTime;
	//是否使用车辆
	private String whetherUseCar;
	//车费
	private BigDecimal carPrice;
	//是否验证ip
	private String whetherCheckIp;
	//ip白名单
	private String ips;
	//支付授权地址
	private String authorizedAddress;
	//公司编码
	private String companyNo;
	//是否开启高级加密
	private String whetherMoreEncode;

	public CooperationDistributionDO() {
	}

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
	public void setDistributionNo(String distributionNo) {
		this.distributionNo = distributionNo;
	}
	/**
	 * 获取：
	 */
	public String getDistributionNo() {
		return distributionNo;
	}
	/**
	 * 设置：合作商名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：合作商名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：合作商类型
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：合作商类型
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：所属地区
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * 获取：所属地区
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
	 * 设置：联系地址
	 */
	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}
	/**
	 * 获取：联系地址
	 */
	public String getContactAddress() {
		return contactAddress;
	}
	/**
	 * 设置：联系人
	 */
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	/**
	 * 获取：联系人
	 */
	public String getContactName() {
		return contactName;
	}
	/**
	 * 设置：联系方式
	 */
	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}
	/**
	 * 获取：联系方式
	 */
	public String getContactMobile() {
		return contactMobile;
	}
	/**
	 * 设置：客服电话
	 */
	public void setCustomerServicePhone(String customerServicePhone) {
		this.customerServicePhone = customerServicePhone;
	}
	/**
	 * 获取：客服电话
	 */
	public String getCustomerServicePhone() {
		return customerServicePhone;
	}
	/**
	 * 设置：
	 */
	public void setContactQq(String contactQq) {
		this.contactQq = contactQq;
	}
	/**
	 * 获取：
	 */
	public String getContactQq() {
		return contactQq;
	}
	/**
	 * 设置：开户行
	 */
	public void setBank(String bank) {
		this.bank = bank;
	}
	/**
	 * 获取：开户行
	 */
	public String getBank() {
		return bank;
	}
	/**
	 * 设置：开户账号
	 */
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	/**
	 * 获取：开户账号
	 */
	public String getBankAccount() {
		return bankAccount;
	}
	/**
	 * 设置：商户号
	 */
	public void setAdminLoginId(String adminLoginId) {
		this.adminLoginId = adminLoginId;
	}
	/**
	 * 获取：商户号
	 */
	public String getAdminLoginId() {
		return adminLoginId;
	}
	/**
	 * 设置：是否开通接口
	 */
	public void setApiIsOpen(String apiIsOpen) {
		this.apiIsOpen = apiIsOpen;
	}
	/**
	 * 获取：是否开通接口
	 */
	public String getApiIsOpen() {
		return apiIsOpen;
	}
	/**
	 * 设置：是否支持过期取票
	 */
	public void setExpiredTake(String expiredTake) {
		this.expiredTake = expiredTake;
	}
	/**
	 * 获取：是否支持过期取票
	 */
	public String getExpiredTake() {
		return expiredTake;
	}
	/**
	 * 设置：是否支持部分取票
	 */
	public void setPartTake(String partTake) {
		this.partTake = partTake;
	}
	/**
	 * 获取：是否支持部分取票
	 */
	public String getPartTake() {
		return partTake;
	}
	/**
	 * 设置：是否支持过期退票
	 */
	public void setExpiredRefund(String expiredRefund) {
		this.expiredRefund = expiredRefund;
	}
	/**
	 * 获取：是否支持过期退票
	 */
	public String getExpiredRefund() {
		return expiredRefund;
	}
	/**
	 * 设置：是否可以预定当天的票
	 */
	public void setBookToday(String bookToday) {
		this.bookToday = bookToday;
	}
	/**
	 * 获取：是否可以预定当天的票
	 */
	public String getBookToday() {
		return bookToday;
	}
	/**
	 * 设置：是否取票后支持现场退票
	 */
	public void setAfterTakeSceneRefund(String afterTakeSceneRefund) {
		this.afterTakeSceneRefund = afterTakeSceneRefund;
	}
	/**
	 * 获取：是否取票后支持现场退票
	 */
	public String getAfterTakeSceneRefund() {
		return afterTakeSceneRefund;
	}
	/**
	 * 设置：appSecret
	 */
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
	/**
	 * 获取：appSecret
	 */
	public String getAppSecret() {
		return appSecret;
	}
	/**
	 * 设置：appID
	 */
	public void setAppId(String appId) {
		this.appId = appId;
	}
	/**
	 * 获取：appID
	 */
	public String getAppId() {
		return appId;
	}
	/**
	 * 设置：销售渠道
	 */
	public void setSaleChannelCode(String saleChannelCode) {
		this.saleChannelCode = saleChannelCode;
	}
	/**
	 * 获取：销售渠道
	 */
	public String getSaleChannelCode() {
		return saleChannelCode;
	}
	/**
	 * 设置：支付方式
	 */
	public void setPayType(String payType) {
		this.payType = payType;
	}
	/**
	 * 获取：支付方式
	 */
	public String getPayType() {
		return payType;
	}
	/**
	 * 设置：允许最大用户数
	 */
	public void setAllowMaxUserNum(Integer allowMaxUserNum) {
		this.allowMaxUserNum = allowMaxUserNum;
	}
	/**
	 * 获取：允许最大用户数
	 */
	public Integer getAllowMaxUserNum() {
		return allowMaxUserNum;
	}
	/**
	 * 设置：订单推迟入园时间(小时)
	 */
	public void setDelayEntryTime(Integer delayEntryTime) {
		this.delayEntryTime = delayEntryTime;
	}
	/**
	 * 获取：订单推迟入园时间(小时)
	 */
	public Integer getDelayEntryTime() {
		return delayEntryTime;
	}
	/**
	 * 设置：
	 */
	public void setDeposit(BigDecimal deposit) {
		this.deposit = deposit;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getDeposit() {
		return deposit;
	}
	/**
	 * 设置：签约开始日期
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * 获取：签约开始日期
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * 设置：签约结束日期
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * 获取：签约结束日期
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * 设置：是否启用
	 */
	public void setEnable(String enable) {
		this.enable = enable;
	}
	/**
	 * 获取：是否启用
	 */
	public String getEnable() {
		return enable;
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
	 * 设置：是否打印
	 */
	public void setWhetherPrint(String whetherPrint) {
		this.whetherPrint = whetherPrint;
	}
	/**
	 * 获取：是否打印
	 */
	public String getWhetherPrint() {
		return whetherPrint;
	}
	/**
	 * 设置：是否发送短信
	 */
	public void setWhetherSendSms(String whetherSendSms) {
		this.whetherSendSms = whetherSendSms;
	}
	/**
	 * 获取：是否发送短信
	 */
	public String getWhetherSendSms() {
		return whetherSendSms;
	}
	/**
	 * 设置：通知URL
	 */
	public void setNoticeUrl(String noticeUrl) {
		this.noticeUrl = noticeUrl;
	}
	/**
	 * 获取：通知URL
	 */
	public String getNoticeUrl() {
		return noticeUrl;
	}
	/**
	 * 设置：是否开启立即退款
	 */
	public void setWhetherRefund(String whetherRefund) {
		this.whetherRefund = whetherRefund;
	}
	/**
	 * 获取：是否开启立即退款
	 */
	public String getWhetherRefund() {
		return whetherRefund;
	}
	/**
	 * 设置：是否开启自动过期退票
	 */
	public void setWhetherAutoRefundOutTime(String whetherAutoRefundOutTime) {
		this.whetherAutoRefundOutTime = whetherAutoRefundOutTime;
	}
	/**
	 * 获取：是否开启自动过期退票
	 */
	public String getWhetherAutoRefundOutTime() {
		return whetherAutoRefundOutTime;
	}
	/**
	 * 设置：是否使用车辆
	 */
	public void setWhetherUseCar(String whetherUseCar) {
		this.whetherUseCar = whetherUseCar;
	}
	/**
	 * 获取：是否使用车辆
	 */
	public String getWhetherUseCar() {
		return whetherUseCar;
	}
	/**
	 * 设置：车费
	 */
	public void setCarPrice(BigDecimal carPrice) {
		this.carPrice = carPrice;
	}
	/**
	 * 获取：车费
	 */
	public BigDecimal getCarPrice() {
		return carPrice;
	}
	/**
	 * 设置：是否验证ip
	 */
	public void setWhetherCheckIp(String whetherCheckIp) {
		this.whetherCheckIp = whetherCheckIp;
	}
	/**
	 * 获取：是否验证ip
	 */
	public String getWhetherCheckIp() {
		return whetherCheckIp;
	}
	/**
	 * 设置：ip白名单
	 */
	public void setIps(String ips) {
		this.ips = ips;
	}
	/**
	 * 获取：ip白名单
	 */
	public String getIps() {
		return ips;
	}
	/**
	 * 设置：支付授权地址
	 */
	public void setAuthorizedAddress(String authorizedAddress) {
		this.authorizedAddress = authorizedAddress;
	}
	/**
	 * 获取：支付授权地址
	 */
	public String getAuthorizedAddress() {
		return authorizedAddress;
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
	/**
	 * 设置：是否开启高级加密
	 */
	public void setWhetherMoreEncode(String whetherMoreEncode) {
		this.whetherMoreEncode = whetherMoreEncode;
	}
	/**
	 * 获取：是否开启高级加密
	 */
	public String getWhetherMoreEncode() {
		return whetherMoreEncode;
	}
}
