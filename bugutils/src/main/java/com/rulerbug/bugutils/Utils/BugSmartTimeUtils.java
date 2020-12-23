package com.rulerbug.bugutils.Utils;

import com.rulerbug.bugutils.Domain.SmartTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BugSmartTimeUtils {
    private static final long SECOND = 1000L;
    private static final long MIN = SECOND * 60;
    private static final long HOUR = MIN * 60;
    private static final long DAY = HOUR * 24;
    private static final long MON = DAY * 30;
    private static final long YEAR = 31622400 * SECOND;
    private static final long TEN_YEAR = 10 * YEAR;
    private static final long CENTURY = 100 * YEAR;

    public static long now() {
        return System.currentTimeMillis();
    }

    public static SmartTime between(long start, long end) {
        long interval = end - start;
        boolean isPositive = interval > 0 ? true : false;
        String DES = dealInterval(interval);
        return new SmartTime(DES, interval, start, end, isPositive);
    }

    private static String dealInterval(long interval) {
        if (interval < MIN) {
            return "一分钟内";
        } else if (interval == MIN) {
            return "刚好一分钟";
        } else if (interval < MIN * 10) {
            return "几分钟";
        } else if (interval == MIN * 10) {
            return "十分钟";
        } else if (interval < MIN * 20) {
            return "十几分钟";
        } else if (interval < MIN * 30) {
            return "半小时内";
        } else if (interval == MIN * 30) {
            return "刚好半小时";
        } else if (interval < MIN * 40) {
            return "半个多小时";
        } else if (interval < MIN * 60) {
            return "不到一小时";
        } else if (interval == HOUR) {
            return "刚好一小时";
        } else if (interval < HOUR * 2) {
            return "一个多小时";
        } else if (interval < HOUR * 10) {
            return "几个小时";
        } else if (interval < DAY) {
            return "不到一天";
        } else if (interval == DAY) {
            return "正好一天";
        } else if (interval < DAY * 2) {
            return "一天多";
        } else if (interval < DAY * 7) {
            return "几天";
        } else if (interval == DAY * 7) {
            return "一星期";
        } else if (interval < MON) {
            return "几星期";
        } else if (interval == MON) {
            return "一个月";
        } else if (interval < MON * 6) {
            return "不到半年";
        } else if (interval == MON * 6) {
            return "半年";
        } else if (interval < YEAR) {
            return "半年多";
        } else if (interval == YEAR) {
            return "一整年";
        } else if (interval < TEN_YEAR) {
            return "几年";
        } else if (interval == TEN_YEAR) {
            return "十年";
        } else if (interval < CENTURY) {
            return "几十年";
        } else if (interval == CENTURY) {
            return "一个世纪";
        } else if (interval < CENTURY * 2) {
            return "一个多世纪";
        } else if (interval < CENTURY * 10) {
            return "几个世纪";
        } else if (interval < CENTURY * 100) {
            return "几十个世纪";
        } else {
            return "很久很久";
        }
    }

    public static String timeCalculate(long time)   {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTimeStr = sdf.format(System.currentTimeMillis());
        //每天毫秒数
        long nd = 1000 * 24 * 60 * 60;
        //每小时毫秒数
        long nh = 1000 * 60 * 60;
        //每分钟毫秒数
        long nm = 1000 * 60;

        Date nowDate = null;
        try {
            nowDate = sdf.parse(nowTimeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date date = new Date(time);

        long diff = nowDate.getTime() - date.getTime();

        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;

        if (day == 0 && hour == 0 && min < 1) {
            return "刚刚";
        } else if (day == 0 && hour < 1) {
            return min + "分钟前";
        } else if (day < 1 && hour >= 1) {
            return hour + "小时前";
        } else {
            return day + "天前";
        }
    }
}
