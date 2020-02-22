package com.ecotourism.api.api.domain.wechat;

import com.ecotourism.api.api.domain.wechat.common.ResuestDataParam;
import com.ecotourism.api.common.annotation.Param;

/**
 * 说明：解密用户信息参数
 * 创建人：陈启勇
 * 创建时间: 2018/8/21 13:57
 **/
public class DecodeUserParam extends ResuestDataParam {
    @Param(notEmpty = true,errorMsg = "用户加密数据不能为空!")
    private String encryptedData;
    @Param(notEmpty = true,errorMsg = "加密偏移量不能为空!")
    private String iv;

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }
}
