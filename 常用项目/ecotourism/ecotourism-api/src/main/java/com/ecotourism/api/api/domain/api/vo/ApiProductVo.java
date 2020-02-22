package com.ecotourism.api.api.domain.api.vo;

import com.ecotourism.api.api.config.ApiEnum;
import com.ecotourism.api.api.domain.procuct.ListProductRequestParam;
import com.ecotourism.api.api.domain.procuct.ProductRequestParams;
import com.ecotourism.api.common.annotation.ApiMgmt;
import com.ecotourism.api.product.service.ProductService;

/**
 * 说明：产品接口
 * 创建人：陈启勇
 * 创建时间: 2018/9/10 15:21
 **/
public class ApiProductVo {
    @ApiMgmt(name = ApiEnum.getProduct, params = ProductRequestParams.class
            ,serviceClassName = ProductService.class
            ,serviceMethodName = "getProduct")
    private String getProduct="getProduct";

    @ApiMgmt(name = ApiEnum.listProducts,params = ListProductRequestParam.class
            ,serviceClassName = ProductService.class
            ,serviceMethodName = "listProducts")
    private String listProducts="listProducts";
}
