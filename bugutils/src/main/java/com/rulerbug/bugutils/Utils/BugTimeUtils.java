package com.rulerbug.bugutils.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BugTimeUtils {


    public static final String DATA_FORMATE_1 = "yyyy/MM/dd";
    public static final String DATA_FORMATE_2 = "yyyy-MM-dd HH:mm:ss";
    public static final String DATA_FORMATE_3 = "yyyy年MM月dd日";
    public static final String DATA_FORMATE_4 = "yyyy MM dd";
    public static final String DATA_FORMATE_5 = "yyyy-MM-dd";
    public static final String DATA_FORMATE_6 = "yyyy MM dd hh:mm:ss";
    public static final String DATA_FORMATE_7 = "yyyy-MM-dd hh:mm:ss";
    /**
     * 将timeMillis格式化
     * 低于一分钟   "43秒"
     * 低于一小时   "26分钟43秒"
     * 其他          "60小时26分钟43秒"
     *
     * @param timeMillis 时间 毫秒级
     * @return
     */
    public static String hourFormatChs(long timeMillis) {
        int timeSecond = (int) (timeMillis / 1000);
        int hour = 60 * 60;
        int minute = 60;
        int hs = timeSecond / hour;
        int ms = timeSecond % hour / minute;
        int ss = timeSecond % hour % minute;
        StringBuilder ret = new StringBuilder();
        if (0 != hs) ret.append(hs).append("时");
        if (0 != ms) ret.append(ms).append("分");
        ret.append(ss).append("秒");
        return ret.toString();
    }

    /**
     * 将timeMillis格式化
     * 低于一分钟   "43秒"
     * 其他   "126分钟43秒"
     *
     * @param timeMillis 时间 毫秒级
     * @return
     */
    public static String minuteFormatChs(long timeMillis) {
        int timeSecond = (int) (timeMillis / 1000);
        int minute = 60;
        int ms = timeSecond / minute;
        int ss = timeSecond % minute;
        StringBuilder ret = new StringBuilder();
        if (0 != ms) ret.append(ms).append("分");
        ret.append(ss).append("秒");
        return ret.toString();
    }
    public static String getCurrentTimrString() {
        String reg = "yyyy年MM月dd日";
        return getCurrentTimrString(reg);
    }

    public static String getCurrentTimrString(String reg) {
        String timeStr = null;
        long time = System.currentTimeMillis();
        Date date = new Date();
        date.setTime(time);
        SimpleDateFormat sdf = new SimpleDateFormat(reg);
        timeStr = sdf.format(date);
        return timeStr;
    }

    public static String TimeToString(long time) {
        String hs, ms, sss;
        long ss = time % 60;

        long mm = (time - ss) / 60 % 60;
        long hh = (time - ss - mm * 60) / 3600;
        sss = ss + "";
        ms = mm + "";
        hs = hh + "";
        if (hh / 10 == 0)
            hs = "0" + hs;
        if (mm / 10 == 0)
            ms = "0" + ms;
        if (ss / 10 == 0)
            sss = "0" + ss;
        String str = hs + ":" + ms + ":" + sss;
        return str;
    }
    public static String TimeToStringByFen(long time) {
        String hs, ms, sss;
        long ss = time % 60;

        long mm = (time - ss) / 60 % 60;
        long hh = (time - ss - mm * 60) / 3600;
        sss = ss + "";
        ms = mm + "";
        hs = hh + "";
        if (hh / 10 == 0)
            hs = "0" + hs;
        if (mm / 10 == 0)
            ms = "0" + ms;
        if (ss / 10 == 0)
            sss = "0" + ss;
        String str = ms + ":" + sss;
        return str;
    }

    public static String TimeToStringByDay(long time) {
        String ds = get_day(time) + "";
        String hs = get_shi(time) + "";
        String ms = get_fen(time) + "";
        String sss = get_miao(time) + "";
        String str = ds + "天" + hs + ":" + ms + ":" + sss;
        return str;
    }


    public static String LongTimeToStringTime(long time, String reg) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(reg);
        String s = simpleDateFormat.format(new Date(time));
        return s;
    }

    public static String LongTimeToStringTime(long time) {

        return LongTimeToStringTime(time, "yyyy/MM/dd");
    }

    private static int get_day(long time) {

        return (int) (time / (3600 * 24));
    }

    public static int get_fen(long time) {
        return (int) (time % (3600) / 60);
    }

    public static int get_shi(long time) {
        return (int) (time % (3600 * 60) / 3600 % 24);
    }

    public static int get_miao(long time) {
        return (int) (time % 60);
    }
}
