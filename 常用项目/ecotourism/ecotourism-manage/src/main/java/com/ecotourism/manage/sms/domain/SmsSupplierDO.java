package com.ecotourism.manage.sms.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 短信供应商
 * 
 * @author 陈启勇
 * @email chqy_ljy@163.com
 * @date 2018-06-07 20:53:33
 */
public class SmsSupplierDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//供应商id
	private Integer supplierId;
	//供应商编号
	private String supplierNo;
	//供应商名称
	private String supplierName;
	//
	private String senderClass;
	//余额查询接口
	private String balanceClass;
	//账号
	private String account;
	//密码
	private String password;
	//appkey
	private String appkey;
	//剩余量
	private Long remainNum;
	//已发送量
	private Long usedNum;
	//短信供应价
	private BigDecimal supplyPrice;
	//售价
	private BigDecimal sellPrice;
	//是否可用
	private String enable;
	//
	private String isDefault;
	//创建时间
	private Date createTime;
	//更新时间
	private Date updateTime;
	//创建人
	private String createUser;
	//修改人
	private String updateUser;
	//产品编码
	private String sprdid;

	/**
	 * 设置：供应商id
	 */
	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}
	/**
	 * 获取：供应商id
	 */
	public Integer getSupplierId() {
		return supplierId;
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
	 * 设置：
	 */
	public void setSenderClass(String senderClass) {
		this.senderClass = senderClass;
	}
	/**
	 * 获取：
	 */
	public String getSenderClass() {
		return senderClass;
	}
	/**
	 * 设置：余额查询接口
	 */
	public void setBalanceClass(String balanceClass) {
		this.balanceClass = balanceClass;
	}
	/**
	 * 获取：余额查询接口
	 */
	public String getBalanceClass() {
		return balanceClass;
	}
	/**
	 * 设置：账号
	 */
	public void setAccount(String account) {
		this.account = account;
	}
	/**
	 * 获取：账号
	 */
	public String getAccount() {
		return account;
	}
	/**
	 * 设置：密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置：appkey
	 */
	public void setAppkey(String appkey) {
		this.appkey = appkey;
	}
	/**
	 * 获取：appkey
	 */
	public String getAppkey() {
		return appkey;
	}
	/**
	 * 设置：剩余量
	 */
	public void setRemainNum(Long remainNum) {
		this.remainNum = remainNum;
	}
	/**
	 * 获取：剩余量
	 */
	public Long getRemainNum() {
		return remainNum;
	}
	/**
	 * 设置：已发送量
	 */
	public void setUsedNum(Long usedNum) {
		this.usedNum = usedNum;
	}
	/**
	 * 获取：已发送量
	 */
	public Long getUsedNum() {
		return usedNum;
	}
	/**
	 * 设置：短信供应价
	 */
	public void setSupplyPrice(BigDecimal supplyPrice) {
		this.supplyPrice = supplyPrice;
	}
	/**
	 * 获取：短信供应价
	 */
	public BigDecimal getSupplyPrice() {
		return supplyPrice;
	}
	/**
	 * 设置：售价
	 */
	public void setSellPrice(BigDecimal sellPrice) {
		this.sellPrice = sellPrice;
	}
	/**
	 * 获取：售价
	 */
	public BigDecimal getSellPrice() {
		return sellPrice;
	}
	/**
	 * 设置：是否可用
	 */
	public void setEnable(String enable) {
		this.enable = enable;
	}
	/**
	 * 获取：是否可用
	 */
	public String getEnable() {
		return enable;
	}
	/**
	 * 设置：
	 */
	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}
	/**
	 * 获取：
	 */
	public String getIsDefault() {
		return isDefault;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	/**
	 * 获取：创建人
	 */
	public String getCreateUser() {
		return createUser;
	}
	/**
	 * 设置：修改人
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	/**
	 * 获取：修改人
	 */
	public String getUpdateUser() {
		return updateUser;
	}
	/**
	 * 设置：产品编码
	 */
	public void setSprdid(String sprdid) {
		this.sprdid = sprdid;
	}
	/**
	 * 获取：产品编码
	 */
	public String getSprdid() {
		return sprdid;
	}
}
