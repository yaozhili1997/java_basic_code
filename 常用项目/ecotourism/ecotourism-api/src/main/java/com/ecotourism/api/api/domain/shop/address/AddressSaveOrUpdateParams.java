package com.ecotourism.api.api.domain.shop.address;

import com.ecotourism.api.api.config.Constants;
import com.ecotourism.api.api.domain.common.OpenIdRequestParams;
import com.ecotourism.api.common.annotation.Param;

/**
 * 说明：收货地址增加或修改接口参数
 * 创建人：陈启勇
 * 创建时间: 2018/9/19 15:38
 **/
public class AddressSaveOrUpdateParams extends OpenIdRequestParams {
    private String addressNo;
    //国家
    private String country;
    //省
    @Param(notEmpty = true,errorMsg = "所在省份不能为空!")
    private String province;
    @Param(notEmpty = true,errorMsg = "所在城市不能为空!")
    private String city;
    //地区
    @Param(notEmpty = true,errorMsg = "所在地区不能为空!")
    private String region;
    //收货人姓名
    @Param(notEmpty = true,errorMsg = "姓名不能为空!")
    private String consigneeName;
    //收货人联系方式
    @Param(notEmpty = true,errorMsg = "联系方式不能为空!",useOther = true,otherClassName = Constants.checkParamCalssName,otherMethodName = Constants.checkPhone)
    private String consigneePhone;
    //详细地址
    @Param(notEmpty = true,errorMsg = "详细地址不能为空!")
    private String detailAddress;
    //邮政编码
    @Param(fieldName = "邮政编码",useOther = true,otherClassName = Constants.checkParamCalssName,otherMethodName = Constants.checkNumber)
    private String postalCode;
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

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddressNo() {
        return addressNo;
    }

    public void setAddressNo(String addressNo) {
        this.addressNo = addressNo;
    }
}
