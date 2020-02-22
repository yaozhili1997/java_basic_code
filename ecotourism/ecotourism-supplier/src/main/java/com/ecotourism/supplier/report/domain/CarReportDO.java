package com.ecotourism.supplier.report.domain;

public class CarReportDO {

    private String checkEquipmentNo;
    private String deviceName;
    private String vehicleNumber;
    private int rideNumber;

    public String getCheckEquipmentNo() {
        return checkEquipmentNo;
    }

    public void setCheckEquipmentNo(String checkEquipmentNo) {
        this.checkEquipmentNo = checkEquipmentNo;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public int getRideNumber() {
        return rideNumber;
    }

    public void setRideNumber(int rideNumber) {
        this.rideNumber = rideNumber;
    }
}
