package com.example.recyclerviewtest;

public class DataClass {
    String deviceName;
    String deviceNum;
    int deviceImage;

    public String getDeviceName() {
        return deviceName;
    }

    public String getDeviceNum() {
        return deviceNum;
    }

    public int getDeviceImage() {
        return deviceImage;
    }

    public DataClass(String deviceName, String deviceNum, int deviceImage) {
        this.deviceName = deviceName;
        this.deviceNum = deviceNum;
        this.deviceImage = deviceImage;
    }

}
