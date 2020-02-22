package com.ecotourism.api.api.domain.shop.car;

import com.ecotourism.api.api.domain.common.OpenIdRequestParams;
import com.ecotourism.api.common.annotation.Param;

/**
 * 说明：删除购物车产品
 * 创建人：陈启勇
 * 创建时间: 2018/9/18 16:49
 **/
public class DeleteShopCarParams extends OpenIdRequestParams {
    //产品编号
    @Param(notEmpty = true,errorMsg = "购物车不能为空!")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
