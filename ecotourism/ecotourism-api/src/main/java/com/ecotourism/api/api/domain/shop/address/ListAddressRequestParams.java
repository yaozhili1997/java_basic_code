package com.ecotourism.api.api.domain.shop.address;

import com.ecotourism.api.api.domain.shop.common.ListCommonParams;

/**
 * 说明：获取收货地址列表，请求参数
 * 创建人：陈启勇
 * 创建时间: 2018/9/19 15:17
 **/
public class ListAddressRequestParams extends ListCommonParams {
    //收货人姓名
    private String consigneeName;
    //收货人联系方式
    private String consigneePhone;
    //是否默认
    private String isDefault;
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

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }
}
