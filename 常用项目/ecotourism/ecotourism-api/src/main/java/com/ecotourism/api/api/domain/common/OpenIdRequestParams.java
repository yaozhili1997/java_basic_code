package com.ecotourism.api.api.domain.common;

import com.ecotourism.api.common.annotation.Param;

/**
 * 说明：请求参数
 * 创建人：陈启勇
 * 创建时间: 2018/8/31 17:52
 **/
public class OpenIdRequestParams {
    @Param(notEmpty = true,errorMsg = "用户唯一id不能为空!")
    private String openId;//用户唯一id
    private String applicationNo;
    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(String applicationNo) {
        this.applicationNo = applicationNo;
    }
}
