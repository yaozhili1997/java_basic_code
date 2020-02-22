package com.ecotourism.api.api.domain.shop.address;

import com.ecotourism.api.api.domain.common.OpenIdRequestParams;
import com.ecotourism.api.common.annotation.Param;

/**
 * 说明：设置默认地址或删除请求参数
 * 创建人：陈启勇
 * 创建时间: 2018/9/19 16:24
 **/
public class AddressSetDefaultParams extends OpenIdRequestParams {
    @Param(notEmpty = true,errorMsg = "请选择地址!")
    private String addressNo;

    public String getAddressNo() {
        return addressNo;
    }
    public void setAddressNo(String addressNo) {
        this.addressNo = addressNo;
    }
}
