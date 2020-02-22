package com.ecotourism.api.api.domain.procuct;

/**
 * 说明：产品列表请求参数
 * 创建人：陈启勇
 * 创建时间: 2018/8/29 15:43
 **/
public class ListProductRequestParam {
    /**
     * @Description 分销商编号
     * @Author scotte
     * @Date 2018/8/29 15:46
     */
    private String distributionNo;
    private String spotNo;
    /**
     * @Description 产品名称
     * @Author scotte
     * @Date 2018/8/29 15:46
     */
    private String productName;
    /**
     * @Description 产品类型
     * @Author scotte
     * @Date 2018/8/29 15:46
     */
    private String productType;
    /**
     * @Description 产品子类
     * @Author scotte
     * @Date 2018/8/29 15:46
     */
    private String productSecondType;
    /**
     * @Description 分页：当前页
     * @Author scotte
     * @Date 2018/8/29 15:46
     */
    private Integer pageNumber;
    /**
     * @Description 分页：每页行数
     * @Author scotte
     * @Date 2018/8/29 15:46
     */
    private Integer pageSize;

    public String getDistributionNo() {
        return distributionNo;
    }

    public void setDistributionNo(String distributionNo) {
        this.distributionNo = distributionNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductSecondType() {
        return productSecondType;
    }

    public void setProductSecondType(String productSecondType) {
        this.productSecondType = productSecondType;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getSpotNo() {
        return spotNo;
    }

    public void setSpotNo(String spotNo) {
        this.spotNo = spotNo;
    }
}
