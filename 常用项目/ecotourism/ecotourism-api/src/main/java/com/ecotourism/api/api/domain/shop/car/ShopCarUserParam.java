package com.ecotourism.api.api.domain.shop.car;

import com.ecotourism.api.api.config.Constants;
import com.ecotourism.api.common.annotation.Param;

/**
 * 说明：购物车用户
 * 创建人：陈启勇
 * 创建时间: 2019/1/23 11:44
 **/
public class ShopCarUserParam {

    //用户名称
    private String customerName;
    //身份证号
    @Param(useOther = true,otherClassName = Constants.checkParamCalssName,otherMethodName = Constants.is18ByteIdCardComplex)
    private String idCard;
    //手机号
    @Param(useOther = true,otherClassName = Constants.checkParamCalssName,otherMethodName = Constants.checkPhone)
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
