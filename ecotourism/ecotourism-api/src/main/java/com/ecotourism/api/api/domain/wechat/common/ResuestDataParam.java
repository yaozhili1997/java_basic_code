package com.ecotourism.api.api.domain.wechat.common;

import com.ecotourism.api.common.annotation.Param;

/**
 * 说明：微信公共请求data参数
 * 创建人：陈启勇
 * 创建时间: 2018/8/21 11:54
 **/
public class ResuestDataParam {
    @Param(notEmpty = true,errorMsg = "openId不能为空!")
    private String openId;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}
