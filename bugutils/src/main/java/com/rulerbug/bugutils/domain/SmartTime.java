package com.rulerbug.bugutils.domain;

public class SmartTime {
    public String DES;
    public long interval;
    public long startTime;
    public long endTime;
    public boolean isPositive;

    public SmartTime(String DES, long interval, long startTime, long endTime, boolean isPositive) {
        this.DES = DES;
        this.interval = interval;
        this.startTime = startTime;
        this.endTime = endTime;
        this.isPositive = isPositive;
    }
}