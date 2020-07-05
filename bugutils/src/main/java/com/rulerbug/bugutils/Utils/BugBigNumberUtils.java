package com.rulerbug.bugutils.Utils;

import java.math.BigDecimal;

public class BugBigNumberUtils {
    //相加两个double
    public static double add(double a, double b) {
        BigDecimal b1 = new BigDecimal(a + "");
        BigDecimal b2 = new BigDecimal(b + "");
        return b1.add(b2).doubleValue();
    }

    //相加两个float
    public static double add(float a, float b) {
        BigDecimal b1 = new BigDecimal(a + "");
        BigDecimal b2 = new BigDecimal(b + "");
        return b1.add(b2).doubleValue();
    }

    //相减两个float
    public static double reduce(float a, float b) {
        BigDecimal b1 = new BigDecimal(a + "");
        BigDecimal b2 = new BigDecimal(b + "");
        return b1.subtract(b2).doubleValue();
    }

    //相减两个double
    public static double reduce(double a, double b) {
        BigDecimal b1 = new BigDecimal(a + "");
        BigDecimal b2 = new BigDecimal(b + "");
        return b1.subtract(b2).doubleValue();
    }
}
