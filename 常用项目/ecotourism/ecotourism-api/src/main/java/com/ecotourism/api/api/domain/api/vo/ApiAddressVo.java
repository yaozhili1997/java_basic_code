package com.ecotourism.api.api.domain.api.vo;

import com.ecotourism.api.api.config.ApiEnum;
import com.ecotourism.api.api.domain.common.OpenIdRequestParams;
import com.ecotourism.api.api.domain.shop.address.AddressSaveOrUpdateParams;
import com.ecotourism.api.api.domain.shop.address.AddressSetDefaultParams;
import com.ecotourism.api.api.domain.shop.address.ListAddressRequestParams;
import com.ecotourism.api.common.annotation.ApiMgmt;
import com.ecotourism.api.shop.service.AddressService;

/**
 * @Description 收货地址接口
 * @Author scotte
 * @Date 2018/9/19 16:59
 * @Param
 * @return
 */
public class ApiAddressVo {

    private static final String apiType="address";

    @ApiMgmt(name = ApiEnum.getAddress, params = AddressSetDefaultParams.class
            ,serviceClassName = AddressService.class
            ,serviceMethodName = "get")
    private String get=apiType+"Get";

    @ApiMgmt(name = ApiEnum.getDefault, params = OpenIdRequestParams.class
            ,serviceClassName = AddressService.class
            ,serviceMethodName = "getDefault")
    private String getDefault=apiType+"GetDefault";

    @ApiMgmt(name = ApiEnum.updateDefault, params = AddressSetDefaultParams.class
            ,serviceClassName = AddressService.class
            ,serviceMethodName = "updateDefault")
    private String updateDefault=apiType+"SetDefault";

    @ApiMgmt(name = ApiEnum.deleteAddress, params = AddressSetDefaultParams.class
            ,serviceClassName = AddressService.class
            ,serviceMethodName = "deleteAddress")
    private String deleteAddress=apiType+"Delete";

    @ApiMgmt(name = ApiEnum.listAddress, params = ListAddressRequestParams.class
            ,serviceClassName = AddressService.class
            ,serviceMethodName = "listAddress")
    private String listAddress=apiType+"List";

    @ApiMgmt(name = ApiEnum.saveOrUpdate, params = AddressSaveOrUpdateParams.class
            ,serviceClassName = AddressService.class
            ,serviceMethodName = "saveOrUpdate")
    private String saveOrUpdate=apiType+"Save";



}
