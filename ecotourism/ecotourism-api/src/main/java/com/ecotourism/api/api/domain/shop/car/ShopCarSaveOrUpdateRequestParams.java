package com.ecotourism.api.api.domain.shop.car;


import com.ecotourism.api.api.config.Constants;
import com.ecotourism.api.api.domain.common.OpenIdRequestParams;
import com.ecotourism.api.common.annotation.Param;

import java.util.List;

/**
 * 说明：购物车保存或修改请求参数
 * 创建人：陈启勇
 * 创建时间: 2018/9/17 11:32
 **/
public class ShopCarSaveOrUpdateRequestParams extends OpenIdRequestParams{

    @Param(notEmpty = true,errorMsg = "购物车数据不能为空!",isEntity = true)
    private List<ShopCarDo> data;

    public class ShopCarDo{
        //用户名称
        @Param(isEntity = true,notEmpty = true,errorMsg = "用户数据不能为空!")
        private List<ShopCarUserParam> users;
        //产品编号
        @Param(notEmpty = true,errorMsg = "产品编号不能为空!")
        private String productNo;
        //游玩时间
        @Param(notEmpty = true,errorMsg = "游玩时间不能为空!",useOther = true,otherClassName = Constants.checkParamCalssName,otherMethodName = Constants.checkPlayTime)
        private String playTime;
        //产品数量
        @Param(notEmpty = true,errorMsg = "产品数量不能为空!")
        private String productNum;

        public String getProductNo() {
            return productNo;
        }

        public void setProductNo(String productNo) {
            this.productNo = productNo;
        }

        public String getProductNum() {
            return productNum;
        }

        public void setProductNum(String productNum) {
            this.productNum = productNum;
        }

        public List<ShopCarUserParam> getUsers() {
            return users;
        }

        public void setUsers(List<ShopCarUserParam> users) {
            this.users = users;
        }

        public String getPlayTime() {
            return playTime;
        }

        public void setPlayTime(String playTime) {
            this.playTime = playTime;
        }
    }
    public List<ShopCarDo> getData() {
        return data;
    }
    public void setData(List<ShopCarDo> data) {
        this.data = data;
    }
}
