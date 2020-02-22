package com.ecotourism.supplier.cooperation.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * 
 * 
 * @author chqy
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
	private String typeName;
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
	private String apiIsOpen="0";
	//是否支持过期取票
	private String expiredTake="0";
	//是否支持部分取票
	private String partTake="0";
	//是否支持过期退票
	private String expiredRefund="0";
	//是否可以预定当天的票
	private String bookToday="0";
	//是否取票后支持现场退票
	private String afterTakeSceneRefund="0";
	//appSecret
	private String appSecret;
	//appID
	private String appId;
	//销售渠道
	private String saleChannelCode;
	private String saleChannelCodeName;
	//支付方式
	private String payType;
	private String payTypeName;
	//允许最大用户数
	private Integer allowMaxUserNum;
	//订单推迟入园时间(小时)
	private Integer delayEntryTime;
	//
	private BigDecimal deposit;
	//签约开始日期
	private String startDate;
	//签约结束日期
	private String endDate;
	//是否启用
	private String enable="1";
	//
	private Date createTime;
	//
	private Date updateTime;
	//
	private String createUser;
	//
	private String updateUser;
	//是否打印
	private String whetherPrint="0";
	//是否发送短信
	private String whetherSendSms="0";
	//通知URL
	private String noticeUrl;
	//是否开启立即退款
	private String whetherRefund="1";
	//是否开启自动过期退票
	private String whetherAutoRefundOutTime="0";
	//是否使用车辆
	private String whetherUseCar="1";
	//车费
	private BigDecimal carPrice;
	//是否验证ip
	private String whetherCheckIp="0";
	//ip白名单
	private String ips;
	//支付授权地址
	private String authorizedAddress;
	//公司编码
	private String companyNo;
	//是否开启高级加密
	private String whetherMoreEncode="1";

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDistributionNo() {
		return distributionNo;
	}

	public void setDistributionNo(String distributionNo) {
		this.distributionNo = distributionNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactMobile() {
		return contactMobile;
	}

	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
	}

	public String getCustomerServicePhone() {
		return customerServicePhone;
	}

	public void setCustomerServicePhone(String customerServicePhone) {
		this.customerServicePhone = customerServicePhone;
	}

	public String getContactQq() {
		return contactQq;
	}

	public void setContactQq(String contactQq) {
		this.contactQq = contactQq;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getAdminLoginId() {
		return adminLoginId;
	}

	public void setAdminLoginId(String adminLoginId) {
		this.adminLoginId = adminLoginId;
	}

	public String getApiIsOpen() {
		return apiIsOpen;
	}

	public void setApiIsOpen(String apiIsOpen) {
		this.apiIsOpen = apiIsOpen;
	}

	public String getExpiredTake() {
		return expiredTake;
	}

	public void setExpiredTake(String expiredTake) {
		this.expiredTake = expiredTake;
	}

	public String getPartTake() {
		return partTake;
	}

	public void setPartTake(String partTake) {
		this.partTake = partTake;
	}

	public String getExpiredRefund() {
		return expiredRefund;
	}

	public void setExpiredRefund(String expiredRefund) {
		this.expiredRefund = expiredRefund;
	}

	public String getBookToday() {
		return bookToday;
	}

	public void setBookToday(String bookToday) {
		this.bookToday = bookToday;
	}

	public String getAfterTakeSceneRefund() {
		return afterTakeSceneRefund;
	}

	public void setAfterTakeSceneRefund(String afterTakeSceneRefund) {
		this.afterTakeSceneRefund = afterTakeSceneRefund;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getSaleChannelCode() {
		return saleChannelCode;
	}

	public void setSaleChannelCode(String saleChannelCode) {
		this.saleChannelCode = saleChannelCode;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public Integer getAllowMaxUserNum() {
		return allowMaxUserNum;
	}

	public void setAllowMaxUserNum(Integer allowMaxUserNum) {
		this.allowMaxUserNum = allowMaxUserNum;
	}

	public Integer getDelayEntryTime() {
		return delayEntryTime;
	}

	public void setDelayEntryTime(Integer delayEntryTime) {
		this.delayEntryTime = delayEntryTime;
	}

	public BigDecimal getDeposit() {
		return deposit;
	}

	public void setDeposit(BigDecimal deposit) {
		this.deposit = deposit;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getWhetherPrint() {
		return whetherPrint;
	}

	public void setWhetherPrint(String whetherPrint) {
		this.whetherPrint = whetherPrint;
	}

	public String getWhetherSendSms() {
		return whetherSendSms;
	}

	public void setWhetherSendSms(String whetherSendSms) {
		this.whetherSendSms = whetherSendSms;
	}

	public String getNoticeUrl() {
		return noticeUrl;
	}

	public void setNoticeUrl(String noticeUrl) {
		this.noticeUrl = noticeUrl;
	}

	public String getWhetherRefund() {
		return whetherRefund;
	}

	public void setWhetherRefund(String whetherRefund) {
		this.whetherRefund = whetherRefund;
	}

	public String getWhetherAutoRefundOutTime() {
		return whetherAutoRefundOutTime;
	}

	public void setWhetherAutoRefundOutTime(String whetherAutoRefundOutTime) {
		this.whetherAutoRefundOutTime = whetherAutoRefundOutTime;
	}

	public String getWhetherUseCar() {
		return whetherUseCar;
	}

	public void setWhetherUseCar(String whetherUseCar) {
		this.whetherUseCar = whetherUseCar;
	}

	public BigDecimal getCarPrice() {
		return carPrice;
	}

	public void setCarPrice(BigDecimal carPrice) {
		this.carPrice = carPrice;
	}

	public String getWhetherCheckIp() {
		return whetherCheckIp;
	}

	public void setWhetherCheckIp(String whetherCheckIp) {
		this.whetherCheckIp = whetherCheckIp;
	}

	public String getIps() {
		return ips;
	}

	public void setIps(String ips) {
		this.ips = ips;
	}

	public String getAuthorizedAddress() {
		return authorizedAddress;
	}

	public void setAuthorizedAddress(String authorizedAddress) {
		this.authorizedAddress = authorizedAddress;
	}

	public String getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(String companyNo) {
		this.companyNo = companyNo;
	}

	public String getWhetherMoreEncode() {
		return whetherMoreEncode;
	}

	public void setWhetherMoreEncode(String whetherMoreEncode) {
		this.whetherMoreEncode = whetherMoreEncode;
	}

	public String getSaleChannelCodeName() {
		return saleChannelCodeName;
	}

	public void setSaleChannelCodeName(String saleChannelCodeName) {
		this.saleChannelCodeName = saleChannelCodeName;
	}

	public String getPayTypeName() {
		return payTypeName;
	}

	public void setPayTypeName(String payTypeName) {
		this.payTypeName = payTypeName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}
