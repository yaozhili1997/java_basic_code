package com.ecotourism.api.api.domain.shop.common;

import com.ecotourism.api.api.domain.common.OpenIdRequestParams;

/**
 * 说明：
 * 创建人：陈启勇
 * 创建时间: 2018/9/19 15:19
 **/
public class ListCommonParams extends OpenIdRequestParams {
    //分页：当前页
    private Integer pageNumber;
    //分页：每页行数
    private Integer pageSize;
    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
