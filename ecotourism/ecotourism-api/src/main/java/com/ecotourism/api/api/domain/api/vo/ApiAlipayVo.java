package com.ecotourism.api.api.domain.api.vo;

import com.ecotourism.api.api.config.ApiEnum;
import com.ecotourism.api.api.config.ResponseType;
import com.ecotourism.api.api.domain.alipay.AlipayUserInfo;
import com.ecotourism.api.api.domain.pay.BuildPayRequestParams;
import com.ecotourism.api.api.service.ClientAlipayService;
import com.ecotourism.api.api.service.ClientPaymentService;
import com.ecotourism.api.common.annotation.ApiMgmt;

/**
 * 说明：支付宝相关接口
 * 创建人：陈启勇
 * 创建时间: 2018/9/10 15:24
 **/
public class ApiAlipayVo {

    @ApiMgmt(name = ApiEnum.alipayPay,params = BuildPayRequestParams.class
            ,serviceClassName = ClientPaymentService.class,responseType = ResponseType.html
            ,serviceMethodName = "buildAlipayResult")
    private String alipayPayHtml="returnView/alipayPay";

    @ApiMgmt(name = ApiEnum.alipayPay,params = BuildPayRequestParams.class
            ,serviceClassName = ClientPaymentService.class
            ,serviceMethodName = "buildAlipayResult")
    private String alipayPay="alipayPay";

    @ApiMgmt(name = ApiEnum.aliPayNotice
            ,serviceClassName = ClientAlipayService.class,responseType = ResponseType.RObj
            ,serviceMethodName = "payNotify")
    private String aliPayNotice="payNotice/alipayNotice";

    @ApiMgmt(name = ApiEnum.aliPayPayReturn
            ,serviceClassName = ClientAlipayService.class,responseType = ResponseType.redirect
            ,serviceMethodName = "payReturn")
    private String aliPayPayReturn="payNotice/alipayPayReturn";

    @ApiMgmt(name = ApiEnum.getAlipayUserinfo,params = AlipayUserInfo.class
            ,serviceClassName = ClientAlipayService.class
            ,serviceMethodName = "getUserInfo")
    private String getAlipayUserinfo="getAlipayUserinfo";
}
