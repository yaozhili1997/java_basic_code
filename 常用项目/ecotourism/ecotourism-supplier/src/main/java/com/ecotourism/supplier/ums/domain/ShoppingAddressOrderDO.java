package com.ecotourism.supplier.ums.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * auther by Sea
 */
public class ShoppingAddressOrderDO implements Serializable {

    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    //地址所属电子票号
    private String electronicTicket;
    //地址编号
    private String addressNo;
    //国家
    private String country;
    //省
    private String province;
    //city
    private String city;
    //地区
    private String region;
    //街道
    private String street;
    //收货人姓名
    private String consigneeName;
    //收货人联系方式
    private String consigneePhone;
    //门牌号
    private String doorNumber;
    //详细地址
    private String detailAddress;
    //邮政编码
    private Integer postalCode;
    //是否默认
    private String isDefault;
    //状态
    private String status;
    //创建时间
    private Date crateTime;
    //更新时间
    private Date updateTime;
    //用户唯一id
    private String openId;

    public ShoppingAddressOrderDO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getElectronicTicket() {
        return electronicTicket;
    }

    public void setElectronicTicket(String electronicTicket) {
        this.electronicTicket = electronicTicket;
    }

    public String getAddressNo() {
        return addressNo;
    }

    public void setAddressNo(String addressNo) {
        this.addressNo = addressNo;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getConsigneeName() {
        return consigneeName;
    }

    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName;
    }

    public String getConsigneePhone() {
        return consigneePhone;
    }

    public void setConsigneePhone(String consigneePhone) {
        this.consigneePhone = consigneePhone;
    }

    public String getDoorNumber() {
        return doorNumber;
    }

    public void setDoorNumber(String doorNumber) {
        this.doorNumber = doorNumber;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCrateTime() {
        return crateTime;
    }

    public void setCrateTime(Date crateTime) {
        this.crateTime = crateTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}
