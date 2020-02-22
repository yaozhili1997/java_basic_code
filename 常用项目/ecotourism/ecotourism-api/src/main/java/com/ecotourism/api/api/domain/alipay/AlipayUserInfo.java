package com.ecotourism.api.api.domain.alipay;

import com.ecotourism.api.common.annotation.Param;

/**
 * 说明：获取用户信息
 * 创建人：陈启勇
 * 创建时间: 2018/10/8 14:39
 **/
public class AlipayUserInfo {
    @Param(notEmpty = true,errorMsg = "支付宝登陆凭证不能为空!")
    private String auth_code;

    public String getAuth_code() {
        return auth_code;
    }
    public void setAuth_code(String auth_code) {
        this.auth_code = auth_code;
    }
}
