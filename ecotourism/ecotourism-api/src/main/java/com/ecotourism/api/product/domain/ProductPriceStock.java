package com.ecotourism.api.product.domain;

import com.alibaba.fastjson.annotation.JSONField;

import java.math.BigDecimal;

/**
 * 说明：产品价格日历
 * 创建人：陈启勇
 * 创建时间: 2018/12/13 14:21
 **/
public class ProductPriceStock {
    private static final long serialVersionUID = 1L;

    @JSONField(serialize = false)
    private Integer id;
    //产品编号
    private String productNo;
    //日期
    private String date;
    //结算价格
    @JSONField(serialize = false)
    private BigDecimal settlementPrice;
    //售价
    private BigDecimal salePrice;
    //已售数量
    private Integer saleNum;
    //库存数量
    private Integer stockNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigDecimal getSettlementPrice() {
        return settlementPrice;
    }

    public void setSettlementPrice(BigDecimal settlementPrice) {
        this.settlementPrice = settlementPrice;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrince) {
        this.salePrice = salePrince;
    }

    public Integer getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(Integer saleNum) {
        this.saleNum = saleNum;
    }

    public Integer getStockNum() {
        return stockNum;
    }

    public void setStockNum(Integer stockNum) {
        this.stockNum = stockNum;
    }
}
