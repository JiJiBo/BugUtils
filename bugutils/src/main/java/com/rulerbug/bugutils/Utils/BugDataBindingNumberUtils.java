package com.rulerbug.bugutils.Utils;

import androidx.databinding.InverseMethod;

public class BugDataBindingNumberUtils {
    @InverseMethod("strToInt")
    public static String intToStr(Integer num) {
        return num + "";
    }

    public static Integer strToInt(String num) {
        return Integer.valueOf(num);
    }

    @InverseMethod("strToShort")
    public static String shortToStr(Short num) {
        return num + "";
    }

    public static Short strToShort(String num) {
        return Short.valueOf(num);
    }

    @InverseMethod("strToDouble")
    public static String doubleToStr(Double num) {
        return num + "";
    }

    public static Double strToDouble(String num) {
        return Double.valueOf(num);
    }

    @InverseMethod("strToFloat")
    public static String floatToStr(Float num) {
        return num + "";
    }

    public static Float strToFloat(String num) {
        return Float.valueOf(num);
    }

    @InverseMethod("strToLong")
    public static String longToStr(Long num) {
        return num + "";
    }

    public static Long strToLong(String num) {
        return Long.valueOf(num);
    }
}
