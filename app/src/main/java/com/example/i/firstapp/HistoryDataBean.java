package com.example.i.firstapp;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by i on 2017/11/20.
 */

public class HistoryDataBean implements Serializable {

    public Date date;

    public long downLoadSpeed;

    public long upLoadSpeed;

    public int ping;

    public String wifiName;

    public boolean isWifi;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getDownLoadSpeed() {
        return downLoadSpeed;
    }

    public void setDownLoadSpeed(long downLoadSpeed) {
        this.downLoadSpeed = downLoadSpeed;
    }

    public long getUpLoadSpeed() {
        return upLoadSpeed;
    }

    public void setUpLoadSpeed(long upLoadSpeed) {
        this.upLoadSpeed = upLoadSpeed;
    }

    public int getPing() {
        return ping;
    }

    public void setPing(int ping) {
        this.ping = ping;
    }

    public String getWifiName() {
        return wifiName;
    }

    public void setWifiName(String wifiName) {
        this.wifiName = wifiName;
    }

    public boolean isWifi() {
        return isWifi;
    }

    public void setWifi(boolean wifi) {
        isWifi = wifi;
    }

    public String getTime() {
        if(date == null) return "";
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        return format.format(date);
    }
}
