package com.ecotourism.supplier.report.domain;

import java.util.Date;

public class LineReportDO {
    private String lineName;
    private int rideNumber;
    private Date checkTime;

    private String deviceName;
    private String carNo;
    private String vehicleNumber;
    private String checkEquipmentNo;

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public int getRideNumber() {
        return rideNumber;
    }

    public void setRideNumber(int rideNumber) {
        this.rideNumber = rideNumber;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getCheckEquipmentNo() {
        return checkEquipmentNo;
    }

    public void setCheckEquipmentNo(String checkEquipmentNo) {
        this.checkEquipmentNo = checkEquipmentNo;
    }
}
