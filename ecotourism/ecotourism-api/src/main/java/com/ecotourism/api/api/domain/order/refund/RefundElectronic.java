package com.ecotourism.api.api.domain.order.refund;

/**
 * 说明：退票电子票号
 * 创建人：陈启勇
 * 创建时间: 2018/10/18 11:00
 **/
public class RefundElectronic {
    private String electronicTicket;//电子票号

    public String getElectronicTicket() {
        return electronicTicket;
    }

    public void setElectronicTicket(String electronicTicket) {
        this.electronicTicket = electronicTicket;
    }
}
