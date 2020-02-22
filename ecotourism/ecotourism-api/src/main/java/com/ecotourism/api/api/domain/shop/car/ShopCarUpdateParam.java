package com.ecotourism.api.api.domain.shop.car;

import com.ecotourism.api.api.config.Constants;
import com.ecotourism.api.api.domain.common.OpenIdRequestParams;
import com.ecotourism.api.common.annotation.Param;

import java.util.List;

/**
 * 说明：购物车修改
 * 创建人：陈启勇
 * 创建时间: 2018/9/19 17:40
 **/
public class ShopCarUpdateParam  extends OpenIdRequestParams {

    //产品编号
    @Param(notEmpty = true, errorMsg = "购物车id不能为空!")
    private String id;
    //产品数量
    private String productNum;
    //游玩时间
    @Param(useOther = true, otherClassName = Constants.checkParamCalssName, otherMethodName = Constants.checkPlayTime)
    private String playTime;

    private List<ShopCarUserParam> users;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getPlayTime() {
        return playTime;
    }

    public void setPlayTime(String playTime) {
        this.playTime = playTime;
    }

    public List<ShopCarUserParam> getUsers() {
        return users;
    }

    public void setUsers(List<ShopCarUserParam> users) {
        this.users = users;
    }
    }
