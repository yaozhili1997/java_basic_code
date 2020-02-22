package com.ecotourism.api.api.domain.procuct;

import com.ecotourism.api.common.annotation.Param;

/**
 * 说明：产品请求参数
 * 创建人：陈启勇
 * 创建时间: 2019/3/8 12:27
 **/
public class ProductRequestParam {
    @Param(notEmpty = true,errorMsg = "产品编号不能为空!")
    private String productNo;

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }
}
