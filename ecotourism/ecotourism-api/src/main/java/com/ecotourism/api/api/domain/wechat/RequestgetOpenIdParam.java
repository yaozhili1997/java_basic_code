package com.ecotourism.api.api.domain.wechat;

import com.ecotourism.api.common.annotation.Param;

/**
 * 说明：获取openid 请求data参数
 * 创建人：陈启勇
 * 创建时间: 2018/8/21 11:52
 **/
public class RequestgetOpenIdParam{

    @Param(notEmpty = true,errorMsg = "微信登陆凭证不能为空!")
    private String code;

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
}
