package com.ecotourism.api.api.domain.api.vo;

import com.ecotourism.api.api.config.ApiEnum;
import com.ecotourism.api.application.service.IndexContentService;
import com.ecotourism.api.common.annotation.ApiMgmt;

/**
 * 说明：应用相关接口
 * 创建人：陈启勇
 * 创建时间: 2018/12/5 11:52
 **/
public class ApiApplyVo {

    @ApiMgmt(name = ApiEnum.getAppIndexImgs
            ,serviceClassName = IndexContentService.class
            ,serviceMethodName = "listAppIndexImgs")
    private String getIndexImgs="getIndexImgs";

}
