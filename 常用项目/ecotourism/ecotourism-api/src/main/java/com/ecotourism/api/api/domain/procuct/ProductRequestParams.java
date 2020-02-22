package com.ecotourism.api.api.domain.procuct;

import com.ecotourism.api.api.config.Constants;
import com.ecotourism.api.common.annotation.Param;

/**
 * 说明：产品接口请求参数
 * 创建人：陈启勇
 * 创建时间: 2018/8/29 15:06
 **/
public class ProductRequestParams {
    @Param(notEmpty = true,errorMsg = "产品编号不能为空!")
    private String productNo;
    @Param(fieldName = "价格日历开始日期",useOther = true,otherClassName = Constants.checkParamCalssName,otherMethodName = Constants.checkSdfDate)
    private String priceStockStartDate;
    @Param(fieldName = "价格日历结束日期",useOther = true,otherClassName = Constants.checkParamCalssName,otherMethodName = Constants.checkSdfDate)
    private String priceStockEndDate;
    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getPriceStockStartDate() {
        return priceStockStartDate;
    }

    public void setPriceStockStartDate(String priceStockStartDate) {
        this.priceStockStartDate = priceStockStartDate;
    }

    public String getPriceStockEndDate() {
        return priceStockEndDate;
    }

    public void setPriceStockEndDate(String priceStockEndDate) {
        this.priceStockEndDate = priceStockEndDate;
    }
}
