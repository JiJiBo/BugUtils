package com.rulerbug.bugutils.domain;

public class BugGpsBean {


    public double wgLat;
    public double wgLon;


    public BugGpsBean(double wgLat, double wgLon) {
        setWgLat(wgLat);
        setWgLon(wgLon);
    }


    public double getWgLat() {
        return wgLat;
    }


    public void setWgLat(double wgLat) {
        this.wgLat = wgLat;
    }


    public double getWgLon() {
        return wgLon;
    }


    public void setWgLon(double wgLon) {
        this.wgLon = wgLon;
    }


    @Override
    public String toString() {
        return wgLat + "," + wgLon;
    }
}
