package com.ecotourism.api.api.domain.api.vo;

import com.ecotourism.api.api.config.ApiEnum;
import com.ecotourism.api.api.domain.order.create.OrderRequestParam;
import com.ecotourism.api.api.domain.order.query.QueryOrderListRequestParams;
import com.ecotourism.api.api.domain.order.query.QueryOrderOneRequestParams;
import com.ecotourism.api.api.domain.order.refund.RefundRequestParams;
import com.ecotourism.api.api.domain.procuct.ProductRequestParam;
import com.ecotourism.api.api.service.ClientOrderService;
import com.ecotourism.api.common.annotation.ApiMgmt;

/**
 * 说明：订单相关接口
 * 创建人：陈启勇
 * 创建时间: 2018/9/10 15:23
 **/
public class ApiOrderVo {
    @ApiMgmt(name = ApiEnum.createOrder,params = OrderRequestParam.class
            ,serviceClassName = ClientOrderService.class
            ,serviceMethodName = "createOrder")
    private String createOrder="createOrder";

    @ApiMgmt(name = ApiEnum.listOrders, params = QueryOrderListRequestParams.class
            ,serviceClassName = ClientOrderService.class
            ,serviceMethodName = "listOrders")
    private String listOrders="listOrders";

    @ApiMgmt(name = ApiEnum.getOrder, params = QueryOrderOneRequestParams.class
            ,serviceClassName = ClientOrderService.class
            ,serviceMethodName = "getOrder")
    private String getOrder="getOrder";

    @ApiMgmt(name = ApiEnum.refundOrder, params = RefundRequestParams.class
            ,serviceClassName = ClientOrderService.class
            ,serviceMethodName = "updateRefundOrder")
    private String refundOrder="refundOrder";


    @ApiMgmt(name = ApiEnum.productMonthSell, params = ProductRequestParam.class
            ,serviceClassName = ClientOrderService.class
            ,serviceMethodName = "getMonthSellCount")
    private String getMonthSellCount="productMonthSell";
}
