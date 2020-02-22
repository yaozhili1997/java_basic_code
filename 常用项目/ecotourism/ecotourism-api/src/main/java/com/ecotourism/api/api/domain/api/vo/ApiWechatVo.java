package com.ecotourism.api.api.domain.api.vo;

import com.ecotourism.api.api.config.ApiEnum;
import com.ecotourism.api.api.config.ResponseType;
import com.ecotourism.api.api.domain.pay.BuildPayRequestParams;
import com.ecotourism.api.api.domain.wechat.RequestgetOpenIdParam;
import com.ecotourism.api.api.service.ClientPaymentService;
import com.ecotourism.api.api.service.ClientWechatService;
import com.ecotourism.api.common.annotation.ApiMgmt;

/**
 * 说明：微信相关接口
 * 创建人：陈启勇
 * 创建时间: 2018/9/10 15:27
 **/
public class ApiWechatVo {

    @ApiMgmt(name = ApiEnum.wechatPay,params = BuildPayRequestParams.class
            ,serviceClassName = ClientPaymentService.class
            ,serviceMethodName = "buildWechatResult")
    private String wechatPay="wechatPay";

    @ApiMgmt(name = ApiEnum.wechatNotice
            ,serviceClassName = ClientWechatService.class,responseType = ResponseType.RObj
            ,serviceMethodName = "wechatNotice")
    private String wechatNotice="payNotice/wechatNotice";

    @ApiMgmt(name = ApiEnum.getWechatUserinfo,params = RequestgetOpenIdParam.class
            ,serviceClassName = ClientWechatService.class
            ,serviceMethodName = "getUserinfo")
    private String getWechatUserinfo="getWechatUserinfo";


}
