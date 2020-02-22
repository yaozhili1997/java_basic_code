package com.ecotourism.supplier.fin.domain;

import java.io.Serializable;

public class DataStatisticsDO  implements Serializable {
    private static final long serialVersionUID = 1L;
    private String  spotName;
    private String  name;
    private String  orderQuantity;
    private String  totalAmount;

    public String getSpotName() {
        return spotName;
    }

    public void setSpotName(String spotName) {
        this.spotName = spotName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(String orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }
}
