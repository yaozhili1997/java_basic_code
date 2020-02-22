package com.ecotourism.api.api.domain.api.vo;

import com.ecotourism.api.api.config.ApiEnum;
import com.ecotourism.api.api.domain.common.OpenIdRequestParams;
import com.ecotourism.api.api.domain.shop.car.DeleteShopCarParams;
import com.ecotourism.api.api.domain.shop.car.ShopCarListRequestParams;
import com.ecotourism.api.api.domain.shop.car.ShopCarSaveOrUpdateRequestParams;
import com.ecotourism.api.api.domain.shop.car.ShopCarUpdateParam;
import com.ecotourism.api.common.annotation.ApiMgmt;
import com.ecotourism.api.shop.service.ShoppingCartService;

/**
 * @Description 购物车接口
 * @Author scotte
 * @Date 2018/9/18 16:59
 * @Param
 * @return
 */
public class ApiShopCarVo {

    private static final String apiType="shopCar";

    @ApiMgmt(name = ApiEnum.listShopCars, params = ShopCarListRequestParams.class
            ,serviceClassName = ShoppingCartService.class
            ,serviceMethodName = "listShopCars")
    private String list=apiType+"List";

    @ApiMgmt(name = ApiEnum.getShopCarTotalCount, params = OpenIdRequestParams.class
            ,serviceClassName = ShoppingCartService.class
            ,serviceMethodName = "getShopCarTotalCount")
    private String getShopCarTotalCount=apiType+"TotalCount";

    @ApiMgmt(name = ApiEnum.saveShopCar,params = ShopCarSaveOrUpdateRequestParams.class
            ,serviceClassName = ShoppingCartService.class
            ,serviceMethodName = "saveShopCar")
    private String saveOrUpdate= apiType+"Save";

    @ApiMgmt(name = ApiEnum.deleteShopCar,params = DeleteShopCarParams.class
            ,serviceClassName = ShoppingCartService.class
            ,serviceMethodName = "deleteShopCar")
    private String delete= apiType+"Delete";

    @ApiMgmt(name = ApiEnum.updateShopCar,params = ShopCarUpdateParam.class
            ,serviceClassName = ShoppingCartService.class
            ,serviceMethodName = "updateShopCar")
    private String updateShopCar= apiType+"Update";
}
