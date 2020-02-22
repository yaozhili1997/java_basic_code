package com.ecotourism.api.api.domain.shop.car;

import com.ecotourism.api.api.domain.shop.common.ListCommonParams;


/**
 * 说明：查询购物车列表
 * 创建人：陈启勇
 * 创建时间: 2018/9/18 15:24
 **/
public class ShopCarListRequestParams extends ListCommonParams {

    //产品名称
    private String id;
    private String productName;
    //产品类型
    private String productType;
    //身份证号
    private String idCard;
    //手机号
    private String phoneNum;
    //游玩时间
    private String playTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPlayTime() {
        return playTime;
    }

    public void setPlayTime(String playTime) {
        this.playTime = playTime;
    }
}
