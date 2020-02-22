package com.ecotourism.manage.fin.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class FinancialManagementDO implements Serializable {

    private static final long serialVersionUID = 1L;
    //订单id
    private Integer orderId;
    //客户名称
    private String customerName;
    //客户电话
    private String customerPhone;
    //客户身份证
    private String customerUserId;
    //订单编号
    private String orderNo;
    //电子票
    private String electronicTicket;
    //产品编号
    private String productNo;
    //产品名称
    private String productName;
    //数量
    private Integer orderQuantity;
    //售价
    private BigDecimal payPrice;
    //总金额
    private BigDecimal totalAmount;
    //支付方式
    private String payType;
    //支付状态
    private String payStatus;
    //订单状态
    private String orderStatus;
    //退款状态
    private String refundStatus;
    //分销商
    private String orderDistributor;
    //购买时间
    private Date purchaseTime;
    //消费时间
    private Date consumptionTime;
    //游玩时间
    private Date playTime;
    //短信状态
    private String messageStatus;
    //是否下发（0-未下发，1-已下发）
    private Integer whetherIssued;
    //检票设备编码
    private String checkEquipmentNo;
    //景点编号
    private String spotNo;
    //票种类型
    private String ticketType;
    //票种定义
    private String ticketNo;
    //检票时间
    private Date checkTime;
    //piaogo系统中的第三方订单号
    private String piaogoOrderNo;
    //取票凭证码
    private String orderVoucherno;
    //是否发送通知
    private Integer whetherSendNotice;
    //购票设备编码
    private String selfMachineNo;
    //退票审核
    private Integer whetherSendRefundNotice;
    //推送检票信息到本地(西信--->本地)
    private Integer whetherSendCheckTolocal;
    //退票(审核)时间
    private Date refundTime;
    //是否使用公交
    private Integer isTransit;
    //乘车时间
    private Date transitTime;
    //设备编号
    private String deviceNo;
    //设备编号2
    private String deviceNoTwo;
    //
    private Date transitTimeTwo;
    //入住时间
    private Date checkInTime;
    //入住办理人
    private String checkInOperator;
    //地推用户编号
    private String pushUserNo;
    //公司编号
    private String companyNo;
    //备注
    private String bz;
    //人工下单用户
    private String distributionUser;
    //来源ip
    private String ip;

    /**
     * 设置：订单id
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    /**
     * 获取：订单id
     */
    public Integer getOrderId() {
        return orderId;
    }
    /**
     * 设置：客户名称
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    /**
     * 获取：客户名称
     */
    public String getCustomerName() {
        return customerName;
    }
    /**
     * 设置：客户电话
     */
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
    /**
     * 获取：客户电话
     */
    public String getCustomerPhone() {
        return customerPhone;
    }
    /**
     * 设置：客户身份证
     */
    public void setCustomerUserId(String customerUserId) {
        this.customerUserId = customerUserId;
    }
    /**
     * 获取：客户身份证
     */
    public String getCustomerUserId() {
        return customerUserId;
    }
    /**
     * 设置：订单编号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
    /**
     * 获取：订单编号
     */
    public String getOrderNo() {
        return orderNo;
    }
    /**
     * 设置：电子票
     */
    public void setElectronicTicket(String electronicTicket) {
        this.electronicTicket = electronicTicket;
    }
    /**
     * 获取：电子票
     */
    public String getElectronicTicket() {
        return electronicTicket;
    }
    /**
     * 设置：产品编号
     */
    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }
    /**
     * 获取：产品编号
     */
    public String getProductNo() {
        return productNo;
    }
    /**
     * 设置：产品名称
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }
    /**
     * 获取：产品名称
     */
    public String getProductName() {
        return productName;
    }
    /**
     * 设置：数量
     */
    public void setOrderQuantity(Integer orderQuantity) {
        this.orderQuantity = orderQuantity;
    }
    /**
     * 获取：数量
     */
    public Integer getOrderQuantity() {
        return orderQuantity;
    }
    /**
     * 设置：售价
     */
    public void setPayPrice(BigDecimal payPrice) {
        this.payPrice = payPrice;
    }
    /**
     * 获取：售价
     */
    public BigDecimal getPayPrice() {
        return payPrice;
    }
    /**
     * 设置：总金额
     */
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
    /**
     * 获取：总金额
     */
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
    /**
     * 设置：支付方式
     */
    public void setPayType(String payType) {
        this.payType = payType;
    }
    /**
     * 获取：支付方式
     */
    public String getPayType() {
        return payType;
    }
    /**
     * 设置：支付状态
     */
    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }
    /**
     * 获取：支付状态
     */
    public String getPayStatus() {
        return payStatus;
    }
    /**
     * 设置：订单状态
     */
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    /**
     * 获取：订单状态
     */
    public String getOrderStatus() {
        return orderStatus;
    }
    /**
     * 设置：退款状态
     */
    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
    }
    /**
     * 获取：退款状态
     */
    public String getRefundStatus() {
        return refundStatus;
    }
    /**
     * 设置：分销商
     */
    public void setOrderDistributor(String orderDistributor) {
        this.orderDistributor = orderDistributor;
    }
    /**
     * 获取：分销商
     */
    public String getOrderDistributor() {
        return orderDistributor;
    }
    /**
     * 设置：购买时间
     */
    public void setPurchaseTime(Date purchaseTime) {
        this.purchaseTime = purchaseTime;
    }
    /**
     * 获取：购买时间
     */
    public Date getPurchaseTime() {
        return purchaseTime;
    }
    /**
     * 设置：消费时间
     */
    public void setConsumptionTime(Date consumptionTime) {
        this.consumptionTime = consumptionTime;
    }
    /**
     * 获取：消费时间
     */
    public Date getConsumptionTime() {
        return consumptionTime;
    }
    /**
     * 设置：游玩时间
     */
    public void setPlayTime(Date playTime) {
        this.playTime = playTime;
    }
    /**
     * 获取：游玩时间
     */
    public Date getPlayTime() {
        return playTime;
    }
    /**
     * 设置：短信状态
     */
    public void setMessageStatus(String messageStatus) {
        this.messageStatus = messageStatus;
    }
    /**
     * 获取：短信状态
     */
    public String getMessageStatus() {
        return messageStatus;
    }
    /**
     * 设置：是否下发（0-未下发，1-已下发）
     */
    public void setWhetherIssued(Integer whetherIssued) {
        this.whetherIssued = whetherIssued;
    }
    /**
     * 获取：是否下发（0-未下发，1-已下发）
     */
    public Integer getWhetherIssued() {
        return whetherIssued;
    }
    /**
     * 设置：检票设备编码
     */
    public void setCheckEquipmentNo(String checkEquipmentNo) {
        this.checkEquipmentNo = checkEquipmentNo;
    }
    /**
     * 获取：检票设备编码
     */
    public String getCheckEquipmentNo() {
        return checkEquipmentNo;
    }
    /**
     * 设置：景点编号
     */
    public void setSpotNo(String spotNo) {
        this.spotNo = spotNo;
    }
    /**
     * 获取：景点编号
     */
    public String getSpotNo() {
        return spotNo;
    }
    /**
     * 设置：票种类型
     */
    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }
    /**
     * 获取：票种类型
     */
    public String getTicketType() {
        return ticketType;
    }
    /**
     * 设置：票种定义
     */
    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }
    /**
     * 获取：票种定义
     */
    public String getTicketNo() {
        return ticketNo;
    }
    /**
     * 设置：检票时间
     */
    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }
    /**
     * 获取：检票时间
     */
    public Date getCheckTime() {
        return checkTime;
    }
    /**
     * 设置：piaogo系统中的第三方订单号
     */
    public void setPiaogoOrderNo(String piaogoOrderNo) {
        this.piaogoOrderNo = piaogoOrderNo;
    }
    /**
     * 获取：piaogo系统中的第三方订单号
     */
    public String getPiaogoOrderNo() {
        return piaogoOrderNo;
    }
    /**
     * 设置：取票凭证码
     */
    public void setOrderVoucherno(String orderVoucherno) {
        this.orderVoucherno = orderVoucherno;
    }
    /**
     * 获取：取票凭证码
     */
    public String getOrderVoucherno() {
        return orderVoucherno;
    }
    /**
     * 设置：是否发送通知
     */
    public void setWhetherSendNotice(Integer whetherSendNotice) {
        this.whetherSendNotice = whetherSendNotice;
    }
    /**
     * 获取：是否发送通知
     */
    public Integer getWhetherSendNotice() {
        return whetherSendNotice;
    }
    /**
     * 设置：购票设备编码
     */
    public void setSelfMachineNo(String selfMachineNo) {
        this.selfMachineNo = selfMachineNo;
    }
    /**
     * 获取：购票设备编码
     */
    public String getSelfMachineNo() {
        return selfMachineNo;
    }
    /**
     * 设置：退票审核
     */
    public void setWhetherSendRefundNotice(Integer whetherSendRefundNotice) {
        this.whetherSendRefundNotice = whetherSendRefundNotice;
    }
    /**
     * 获取：退票审核
     */
    public Integer getWhetherSendRefundNotice() {
        return whetherSendRefundNotice;
    }
    /**
     * 设置：推送检票信息到本地(西信--->本地)
     */
    public void setWhetherSendCheckTolocal(Integer whetherSendCheckTolocal) {
        this.whetherSendCheckTolocal = whetherSendCheckTolocal;
    }
    /**
     * 获取：推送检票信息到本地(西信--->本地)
     */
    public Integer getWhetherSendCheckTolocal() {
        return whetherSendCheckTolocal;
    }
    /**
     * 设置：退票(审核)时间
     */
    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
    }
    /**
     * 获取：退票(审核)时间
     */
    public Date getRefundTime() {
        return refundTime;
    }
    /**
     * 设置：是否使用公交
     */
    public void setIsTransit(Integer isTransit) {
        this.isTransit = isTransit;
    }
    /**
     * 获取：是否使用公交
     */
    public Integer getIsTransit() {
        return isTransit;
    }
    /**
     * 设置：乘车时间
     */
    public void setTransitTime(Date transitTime) {
        this.transitTime = transitTime;
    }
    /**
     * 获取：乘车时间
     */
    public Date getTransitTime() {
        return transitTime;
    }
    /**
     * 设置：设备编号
     */
    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo;
    }
    /**
     * 获取：设备编号
     */
    public String getDeviceNo() {
        return deviceNo;
    }
    /**
     * 设置：设备编号2
     */
    public void setDeviceNoTwo(String deviceNoTwo) {
        this.deviceNoTwo = deviceNoTwo;
    }
    /**
     * 获取：设备编号2
     */
    public String getDeviceNoTwo() {
        return deviceNoTwo;
    }
    /**
     * 设置：
     */
    public void setTransitTimeTwo(Date transitTimeTwo) {
        this.transitTimeTwo = transitTimeTwo;
    }
    /**
     * 获取：
     */
    public Date getTransitTimeTwo() {
        return transitTimeTwo;
    }
    /**
     * 设置：入住时间
     */
    public void setCheckInTime(Date checkInTime) {
        this.checkInTime = checkInTime;
    }
    /**
     * 获取：入住时间
     */
    public Date getCheckInTime() {
        return checkInTime;
    }
    /**
     * 设置：入住办理人
     */
    public void setCheckInOperator(String checkInOperator) {
        this.checkInOperator = checkInOperator;
    }
    /**
     * 获取：入住办理人
     */
    public String getCheckInOperator() {
        return checkInOperator;
    }
    /**
     * 设置：地推用户编号
     */
    public void setPushUserNo(String pushUserNo) {
        this.pushUserNo = pushUserNo;
    }
    /**
     * 获取：地推用户编号
     */
    public String getPushUserNo() {
        return pushUserNo;
    }
    /**
     * 设置：公司编号
     */
    public void setCompanyNo(String companyNo) {
        this.companyNo = companyNo;
    }
    /**
     * 获取：公司编号
     */
    public String getCompanyNo() {
        return companyNo;
    }
    /**
     * 设置：备注
     */
    public void setBz(String bz) {
        this.bz = bz;
    }
    /**
     * 获取：备注
     */
    public String getBz() {
        return bz;
    }
    /**
     * 设置：人工下单用户
     */
    public void setDistributionUser(String distributionUser) {
        this.distributionUser = distributionUser;
    }
    /**
     * 获取：人工下单用户
     */
    public String getDistributionUser() {
        return distributionUser;
    }
    /**
     * 设置：来源ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }
    /**
     * 获取：来源ip
     */
    public String getIp() {
        return ip;
    }
}
