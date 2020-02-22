package com.ecotourism.api.api.domain.order.create;

import com.ecotourism.api.api.config.Constants;
import com.ecotourism.api.common.annotation.Param;

/**
 * 说明：下单产品数据
 * 创建人：陈启勇
 * 创建时间: 2018/8/23 10:05
 **/
public class OrderProductData {
    @Param(notEmpty = true,errorMsg = "用户名不能为空!")
    private String customerName;//用户名称
    @Param(notEmpty = true,errorMsg = "用户手机号不能为空!",useOther = true,otherClassName = Constants.checkParamCalssName,otherMethodName = Constants.checkPhone)
    private String customerPhone;//用户手机号
    @Param(useOther = true,otherClassName = Constants.checkParamCalssName,otherMethodName = Constants.is18ByteIdCardComplex)
    private String customerUserId;//证件号
    @Param(notEmpty = true,errorMsg = "产品编码不能为空!")
    private String productNo;//产品编码
    @Param(notEmpty = true,errorMsg = "产品数量不能为空!",useOther = true,otherClassName = Constants.checkParamCalssName,otherMethodName = Constants.checkProductNum)
    private String nums;//数量
    private String payPrice;//售价
    private String totalAmount;//总价
    @Param(notEmpty = true,errorMsg = "游玩时间不能为空!",useOther = true,otherClassName = Constants.checkParamCalssName,otherMethodName = Constants.checkPlayTime)
    private String playTime;//游玩时间
    private AddressParams address;//收获地址

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getNums() {
        return nums;
    }

    public void setNums(String nums) {
        this.nums = nums;
    }

    public String getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(String payPrice) {
        this.payPrice = payPrice;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getPlayTime() {
        return playTime;
    }
    public void setPlayTime(String playTime) {
        this.playTime = playTime;
    }
    public String getCustomerPhone() {
        return customerPhone;
    }
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerUserId() {
        return customerUserId;
    }

    public void setCustomerUserId(String customerUserId) {
        this.customerUserId = customerUserId;
    }

    public AddressParams getAddress() {
        return address;
    }

    public void setAddress(AddressParams address) {
        this.address = address;
    }
}
