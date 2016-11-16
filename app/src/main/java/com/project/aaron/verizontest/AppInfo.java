package com.project.aaron.verizontest;

import android.graphics.drawable.Drawable;

/**
 * Created by Aaron Revilla on 11/13/2016.
 */

public class AppInfo {

    private String dumpsys;
    private String timeOnBattery;
    private String mobileData;
    private String wifiData;
    private String powerDrain;
    private String pkgName;
    private Drawable appImg;


    public AppInfo(){}


    public String getDumpsys() {
        return dumpsys;
    }

    public void setDumpsys(String dumpsys) {
        this.dumpsys = dumpsys;
    }

    public String getTimeOnBattery() {
        return timeOnBattery;
    }

    public void setTimeOnBattery(String timeOnBattery) {
        this.timeOnBattery = timeOnBattery;
    }

    public String getMobileData() {
        return mobileData;
    }

    public void setMobileData(String mobileData) {
        this.mobileData = mobileData;
    }

    public String getWifiData() {
        return wifiData;
    }

    public void setWifiData(String wifiData) {
        this.wifiData = wifiData;
    }

    public String getPowerDrain() {
        return powerDrain;
    }

    public void setPowerDrain(String powerDrain) {
        this.powerDrain = powerDrain;
    }

    public String getPkgName() {
        return pkgName;
    }

    public void setPkgName(String pkgName) {
        this.pkgName = pkgName;
    }

    public Drawable getAppImg() {
        return appImg;
    }

    public void setAppImg(Drawable appImg) {
        this.appImg = appImg;
    }
}
