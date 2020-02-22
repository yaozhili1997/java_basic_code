package com.ecotourism.manage.product.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ProductPriceStockDO implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    //产品编号
    private String productNo;
    //日期
    private String date;
    //结算价格
    private BigDecimal settlementPrice;
    //售价
    private BigDecimal salePrice;
    //已售数量
    private Integer saleNum;
    //库存数量
    private Integer stockNum;
    //创建人
    private String createUser;
    //创建时间
    private Date createTime;
    //更新人
    private String updateUser;
    //更新时间
    private Date updateTime;
    //库存类型 0-不限库存，1-总库存，2-日库存
    private Integer stockType;
    //总库存
    private Integer totalStockNum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
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

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStockType() {
        return stockType;
    }

    public void setStockType(Integer stockType) {
        this.stockType = stockType;
    }

    public Integer getTotalStockNum() {
        return totalStockNum;
    }

    public void setTotalStockNum(Integer totalStockNum) {
        this.totalStockNum = totalStockNum;
    }
}
