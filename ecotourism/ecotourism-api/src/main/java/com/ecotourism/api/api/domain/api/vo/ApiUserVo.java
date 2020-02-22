package com.ecotourism.api.api.domain.api.vo;

import com.ecotourism.api.api.config.ApiEnum;
import com.ecotourism.api.api.domain.common.OpenIdRequestParams;
import com.ecotourism.api.api.service.ClientOrderService;
import com.ecotourism.api.api.service.ClientUserService;
import com.ecotourism.api.common.annotation.ApiMgmt;

/**
 * 说明：用户相关接口
 * 创建人：陈启勇
 * 创建时间: 2018/9/10 15:25
 **/
public class ApiUserVo {
    @ApiMgmt(name = ApiEnum.getOrderUserInfo,params = OpenIdRequestParams.class
            ,serviceClassName = ClientOrderService.class
            ,serviceMethodName = "getOrderUserInfo")
    private String getOrderUserInfo="getOrderUserInfo";

    @ApiMgmt(name = ApiEnum.getUserInfo,params = OpenIdRequestParams.class
            ,serviceClassName = ClientUserService.class
            ,serviceMethodName = "getUserInfo")
    private String getUserInfo="getUserInfo";

}
